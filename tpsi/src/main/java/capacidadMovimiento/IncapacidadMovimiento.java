package capacidadMovimiento;

import tablero. *; 

public class IncapacidadMovimiento implements CapacidadMovimiento{
	
	public boolean validarMovimiento(int posXi, int posYi, int posXf, int posYf, Tablero tablero) {
		throw new excepciones.ExcepcionMovimientoInvalido("Las Bombas no pueden moverse");
	}
}
