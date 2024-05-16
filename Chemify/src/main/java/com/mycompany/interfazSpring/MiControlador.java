package com.mycompany.interfazSpring;

import com.mycompany.Clases.User;
import com.mycompany.ConexionSQL.Conexion;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MiControlador {
    @GetMapping("/")
    public String index() {
        return "login";
    }

    @GetMapping("/login")
    public String showLoginForm() {

        return "login";
    }

    @PostMapping("/login")
    public String login(User user) {
        if(Conexion.validarUsuario(user.getUsername(), user.getPassword())) {
            return "redirect:/acceso";
        }
        else {
            return "redirect:/noAcceso";
        }
    }
}
