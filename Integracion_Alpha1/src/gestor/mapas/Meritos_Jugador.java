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
@Table(name="Meritos_Jugador")
public class Meritos_Jugador {
	
	@Id
	@GeneratedValue(generator = "table", strategy=GenerationType.TABLE)
	@TableGenerator(name = "table", allocationSize = 10)	
	private int cod_Meritos_Jugador;

	@ManyToOne
	@JoinColumn(name="codPlayer")
	private Jugador codPlayer;
	
	@ManyToOne
	@JoinColumn(name="codMerito")
	private Meritos codMerito;

	public int getCod_Meritos_Jugador() {
		return cod_Meritos_Jugador;
	}

	public void setCod_Meritos_Jugador(int cod_Meritos_Jugador) {
		this.cod_Meritos_Jugador = cod_Meritos_Jugador;
	}

	public Jugador getCodPlayer() {
		return codPlayer;
	}

	public void setCodPlayer(Jugador codPlayer) {
		this.codPlayer = codPlayer;
	}

	public Meritos getCodMerito() {
		return codMerito;
	}

	public void setCodMerito(Meritos codMerito) {
		this.codMerito = codMerito;
	}
}
