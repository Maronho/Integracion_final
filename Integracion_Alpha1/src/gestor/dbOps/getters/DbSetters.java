package gestor.dbOps.getters;

import org.hibernate.Session;

import gestor.mapas.Escuadra;
import gestor.mapas.Escuadra_Jugador;
import gestor.mapas.Jugador;

public class DbSetters {
	
	public static Session sesion;
	
	public boolean putPlayerIntoSquad(Jugador player, Escuadra squad, int number){
		
		Escuadra_Jugador newPlayer_squad = new Escuadra_Jugador();
		
		newPlayer_squad.setEscuadra(squad);
		newPlayer_squad.setJugador(player);
		newPlayer_squad.setNumero(number);
		
		sesion.beginTransaction();
		sesion.save(newPlayer_squad);
		sesion.getTransaction().commit();		
		
		return true;
	}
	
	public boolean changePlayerSquad(Jugador player, Escuadra squad, int number){
		
		
				
		return false;
	}
}
