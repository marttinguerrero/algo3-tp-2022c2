package jugador;

import java.util.ArrayList;

import ficha.Ficha;
import ficha.TipoDeFicha;
import tablero. *;

public class JugadorRobot implements java.io.Serializable , Jugador{
	private static final long serialVersionUID = 1L;
	private int fichasVivas;
	
	private int fichaBombaVivas;
	private boolean banderaViva;
	
	public JugadorRobot() {
		this.fichasVivas = 40;
		
		this.fichaBombaVivas = 6;
		this.banderaViva = true;
	}
	
public boolean moverFicha(int posXi, int posYi, int posXf, int posYf, Tablero tablero) {
		
		ArrayList<int[]> posFichas = tablero.obtenerFichasDeUnJugador(this);
		
		java.util.Random random = new java.util.Random();
		int posicionRandom = random.nextInt(posFichas.size());
		int[] posFicha = posFichas.get(posicionRandom);
		posFichas.remove(posicionRandom);
		
		int posXicompu = posFicha[0];
		int posYicompu = posFicha[1];
		
		int[] movimientoPosible = null;

		while (posFichas.size() != 0 || movimientoPosible == null) {
		
			movimientoPosible = tablero.obtenerFicha(posXicompu, posYicompu).movimientoPosible(posXicompu, posYicompu, tablero);
			
			posicionRandom = random.nextInt(posFichas.size());
			posFicha = posFichas.get(posicionRandom);
			posFichas.remove(posicionRandom);
			posXicompu = posFicha[0];
			posYicompu = posFicha[1];
		}
		
		int posXfcompu = movimientoPosible[0];
		int posYfcompu = movimientoPosible[1];
		tablero.moverFicha(posXicompu, posYicompu, posXfcompu, posYfcompu, this);
		return true;
	}
	
	public void perderFicha(Ficha ficha) {
		if (ficha.obtenerValor() == TipoDeFicha.BOMBA.valor) {
			fichaBombaVivas = fichaBombaVivas - 1;
			
		}
		if (ficha.obtenerValor() == TipoDeFicha.BANDERA.valor) {
			banderaViva = false;
			
		}
		fichasVivas = fichasVivas - 1;	
	}
	
	public boolean armarEstrategia() {
		return true;
	}
	
	public boolean perdio() {
		return (fichasVivas == 0 || fichaBombaVivas == fichasVivas || !banderaViva);
	}
}
