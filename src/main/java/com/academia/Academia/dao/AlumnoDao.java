package com.academia.Academia.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.academia.Academia.dao.beans.Alumno;

public interface AlumnoDao extends CrudRepository<Alumno, Long>{
	
		List<Alumno> findByNombre(String nombre);

}
