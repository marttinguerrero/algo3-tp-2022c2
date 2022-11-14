package partida;

import jugador. *;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import fabricaDeFichas.FabricaDeFichas;
import ficha. *;
import interfaceUsuario.InterfaceUsuario;
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

		fichas.add(fabricaDeFichas.crearFicha(color, TipoDeFicha.BANDERA, jugador));
		fichas.add(fabricaDeFichas.crearFicha(color, TipoDeFicha.ESPIA, jugador));
		for (int i = 0; i<8; i++) {
			fichas.add(fabricaDeFichas.crearFicha(color, TipoDeFicha.DOS, jugador));
		}
		for (int i = 0; i<5; i++) {
			fichas.add(fabricaDeFichas.crearFicha(color, TipoDeFicha.TRES, jugador));
		}
		for (int i = 0; i<4; i++) {
			fichas.add(fabricaDeFichas.crearFicha(color, TipoDeFicha.CUATRO, jugador));
		}
		for (int i = 0; i<4; i++) {
			fichas.add(fabricaDeFichas.crearFicha(color, TipoDeFicha.CINCO, jugador));
		}
		for (int i = 0; i<4; i++) {
			fichas.add(fabricaDeFichas.crearFicha(color, TipoDeFicha.SEIS, jugador));
		}
		for (int i = 0; i<3; i++) {
			fichas.add(fabricaDeFichas.crearFicha(color, TipoDeFicha.SIETE, jugador));
		}
		fichas.add(fabricaDeFichas.crearFicha(color, TipoDeFicha.OCHO, jugador));
		fichas.add(fabricaDeFichas.crearFicha(color, TipoDeFicha.OCHO, jugador));
		fichas.add(fabricaDeFichas.crearFicha(color, TipoDeFicha.NUEVE, jugador));
		fichas.add(fabricaDeFichas.crearFicha(color, TipoDeFicha.DIEZ, jugador));
		for (int i = 0; i<6; i++) {
			fichas.add(fabricaDeFichas.crearFicha(color, TipoDeFicha.BOMBA, jugador));
		}
		return fichas;
		
	}
	
	public void comenzarPartida() {
		while(!jugador1.perdio() && !jugador2.perdio()) {
			int posXi = interfaceUsuario.perdirPosXi();
			int posYi = interfaceUsuario.perdirPosYi();
			int posXf = interfaceUsuario.perdirPosXf();
			int posYf = interfaceUsuario.perdirPosYf();
			while (!jugadorEnTurno.moverFicha(posXi, posYi, posXf, posYf, tablero)) {
					posXi = interfaceUsuario.perdirPosXi();
					posYi = interfaceUsuario.perdirPosYi();
					posXf = interfaceUsuario.perdirPosXf();
					posYf = interfaceUsuario.perdirPosYf();
				}
			}
			actualizarTurno();
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
	

}