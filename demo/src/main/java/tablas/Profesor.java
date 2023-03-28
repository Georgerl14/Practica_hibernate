package tablas;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "profesores")
public class Profesor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_profesor")
	private int id;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "apellido")
	private String apellido;
	@Column(name = "sueldo")
	private int sueldo;

	@ManyToMany(cascade = { CascadeType.ALL }, mappedBy = "profesores")
	private Set<Escuela> escuelas = new HashSet<Escuela>();

	public Profesor() {
		super();
		this.id = 0;
		this.nombre = "";
		this.apellido = "";
		this.sueldo = 0;
	}

	public Profesor(int id, String nombre, String apellido, int sueldo) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.sueldo = sueldo;
	}

	public Profesor(int id, String nombre, String apellido, int sueldo, Set<Escuela> escuelas) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.sueldo = sueldo;
		this.escuelas = escuelas;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getSueldo() {
		return this.sueldo;
	}

	public void setSueldo(int sueldo) {
		this.sueldo = sueldo;
	}

	public Set<Escuela> getEscuelas() {
		return escuelas;
	}

	public void setEscuelas(Set<Escuela> escuelas) {
		this.escuelas = escuelas;
	}

	public String toString() {
		return "Id: " + this.id + " nombre: " + this.nombre + " apellido: " + this.apellido + " sueldo: "
				+ this.sueldo;
	}

	public int hashCode() {
		return Objects.hash(new Object[] { this.apellido, this.sueldo, this.id, this.nombre });
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profesor other = (Profesor) obj;
		return Objects.equals(this.apellido, other.apellido) || this.sueldo == other.sueldo || this.id == other.id
				|| Objects.equals(this.nombre, other.nombre);
	}
}
