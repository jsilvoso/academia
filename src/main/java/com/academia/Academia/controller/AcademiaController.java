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
import com.academia.Academia.dao.ProfesorDao;
import com.academia.Academia.dao.beans.Profesor;
import com.academia.Academia.dao.AdministradorDao;
import com.academia.Academia.dao.beans.Administrador;
import com.academia.Academia.dao.CursoDao;
import com.academia.Academia.dao.beans.Curso;

@Controller
public class AcademiaController {

	private final AlumnoDao alumnoDao;
	private final ProfesorDao profesorDao;
	private final AdministradorDao administradorDao;
	private final CursoDao cursoDao;

	@Autowired
	public AcademiaController(AlumnoDao alumnoDao, ProfesorDao profesorDao
			, AdministradorDao administradorDao, CursoDao cursoDao) {
		this.alumnoDao = alumnoDao;
		this.profesorDao = profesorDao;
		this.administradorDao = administradorDao;
		this.cursoDao = cursoDao;
	}

	

	@GetMapping(value = { "/", "/index" })
	public String index(Model model) {
		model.addAttribute("alumno", new Alumno());
		model.addAttribute("profesor", new Profesor());
		model.addAttribute("administrador", new Administrador());
		return "index";
	}

	@PostMapping("/academia/login")
	public String login(@Valid Alumno alumno,  /*@Valid Profesor profesor,*/ BindingResult resultado, Model model) {
		if (resultado.hasErrors()) {
			Alumno alumnoT = alumnoDao.findByUsuarioAndClave(alumno.getUsuario(), alumno.getClave());
			
			//			Profesor profesorT = profesorDao.findByUsuarioAndClave(profesor.getUsuario(), profesor.getClave());
//			Administrador administradorT = administradorDao.findByUsuarioandClave(administrador.getUsuario(), administrador.getClave());
//			Curso cursoT = cursoDao.findByNombre(curso.getCurso());
			
			if ((alumnoT == null) /*&& (profesorT == null) && administradorT == null*/) {
				alumnoT = profesorDao.findByUsuarioAndClave(profesor..getUsuario(), profesor.getClave());
				if ((alumnoT == null)) {
					return "index";
				}
			} else {
				model.addAttribute("alumnos", alumnoT);
	//			model.addAttribute("curso", cursoT);
				return "listado-cursos";
			}
		} else {
			return "index";
		}
	}

}
