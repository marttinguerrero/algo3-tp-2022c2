package capacidadMovimiento;

import ficha. *;
import tablero. *; 

public interface CapacidadMovimiento {
	
	public boolean validarMovimiento(int PosXf, int PosYf , Tablero tablero, Color color);
	
}
