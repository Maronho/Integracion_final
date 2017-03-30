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
@Table(name="Jugador_Partida")

public class Jugador_Partida {

	@Id
	@GeneratedValue(generator = "table", strategy=GenerationType.TABLE)
	@TableGenerator(name = "table", allocationSize = 10)	
	private int cod_JugadorPartida;	
	
	@ManyToOne
	@JoinColumn(name="codJugador")
	private Jugador codJugador;
	
	@ManyToOne
	@JoinColumn(name="codRol")
	private Rol codRol;
	
	@ManyToOne
	@JoinColumn(name="codAparato")
	private Aparato aparato;
	
	@ManyToOne
	@JoinColumn(name="codPartida")
	private Partida partida;
	
	@Column(name="Puntuacion")
	private int puntuacion;

	public Jugador getCodJugador() {
		return codJugador;
	}

	public void setCodJugador(Jugador codJugador) {
		this.codJugador = codJugador;
	}

	public Rol getCodRol() {
		return codRol;
	}

	public void setCodRol(Rol codRol) {
		this.codRol = codRol;
	}

	public Aparato getAparato() {
		return aparato;
	}

	public void setAparato(Aparato aparato) {
		this.aparato = aparato;
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}

	public int getCod_JugadorPartida() {
		return cod_JugadorPartida;
	}

	public void setCod_JugadorPartida(int cod_JugadorPartida) {
		this.cod_JugadorPartida = cod_JugadorPartida;
	}

	public Partida getPartida() {
		return partida;
	}

	public void setPartida(Partida partida) {
		this.partida = partida;
	}	
}
