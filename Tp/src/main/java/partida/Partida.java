package partida;

import jugador. *;

import java.util.ArrayList;

import ej3HerenciayPolimorfismo.Alumno;
import ficha. *; 
import tablero. *;
import ficha.Ficha;

public class Partida {
	private Jugador jugador1;
	private Jugador jugador2;
	private Tablero tablero;
	private Jugador jugadorEnTurno;
	
	public Partida(Jugador jugador1, Jugador jugador2) {
		this.jugador1 = jugador1;
		this.jugador2 = jugador2;
		this.tablero = new Tablero();
		inicializarFichas(Color.ROJA);
		inicializarFichas(Color.AZUL);
	}
	
	private void inicializarFichas(Color color) {
		ArrayList<Ficha> fichas=  new ArrayList<Ficha>();
		fichas.add(new Bandera(color));
		//fichas.add(new Espia(color));
		//fichas.add(new Diez(color));
		//fichas.add(new Nueve(color));
		for (int i = 0; i<8; i++) {
			fichas.add(new Dos(color));
		}
		for (int i = 0; i<8; i++) {
			fichas.add(new Tres(color));
		}
	}
	
	//retorna true si se colocaron todas las fichas correctamente
	public boolean inicializarPartida() {
		return jugador1.armarEstrategia() && jugador2.armarEstrategia();
	}
	
	//seguro hay otra forma de hacer esto
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
