package com.formacionspring.app.apirest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.formacionspring.app.apirest.entity.Empleado;
import com.formacionspring.app.apirest.service.EmpleadoService;

@Controller
public class EmpleadoController {

	@Autowired
	private EmpleadoService servicio;
	
//	@GetMapping("/hola")
//	public String helloweb(Model model) {
//		model.addAttribute("key",servicio.listarTodosLosEmpleados());
//		return "hola"; //esta palabra señala al archivo .html
//		//con la misma palabra que hemos creado en la carpeta templates
//		//luego si ponemos http://localhost:8087/hola en google aparece el
//		//mensaje que hay en el archivo de html
//	}
//	
	
	@GetMapping({"/empleados","/"})
	public String listarEmpleados(Model model) {
		model.addAttribute("key",servicio.listarTodosLosEmpleados());
		return "empleados"; //esta palabra señala al archivo .html
		//con la misma palabra que hemos creado en la carpeta templates
		//luego si ponemos http://localhost:8087/empleados en google aparece el
		//mensaje que hay en el archivo de html
	}
	
	@GetMapping("/empleado/nuevo")
	public String formularioEmpleado(Model modelo) {
		Empleado newEmpleado = new Empleado();
		modelo.addAttribute("empleadoKey",newEmpleado);
		return "nuevo_empleado";
	}
	
	@PostMapping("/empleado")
	public String guardarEmpleado(@ModelAttribute("empleadoKey") Empleado empleado) {
		servicio.guardarEmpleado(empleado);
		return "redirect:/empleados";
	}
	
	@GetMapping("/empleado/editar/{id}")
	public String formularioEdicionEmpleado(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("empleadoKey",servicio.obtenerEmpeladoPorId(id));
		return "editar_empleado";
	}
	
	@PostMapping("/empleado/editar/{id}")
	public String editarEmpleado(@PathVariable Long id, @ModelAttribute("empleadoKey") Empleado empleado) {
		Empleado empleadoEdit=servicio.obtenerEmpeladoPorId(id);
		empleadoEdit.setNombre(empleado.getNombre());
		empleadoEdit.setApellido(empleado.getApellido());
		empleadoEdit.setEmail(empleado.getEmail());
		empleadoEdit.setTelefono(empleado.getTelefono());
		
		servicio.guardarEmpleado(empleadoEdit);
		return "redirect:/empleados";
	}
	
	
	@GetMapping("/empleado/borrar/{id}")
	public String eliminarEmpleado(@PathVariable Long id) {
		servicio.eliminarEmpleado(id);
		return "redirect:/empleados";
	}
	
}
