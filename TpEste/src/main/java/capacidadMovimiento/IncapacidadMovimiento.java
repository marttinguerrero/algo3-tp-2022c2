package capacidadMovimiento;


import tablero. *; 

public class IncapacidadMovimiento implements CapacidadMovimiento , java.io.Serializable{
	
	private static final long serialVersionUID = 1L;

	public boolean validarMovimiento(int posXi, int posYi, int posXf, int posYf, Tablero tablero) {
		//throw new excepciones.ExcepcionMovimientoInvalido("Las Bombas no pueden moverse");
		return false;
	}
	
	public int[] movimientoPosible(int posXi, int posYi, Tablero tablero) {
		return null;
	}
}
