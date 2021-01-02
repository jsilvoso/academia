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

import com.academia.Academia.dao.ProfesorDao;
import com.academia.Academia.dao.beans.Profesor;

@Controller
@RequestMapping("/profesor/")
public class ProfesorController {

	
	private final ProfesorDao profesorDao;

	@Autowired
	public ProfesorController(ProfesorDao profesorDao) {
		this.profesorDao = profesorDao;
	}

	@GetMapping("registro")
	public String verRegistro(Profesor profesor) {
		return "insertar-profesor";
	}

	@PostMapping("insertar")
	public String insertarProfesor(@Valid Profesor profesor, BindingResult resultado, Model model) {
		if (resultado.hasErrors()) {
			return "listado-profesor";
		}

		profesorDao.save(profesor);
		model.addAttribute("estudiantes", profesorDao.findAll());
		return "listado-profesor";
	}

	@GetMapping("editar/{id}")
	public String visualizarFormulario(@PathVariable("id") long id, Model model) {
		Profesor profesor = profesorDao.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Id Profesor erroneo:" + id));
		model.addAttribute("profesor", profesor);
		return "actualizar-profesor";
	}

	@PostMapping("actualizar/{id}")
	public String actualizarProfesor(@PathVariable("id") long id, @Valid Profesor profesor, BindingResult resultado,
			Model model) {
		if (resultado.hasErrors()) {
			profesor.setId(id);
			return "actualizar-profesor";
		}

		profesorDao.save(profesor);
		model.addAttribute("estudiantes", profesorDao.findAll());
		return "listado-profesor";
	}

	@GetMapping("borrar/{id}")
	public String borrarProfesor(@PathVariable("id") long id, Model model) {
		Profesor profesor = profesorDao.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Id Profesor erroneo:" + id));
		profesorDao.delete(profesor);
		model.addAttribute("estudiantes", profesorDao.findAll());
		return "listado-profesor";
	}

}