package gestor.mapas;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import gestor.Model.Player;

@Entity
@Table(name="Estadisticas")
public class Estadisticas implements Serializable {

	@Id
	@OneToOne(cascade={CascadeType.PERSIST,CascadeType.REMOVE})
	@JoinColumn  (name="jugador")
	private Jugador jugador;

	@Column(name="nSalidas")
	private int salidas;
	
	@Column(name="derribos")
	private int derribos;
	
	@Column(name="kill_ratio")
	private double kill_ratio;


	public int getSalidas() {
		return salidas;
	}

	public void setSalidas(int salidas) {
		this.salidas = salidas;
	}

	public int getDerribos() {
		return derribos;
	}

	public void setDerribos(int derribos) {
		this.derribos = derribos;
	}

	public double getKill_ratio() {
		return kill_ratio;
	}

	public void setKill_ratio(double kill_ratio) {
		this.kill_ratio = kill_ratio;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}
}
