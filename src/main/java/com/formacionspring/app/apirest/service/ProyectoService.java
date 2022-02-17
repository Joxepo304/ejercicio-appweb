package com.formacionspring.app.apirest.service;

import java.util.List;


import com.formacionspring.app.apirest.entity.Proyecto;
	
	public interface ProyectoService {
		
	public List<Proyecto> listarTodosLosProyectos();
	
	public Proyecto guardarProyecto(Proyecto proyecto);
	
	public Proyecto obtenerProyectoPorId(Long id);
	
	public void eliminarProyecto(Long id);

}
