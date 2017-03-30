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
@Table(name="Escuadra_Jugador")
public class Escuadra_Jugador {
	
	@Id
	@GeneratedValue(generator = "table", strategy=GenerationType.TABLE)
	@TableGenerator(name = "table", allocationSize = 10)	
	private int cod_jugador_escuadra;
	
	@ManyToOne
	@JoinColumn(name="jugador")
	private Jugador jugador;
	
	@ManyToOne
	@JoinColumn(name = "escuadra")
	private Escuadra escuadra;
	
	@Column(name = "numero")
	private int numero;

	public int getCod_jugador_escuadra() {
		return cod_jugador_escuadra;
	}

	public void setCod_jugador_escuadra(int cod_jugador_escuadra) {
		this.cod_jugador_escuadra = cod_jugador_escuadra;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	public Escuadra getEscuadra() {
		return escuadra;
	}

	public void setEscuadra(Escuadra escuadra) {
		this.escuadra = escuadra;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}


	
	

}
