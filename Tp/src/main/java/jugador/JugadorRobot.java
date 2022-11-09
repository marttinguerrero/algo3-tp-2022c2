package jugador;

import ficha.Ficha;
import tablero. *;

public class JugadorRobot implements Jugador {
	private int fichasVivas;
	private int fichaMineroVivas;
	private int fichaBombaVivas;
	private boolean banderaViva;
	
	public JugadorRobot() {
		this.fichasVivas = 0;
		this.fichaMineroVivas = 0;
		this.fichaBombaVivas = 0;
		this.banderaViva = true;
	}
	
	public boolean moverFicha(int posXi, int posYi, int posXf, int posYf, Tablero tablero) {
		return tablero.moverFicha(posXi, posYi, posXf, posYf);
	}
	
	public void perderFicha(Ficha ficha) {
		if (ficha.obtenerValor() == 3) {
			fichaMineroVivas = fichaMineroVivas - 1;
		}
		else if (ficha.obtenerValor() == 11) {
			fichaBombaVivas = fichaBombaVivas - 1;
			
		}
		else if (ficha.obtenerValor() == 0) {
			banderaViva = false;	
		}
		fichasVivas = fichasVivas - 1;	
	}
	
	public boolean armarEstrategia() {
		return true;
	}
	
	public boolean perdio() {
		return !(fichasVivas == 0 || fichaMineroVivas == 0 || fichaBombaVivas == fichasVivas || !banderaViva);
	}
}
