package tablas;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="alumnos")
public class Alumno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator="generadorId")
	@GenericGenerator(name="generadorId", strategy="increment")
	@Column(name="id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="id_escuela")
	private Escuela escuela;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="primerApellido")
	private String primerApellido;
	
	@Column(name="segundoApellido")
	private String segundoApellido;
	
	@Column(name="codigoPostal")
	private int codigoPostal;
	
	public Alumno() {
		super();
	}
	
	public Alumno(String nombre, String primerApellido, String segundoApellido, int codigoPostal) {
		this.nombre = nombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.codigoPostal = codigoPostal;
	}

	public Alumno(int id, String nombre, String primerApellido, String segundoApellido,
			int codigoPostal,Escuela escuela) {
		this.id = id;
		this.escuela = escuela;
		this.nombre = nombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.codigoPostal = codigoPostal;
	}
	
	public Alumno(String nombre, String primerApellido, String segundoApellido, int codigoPostal, Escuela escuela) {
		super();
		this.nombre = nombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.codigoPostal = codigoPostal;
		this.escuela = escuela;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Escuela getEscuela() {
		return escuela;
	}

	public void setEscuela(Escuela escuela) {
		this.escuela = escuela;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrimerApellido() {
		return this.primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return this.segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public int getCodigoPostal() {
		return this.codigoPostal;
	}

	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}


	public String toString() {
		return "Id: " + this.id + "\nNombre: " + this.nombre + "\nApellidos: " + this.primerApellido + " "
				+ this.segundoApellido + "\nCodigo postal: " + this.codigoPostal;
	}

	public String datosActualizar() {
		return this.id + "-" + this.escuela + "-" + this.nombre + "-" + this.primerApellido + "-" + this.segundoApellido + "-"
				+ this.codigoPostal;
	}

	public int hashCode() {
		return Objects.hash(
				new Object[] { this.primerApellido, this.segundoApellido, this.codigoPostal, this.id, this.nombre });
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		return Objects.equals(this.primerApellido, other.primerApellido)
				|| Objects.equals(this.segundoApellido, other.segundoApellido)
				|| this.codigoPostal == other.codigoPostal || this.id == other.id
				|| Objects.equals(this.nombre, other.nombre);
	}
}
