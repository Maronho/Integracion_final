package gestor.dbOps;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.Query;
import javax.swing.plaf.synth.SynthSpinnerUI;
import javax.swing.text.html.HTMLDocument.HTMLReader.ParagraphAction;

import org.hibernate.Session;

import gestor.Model.Player;
import gestor.dbOps.getters.DbGetters;
import gestor.mapas.Aparato;
import gestor.mapas.Escuadra;
import gestor.mapas.Escuadra_Jugador;
import gestor.mapas.Instructor;
import gestor.mapas.Jugador;
import gestor.mapas.LoginData;
import gestor.mapas.Meritos;
import gestor.mapas.Nivel;
import gestor.mapas.Rango;
import gestor.mapas.Rol;

public class Consultas {

	public static Session sesion;
	
	private DbGetters dbGetters;
	
	public Consultas (){
		this.dbGetters = new DbGetters();
		dbGetters.sesion = this.sesion;
	}
	
	public void createListaEscuadras(){
		Escuadra squad = new Escuadra();
		Escuadra squad2 = new Escuadra();
		squad.setColor("Rojo");
		squad2.setColor("Oro");
		
		Query getPlayers = sesion.createQuery("from Jugador");
		
		Escuadra_Jugador squad_player1 = new Escuadra_Jugador();
		Escuadra_Jugador squad_player2 = new Escuadra_Jugador();
		
		List<Jugador> players = getPlayers.getResultList();
		
		squad_player1.setEscuadra(squad);
		squad_player1.setJugador(players.get(0));
		squad_player1.setNumero(1);
		
		squad_player2.setEscuadra(squad2);
		squad_player2.setJugador(players.get(1));
		squad_player2.setNumero(1);
		
		sesion.beginTransaction();
		sesion.save(squad);
		sesion.save(squad2);
		sesion.save(squad_player1);
		sesion.save(squad_player2);
		
		sesion.getTransaction().commit();
		
		
	}
	
	public void createListaRangos() {
		Rango rang = new Rango();
		
		rang.setCanEdit(true);
		rang.setNombre("Mariscal");
		
		Rango rang2  = new Rango();		
		rang2.setCanEdit(true);
		rang2.setNombre("Jefe de escuadron");
		
		Rango rang3 = new Rango();
		rang3.setCanEdit(true);
		rang3.setNombre("Jefe de escuadra");
		
		Rango rang4 = new Rango();
		rang4.setCanEdit(false);
		rang4.setNombre("Oficial");

		Rango rang5 = new Rango();
		rang5.setCanEdit(false);
		rang5.setNombre("Alferez");		
		
		sesion.beginTransaction();
		sesion.save(rang);
		sesion.save(rang2);
		sesion.save(rang3);
		sesion.save(rang4);
		sesion.save(rang5);
		sesion.getTransaction().commit();
		
	}
	
	public void createListaRoles (){
		Rol rol1,rol2,rol3,rol4,rol5; 
		
		rol1 = new Rol ();
		rol1.setNomRol("CAP");
		rol2 = new Rol();
		rol2.setNomRol("SEAD");
		rol3 = new Rol();
		rol3.setNomRol("CAS");
		rol4 = new Rol();
		rol4.setNomRol("Bombardeo");
		rol5 = new Rol ();
		rol5.setNomRol("Escolta");
		 
		sesion.beginTransaction();
		sesion.save(rol1);
		sesion.save(rol2);
		sesion.save(rol3);
		sesion.save(rol4);
		sesion.save(rol5);
		
		sesion.getTransaction().commit();
	}

	public void createListaAparatos() {
		
		Aparato ap1,ap2,ap3,ap4,ap5;
		ap1= new Aparato();
		ap1.setNombre("F-15");
		ap2 = new Aparato();
		ap2.setNombre("Su-25");
		ap3 = new Aparato();
		ap3.setNombre("Mig-29");
		ap4 = new Aparato();
		ap4.setNombre("Mirage 2000");
		ap5 = new Aparato();
		ap5.setNombre("A-10 C");
		
		
		sesion.beginTransaction();
		
		sesion.save(ap1);
		sesion.save(ap2);
		sesion.save(ap3);
		sesion.save(ap4);
		sesion.save(ap5);
		
		
		sesion.getTransaction().commit();
		
		
	}

	public void createListaNiveles() {
			
		Nivel lv1, lv2, lv3;
		
		lv1 = new Nivel();
		lv1.setNivel("Aprendiz");
		lv2 = new Nivel();
		lv2.setNivel("Combat ready");
		lv3 = new Nivel();
		lv3.setNivel("Profesor");
		
		sesion.beginTransaction();
		
		sesion.save(lv1);
		sesion.save(lv2);
		sesion.save(lv3);
		sesion.getTransaction().commit();
		
	}

	public void createListaMeritos() {
		
		Meritos mr1, mr2, mr3;
		
		mr1 = new Meritos();
		mr1.setNombreMerito("Joven Promesa");
		mr1.setCriterio(3);
		
		mr2 = new Meritos();
		mr2.setNombreMerito("As");
		mr2.setCriterio(6);
		
		mr3 = new Meritos();
		mr3.setNombreMerito("As legendario");
		mr3.setCriterio(10);
		
		sesion.beginTransaction();
		
		sesion.save(mr1);
		sesion.save(mr2);
		sesion.save(mr3);
		sesion.getTransaction().commit();
		
	}

	public void createJugadores(){
		
		List<Rango> rangos = new ArrayList<>();
		List<Aparato>aparatos = new ArrayList<>();
		List<Nivel> niveles = new ArrayList<>();
		
		Query getRangos = sesion.createQuery("from Rango");
		Query getAparatos = sesion.createQuery("from Aparato");
		Query getNiveles = sesion.createQuery("from Nivel");
		
		rangos = getRangos.getResultList();
		aparatos = getAparatos.getResultList();
		niveles = getNiveles.getResultList();
		
		Jugador jg1 = new Jugador();
		LoginData lg1 = new LoginData();
		
		jg1.setNombre("Pepe");
		jg1.setApellido("Perez");
		jg1.setCallsign("Big Boss");
		jg1.setRango(rangos.get(0));
		
		lg1.setJugador(jg1);
		lg1.setUsername("BigBoss");
		lg1.setPassword("12345");
		
		jg1.setLoginData(lg1);
		
		Jugador jg2 = new Jugador();
		LoginData lg2 = new LoginData();
		
		jg2.setNombre("Hans");
		jg2.setApellido("Heinz");
		jg2.setCallsign("Mayonesa");
		jg2.setRango(rangos.get(4));
		
		lg2.setJugador(jg2);
		lg2.setUsername("Mayonesa");
		lg2.setPassword("12345");
		
		jg2.setLoginData(lg2);
		
		Instructor ins1 = new Instructor();
		ins1.setAlumno(jg2);
		ins1.setInstructor(jg2);
		ins1.setAparato(aparatos.get(0));
		ins1.setNivel(niveles.get(1));
		
		sesion.beginTransaction();
		sesion.save(jg1);
		sesion.save(lg1);
		sesion.save(jg2);
		sesion.save(lg2);
		
		sesion.save(ins1);
				
		sesion.getTransaction().commit();
		
	}

	public DbGetters getGetters() {
		return dbGetters;
	}
}
