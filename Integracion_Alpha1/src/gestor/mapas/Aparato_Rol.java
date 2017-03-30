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
@Table(name="Aparato_Rol")
public class Aparato_Rol {

	@Id
	@GeneratedValue(generator = "table", strategy=GenerationType.TABLE)
	@TableGenerator(name = "table", allocationSize = 10)	
	private int codAparatoRol;	
	
	@ManyToOne
	@JoinColumn(name="codAparato")
	private Aparato aparato;
	
	
	@ManyToOne
	@JoinColumn(name="codRol")
	private Rol rol;


	public Aparato getAparato() {
		return aparato;
	}


	public void setAparato(Aparato aparato) {
		this.aparato = aparato;
	}


	public Rol getRol() {
		return rol;
	}


	public void setRol(Rol rol) {
		this.rol = rol;
	}
	
}
