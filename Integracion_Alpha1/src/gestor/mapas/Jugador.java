package gestor.mapas;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Jugador")

public class Jugador implements Serializable{

	@Id
	@GeneratedValue(generator = "table", strategy=GenerationType.TABLE)
	@TableGenerator(name = "table", allocationSize = 10)	
	private int codPlayer;
	
	@ManyToOne
	@JoinColumn(name="rango")
	private Rango rango;
	
	@Column(name="nombre", length=20)
	private String nombre;
	
	@Column(name = "callsign", length=20)
	private String callsign;
	
	@Column(name = "apellido", length=20)
	private String apellido;
	
	@OneToOne (cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn 
	private LoginData loginData;

	/*@OneToOne (cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn 
	private Estadisticas stats;*/
	
	public int getCodPlayer() {
		return codPlayer;
	}

	public void setCodPlayer(int codPlayer) {
		this.codPlayer = codPlayer;
	}

	public Rango getRango() {
		return rango;
	}

	public void setRango(Rango rango) {
		this.rango = rango;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCallsign() {
		return callsign;
	}

	public void setCallsign(String callsign) {
		this.callsign = callsign;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public LoginData getLoginData() {
		return loginData;
	}

	public void setLoginData(LoginData loginData) {
		this.loginData = loginData;
	}
	
	
}
