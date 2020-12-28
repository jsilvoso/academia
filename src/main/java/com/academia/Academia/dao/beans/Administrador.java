package com.academia.Academia.dao.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "Administradores")
public class Administrador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank(message = "El nombre no puede ser vacio")
	@Column(name = "nombre")
	private String nombre;
	
	@NotBlank(message = "El nombre no puede ser vacio")
	private String usuario;
	
	@NotBlank(message = "El nombre no puede ser vacio")
	private String clave;

}
