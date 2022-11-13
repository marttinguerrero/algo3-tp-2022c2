package capacidadMovimiento;

import java.util.ArrayList;

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
			return false;
			//throw new excepciones.ExcepcionMovimientoInvalido("Una de tus fichas se encuentra en esa posicion");
		}
		if (!((movimientosEnX == 1 && movimientosEnY == 0) || (movimientosEnX == 0 && movimientosEnY == 1))) {
			return false;
			//throw new excepciones.ExcepcionMovimientoInvalido("Esta ficha solo puede moverse una casilla a la vez y en linea recta");
		}
		return true;
	}

	
	public int[] movimientoPosible(int posXi, int posYi, Tablero tablero) {
		
		//falta validar si es una pos valida del tablero xf e yf
		
		System.out.print(String.format("entra la ficha %d para buscar mov posibles\n", tablero.obtenerFicha(posXi, posYi).obtenerValor()));
		ArrayList<int[]> movimientosPosibles = new ArrayList<int[]>();
		
		//movimiento horizontal a la derecha
		int[] pos0 = new int[2];
		pos0[0] = posXi + 1;
		pos0[1] = 0;
		movimientosPosibles.add(pos0);
		
		int[] pos1 = new int[2];
		pos1[0] = posXi - 1;
		pos1[1] = 0;
		movimientosPosibles.add(pos1);
		
		int[] pos2 = new int[2];
		pos2[0] = 0;
		pos2[1] = posYi + 1;
		movimientosPosibles.add(pos2);
		
		int[] pos3 = new int[2];
		pos3[0] = 0;
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
