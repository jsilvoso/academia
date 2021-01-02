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

import com.academia.Academia.dao.CursoDao;
import com.academia.Academia.dao.beans.Curso;

@Controller
@RequestMapping("/curso/")
public class CursoController {

	private final CursoDao cursoDao;
	
	@Autowired
	public CursoController(CursoDao cursoDao) {
		this.cursoDao = cursoDao;
	}
	
	@GetMapping("registro")
	public String verRegistro(Curso curso) {
		return "insertar-alumno";
	}

	@PostMapping("insertar")
	public String insertarCurso(@Valid Curso curso, BindingResult resultado, Model model) {
		if (resultado.hasErrors()) {
			return "insertar-curso";
		}

		cursoDao.save(curso);
		model.addAttribute("cursos", cursoDao.findAll());
		return "listado-curso";
	}
	
	@GetMapping("editar/{id}")
	public String visualizarFormulario(@PathVariable("id") long id, Model model) {
		Curso curso = cursoDao.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Id Curso erroneo:" + id));				
		model.addAttribute("curso", curso);
		return "actualizar-curso";
	}
	
	@PostMapping("actualizar/{id}")
	public String actualizarCurso(@PathVariable("id") long id, @Valid Curso curso, BindingResult resultado,
			Model model) {
		if (resultado.hasErrors()) {
			curso.setId(id);
			return "actualizar-curso";
		}

		cursoDao.save(curso);
		model.addAttribute("cursos", cursoDao.findAll());
		return "listado-curso";
	}
	
	@GetMapping("borrar/{id}")
	public String borrarCurso(@PathVariable("id") long id, Model model) {
		Curso curso = cursoDao.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Id Curso erroneo:" + id));
		cursoDao.delete(curso);
		model.addAttribute("cursos", cursoDao.findAll());
		return "listado-curso";
	}
	
}
