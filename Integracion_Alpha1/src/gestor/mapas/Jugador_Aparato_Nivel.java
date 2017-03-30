package gestor.mapas;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="Jugador_Aparato_Nivel")
public class Jugador_Aparato_Nivel {
	
	@Id
	@GeneratedValue(generator = "table", strategy=GenerationType.TABLE)
	@TableGenerator(name = "table", allocationSize = 10)	
	private int cod_JugadorAparatoNivel;	
	
	@ManyToOne
	@JoinColumn(name="codJugador")
	private Jugador codJugador;
	
	@ManyToOne
	@JoinColumn(name="codAparato")
	private Aparato codAparato;
	
	@ManyToOne
	@JoinColumn(name="codNivel")
	private Nivel codNivel;

	public Jugador getCodJugador() {
		return codJugador;
	}

	public void setCodJugador(Jugador codJugador) {
		this.codJugador = codJugador;
	}

	public Aparato getCodAparato() {
		return codAparato;
	}

	public void setCodAparato(Aparato codAparato) {
		this.codAparato = codAparato;
	}

	public Nivel getCodNivel() {
		return codNivel;
	}

	public void setCodNivel(Nivel codNivel) {
		this.codNivel = codNivel;
	}

	public int getCod_JugadorAparatoNivel() {
		return cod_JugadorAparatoNivel;
	}

	public void setCod_JugadorAparatoNivel(int cod_JugadorAparatoNivel) {
		this.cod_JugadorAparatoNivel = cod_JugadorAparatoNivel;
	}
}
