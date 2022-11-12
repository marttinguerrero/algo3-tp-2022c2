package capacidadMovimiento;

import ficha. *;
import tablero. *; 

public class MovimientoDeUnaCasilla implements CapacidadMovimiento{

	//precond, entran pos validas
	public boolean validarMovimiento(int posXi, int posYi, int posXf, int posYf, Tablero tablero) {
		Ficha aMover = tablero.obtenerFicha(posXi, posYi);
		Ficha aComer = tablero.obtenerFicha(posXf, posYf);
		
		int movimientosEnX = java.lang.Math.abs(posXf - posXi);
		int movimientosEnY = java.lang.Math.abs(posYf - posYi);
		
		if (aComer != Tablero.VACIO && aComer.obtenerColor() == aMover.obtenerColor()) {
			throw new excepciones.ExcepcionMovimientoInvalido("Una de tus fichas se encuentra en esa posicion");
		}
		if (!((movimientosEnX == 1 && movimientosEnY == 0) || (movimientosEnX == 0 && movimientosEnY == 1))) {
			throw new excepciones.ExcepcionMovimientoInvalido("Esta ficha solo puede moverse una casilla a la vez y en linea recta");
		}
		return true;
	}
}
