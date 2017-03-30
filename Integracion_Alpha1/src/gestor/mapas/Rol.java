package gestor.mapas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="Rol")
public class Rol {
	@Id
	@GeneratedValue(generator = "table", strategy=GenerationType.TABLE)
	@TableGenerator(name = "table", allocationSize = 10)	
	private int codRol;
	
	@Column(name = "nomRol", length=20, unique = true)
	private String nomRol;

	public int getCodRol() {
		return codRol;
	}

	public void setCodRol(int codRol) {
		this.codRol = codRol;
	}

	public String getNomRol() {
		return nomRol;
	}

	public void setNomRol(String nomRol) {
		this.nomRol = nomRol;
	}
}
