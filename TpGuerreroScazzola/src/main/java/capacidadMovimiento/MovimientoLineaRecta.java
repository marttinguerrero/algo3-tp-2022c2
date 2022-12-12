package capacidadMovimiento;


import java.util.ArrayList;

import ficha.Ficha;

import tablero. *;

public class MovimientoLineaRecta implements CapacidadMovimiento , java.io.Serializable{
	
	private static final long serialVersionUID = 1L;


	//Esta función chequea los movimientos de la pieza número 2 que puede moverse libremente en linea recta, siempre y cuando no haya otra
	//pieza en su camino. Se fija que si se mueve en el eje X no se mueva en el eje Y, lo mismo viceversa, sino retorna false.
	public boolean validarMovimiento(int posXi, int posYi, int posXf, int posYf, Tablero tablero) {
		Ficha aMover = tablero.obtenerFicha(posXi, posYi);
		Ficha aComer = tablero.obtenerFicha(posXf, posYf);
		
		int movimientosEnX = java.lang.Math.abs(posXf - posXi);
		int movimientosEnY = java.lang.Math.abs(posYf - posYi);
		
		if (aComer != Tablero.VACIO && aComer.obtenerColor() == aMover.obtenerColor()) {
			return false;
		}
		
		if (!((movimientosEnX == 0 && movimientosEnY != 0) ||(movimientosEnX != 0 && movimientosEnY == 0))) {
			return false;
		}
		
		if (movimientosEnY == 0) {
			for (int i = 0; i < (movimientosEnX - 1); i++) {
				if (tablero.obtenerFicha(posXi + (((posXf - posXi) /java.lang.Math.abs(posXf - posXi)) + i*((posXf - posXi) /java.lang.Math.abs(posXf - posXi))), posYi) != Tablero.VACIO) {
					return false;
				}
			}
		}
		
		if (movimientosEnX == 0) {
			for (int i = 0; i < (movimientosEnY - 1); i++) {
				if (tablero.obtenerFicha(posXi , posYi + ((posYf - posYi) /java.lang.Math.abs(posYf - posYi)) + i) != Tablero.VACIO) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	
	
	//Esta función se usa para ver los movimientos posibles que tiene una pieza. Esta función se usa para el jugadorRobot, para que encuentre 
	//movimientos posibles de una pieza elegida de manera random.
	public int[] movimientoPosible(int posXi, int posYi, Tablero tablero) {
		
		
		ArrayList<int[]> movimientosPosibles = new ArrayList<int[]>();
		
		for (int i = 1; i < 10; i++) {
			
			int[] pos0 = new int[2];
			pos0[0] = posXi + i;
			pos0[1] = 0;
			movimientosPosibles.add(pos0);
			
			int[] pos1 = new int[2];
			pos1[0] = posXi - i;
			pos1[1] = 0;
			movimientosPosibles.add(pos1);
			
			int[] pos2 = new int[2];
			pos2[0] = 0;
			pos2[1] = posYi + i;
			movimientosPosibles.add(pos2);
			
			int[] pos3 = new int[2];
			pos3[0] = 0;
			pos3[1] = posYi - i;
			movimientosPosibles.add(pos3);
		}
		
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