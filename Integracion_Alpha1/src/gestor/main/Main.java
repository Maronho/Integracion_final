package gestor.main;

import java.util.Scanner;

import org.hibernate.Session;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import gestor.Interface.login_controller;
import gestor.dbOps.Consultas;
import gestor.mapas.HibernateUtil;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;



public class Main extends Application{

	
	private Session sesion;
	
	public static void main(String[] args) {
		Session sesion = HibernateUtil.getSessionFactory().openSession();
		Consultas.sesion = sesion;
	
		Consultas cons = new Consultas();
	
		//cons.createListaEscuadras();
		/*cons.createListaRangos();
		cons.createListaRoles();
		cons.createListaAparatos();
		
		cons.createListaNiveles();
		cons.createListaMeritos();*/

		
		//cons.createJugadores();
	
		launch(args);
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		
		login_controller login =new login_controller(primaryStage, this);
		
		primaryStage.setScene(new Scene(login.getVista()));
		primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/recursos/imagenes/red_flag_icon.png")));
		primaryStage.setTitle("RED FLAG");
		primaryStage.show();
		
	}

}
