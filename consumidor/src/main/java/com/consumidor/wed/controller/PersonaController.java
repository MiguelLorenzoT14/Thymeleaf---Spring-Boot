package com.consumidor.wed.controller;

import com.consumidor.wed.model.Persona;
import com.consumidor.wed.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping
public class PersonaController {
    @Autowired
    protected PersonaService personaService;

    @GetMapping("/")
    public String redireccion(Model model){
        return "redirect:persona";
    }
    @GetMapping("/persona")
    public String ListarPersonas(Model model){

        List<Persona> personaList = personaService.ListarPersona();

        model.addAttribute("personas",personaList);

        return "persona";
    }

    @GetMapping("/nuevo")
    public String nuevo(Persona persona, Model model){

        model.addAttribute("persona", persona);
        return "formulario";
    }

    @PostMapping("/persona/grabar")
    public String agregarPersona(Persona persona, Model model){

        personaService.AgregarPersona(persona);

        List<Persona> personaList = personaService.ListarPersona();
        model.addAttribute("personas",personaList);

        return "redirect:/";
    }

    @GetMapping("/modificar/{id}")
    public String modificarPersona(@PathVariable("id") Integer id, Model model){

        Persona persona = personaService.BuscarPersonaID(id);
        model.addAttribute("persona",persona);

        return "formulario";
    }


    @GetMapping("/eliminar/{id}")
    public String eliminarPersona(@PathVariable int id, Model model) {
        personaService.EliminarPersona(id);

        List<Persona> personaList = personaService.ListarPersona();
        model.addAttribute("personas", personaList);
        return "redirect:/";
    }

}
