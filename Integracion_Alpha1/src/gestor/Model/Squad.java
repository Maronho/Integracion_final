package gestor.Model;

import java.util.List;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

public class Squad {

	private StringProperty color;
	
	private ListProperty<Player> players;
	
	public Squad (String color, ObservableList<Player> players){
		this.color = new SimpleStringProperty(this, "color",color);
		this.players = new SimpleListProperty<Player>(this, "players", players);
	}

	public final StringProperty colorProperty() {
		return this.color;
	}
	

	public final String getColor() {
		return this.colorProperty().get();
	}
	

	public final void setColor(final String color) {
		this.colorProperty().set(color);
	}
	

	public final ListProperty<Player> playersProperty() {
		return this.players;
	}
	

	public final ObservableList<Player> getPlayers() {
	return this.playersProperty().get();
	}
	

	public final  void setPlayers(final ObservableList <Player> players) {
	this.playersProperty().set(players);
	}
	
	
}
