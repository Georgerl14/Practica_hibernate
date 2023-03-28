package tablas;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "directores")
public class Director implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "nombre")
	private String nombre;

	@Column(name = "apellido")
	private String apellido;

	@Column(name = "telefono")
	private int telefono;

	public Director() {
		super();
		this.nombre = "";
		this.apellido = "";
		this.telefono = 0;
	}

	public Director(String nombre, String apellido, int telefono) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	@Override
    public String toString() {
        return "Nombre " + nombre + ", apellido " + apellido + ", telefono " + telefono;
    }
}
