package com.academia.Academia.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.academia.Academia.dao.beans.Curso;

public interface CursoDao extends CrudRepository<Curso, Long>{

	List<Curso>findByNombre(String nombre);
}
