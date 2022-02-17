package com.formacionspring.app.apirest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.formacionspring.app.apirest.entity.Departamento;
import com.formacionspring.app.apirest.service.DepartamentoService;

public class DepartamentoController {

	@Autowired
	private DepartamentoService servicio;
	
	@GetMapping({ "/departamentos", "/" })
	public String listarDepartamentos(Model model) {
		model.addAttribute("key", servicio.listarTodosLosDepartamento());
		return "departamento";
	}
	

	
	@GetMapping("departamentos/nuevo")
	public String formularioDepartamentos(Model modelo) {
		Departamento newDepartamento = new Departamento();
		modelo.addAttribute("DepartamentoKey", newDepartamento);
		return "nuevo_departamento";
	}

	@PostMapping("/departamentos")
	public String guardarDepartamento(@ModelAttribute("departamento") Departamento departamento) {
		servicio.guardarDepartamento(departamento);
		return "redirect:/departamentos";
	}

	@GetMapping("/departamentos/editar/{id}")
	public String formularioEdicionDepartamento(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("DepartamentoKey", servicio.obtenerDepartamentoPorId(id));
		return "editar_departamento";
	}

	@PostMapping("/departamentos/editar/{id}")
	public String editarDepartamento(@PathVariable Long id, @ModelAttribute("departamentoKey") Departamento departamento) {
		Departamento departamentoEdit = servicio.obtenerDepartamentoPorId(id);
		departamentoEdit.setNombre(departamento.getNombre());
		servicio.guardarDepartamento(departamentoEdit);
		return "redirect:/departamentos";
	}

	@GetMapping("/departamentos/borrar/{id}")
	public String formularioEliminarDepartamento(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("departamentoKey", servicio.obtenerDepartamentoPorId(id));
		return "borrar_departamento";
	}
	
	@PostMapping("/departamentos/borrar/{id}")
	public String eliminarDepartamento(@PathVariable Long id) {
		servicio.eliminarDepartamento(id);
		return "redirect:/departamentos";
	}
	
}

