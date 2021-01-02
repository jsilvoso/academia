package com.academia.Academia.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.academia.Academia.dao.beans.Administrador;

public interface AdministradorDao extends CrudRepository<Administrador, Long> {
	
	//Administrador findByUsuarioandClave(String usuario, String clave);
}
