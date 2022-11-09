package ficha;

import capacidadEnfrentamiento. *;
import capacidadMovimiento. *;
import tablero. *;

public class Ficha {
	
	private int valor;
	private Color color;
	private CapacidadMovimiento capacidadMovimiento;
	private CapacidadEnfrentamiento capacidadEnfrentamiento;
	
	public Ficha(Color color, int valor, CapacidadMovimiento capacidadMovimiento, CapacidadEnfrentamiento capacidadEnfrentamiento) {
		this.color = color;
		this.valor = 2;
		this.capacidadMovimiento = capacidadMovimiento;
		this.capacidadEnfrentamiento = capacidadEnfrentamiento;
	}
	
	public boolean validarMovimiento(int posX, int posY, Tablero tablero) {
		return capacidadMovimiento.validarMovimiento(posX, posY, tablero, color);
	}
	
	public ResultadoEnfrentamiento enfrentar(Ficha ficha) {
		return capacidadEnfrentamiento.enfrentar(ficha, valor);
	}
	
	public int obtenerValor() {
		return valor;
	}
	
	public Color obtenerColor() {
		return color;
		
	}
}