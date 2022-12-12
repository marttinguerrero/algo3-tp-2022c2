
package capacidadMovimiento;


import tablero. *; 

public class IncapacidadMovimiento implements CapacidadMovimiento , java.io.Serializable{
	
	private static final long serialVersionUID = 1L;

	
	
	//Esta función retorna siempre false, es para las piezas que no se pueden mover.
	public boolean validarMovimiento(int posXi, int posYi, int posXf, int posYf, Tablero tablero) {
		
		return false;
	}
	
	
	//Está función retorna siempre false, porque se fija los movimientos posibles de piezas que no se pueden mover.
	public int[] movimientoPosible(int posXi, int posYi, Tablero tablero) {
		return null;
	}
}