package com.bluni.bluni.controllers;

import com.bluni.bluni.models.entity.Computer;
import com.bluni.bluni.models.entity.Ubication;
import com.bluni.bluni.models.service.IComputerService;
import com.bluni.bluni.models.service.IUbicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
@Controller
@RequestMapping("/views/computers")
public class
ComputerController {
    @Autowired
    private IComputerService computerService;
    @Autowired
    private IUbicationService ubicationService;

    @Secured("ROLE_USER")
    @RequestMapping("/")
    public String listarComputers(Model model, @Param("palabraClave") String palabraClave) {
        List<Computer> listadoComputers = computerService.listarTodos(palabraClave);
        model.addAttribute("titulo", "Lista de equipos");
        model.addAttribute("computers", listadoComputers);
        model.addAttribute("palabraClave", palabraClave);
        return "/views/computers/listar";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/create")
    public String crear(Model model) {
        Computer computer = new Computer();
        List<Ubication> listaUbicaciones = ubicationService.ListaUbicaciones();
        model.addAttribute("titulo", "Formulario: Nuevo Equipo");
        model.addAttribute("computer", computer);
        model.addAttribute("ubicaciones", listaUbicaciones);
        return "/views/computers/frmCrear";
    }
    @Secured("ROLE_ADMIN")
    @PostMapping("/save")
    public String guardar(@Valid @ModelAttribute Computer computer, BindingResult result, Model model, RedirectAttributes attribute) {
        List<Ubication> listaUbicaciones = ubicationService.ListaUbicaciones();
        if (result.hasErrors()) {
            model.addAttribute("titulo", "Formulario: Nuevo Equipo");
            model.addAttribute("computer", computer);
            model.addAttribute("ubicaciones", listaUbicaciones);
            return "/views/computers/frmCrear";
        }
        computerService.guardar(computer);
        attribute.addFlashAttribute("success", "¡Equipo guardado con éxito!");
        return "redirect:/views/computers/";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") Long idComputer, Model model, RedirectAttributes attribute) {

        Computer computer = null;

        if (idComputer > 0) {
            computer = computerService.buscarPorId(idComputer);
            if (computer == null) {
                attribute.addFlashAttribute("error", "Error: El ID del equipo no existe");
                return "redirect:/views/computers/";
            }
        } else {
            attribute.addFlashAttribute("error", "Error con el ID del equipo");
            return "redirect:/views/computers/";
        }
        List<Ubication> listaUbicaciones = ubicationService.ListaUbicaciones();
        model.addAttribute("titulo", "Formulario: Editar Equipo");
        model.addAttribute("computer", computer);
        model.addAttribute("ubicaciones", listaUbicaciones);
        return "/views/computers/frmCrear";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") Long idComputer, RedirectAttributes attribute) {
        Computer computer = null;

        if (idComputer > 0) {
            computer = computerService.buscarPorId(idComputer);
            if (computer == null) {
                attribute.addFlashAttribute("error", "Error: El ID del equipo no existe");
                return "redirect:/views/computers/";
            }
        } else {
            attribute.addAttribute("error", "Error con el ID del equipo");
            return "redirect:/views/computers/";
        }

        computerService.eliminar(idComputer);
        attribute.addFlashAttribute("warning", "¡Equipo eliminado con éxito!");
        return "redirect:/views/computers/";
    }
}
