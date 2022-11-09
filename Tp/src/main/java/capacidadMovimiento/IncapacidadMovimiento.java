package capacidadMovimiento;

import ficha. *;
import tablero. *; 

public class IncapacidadMovimiento implements CapacidadMovimiento{
	
	public boolean validarMovimiento(int PosXf, int PosYf , Tablero tablero, Color color) {
		return false;
	}
}
