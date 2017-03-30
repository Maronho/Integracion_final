package gestor.mapas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="Rango")
public class Rango {

	@Id
	@GeneratedValue(generator = "table", strategy=GenerationType.TABLE)
	@TableGenerator(name = "table", allocationSize = 10)	
	private int codRango;	
	
	@Column (name="Nombre_Rango", length = 20, unique = true)
	private String nombre;
	
	@Column (name = "canEdit")
	private boolean canEdit;

	public int getCodRango() {
		return codRango;
	}

	public void setCodRango(int codRango) {
		this.codRango = codRango;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isCanEdit() {
		return canEdit;
	}

	public void setCanEdit(boolean canEdit) {
		this.canEdit = canEdit;
	}
	
}
