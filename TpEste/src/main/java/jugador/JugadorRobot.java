package jugador;

import java.util.ArrayList;

import ficha.Ficha;
import tablero. *;

public class JugadorRobot implements java.io.Serializable , Jugador{
	private static final long serialVersionUID = 1L;
	private int fichasVivas;
	private int fichaMineroVivas;
	private int fichaBombaVivas;
	private boolean banderaViva;
	
	public JugadorRobot() {
		this.fichasVivas = 40;
		this.fichaMineroVivas = 3;
		this.fichaBombaVivas = 6;
		this.banderaViva = true;
	}
	
	public boolean moverFicha(int posXi, int posYi, int posXf, int posYf, Tablero tablero) {
		System.out.print("entra a jugar la computadora\n");
		
		ArrayList<int[]> posFichas = tablero.obtenerFichas(this);
		
		tablero.imprimirFichasEnEsasPosiciones(posFichas);
		
		java.util.Random random = new java.util.Random();
		int posicionRandom = random.nextInt(posFichas.size());
		int[] posFicha = posFichas.get(posicionRandom);
		posFichas.remove(posicionRandom);
		
		posXi = posFicha[0];
		posYi = posFicha[0];
		
		int[] movimientoPosible = null;
		//int[] posFichaComputadora = tablero.obtenerFicha(posXi, posYi).movimientoPosible(posXi, posYi, tablero);
		while (posFichas.size() != 0 || movimientoPosible == null) {
			System.out.print("entra al bucle para buscar un movimiento posible\n");
			tablero.imprimirFichasEnEsasPosiciones(posFichas);
			
			movimientoPosible = tablero.obtenerFicha(posXi, posYi).movimientoPosible(posXi, posYi, tablero);
			
			posicionRandom = random.nextInt(posFichas.size());
			posFicha = posFichas.get(posicionRandom);
			posFichas.remove(posicionRandom);
			posXi = posFicha[0];
			posYi = posFicha[0];
		}
		
		if (movimientoPosible != null) {
			int posXfsi = movimientoPosible[0];
			int posYfsi = movimientoPosible[1];
			tablero.moverFicha(posXi, posYi, posXfsi, posYfsi, this);
			return true;
		}
		
		return false;
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
		return (fichasVivas == 0 || fichaBombaVivas == fichasVivas || !banderaViva);
	}
}
