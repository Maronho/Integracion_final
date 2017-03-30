package gestor.Interface;

import java.io.IOException;
import java.util.List;

import org.hibernate.Session;

import gestor.Model.Player;
import gestor.Model.Squad;
import gestor.VistasParciales.EscuadronController;
import gestor.dbOps.getters.DbGetters;
import gestor.dbOps.getters.DbLogin;
import gestor.dbOps.getters.DbSetters;
import gestor.mapas.Escuadra;
import gestor.mapas.HibernateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Menu_controller {
	
	private DbLogin loginData;
	
	private DbGetters getters;
	
	private BorderPane vista;
	
	@FXML
    private TabPane tabPane;
	
    @FXML
    private Tab squadTab;
	
	@FXML
	private Text name_text;

    @FXML
    private Text callsign_text;

    @FXML
    private Text surname_text;

    @FXML
    private Text rank_text;

    @FXML
    private Text squad_text;

    @FXML
    private Text number_text;
	
    private Stage stage;
    
    private Session sesion;
    
    private DbGetters dbGetters;
    private DbSetters dbSetters;
    
    private ObservableList<Squad> escuadrasBean;
    
    private EscuadronController squadControl;

    public Menu_controller(Stage stage, login_controller login_controller) {
    	
    	sesion= login_controller.getSesion();
    	
    	dbGetters = new DbGetters();
    	dbSetters = new DbSetters();
    	
    	dbGetters.sesion = this.sesion;
    	dbSetters.sesion = this.sesion;
    	
    	
    	this.stage=stage;
		FXMLLoader loader=new FXMLLoader(getClass().getResource("menu_view.fxml"));
		loader.setController(this);
		try {
			vista=loader.load();
		} catch (IOException e) {
     	e.printStackTrace();}
		
		this.loginData= login_controller.getLoginData();
		
		name_text.setText(loginData.getLogged().getNombre());
		callsign_text.setText("'"+loginData.getLogged().getCallsign()+"'");
		surname_text.setText(loginData.getLogged().getApellido());
		
		rank_text.setText(loginData.getLogged().getRango().getNombre());
		
		squad_text.setText(loginData.getSquad().getEscuadra().getColor());
		number_text.setText(Integer.toString(loginData.getSquad().getNumero()));
		
		escuadrasBean = FXCollections.observableArrayList();		
		
			
		try {
			squadControl = new EscuadronController(this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		System.out.println(squadControl.getView().getId());	
		
		//squadTab.setContent(squadControl.getSquadBorderPane());
		
		System.out.println(tabPane.getTabs().size());
		
		tabPane.getTabs().add(new Tab("Escuadron", squadControl.getView()));
		
		//checkSuperuser();
		
		//initFields();
		
		
		
	}

	/**/

	/*private void initFields() {
		List squadList = dbGetters.getSquadList();
		
		System.out.println(squadList.size());
		
		for (int i = 0; i < squadList.size(); i++) {
			Squad act = (Squad)squadList.get(i);
			
			escuadrasBean.add(act);
			
			select_squad_combo.getItems().add(act.getColor());
			
			Select_squad_newPlayer_Combo.getItems().add(act.getColor());
			
			
		}
		
		Select_squad_newPlayer_Combo.getSelectionModel().select(0);
		select_squad_combo.getSelectionModel().select(0);
		
		bindSquadTable(escuadrasBean.get(select_squad_combo.getSelectionModel().getSelectedIndex()));
		
	}*/

	/*private void checkSuperuser() {
	
		if(loginData.isSuperuser()){
			superUser_SquadMenu.setExpanded(true);
			superUser_SquadMenu.setDisable(false);
		}
		else{
			superUser_SquadMenu.setExpanded(false);
			superUser_SquadMenu.setDisable(true);
		}
		
	}*/

	@FXML
    void onAddPlayer(ActionEvent event) {

    }

    @FXML
    void onCreateNewSquad(ActionEvent event) {

    }

    @FXML
    void onShowSquad(ActionEvent event) {

    }

    @FXML
    void select_squad_combo(ActionEvent event) {

    }

	public BorderPane getVista() {
		return vista;
	}

	public void setVista(BorderPane vista) {
		this.vista = vista;
	}

	public DbGetters getDbGetters() {
		return dbGetters;
	}

	public void setDbGetters(DbGetters dbGetters) {
		this.dbGetters = dbGetters;
	}

	public DbSetters getDbSetters() {
		return dbSetters;
	}

	public void setDbSetters(DbSetters dbSetters) {
		this.dbSetters = dbSetters;
	}

	public DbLogin getLoginData() {
		return loginData;
	}
}
