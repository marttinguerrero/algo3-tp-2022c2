package capacidadMovimiento;

import ficha. *;
import tablero. *; 

public class MovimientoDeUnaCasilla implements CapacidadMovimiento{

	//queda terminar
	public boolean validarMovimiento(int PosXf, int PosYf , Tablero tablero, Color color) {
		if (tablero.obtenerFicha(PosXf, PosYf) == Tablero.VACIO || tablero.obtenerFicha(PosXf, PosYf).obtenerColor() == color) {
			return false;
		}
		return true;
	}
}
