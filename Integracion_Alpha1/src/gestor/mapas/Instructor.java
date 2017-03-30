package gestor.mapas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="Instructores")
public class Instructor {
	@Id
	@GeneratedValue(generator = "table", strategy=GenerationType.TABLE)
	@TableGenerator(name = "table", allocationSize = 10)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="codInstructor")
	private Jugador Instructor;
	
	@ManyToOne
	@JoinColumn(name="codAlumno")
	private Jugador Alumno;
	
	@ManyToOne
	@JoinColumn(name="Aparato")
	private Aparato aparato;
	
	@ManyToOne
	@JoinColumn(name="Nivel")
	private Nivel nivel;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Jugador getInstructor() {
		return Instructor;
	}

	public void setInstructor(Jugador instructor) {
		Instructor = instructor;
	}

	public Jugador getAlumno() {
		return Alumno;
	}

	public void setAlumno(Jugador alumno) {
		Alumno = alumno;
	}

	public Aparato getAparato() {
		return aparato;
	}

	public void setAparato(Aparato aparato) {
		this.aparato = aparato;
	}

	public Nivel getNivel() {
		return nivel;
	}

	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}
	
	
}
