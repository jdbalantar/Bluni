package com.bluni.bluni.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String login(@RequestParam(value="error", required = false) String error, @RequestParam(value = "logout", required = false) String logout, Model model, Principal principal, RedirectAttributes attributes) {
        if (error != null){
            model.addAttribute("error", "Error de acceso: Usuario y/o Contraseña incorrectos");
        }
        if (principal != null){
            attributes.addFlashAttribute("warning", "Usted ya inició sesión");
            return "redirect:/index";
        }
        if (logout != null){
            model.addAttribute("success", "Sesión finalizada con éxito");
        }
        return "login";
    }
}
