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
	
}
