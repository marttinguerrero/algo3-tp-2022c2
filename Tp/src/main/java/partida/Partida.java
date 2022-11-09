package partida;

import jugador. *;
import interfaceUsuario. *; 
import capacidadEnfrentamiento. *;

import capacidadMovimiento. *;
import java.util.ArrayList;

import ficha. *; 
import tablero. *;

public class Partida {
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
	}
	
	//Ficha(Color color, int valor, CapacidadMovimiento capacidadMovimiento, CapacidadEnfrentamiento capacidadEnfrentamiento, Jugador jugador)
	
	private ArrayList<Ficha> inicializarFichas(Color color, Jugador jugador) {
		ArrayList<Ficha> fichas =  new ArrayList<Ficha>();
		fichas.add(new Ficha(color, 0, new MovimientoDeUnaCasilla(), new CapacidadGanarMenoresYDiez(), jugador));
		fichas.add(new Ficha(color, 1, new MovimientoDeUnaCasilla(), new CapacidadGanarMenores(), jugador));
		for (int i = 0; i<8; i++) {
			fichas.add(new Ficha(color, 2, new MovimientoLineaRecta(), new CapacidadGanarMenores(), jugador));
		}
		for (int i = 0; i<5; i++) {
			fichas.add(new Ficha(color, 3, new MovimientoDeUnaCasilla(), new CapacidadGanarMenoresYBomba(), jugador));
		}
		for (int i = 0; i<4; i++) {
			fichas.add(new Ficha(color, 4, new MovimientoDeUnaCasilla(), new CapacidadGanarMenores(), jugador));
		}
		for (int i = 0; i<4; i++) {
			fichas.add(new Ficha(color, 5, new MovimientoDeUnaCasilla(), new CapacidadGanarMenores(), jugador));
		}
		for (int i = 0; i<4; i++) {
			fichas.add(new Ficha(color, 6, new MovimientoDeUnaCasilla(), new CapacidadGanarMenores(), jugador));
		}
		for (int i = 0; i<3; i++) {
			fichas.add(new Ficha(color, 7, new MovimientoDeUnaCasilla(), new CapacidadGanarMenores(), jugador));
		}
		fichas.add(new Ficha(color, 8, new MovimientoDeUnaCasilla(), new CapacidadGanarMenores(), jugador));
		fichas.add(new Ficha(color, 8, new MovimientoDeUnaCasilla(), new CapacidadGanarMenores(), jugador));
		fichas.add(new Ficha(color, 9, new MovimientoDeUnaCasilla(), new CapacidadGanarMenores(), jugador));
		fichas.add(new Ficha(color, 10, new MovimientoDeUnaCasilla(), new CapacidadGanarMenores(), jugador));
		for (int i = 0; i<6; i++) {
			fichas.add(new Ficha(color, 11, new IncapacidadMovimiento(), new CapacidadGanarMenores(), jugador));
		}
		return fichas;
		
	}
	
	public void comenzarPartida() {
		boolean seguirJugando = true;
		while(!jugador1.perdio() && !jugador2.perdio() && seguirJugando) {
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
			actualizarTurno();
			seguirJugando = interfaceUsuario.perdirSiQuiereSeguirJugando();
		}
	}
	
	//retorna true si se colocaron todas las fichas correctamente
	public boolean inicializarPartida() {
		return jugador1.armarEstrategia() && jugador2.armarEstrategia();
	}
	
	//seguro hay otra forma de hacer esto
	private void actualizarTurno() {
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
