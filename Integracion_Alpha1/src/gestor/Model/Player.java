package gestor.Model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Player {

	private StringProperty name, surname, callsign;
	private IntegerProperty kills, deaths, squad_number;
	private DoubleProperty kdRatio;
	
	public Player(String name, String surname, 
				  String callsign , Integer kills,
				  Integer deaths, Integer number, double ratio){
		
			this.name = new SimpleStringProperty(this,"name",name);
			this.surname = new SimpleStringProperty(this,"surname",surname);
			this.callsign = new SimpleStringProperty(this,"callsign",callsign);
			this.kills = new SimpleIntegerProperty(this,"kills",kills);
			this.deaths = new SimpleIntegerProperty(this,"deaths",deaths);
			this.squad_number = new SimpleIntegerProperty(this, "squad_number", number);
			this.kdRatio = new SimpleDoubleProperty(this, "kdRatio", ratio);
		
			System.out.println(this.name+" - "+this.surname+" - "+this.callsign+" - "+this.kills+" - "+this.deaths+" - "+squad_number+" - "+this.kdRatio);
			
	}

	public final StringProperty nameProperty() {
		return this.name;
	}
	

	public final String getName() {
		return this.nameProperty().get();
	}
	

	public final void setName(final String name) {
		this.nameProperty().set(name);
	}
	

	public final StringProperty surnameProperty() {
		return this.surname;
	}
	

	public final String getSurname() {
		return this.surnameProperty().get();
	}
	

	public final void setSurname(final String surname) {
		this.surnameProperty().set(surname);
	}
	

	public final StringProperty callsignProperty() {
		return this.callsign;
	}
	

	public final String getCallsign() {
		return this.callsignProperty().get();
	}
	

	public final void setCallsign(final String callsign) {
		this.callsignProperty().set(callsign);
	}
	

	public final IntegerProperty killsProperty() {
		return this.kills;
	}
	

	public final int getKills() {
		return this.killsProperty().get();
	}
	

	public final void setKills(final int kills) {
		this.killsProperty().set(kills);
	}
	

	public final IntegerProperty deathsProperty() {
		return this.deaths;
	}
	

	public final int getDeaths() {
		return this.deathsProperty().get();
	}
	

	public final void setDeaths(final int deaths) {
		this.deathsProperty().set(deaths);
	}
	

	public final IntegerProperty squad_numberProperty() {
		return this.squad_number;
	}
	

	public final int getSquad_number() {
		return this.squad_numberProperty().get();
	}
	

	public final void setSquad_number(final int squad_number) {
		this.squad_numberProperty().set(squad_number);
	}
	

	public final DoubleProperty kdRatioProperty() {
		return this.kdRatio;
	}
	

	public final double getKdRatio() {
		return this.kdRatioProperty().get();
	}
	

	public final void setKdRatio(final double kdRatio) {
		this.kdRatioProperty().set(kdRatio);
	}
	

	
	
}
