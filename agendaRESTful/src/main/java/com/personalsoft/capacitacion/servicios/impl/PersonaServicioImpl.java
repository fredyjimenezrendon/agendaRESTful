package com.personalsoft.capacitacion.servicios.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.personalsoft.capacitacion.modelo.Persona;
import com.personalsoft.capacitacion.servicios.PersonaServicio;

@Service("personaService")
public class PersonaServicioImpl implements PersonaServicio {
	
	private static List<Persona> listaPersonas = new ArrayList<Persona>();
	private static Long id = 2L;
	{
		Persona persona1 = new Persona(1L, "Juan", "Perez", "555-66-77");
		Persona persona2 = new Persona(2L, "Maria", "Gomez", "999-88-77");
		
		listaPersonas.add(persona1);
		listaPersonas.add(persona2);
	}

	public List<Persona> obtenerTodasLasPersonas() {
		return listaPersonas;
	}

	public Persona obtenerPersona(Long id) {
		return obtenerPersonaPorId(id);
	}

	public void agregarPersona(Persona persona) {
		persona.setId(++id);
		listaPersonas.add(persona);

	}

	public void borrarPersona(Long id) {
		Persona foundpersona = obtenerPersonaPorId(id);
		if (foundpersona != null) {
			listaPersonas.remove(foundpersona);
			id--;
		}

	}

	public void actualizarPersona(Persona persona) {
		Persona personaEncontrada = obtenerPersonaPorId(persona.getId());
		if (personaEncontrada != null) {
			listaPersonas.remove(personaEncontrada);
			listaPersonas.add(persona);
		}

	}
	
	private Persona obtenerPersonaPorId(Long id) {
		for (Persona persona: listaPersonas) {
			if (persona.getId() == id) {
				return persona;
			}
		}

		return null;
	}

}
