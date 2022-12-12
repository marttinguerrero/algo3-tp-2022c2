package capacidadMovimiento;


import java.util.ArrayList;

import ficha. *;
import tablero. *; 

public class MovimientoDeUnaCasilla implements CapacidadMovimiento , java.io.Serializable{

	private static final long serialVersionUID = 1L;


	//Valida el movimiento de las piezas que se mueven de a un lugar si una pieza se mueve a más de un lugar en el eje X o Y
	// retorna false. 
	public boolean validarMovimiento(int posXi, int posYi, int posXf, int posYf, Tablero tablero) {

		Ficha aMover = tablero.obtenerFicha(posXi, posYi);
		Ficha aComer = tablero.obtenerFicha(posXf, posYf);
		int movimientosEnX = java.lang.Math.abs(posXf - posXi);
		int movimientosEnY = java.lang.Math.abs(posYf - posYi);
		
		if (aComer != Tablero.VACIO && aComer.obtenerColor() == aMover.obtenerColor()) {
			return false;
			
		}
		if (!((movimientosEnX == 1 && movimientosEnY == 0) || (movimientosEnX == 0 && movimientosEnY == 1))) {
			return false;
			
		}
		
		return true;
	}

	
	//Esta función se usa para ver los movimientos posibles que tiene una pieza. Esta función se usa para el jugadorRobot, para que encuentre 
	//movimientos posibles de una pieza elegida de manera random.
	public int[] movimientoPosible(int posXi, int posYi, Tablero tablero) {
		
		
		
		ArrayList<int[]> movimientosPosibles = new ArrayList<int[]>();
		
		int[] pos0 = new int[2]; 
		pos0[0] = posXi + 1;
		pos0[1] = posYi;
		movimientosPosibles.add(pos0);
		
		int[] pos1 = new int[2];
		pos1[0] = posXi - 1;
		pos1[1] = posYi;
		movimientosPosibles.add(pos1);
		
		int[] pos2 = new int[2];
		pos2[0] = posXi;
		pos2[1] = posYi + 1;
		movimientosPosibles.add(pos2);
		
		int[] pos3 = new int[2];
		pos3[0] = posXi;
		pos3[1] = posYi - 1;
		movimientosPosibles.add(pos3);
		
		
		
		for (int i = 0; i < movimientosPosibles.size(); i++) {
			int[] pos = movimientosPosibles.get(i);
			int posXf = pos[0];
			int posYf = pos[1];

			if (tablero.validarPosicion(posXf, posYf) && validarMovimiento(posXi, posYi, posXf, posYf, tablero)) {
				return pos;
			}
		}
		
		return null;
	}
}