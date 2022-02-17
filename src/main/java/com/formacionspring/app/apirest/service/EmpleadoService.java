package com.formacionspring.app.apirest.service;

import java.util.List;

import com.formacionspring.app.apirest.entity.Empleado;


public interface EmpleadoService {

	public List<Empleado> listarTodosLosEmpleados();
	
	public Empleado guardarEmpleado(Empleado empleado);
	
	public Empleado obtenerEmpeladoPorId(Long id);
	
	public void eliminarEmpleado(Long id);
}
