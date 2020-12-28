package com.academia.Academia.dao.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "Profesores")
public class Profesor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotBlank(message = "El nombre no puede ser vacio")
	@Column(name = "nombre")
	private String nombre;

	@NotBlank(message = "El email no puede ser vacio")
	@Column(name = "email")
	private String email;

	@NotBlank(message = "El nombre no puede ser vacio")
	private String usuario;

	@NotBlank(message = "El nombre no puede ser vacio")
	private String clave;

	@OneToMany(mappedBy = "profesor")
	private List<Curso> cursos = new ArrayList<Curso>();

	public void insertarCurso(Curso curso) {
		cursos.add(curso);
		curso.setProfesor(this);
	}

	public void borrarCurso(Curso curso) {
		cursos.remove(curso);
		curso.setProfesor(null);
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
