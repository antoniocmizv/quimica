package com.mycompany.interfazSpring;

import com.mycompany.Clases.*;
import com.mycompany.ConexionSQL.Conexion;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MiControlador {
    @GetMapping("/")
    public String index() {
        return "inicio";
    }

    @GetMapping("/login")
    public String showPage() {
        return "inicio";
    }

    @GetMapping("/inicio")
    public String showLoginForm() {
        return "inicio";
    }

    @GetMapping("/acceso")
    public String showAcceso(Model model) {
        List<Producto> productos = new ArrayList<>();
        model.addAttribute("productos", productos);
        return "busqueda";
    }

    @GetMapping("/busqueda")
    public String showBusqueda(Model model) {
        model.addAttribute("busquedaRealizada", false);
        return "busqueda";
    }

    @PostMapping("/login")
    public String acceso(Acceso user, Model model) {
        if (Conexion.validarUsuario(user.getUsername(), user.getPassword())) {
            return "busqueda";
        }
        // Si el usuario no es válido, redirige a la página de inicio y muestra un mensaje de error
        model.addAttribute("loginError", true);
        model.addAttribute("errorMessage", "Usuario o contraseña incorrectos");
        return "inicio";
    }

    @PostMapping("/buscarProducto")
    public String buscarProducto(@RequestParam("nombreProducto") String nombreProducto, Model model) {
        ArrayList<Producto> productos = Conexion.buscarProductos(nombreProducto);
        if (productos==null || productos.isEmpty()) {
            model.addAttribute("busquedaRealizada", false);
            model.addAttribute("error", "No se encontraron productos con ese nombre.");
            return "busqueda";
        }
        model.addAttribute("productos", productos);
        model.addAttribute("busquedaRealizada", true);
        if (productos.get(0) instanceof Quimico) {
            model.addAttribute("quimico", true);
        } else if (productos.get(0) instanceof Materiales) {
            model.addAttribute("materiales", true);
        } else if (productos.get(0) instanceof ProductoAuxiliar) {
            model.addAttribute("pA", true);
        }
        return "busqueda";
    }

    @GetMapping("/insertar")
    public String showInsertar(Model model) {
        List<String> almacenes = List.of(Conexion.obtenerLocalizaciones());
        List<String> ubicaciones = List.of(Conexion.obtenerUbicacionesDeAlmacen(almacenes.get(0)));
        model.addAttribute("almacenes", almacenes);
        model.addAttribute("ubicaciones", ubicaciones);
        return "insertar";

    }

    @GetMapping("/obtenerUbicaciones")
    @ResponseBody
    public List<String> obtenerUbicaciones(@RequestParam String almacen) {
        return List.of(Conexion.obtenerUbicacionesDeAlmacen(almacen));
    }

    @GetMapping("/actualizar")
    public String showModificar() {
        return "modificar";
    }

    @GetMapping("/producto/{producto}")
    public String showProductDetails(@PathVariable("producto") Quimico quimico, Model model) {
        model.addAttribute("producto", quimico);
        return "detalleQuimico";
    }

    @GetMapping("detalleQuimico")
    public String showQuimico() {
        return "detalleQuimico";
    }

    @GetMapping("informes")
    public String showInformes() {
        return "informes";
    }

    @PostMapping("/descargarPDF")
    public void descargarPDF(@RequestParam(value = "nombreProducto", required = false) String nombreProducto, HttpServletResponse response) {
        try {
            // Genera el PDF
            byte[] pdfData = GeneradorPDF.generarPdfByte(nombreProducto);

            // Configura la respuesta
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment; filename=informe.pdf");

            // Escribe los datos del PDF en la respuesta
            OutputStream os = response.getOutputStream();
            os.write(pdfData);
            os.flush();
            os.close();
        } catch (Exception e) {
            // Maneja la excepción
            e.printStackTrace();
        }
    }


    @GetMapping("/alertas")
    public String getAlertas(Model model) {
        String mensaje = SistemaAlertasStock.verificarStock();
        model.addAttribute("mensaje", mensaje);
        return "alertas";
    }


    @PostMapping("/enviarAlertas")
    public String enviarAlertas(@RequestParam("email") String email, Model model) {
        String mensaje = SistemaAlertasStock.verificarStock();
        EnvioCorreo.enviarAlertaStock(email, "Alerta de Stock", mensaje);
        model.addAttribute("mensaje", mensaje); // Agrega el mensaje al modelo
        return "alertas";
    }


    @GetMapping("/recuperarContraseña")
    public String showRecuperarContraseña() {
        return "contrasenaOlvidada";
    }
    @PostMapping("/register")
    public String register(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
        Conexion.registrarUsuario(username, password);
        return "inicio";
    }
}


