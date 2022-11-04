package partida;

import jugador. *;
import tablero. *;

public class Partida {
	private Jugador jugador1;
	private Jugador jugador2;
	private Tablero tablero;
	private Jugador jugadorEnTurno;
	
	public Partida(Jugador jugador1, Jugador jugador2, Tablero tablero) {
		this.jugador1 = jugador1;
		this.jugador2 = jugador2;
		this.tablero = tablero;
		
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
