package gestor.mapas;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="LoginData")
public class LoginData implements Serializable{

	
	@Id
	@OneToOne(cascade={CascadeType.PERSIST,CascadeType.REMOVE})
	@JoinColumn  (name="jugador")
	private Jugador jugador;
	
	@Column(name="username", length=20)
	private String username;
	
	@Column(name="password", length=40)
	private String password;

	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
