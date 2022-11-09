package jugador;

import ficha.Ficha;

public interface Jugador {
	
	public boolean armarEstrategia();
	
	public boolean moverFicha(int posXi, int posYi, int posXf, int posYf);
	
	public boolean perdio();
	
	public void perderFicha(Ficha ficha);
}
