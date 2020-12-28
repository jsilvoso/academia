package com.academia.Academia.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.academia.Academia.dao.AlumnoDao;
import com.academia.Academia.dao.beans.Alumno;

@Controller
public class AcademiaController {

	private final AlumnoDao alumnoDao;

	@Autowired
	public AcademiaController(AlumnoDao alumnoDao) {
		this.alumnoDao = alumnoDao;
	}

	@GetMapping(value = { "/", "/index" })
	public String index(Model model) {
		model.addAttribute("alumno", new Alumno());
		return "index";
	}

	@PostMapping("/academia/login")
	public String login(@Valid Alumno alumno, BindingResult resultado, Model model) {
		if (resultado.hasErrors()) {
			Alumno alumnoT = alumnoDao.findByUsuarioAndClave(alumno.getUsuario(), alumno.getClave());
			if (alumnoT == null) {
				return "index";
			} else {
				model.addAttribute("alumno", alumnoT);
				return "listado-cursos";
			}
		} else {
			return "index";
		}
	}

}
