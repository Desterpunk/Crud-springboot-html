package com.sofkau.CrudSpringBoot.controlador;

import com.sofkau.CrudSpringBoot.modelo.Persona;
import com.sofkau.CrudSpringBoot.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.RecursiveTask;

@Controller
@RequestMapping
public class Controlador {
    @Autowired
    private PersonaService service;
    @GetMapping("/listar")
    public String listar(Model model) {
        List<Persona> personas = service.listar();
        model.addAttribute("personas",personas);
        return "index";
    }
    @GetMapping("/new")
    public String agregar(Model model){
        model.addAttribute("persona", new Persona());
        return "form";
    }
    @PostMapping("/save")
    public String save(Persona persona, Model model){
        service.save(persona);
        return "redirect:/listar";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model model){
        Optional<Persona> persona = service.listarId(id);
        model.addAttribute("persona",persona);
        return "form";
    }
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable int id, Model model){
        service.delete(id);
        return "redirect:/listar";
    }

    @GetMapping("/menu")
    public String  menu(){
        return "menu";
    }
    @GetMapping("/index")
    public String  index(){
        return "index";
    }
}
