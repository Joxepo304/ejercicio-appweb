package com.formacionspring.app.apirest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formacionspring.app.apirest.dao.ProyectoDao;
import com.formacionspring.app.apirest.entity.Proyecto;

@Service
public class ProyectoServiceImpl implements ProyectoService{

	@Autowired
	private ProyectoDao proyectoDao;
	

	@Override
	public List<Proyecto> listarTodosLosProyectos() {
		// TODO Auto-generated method stub
		return proyectoDao.findAll();
	}

	@Override
	public Proyecto guardarProyecto(Proyecto proyecto) {
		// TODO Auto-generated method stub
		return proyectoDao.save(proyecto);
	}

	@Override
	public Proyecto obtenerProyectoPorId(Long id) {
		// TODO Auto-generated method stub
		return proyectoDao.findById(id).get();
	}

	@Override
	public void eliminarProyecto(Long id) {
		// TODO Auto-generated method stub
		proyectoDao.deleteById(id);
	}

}
