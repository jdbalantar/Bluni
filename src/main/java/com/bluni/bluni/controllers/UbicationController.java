package com.bluni.bluni.controllers;

import com.bluni.bluni.models.entity.Computer;
import com.bluni.bluni.models.entity.Ubication;
import com.bluni.bluni.models.service.IUbicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/views/ubications")
public class UbicationController {
    @Autowired
    private IUbicationService ubicationService;

    @Secured("ROLE_USER")
    @GetMapping("/")
    public String listarUbications(Model model) {
        List<Ubication> listaUbicaciones = ubicationService.ListaUbicaciones();
        model.addAttribute("titulo", "Ubicaciones");
        model.addAttribute("ubicaciones", listaUbicaciones);
        return "/views/ubications/listar";
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/save")
    public String guardar(@Valid @ModelAttribute Ubication ubication, BindingResult result, Model model, RedirectAttributes attribute) {
        List<Ubication> listaUbicaciones = ubicationService.ListaUbicaciones();
        if (result.hasErrors()) {
            model.addAttribute("titulo", "Formulario: Nueva ubicación");
            model.addAttribute("ubicacion", listaUbicaciones);
            return "/views/ubications/frmCrear";
        }
        ubicationService.guardar(ubication);
        attribute.addFlashAttribute("success", "¡Ubicación registrada con éxito!");
        return "redirect:/views/ubications/";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/create")
    public String crear(Model model) {
        Ubication ubication = new Ubication();
        model.addAttribute("titulo", "Formulario: Nueva ubicación");
        model.addAttribute("ubicacion", ubication);
        return "/views/ubications/frmCrear";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") Long idUbication, Model model, RedirectAttributes attribute) {

        Ubication ubication = null;

        if (idUbication > 0) {
            ubication = ubicationService.buscarPorId(idUbication);
            if (ubication == null) {
                attribute.addFlashAttribute("error", "Error: El ID del equipo no existe");
                return "redirect:/views/ubications/";
            }
        } else {
            attribute.addFlashAttribute("error", "Error con el ID del equipo");
            return "redirect:/views/ubications/";
        }
        List<Ubication> listaUbicaciones = ubicationService.ListaUbicaciones();
        model.addAttribute("titulo", "Formulario: Editar Equipo");
        model.addAttribute("ubicacion", ubication);
        return "/views/ubications/frmCrear";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") Long idUbication, RedirectAttributes attribute) {
        Ubication ubication = null;

        if (idUbication > 0) {
            ubication = ubicationService.buscarPorId(idUbication);
            if (ubication == null) {
                attribute.addFlashAttribute("error", "Error: El ID de la ubicación no existe");
                return "redirect:/views/ubications/";
            }
        } else {
            attribute.addAttribute("error", "Error con el ID de la ubicación");
            return "redirect:/views/ubications/";
        }

        ubicationService.eliminar(idUbication);
        attribute.addFlashAttribute("warning", "¡Ubicación eliminada con éxito!");
        return "redirect:/views/ubications/";
    }

}
