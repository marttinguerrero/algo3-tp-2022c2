package capacidadMovimiento;

import ficha.Color;
//import ficha.Ficha;
import tablero. *;

public class MovimientoLineaRecta implements CapacidadMovimiento{
	
	//queda implementar
	public boolean validarMovimiento(int PosXf, int PosYf , Tablero tablero, Color color) {
		if (tablero.obtenerFicha(PosXf, PosYf).obtenerColor() == color) {
			return false;
		}
		return true;
	}
}
