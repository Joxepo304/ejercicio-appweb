package com.formacionspring.app.apirest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.formacionspring.app.apirest.dao.DepartamentoDao;
import com.formacionspring.app.apirest.entity.Departamento;

public class DepartamentoServiceImpl implements DepartamentoService{

	@Autowired
	private DepartamentoDao departamentoDao;
	
	
	@Override
	public List<Departamento> listarTodosLosDepartamento() {
		return departamentoDao.findAll();
	}

	@Override
	public Departamento guardarDepartamento(Departamento departamento) {
		return departamentoDao.save(departamento);
	}

	@Override
	public Departamento obtenerDepartamentoPorId(Long id) {
		return departamentoDao.findById(id).get();
	}

	@Override
	public void eliminarDepartamento(Long id) {
		departamentoDao.deleteById(id);
		
	}

}
