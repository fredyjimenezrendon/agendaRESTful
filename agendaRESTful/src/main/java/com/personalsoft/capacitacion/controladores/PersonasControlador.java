package com.personalsoft.capacitacion.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.personalsoft.capacitacion.modelo.Persona;
import com.personalsoft.capacitacion.servicios.PersonaServicio;

@RestController
@RequestMapping("/personas")
public class PersonasControlador {

    @Autowired
    private PersonaServicio personaServicio;

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Persona> obtenerTodas() {
        return personaServicio.obtenerTodasLasPersonas();
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Persona obtener(@PathVariable("id") Long id) {
       return personaServicio.obtenerPersona(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void agregar(@RequestBody Persona persona) {
        personaServicio.agregarPersona(persona);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void actualizar(@RequestBody Persona persona) {
        personaServicio.actualizarPersona(persona);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void remover(@PathVariable("id") Long id) {
        personaServicio.borrarPersona(id);
    }
}