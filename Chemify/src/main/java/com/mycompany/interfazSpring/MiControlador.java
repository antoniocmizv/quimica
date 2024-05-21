package com.mycompany.interfazSpring;

import com.itextpdf.text.pdf.qrcode.Mode;
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
        model.addAttribute("error", "Usuario o contraseña incorrectos");
        return "inicio";
    }

    @PostMapping("/buscarProducto")
    public String buscarProducto(@RequestParam("nombreProducto") String nombreProducto, Model model) {
        ArrayList<Producto> productos = Conexion.buscarProductos(nombreProducto);
        if (productos == null || productos.isEmpty()) {
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
    public String register(@RequestParam("username") String username, @RequestParam("password") String password,
                           @RequestParam("email") String email, Model model) {
        if (username.isEmpty() || password.isEmpty() || email.isEmpty()) {
            model.addAttribute("error", "Por favor, rellene todos los campos");
            return "inicio";
        }
        Conexion.registrarUsuario(username, password, email);
        return "inicio";
    }

    @PostMapping("/restorePassword")
    public String restorePassword(@RequestParam("username") String username, Model model) {
        String email = Conexion.recuperarEmail(username);
        String password = Conexion.recuperarContraseña(username);
        if (password == null) {
            model.addAttribute("error", "El usuario no existe");
            return "contrasenaOlvidada";
        }
        EnvioCorreo.enviarContrasena(username, password, email);
        return "inicio";
    }

    @GetMapping("/dashboard")
    public String showDashboard(Model model) {
        int productCount = Conexion.countProducts(); // productService es tu servicio que interactúa con la base de datos
        model.addAttribute("productCount", productCount);
        int quimicoCount = Conexion.countQuimicos();
        model.addAttribute("quimicoCount", quimicoCount);
        String mensaje = SistemaAlertasStock.verificarStock();
        model.addAttribute("mensaje", mensaje);
        List<User> usuarios = Conexion.obtenerUsuarios();
        model.addAttribute("usuarios", usuarios);
        return "dashboard";
    }

    @GetMapping("/actualizarQuimico/{id}")
    public String showActualizarQuimico(@PathVariable("id") int id, Model model) {
        Quimico producto = Conexion.obtenerQuimico(id);
        model.addAttribute("producto", producto);
        List<String> almacenes = List.of(Conexion.obtenerLocalizaciones());
        List<String> ubicaciones = List.of(Conexion.obtenerUbicacionesDeAlmacen(almacenes.get(0)));
        List<String> pictogramas = List.of("Explosivo", "Inflamable", "Corrosivo", "Tóxico", "Irritante", "Peligroso para el medio ambiente");
        String[] formato = Conexion.obtenerFormatosQ();
        model.addAttribute("almacenes", almacenes);
        model.addAttribute("ubicaciones", ubicaciones);
        model.addAttribute("pictogramas", pictogramas);
        model.addAttribute("formato", formato);

        return "modificarQuimico";
    }

    @PostMapping("/actQuimi/{id}")
    public String actualizarQuimico(@PathVariable("id") int id,
                                    @RequestParam("nombre") String nombre,
                                    @RequestParam("cantidad") int cantidad,
                                    @RequestParam("pureza") String pureza,
                                    @RequestParam("stock_minimo") int stock_minimo,
                                    @RequestParam("almacen") String almacen,
                                    @RequestParam("ubicacion") String ubicacion,
                                    @RequestParam("formato") String formato) {
        // Obtén el producto actual de la base de datos
        Quimico productoActual = Conexion.obtenerQuimico(id);

        // Actualiza el producto actual con los datos del formulario
        productoActual.setNombre(nombre);
        productoActual.setCantidad(cantidad);
        productoActual.setPureza(pureza);
        productoActual.setStock_minimo(stock_minimo);
        productoActual.setAlmacen(almacen);
        productoActual.setUbicacion(ubicacion);
        productoActual.setFormato(formato);

        int id_almacen = Conexion.obtenerIdAlmacen(almacen);
        int id_ubicacion = Conexion.obtenerIdUbicacion(ubicacion);
        productoActual.setId_almacen(id_almacen);
        productoActual.setId_ubicacion(id_ubicacion);

        // Guarda el producto actualizado en la base de datos
        Conexion.actualizarQuimico(productoActual);
        System.out.println("Producto actualizado: " + productoActual.getNombre());

        // Redirige al usuario a la página de detalles del producto
        return "redirect:/busqueda";
    }
    @PostMapping("/actMaterial/{id}")
    public String actualizarMaterial(@PathVariable("id") int id,
                                    @RequestParam("nombre") String nombre,
                                    @RequestParam("cantidad") int cantidad,
                                    @RequestParam("stock_minimo") int stock_minimo,
                                    @RequestParam("almacen") String almacen,
                                    @RequestParam("ubicacion") String ubicacion) {
        // Obtén el producto actual de la base de datos
        Materiales productoActual = Conexion.obtenerMateriales(id);

        // Actualiza el producto actual con los datos del formulario
        productoActual.setNombre(nombre);
        productoActual.setCantidad(cantidad);
        productoActual.setStock_minimo(stock_minimo);
        productoActual.setAlmacen(almacen);
        productoActual.setUbicacion(ubicacion);

        int id_almacen = Conexion.obtenerIdAlmacen(almacen);
        int id_ubicacion = Conexion.obtenerIdUbicacion(ubicacion);
        productoActual.setId_almacen(id_almacen);
        productoActual.setId_ubicacion(id_ubicacion);

        // Guarda el producto actualizado en la base de datos
        Conexion.actualizarMaterial(productoActual);
        System.out.println("Producto actualizado: " + productoActual.getNombre());

        // Redirige al usuario a la página de detalles del producto
        return "redirect:/busqueda";
    }
    @PostMapping("/actPa/{id}")
    public String actualizarPa(@PathVariable("id") int id,
                                    @RequestParam("nombre") String nombre,
                                    @RequestParam("cantidad") int cantidad,
                                    @RequestParam("stock_minimo") int stock_minimo,
                                    @RequestParam("almacen") String almacen,
                                    @RequestParam("ubicacion") String ubicacion) {
        // Obtén el producto actual de la base de datos
        ProductoAuxiliar productoActual = Conexion.obtenerProductosAux(id);

        // Actualiza el producto actual con los datos del formulario
        productoActual.setNombre(nombre);
        productoActual.setCantidad(cantidad);
        productoActual.setStock_minimo(stock_minimo);
        productoActual.setAlmacen(almacen);
        productoActual.setUbicacion(ubicacion);

        int id_almacen = Conexion.obtenerIdAlmacen(almacen);
        int id_ubicacion = Conexion.obtenerIdUbicacion(ubicacion);
        productoActual.setId_almacen(id_almacen);
        productoActual.setId_ubicacion(id_ubicacion);

        // Guarda el producto actualizado en la base de datos
        Conexion.actualizarProductoAuxiliar(productoActual);
        System.out.println("Producto actualizado: " + productoActual.getNombre());

        // Redirige al usuario a la página de detalles del producto
        return "redirect:/busqueda";
    }

    @GetMapping("/actualizarPa/{id}")
    public String showActualizarPa(@PathVariable("id") int id, Model model) {
        ProductoAuxiliar producto = Conexion.obtenerProductosAux(id);
        model.addAttribute("producto", producto);
        List<String> almacenes = List.of(Conexion.obtenerLocalizaciones());
        List<String> ubicaciones = List.of(Conexion.obtenerUbicacionesDeAlmacen(almacenes.get(0)));
        model.addAttribute("almacenes", almacenes);
        model.addAttribute("ubicaciones", ubicaciones);
        return "modificarPa";
    }
    @GetMapping("/actualizarMaterial/{id}")
    public String showActualizarMaterial(@PathVariable("id") int id, Model model) {
        Materiales producto = Conexion.obtenerMateriales(id);
        model.addAttribute("producto", producto);
        List<String> almacenes = List.of(Conexion.obtenerLocalizaciones());
        List<String> ubicaciones = List.of(Conexion.obtenerUbicacionesDeAlmacen(almacenes.get(0)));
        model.addAttribute("almacenes", almacenes);
        model.addAttribute("ubicaciones", ubicaciones);
        return "modificarMaterial";
    }



    @GetMapping("/eliminarProducto/{id}")
    public String eliminarQuimico(@PathVariable("id") int id) {
        // Elimina el químico de la base de datos
        Conexion.eliminarProducto(id);
        return "redirect:/busqueda";
    }


}


