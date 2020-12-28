package com.academia.Academia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.academia.Academia.dao.AlumnoDao;

@Controller
public class AcademiaController {
	
	private final AlumnoDao alumnoDao;
	
	@Autowired
	public AcademiaController(AlumnoDao alumnoDao) {
		this.alumnoDao = alumnoDao;
	}

	@GetMapping(value = { "/", "/index" })
	public String index(Model model) {
		model.addAttribute("estudiantes", alumnoDao.findAll());
		return "index";
	}

}
