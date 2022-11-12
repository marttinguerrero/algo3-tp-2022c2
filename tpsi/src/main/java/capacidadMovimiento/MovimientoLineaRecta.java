package capacidadMovimiento;

import ficha.Ficha;
//import ficha.Ficha;
import tablero. *;

public class MovimientoLineaRecta implements CapacidadMovimiento{
	
	//precond, entran pos validas
	public boolean validarMovimiento(int posXi, int posYi, int posXf, int posYf, Tablero tablero) {
		Ficha aMover = tablero.obtenerFicha(posXi, posYi);
		Ficha aComer = tablero.obtenerFicha(posXf, posYf);
		
		int movimientosEnX = java.lang.Math.abs(posXf - posXi);
		int movimientosEnY = java.lang.Math.abs(posYf - posYi);
		
		if (aComer != Tablero.VACIO && aComer.obtenerColor() == aMover.obtenerColor()) {
			throw new excepciones.ExcepcionMovimientoInvalido("Una de tus fichas se encuentra en esa posicion");
		}
		
		if (!(movimientosEnY == 0 || movimientosEnY == 0) || (movimientosEnY == 0 && movimientosEnY == 0)) {
			throw new excepciones.ExcepcionMovimientoInvalido("Esta ficha solo puede moverse en linea recta");
		}
		
		if (movimientosEnY == 0) {
			for (int i = 0; i < (movimientosEnX - 1); i++) {
				if (tablero.obtenerFicha(posXi + 1 + i, posYi) != Tablero.VACIO) {
					throw new excepciones.ExcepcionMovimientoInvalido("No se puede saltar fichas");
				}
			}
		}
		
		if (movimientosEnX == 0) {
			for (int i = 0; i < (movimientosEnY - 1); i++) {
				if (tablero.obtenerFicha(posXi , posYi + 1 + i) != Tablero.VACIO) {
					throw new excepciones.ExcepcionMovimientoInvalido("No se puede saltar fichas");
				}
			}
		}
		
		return true;
	}
}
