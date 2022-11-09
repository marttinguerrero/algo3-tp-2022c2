package jugador;

import tablero. *;
import ficha. *; 

public class JugadorHumano implements Jugador{
	//fichas colocadas sera la suma de estas dos
	private int fichasVivas;
	//private int fichasMuertas;
	private int fichaMineroVivas;
	private int fichaBombaVivas;
	private Tablero tablero;
	
	public JugadorHumano(Tablero tablero) {
		this.tablero = tablero;
	}
	
	public void perderFicha(Ficha ficha) {
		if (ficha.obtenerValor() == 3) {
			fichaMineroVivas = fichaMineroVivas - 1;
		}
		else if (ficha.obtenerValor() == 11) {
			fichaBombaVivas = fichaBombaVivas - 1;
			
		}
		fichasVivas = fichasVivas - 1;	
	}
	
	public boolean moverFicha(int posXi, int posYi, int posXf, int posYf) {
		return tablero.moverFicha(posXi, posYi, posXf, posYf);
	}
	
	public boolean armarEstrategia() {
		return true;
	}
	
	public boolean perdio() {
		return !(fichasVivas == 0 || fichaMineroVivas == 0 || fichaBombaVivas == fichasVivas);
	}
}
