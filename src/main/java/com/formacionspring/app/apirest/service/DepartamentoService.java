package com.formacionspring.app.apirest.service;

import java.util.List;

import com.formacionspring.app.apirest.entity.Departamento;

public interface DepartamentoService {

	
public List<Departamento> listarTodosLosDepartamento();
	
	public Departamento guardarDepartamento(Departamento departamento);
	
	public Departamento obtenerDepartamentoPorId(Long id);
	
	public void eliminarDepartamento(Long id);
}
