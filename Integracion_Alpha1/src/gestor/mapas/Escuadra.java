package gestor.mapas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="Escuadra")
public class Escuadra {
	
	@Id
	@GeneratedValue(generator = "table", strategy=GenerationType.TABLE)
	@TableGenerator(name = "table", allocationSize = 10)	
	private int cod_escuadra;
	
	@Column (name = "color", length= 20)
	private String color;

	public int getCod_escuadra() {
		return cod_escuadra;
	}

	public void setCod_escuadra(int cod_escuadra) {
		this.cod_escuadra = cod_escuadra;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}
