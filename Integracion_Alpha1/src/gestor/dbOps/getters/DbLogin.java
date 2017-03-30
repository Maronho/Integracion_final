package gestor.dbOps.getters;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import gestor.Model.Player;
import gestor.mapas.Escuadra;
import gestor.mapas.Escuadra_Jugador;
import gestor.mapas.Jugador;
import gestor.mapas.LoginData;

public class DbLogin {

	public static Session sesion;
	
	private boolean isLogged;
	private boolean isSuperuser;
	private Jugador logged;
	private Escuadra_Jugador squad;
	
	public DbLogin() {
		isLogged = false;
		
	}
	
	public boolean logIn(String username, String pssword){		
	
		List<Jugador> jugadores = new ArrayList<>();
		Query getPlayers = sesion.createQuery("From Jugador");		
		jugadores = getPlayers.getResultList();		
		
		for (int i = 0; i < jugadores.size(); i++) {
			LoginData log = jugadores.get(i).getLoginData();
			
			if (log.getUsername().equals(username)){
				
				if (log.getPassword().equals(pssword)){
					isLogged=true;
					logged = jugadores.get(i);
					isSuperuser = jugadores.get(i).getRango().isCanEdit();
				}
			}
		}
		
		if (isLogged){
			List <Escuadra_Jugador> squadList=  new ArrayList<>();
			Query getSquad = sesion.createQuery("From Escuadra_Jugador");
			squadList = getSquad.getResultList();
			for (int i = 0; i < squadList.size(); i++) {
				if (squadList.get(i).getJugador().equals(logged)){
					squad = squadList.get(i);
				}
			}
		}
		
		return isLogged;		
	}

	public boolean isLogged() {
		return isLogged;
	}

	public boolean isSuperuser() {
		return isSuperuser;
	}

	public Jugador getLogged() {
		return logged;
	}

	public Escuadra_Jugador getSquad() {
		return squad;
	}

	public void setSquad(Escuadra_Jugador squad) {
		this.squad = squad;
	}
	
}
