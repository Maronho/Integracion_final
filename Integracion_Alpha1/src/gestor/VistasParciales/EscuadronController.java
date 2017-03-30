package gestor.VistasParciales;



import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.hibernate.sql.Select;

import gestor.Interface.Menu_controller;
import gestor.Model.Player;
import gestor.Model.Squad;
import gestor.dbOps.getters.DbGetters;
import gestor.dbOps.getters.DbSetters;
import gestor.mapas.Escuadra;
import gestor.mapas.Escuadra_Jugador;
import gestor.mapas.Jugador;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.BorderPane;

	public class EscuadronController {
		
		private BorderPane view;
		
		private DbGetters dbGetters;
		private DbSetters dbSetters;
		
		private Menu_controller parent;
		
	    private ObservableList<Squad> escuadrasBean;
		
		@FXML
	    private TableView<Player> squad_table;

	    @FXML
	    private TableColumn<Player, String> SquadPlayerColumn;

	    @FXML
	    private TableColumn<Player, Integer> squad_number_column;
	    
	    @FXML
	    private TableColumn<Player, Integer> squad_kills;

	    @FXML
	    private TableColumn<Player, Integer> squad_combatMissions;

	    @FXML
	    private TableColumn<Player, Double> squad_KD;

	    @FXML
	    private TitledPane superUser_SquadMenu;

	    @FXML
	    private ComboBox<String> select_Player_combo;

	    @FXML
	    private ComboBox<String> select_squad_combo;
	    
	    @FXML
	    private ComboBox<String> Select_squad_newPlayer_Combo;

	    @FXML
	    private Spinner<Integer> numberPicker;

	    @FXML
	    private TextField SquadColorField;

	    private List <Jugador> playerList;
	    
	    public EscuadronController(Menu_controller parent) throws IOException {
			
	    	this.parent = parent;
	    	FXMLLoader loader=new FXMLLoader(getClass().getResource("EscuadronVista.fxml"));
	    	loader.setController(this);
	    	
	    	view = loader.load();
	    	
	    	dbGetters = parent.getDbGetters();
	    	dbSetters = parent.getDbSetters();
	    	
			escuadrasBean = FXCollections.observableArrayList();		
			
			initFields();
			
			checkSuperuser();
	    	
	    }
	    
    private void initFields() {
    	
    	
    	
		List squadList = dbGetters.getSquadList();
		playerList = dbGetters.getPlayerList();
		
		System.out.println(squadList.size());
		
		for (int i = 0; i < squadList.size(); i++) {
			Squad act = (Squad)squadList.get(i);
			
			escuadrasBean.add(act);
			
			select_squad_combo.getItems().add(act.getColor());
			
			Select_squad_newPlayer_Combo.getItems().add(act.getColor());
			
			
		}
		
		for (int i = 0; i < playerList.size(); i++) {
			select_Player_combo.getItems().add(
					playerList.get(i).getNombre()+" '"+
					playerList.get(i).getCallsign()+"' "+ 
					playerList.get(i).getApellido());			
		}
		
		Select_squad_newPlayer_Combo.getSelectionModel().select(0);
		select_squad_combo.getSelectionModel().select(0);
		
		bindSquadTable(escuadrasBean.get(select_squad_combo.getSelectionModel().getSelectedIndex()));
		
	}
	
    private void bindSquadTable(Squad squad) {
		
		System.out.println(squad.getColor()+"--"+squad.getPlayers().size());
		
		squad_table.itemsProperty().bind(squad.playersProperty());
		SquadPlayerColumn.setCellValueFactory(cellData -> cellData.getValue().callsignProperty());
		squad_number_column.setCellValueFactory(cellData -> cellData.getValue().squad_numberProperty().asObject());
		
		System.out.println(squad_kills.hasProperties());
		
		squad_kills.setCellValueFactory(cellData -> cellData.getValue().killsProperty().asObject());
		squad_combatMissions.setCellValueFactory(cellData -> cellData.getValue().deathsProperty().asObject());
		squad_KD.setCellValueFactory(cellData -> cellData.getValue().kdRatioProperty().asObject());
    }
    
    @FXML
    void onAddPlayer(ActionEvent event) {
    	int seleccion = select_Player_combo.getSelectionModel().getSelectedIndex();
    	Jugador jugActual = playerList.get(seleccion);
    	Escuadra escActual = new Escuadra(); 
    	int numero = (int) numberPicker.getValue();
    	boolean hasSquad = dbGetters.playerHasSquad(jugActual);
    	
    	List <Escuadra> escuadras = dbGetters.getSquadListRaw();
    	
    	for (Escuadra escuadra : escuadras){
    		if (escuadra.getColor().equals(select_squad_combo.getSelectionModel().getSelectedItem())){
    			escActual = escuadra;
    		}
    	}
    	
    	boolean complete= false;
    	
    	if(hasSquad){
    		complete = dbSetters.changePlayerSquad(jugActual, escActual, numero);
    	}
    	else{
    		complete = dbSetters.putPlayerIntoSquad(jugActual, escActual, numero);
    	}
    	
    	if (complete ){
    		initFields();
    	 	squad_table.itemsProperty().unbind();
        	bindSquadTable(escuadrasBean.get(select_squad_combo.getSelectionModel().getSelectedIndex()));
        }
    }

    @FXML
    void onCreateNewSquad(ActionEvent event) {
    	
    }

    @FXML
    void onShowSquad(ActionEvent event) {
    	squad_table.itemsProperty().unbind();
    	bindSquadTable(escuadrasBean.get(select_squad_combo.getSelectionModel().getSelectedIndex()));}

    private void checkSuperuser() {
    	
		if(parent.getLoginData().isSuperuser()){
			superUser_SquadMenu.setExpanded(true);
			superUser_SquadMenu.setDisable(false);
		}
		else{
			superUser_SquadMenu.setExpanded(false);
			superUser_SquadMenu.setDisable(true);
		}
		
	}
    
	public BorderPane getView() {
		return view;
	}

	public void setView(BorderPane view) {
		this.view = view;
	}



}
