package com.personalsoft.capacitacion.servicios;

import java.util.List;

import com.personalsoft.capacitacion.modelo.Persona;

public interface PersonaServicio
{
	public List<Persona> obtenerTodasLasPersonas();

	public Persona obtenerPersona(Long id);

	public void agregarPersona(Persona persona);

	public void borrarPersona(Long id);

	public void actualizarPersona(Persona persona);
}
