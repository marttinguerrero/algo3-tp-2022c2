package ficha;

import capacidadEnfrentamiento. *;
import capacidadMovimiento. *;
import tablero. *;
import jugador. *;

public class Ficha {
	
	private int valor;
	private Color color;
	private CapacidadMovimiento capacidadMovimiento;
	private CapacidadEnfrentamiento capacidadEnfrentamiento;
	private Jugador jugador;
	
	public Ficha(Color color, int valor, CapacidadMovimiento capacidadMovimiento, CapacidadEnfrentamiento capacidadEnfrentamiento, Jugador jugador) {
		this.color = color;
		this.valor = 2;
		this.capacidadMovimiento = capacidadMovimiento;
		this.capacidadEnfrentamiento = capacidadEnfrentamiento;
		this.jugador = jugador;
	}
	public Jugador obtenerJugador() {
		return jugador;
	}
	
	public boolean validarMovimiento(int posX, int posY, Tablero tablero) {
		return capacidadMovimiento.validarMovimiento(posX, posY, tablero, color);
	}
	
	public ResultadoEnfrentamiento enfrentar(Ficha ficha) {
		return capacidadEnfrentamiento.enfrentar(this, ficha);
	}
	
	public int obtenerValor() {
		return valor;
	}
	
	public Color obtenerColor() {
		return color;
		
	}
}