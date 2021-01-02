package com.academia.Academia.dao.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "Cursos")
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotBlank(message = "El nombre no puede ser vacio")
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "horario")
	private String horario;

	@ManyToOne(fetch = FetchType.LAZY)
	private Profesor profesor;
	
	@ManyToMany(mappedBy = "cursos")
	private List<Alumno> alumnos = new ArrayList<Alumno>();
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Curso))
			return false;
		Curso cursoT = (Curso) obj;
		return id == cursoT.getId();
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
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

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

}
