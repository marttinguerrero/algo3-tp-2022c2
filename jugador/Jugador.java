package jugador;

import ficha.Ficha;
import tablero.Tablero;

public interface Jugador {
	
	public boolean armarEstrategia();
	
	public boolean moverFicha(int posXi, int posYi, int posXf, int posYf, Tablero tablero);
	
	public boolean perdio();
	
	public void perderFicha(Ficha ficha);
	
	//public String obtenerNombre();
	
	//public String obtenerTipo();
	
	//public String obtenerColor();
	
}
