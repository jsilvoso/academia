package com.academia.Academia.dao;

import org.springframework.data.repository.CrudRepository;

import com.academia.Academia.dao.beans.Administrador;

public interface AdministradorDao extends CrudRepository<Administrador, Long> {
	
	Administrador findByUsuarioAndClave(String usuario, String clave);
}
