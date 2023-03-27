package tablas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "escuelas")
public class Escuela implements Serializable {

	private static final long serialVersionUID = 1L;
	@EmbeddedId
	EscuelaId escuelaId;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "provincia")
	private String provincia;

	@Column(name = "telefono")
	private int telefono;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "nombre_director")
	private Director director;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "escuelas_profesores", joinColumns = { @JoinColumn(name = "id_escuela") }, inverseJoinColumns = {
			@JoinColumn(name = "id_profesor") })
	private Set<Profesor> profesores = new HashSet<Profesor>();

	@OneToMany(mappedBy = "escuela", cascade = CascadeType.ALL)
	private List<Alumno> listaAlumno = new ArrayList<Alumno>();

	public Escuela() {
		super();
		this.nombre = "";
		this.provincia = "";
		this.telefono = 0;
	}

	public Escuela(String nombre, String provincia, int telefono) {
		super();
		this.nombre = nombre;
		this.provincia = provincia;
		this.telefono = telefono;
	}

	public Escuela(EscuelaId escuelaId, String nombre, String provincia, int telefono) {
		super();
		this.escuelaId = escuelaId;
		this.nombre = nombre;
		this.provincia = provincia;
		this.telefono = telefono;
	}

	public Escuela(EscuelaId escuelaId, Director nombreDirector, String nombre, String provincia, int telefono) {
		super();
		this.escuelaId = escuelaId;
		this.nombre = nombre;
		this.provincia = provincia;
		this.telefono = telefono;
	}

	public EscuelaId getEscuelaId() {
		return escuelaId;
	}

	public void setEscuelaId(EscuelaId escuelaId) {
		this.escuelaId = escuelaId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public Set<Profesor> getProfesores() {
		return profesores;
	}

	public void setProfesores(Set<Profesor> profesores) {
		this.profesores = profesores;
	}

	public Director getDirector() {
		return director;
	}

	public void setDirector(Director director) {
		this.director = director;
	}

	public List<Alumno> getListaAlumno() {
		return listaAlumno;
	}

	public void setListaAlumno(List<Alumno> listaAlumno) {
		this.listaAlumno = listaAlumno;
	}

	@Override
	public String toString() {
		return "[" + escuelaId + "] - Escuela " + nombre + ", provincia de " + provincia + " con telefono: "
				+ telefono;
	}

	public String informacionExtra() {
		try {
			return "Director " + director.getNombre() + ", Número de alumnos: " + listaAlumno.size()
			+ ", Número de profesores: " + profesores.size();
		} catch (Exception e) {
			return "Director (vacante disponible)"+ ", Número de alumnos: " + listaAlumno.size() + ", Número de profesores: " + profesores.size();
		}
	}

}
