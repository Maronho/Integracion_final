package gestor.mapas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="Meritos")

public class Meritos {
	@Id
	@GeneratedValue(generator = "table", strategy=GenerationType.TABLE)
	@TableGenerator(name = "table", allocationSize = 10)	
	private int codMerito;	
	
	@Column (name="Nombre", length= 20)
	private String nombreMerito;
	
	@Column (name = "Criterio")
	private int Criterio;

	public int getCodMerito() {
		return codMerito;
	}

	public void setCodMerito(int codMerito) {
		this.codMerito = codMerito;
	}

	public String getNombreMerito() {
		return nombreMerito;
	}

	public void setNombreMerito(String nombreMerito) {
		this.nombreMerito = nombreMerito;
	}

	public int getCriterio() {
		return Criterio;
	}

	public void setCriterio(int criterio) {
		Criterio = criterio;
	}
	
}
