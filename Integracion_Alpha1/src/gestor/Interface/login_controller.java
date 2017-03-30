package gestor.Interface;

import java.io.IOException;

import org.hibernate.Session;

import gestor.dbOps.getters.DbLogin;
import gestor.main.Main;
import gestor.mapas.HibernateUtil;
import gestor.mapas.LoginData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class login_controller {

	private Main parentClass;
	private Stage stage;
	private BorderPane vista;
	
	private DbLogin loginData;
	
	private Session sesion;
	
	private Menu_controller menuControl;
	
	@FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    public login_controller(Stage stage, Main parent) {
    	this.stage=stage;
		FXMLLoader loader=new FXMLLoader(getClass().getResource("login_view.fxml"));
		loader.setController(this);
		try {
			vista=loader.load();
		} catch (IOException e) {
     	e.printStackTrace();}
		
		sesion = HibernateUtil.getSessionFactory().openSession();
		
		loginData = new DbLogin();
		loginData.sesion = sesion;
	}
    
    private void launchMenu() {
	
    	menuControl =new Menu_controller(stage, this);
		
		stage.setScene(new Scene(menuControl.getVista()));
		stage.getIcons().add(new Image(getClass().getResourceAsStream("/recursos/imagenes/red_flag_icon.png")));
		stage.setTitle("RED FLAG");
		stage.show();
	}
    
    @FXML
    void onCrearUsuario(ActionEvent event) {
    
    }

    
    
    @FXML
    void onLogearseButton(ActionEvent event) {
    	if (loginData.logIn(usernameField.getText(), passwordField.getText())){
    		System.out.println(loginData.getLogged().getNombre()+" "+loginData.getLogged().getApellido());
    		
    		launchMenu();
    		
    	}
    	else{
    		Alert alert = new Alert(AlertType.WARNING);
    		alert.setTitle("Error");
    		alert.setHeaderText("Datos de login incorrectos");
    		alert.setContentText("Revise los campos");

    		alert.showAndWait();
    	}
    }



	@FXML
    void onRecuperarContraseña(ActionEvent event) {

    }

    @FXML
    void onSalirButton(ActionEvent event) {

    }

	public BorderPane getVista() {
		return vista;
	}

	public void setVista(BorderPane vista) {
		this.vista = vista;
	}

	public DbLogin getLoginData() {
		return loginData;
	}

	public void setLoginData(DbLogin loginData) {
		this.loginData = loginData;
	}

	public Session getSesion() {
		return sesion;
	}

	public void setSesion(Session sesion) {
		this.sesion = sesion;
	}
	
}
