package com.academia.Academia.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.academia.Academia.dao.beans.Profesor;

public interface ProfesorDao extends CrudRepository<Profesor, Long> {

	Profesor findByUsuarioAndClave(String usuario, String clave);
}
