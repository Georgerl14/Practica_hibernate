package tablas;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EscuelaId implements Serializable{
	private static final long serialVersionUID = 1L;

	@Column(name = "id_escuela")
	private int idEscuela;

	public EscuelaId() {
		super();
	}

	public EscuelaId(int idEscuela) {
		super();
		this.idEscuela = idEscuela;
	}

	public int getIdEscuela() {
		return idEscuela;
	}

	public void setIdEscuela(int idEscuela) {
		this.idEscuela = idEscuela;
	}

	@Override
	public String toString() {
		return String.valueOf(idEscuela);
	}

}
