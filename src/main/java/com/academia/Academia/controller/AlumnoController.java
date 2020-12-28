package com.academia.Academia.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.academia.Academia.dao.AlumnoDao;
import com.academia.Academia.dao.beans.Alumno;

@Controller
@RequestMapping("/alumno/")
public class AlumnoController {

	
	private final AlumnoDao alumnoDao;

	@Autowired
	public AlumnoController(AlumnoDao alumnoDao) {
		this.alumnoDao = alumnoDao;
	}

	@GetMapping("registro")
	public String verRegistro(Alumno alumno) {
		return "insertar-alumno";
	}

	@PostMapping("insertar")
	public String insertarAlumno(@Valid Alumno alumno, BindingResult resultado, Model model) {
		if (resultado.hasErrors()) {
			return "insertar-alumno";
		}

		alumnoDao.save(alumno);
		model.addAttribute("estudiantes", alumnoDao.findAll());
		return "listado-alumno";
	}

	@GetMapping("editar/{id}")
	public String visualizarFormulario(@PathVariable("id") long id, Model model) {
		Alumno alumno = alumnoDao.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Id Alumno erroneo:" + id));
		model.addAttribute("alumno", alumno);
		return "actualizar-alumno";
	}

	@PostMapping("actualizar/{id}")
	public String actualizarAlumno(@PathVariable("id") long id, @Valid Alumno alumno, BindingResult resultado,
			Model model) {
		if (resultado.hasErrors()) {
			alumno.setId(id);
			return "actualizar-alumno";
		}

		alumnoDao.save(alumno);
		model.addAttribute("estudiantes", alumnoDao.findAll());
		return "listado-alumno";
	}

	@GetMapping("borrar/{id}")
	public String borrarAlumno(@PathVariable("id") long id, Model model) {
		Alumno alumno = alumnoDao.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Id Alumno erroneo:" + id));
		alumnoDao.delete(alumno);
		model.addAttribute("estudiantes", alumnoDao.findAll());
		return "listado-alumno";
	}

}
