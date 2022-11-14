package ficha;

import java.io.Serializable;

import capacidadEnfrentamiento. *;
import capacidadMovimiento. *;
import tablero. *;
import jugador. *;

public class Ficha implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	private int valor;
	private Color color;
	private CapacidadMovimiento capacidadMovimiento;
	private CapacidadEnfrentamiento capacidadEnfrentamiento;
	private Jugador jugador;
	
	public Ficha(Color color, int valor, CapacidadMovimiento capacidadMovimiento, CapacidadEnfrentamiento capacidadEnfrentamiento, Jugador jugador) {
		this.color = color;
		this.valor = valor;
		this.capacidadMovimiento = capacidadMovimiento;
		this.capacidadEnfrentamiento = capacidadEnfrentamiento;
		this.jugador = jugador;
	}
	public Jugador obtenerJugador() {
		return jugador;
	}
	
	public boolean validarMovimiento(int posXi, int posYi, int posXf, int posYf, Tablero tablero) {
		return capacidadMovimiento.validarMovimiento(posXi, posYi, posXf, posYf, tablero);
	}
	
	public ResultadoEnfrentamiento enfrentar(Ficha ficha) {
		return capacidadEnfrentamiento.enfrentar(this, ficha);
	}
	
	public int[] movimientoPosible(int posXi, int posYi, Tablero tablero) {
		int[] mov = capacidadMovimiento.movimientoPosible(posXi, posYi, tablero);
		if (mov != null) {
			return mov;
		}
		return null;
	}
	
	public int obtenerValor() {
		return valor;
	}
	
	public Color obtenerColor() {
		return color;
		
	}
}