package gestor.dbOps.getters;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import gestor.Model.Player;
import gestor.Model.Squad;
import gestor.mapas.Aparato;
import gestor.mapas.Escuadra;
import gestor.mapas.Escuadra_Jugador;
import gestor.mapas.Estadisticas;
import gestor.mapas.Jugador;
import gestor.mapas.Rango;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DbGetters {
	
	public static Session sesion;
	
	public List getPlayersBySquad(int cod){
		List<Player> jugadores= new ArrayList<>();
		
		return jugadores;
	}
	
	public List getSquadList(){
		List<Escuadra> escuadras = new ArrayList<Escuadra>();
		List<Escuadra_Jugador> escuadra_Jugadors = new ArrayList<Escuadra_Jugador>();
		List<Estadisticas> estadisticas = new ArrayList<Estadisticas>();
		
		List <Squad> squadList = new ArrayList<Squad>();
		
		Query getEscuadras = sesion.createQuery("From Escuadra");
		
		escuadras = getEscuadras.getResultList();
		
		Query getJugadoresEscuadra = sesion.createQuery("From Escuadra_Jugador");
		
		escuadra_Jugadors = getJugadoresEscuadra.getResultList();
		
		Query getEstadisticas = sesion.createQuery("From Estadisticas");
		
		estadisticas = getEstadisticas.getResultList();
		
		for (int i = 0; i < escuadras.size(); i++) {
						
			String color = escuadras.get(i).getColor();
			ObservableList<Player> list = FXCollections.observableArrayList();
			
			for (int j = 0; j < escuadra_Jugadors.size(); j++) {
				
				if (escuadra_Jugadors.get(j).getEscuadra().getColor().equals(color))
				{
					System.out.println(escuadra_Jugadors.get(j).getJugador().getCallsign()+" --> "+ color);					
					
					Jugador act = escuadra_Jugadors.get(j).getJugador();					
					
					for (int j2 = 0; j2 < estadisticas.size(); j2++) {
						
						Estadisticas currentStats = estadisticas.get(j2);
						
						System.out.println(currentStats.getJugador().getCodPlayer()+" -> "+act.getCodPlayer());
						
						if (currentStats.getJugador().getCodPlayer() == act.getCodPlayer()){
							System.out.println("CoincideB");
							Player play = new Player(
									currentStats.getJugador().getNombre(), 
									currentStats.getJugador().getApellido(), 
									currentStats.getJugador().getCallsign(), 
									currentStats.getDerribos(), 
									currentStats.getSalidas(), 
									escuadra_Jugadors.get(j).getNumero(),
									currentStats.getKill_ratio());
							
							list.add(play);
						}
					}
					//list.clear();
				}
				
			}

			squadList.add(new Squad(color, list));
		}
		
		return squadList;
	}

	public List getPlayerList(){
		List <Jugador> listPlayersBySquad = new ArrayList<Jugador>();
		Query getJugadores = sesion.createQuery("From Jugador");
		
		listPlayersBySquad = getJugadores.getResultList();
		
		return listPlayersBySquad;		
	}
	
	public boolean playerHasSquad(Jugador player){
		
		List <Escuadra_Jugador> listPlayersBySquad = new ArrayList<Escuadra_Jugador>();
		
		Query getJugadoresEscuadra = sesion.createQuery("From Escuadra_Jugador");
		
		boolean hasSquad = false;
		
		listPlayersBySquad = getJugadoresEscuadra.getResultList();
		
		for (int i = 0; i < listPlayersBySquad.size(); i++) {
			if (listPlayersBySquad.get(i).getCod_jugador_escuadra() == player.getCodPlayer()){
				hasSquad=true;
			}
		}
		
		return hasSquad;
	}
	
	public List getSquadListRaw(){
		List <Escuadra> listSquads = new ArrayList<Escuadra>();
		Query getJugadoresEscuadra = sesion.createQuery("From Escuadra");
		return getJugadoresEscuadra.getResultList();
	}
		
	public List getAparatos(){
		
		List<Aparato> listaAparatos = new ArrayList<>();
		
		Query getAparatos = sesion.createQuery("from Aparato");
		
		listaAparatos = getAparatos.getResultList();
		
		return listaAparatos;
	} 
	
	public List getRango(){
		List<Rango> listaRangos = new ArrayList<>();
		Query getRangos = sesion.createQuery("from Rango");
		
		listaRangos = getRangos.getResultList();
		
		return listaRangos;
	}
	
}
