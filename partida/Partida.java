package partida;

import jugador. *;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
//import com.csvreader.CsvReader;
//import com.csvreader.CsvWriter;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileWriter;
//import java.io.IOException;
import java.util.ArrayList;
//import java.util.List;
import interfaceUsuario. *; 
import capacidadEnfrentamiento. *;

import capacidadMovimiento. *;
//import java.util.ArrayList;
import fabricaDeFichas.FabricaDeFichas;
import ficha. *; 
import tablero. *;

public class Partida implements Serializable{
	private static final long serialVersionUID = 1L;
	private Jugador jugador1;
	private Jugador jugador2;
	private Tablero tablero;
	private Jugador jugadorEnTurno;
	private InterfaceUsuario interfaceUsuario;
	

	
	public Partida(Jugador jugador1, Jugador jugador2, InterfaceUsuario interfaceUsuario) {
		this.interfaceUsuario = interfaceUsuario;
		this.jugador1 = jugador1;
		this.jugador2 = jugador2;
		ArrayList<Ficha> fichasRojas = inicializarFichas(Color.ROJA, jugador1);
		ArrayList<Ficha> fichasAzules = inicializarFichas(Color.AZUL, jugador2);
		this.tablero = new Tablero(fichasRojas, fichasAzules);
		this.jugadorEnTurno = jugador1;
	}
	
	
	public boolean guardarPartida(String nombreArchivo, Partida partida) throws IOException {
		
		try (FileOutputStream fileOutputStream = new FileOutputStream(nombreArchivo)){
			
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		objectOutputStream.writeObject(partida);
		objectOutputStream.close();
		return true;
		}
		
		catch (IOException e) {
			return false;
		}
		
		
	}
	public boolean cargarPartida(String nombreArchivo, Partida partida) throws IOException, ClassNotFoundException {
		try(FileInputStream fileInputStream = new FileInputStream(nombreArchivo)){
		
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		partida = (Partida) objectInputStream.readObject();
		objectInputStream.close();
		return true;
		}
		catch (IOException e) {
			return false;
		}	
		
	}
	
	
	public ArrayList<Ficha> inicializarFichas(Color color, Jugador jugador) {
		ArrayList<Ficha> fichas =  new ArrayList<Ficha>();
		FabricaDeFichas fabricaDeFichas = new FabricaDeFichas();

		fichas.add(fabricaDeFichas.crearFicha(color, 0, jugador));
		fichas.add(fabricaDeFichas.crearFicha(color, 1, jugador));
		for (int i = 0; i<8; i++) {
			fichas.add(fabricaDeFichas.crearFicha(color, 2, jugador));
		}
		for (int i = 0; i<5; i++) {
			fichas.add(fabricaDeFichas.crearFicha(color, 3, jugador));
		}
		for (int i = 0; i<4; i++) {
			fichas.add(fabricaDeFichas.crearFicha(color, 4, jugador));
		}
		for (int i = 0; i<4; i++) {
			fichas.add(fabricaDeFichas.crearFicha(color, 5, jugador));
		}
		for (int i = 0; i<4; i++) {
			fichas.add(fabricaDeFichas.crearFicha(color, 6, jugador));
		}
		for (int i = 0; i<3; i++) {
			fichas.add(fabricaDeFichas.crearFicha(color, 7, jugador));
		}
		fichas.add(fabricaDeFichas.crearFicha(color, 8, jugador));
		fichas.add(fabricaDeFichas.crearFicha(color, 8, jugador));
		fichas.add(fabricaDeFichas.crearFicha(color, 9, jugador));
		fichas.add(fabricaDeFichas.crearFicha(color, 10, jugador));
		for (int i = 0; i<6; i++) {
			fichas.add(fabricaDeFichas.crearFicha(color, 11, jugador));
		}
		return fichas;
		
	}
	
	
	public void comenzarPartida() {
		boolean seguirJugando = true;
		tablero.imprimir_tablero();
			actualizarTurno();
			tablero.imprimir_tablero();
		}

	public boolean inicializarPartida() {
		return jugador1.armarEstrategia() && jugador2.armarEstrategia();
	}
	
	public void actualizarTurno() {
		if (jugadorEnTurno == jugador1) {
			jugadorEnTurno = jugador2;
		} else {
			jugadorEnTurno = jugador1;
		}
	}
	
	public boolean finDePartida() {
		return jugador1.perdio() || jugador2.perdio();
	}
}
