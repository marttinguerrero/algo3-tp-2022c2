package jugador;

import java.util.ArrayList;

import excepciones.ExcepcionMovimientoInvalido;
import excepciones.ExcepcionPosicionInvalida;
import excepciones.ExcepcionTurnoEquivocado;
import ficha.Color;
import ficha.Ficha;
import ficha.TipoDeFicha;
import tablero. *;

public class JugadorRobot implements java.io.Serializable , Jugador{
	private static final long serialVersionUID = 1L;
	private int fichasVivas;
	private String nombre = "Soy la computadora";

	private Color colorFichas;
	private int fichaBombaVivas;
	private boolean banderaViva;
	
	public JugadorRobot(Color color) {
		this.fichasVivas = 40;
		this.fichaBombaVivas = 6;
		this.banderaViva = true;
		this.colorFichas = color;
	}
	

	public Color obtenerColor() {
		return colorFichas;
	}




	public String obtenerNombre() {
		return nombre;
	}


	public boolean armarEstrategiaJugador1(int posXi, int posYi, int posXf, int posYf, Tablero tablero) throws ExcepcionMovimientoInvalido, ExcepcionPosicionInvalida, ExcepcionTurnoEquivocado {
		if (!(tablero.validarPosicionCampoJugador1(posXi, posYi) && tablero.validarPosicionCampoJugador1(posXf, posYf))) {
			throw new excepciones.ExcepcionPosicionInvalida();
		}
		return tablero.rotarFicha(posXi, posYi, posXf, posYf, this);
	}


	public boolean armarEstrategiaJugador2(int posXi, int posYi, int posXf, int posYf, Tablero tablero) throws ExcepcionMovimientoInvalido, ExcepcionPosicionInvalida, ExcepcionTurnoEquivocado {
		if (!(tablero.validarPosicionCampoJugador2(posXi, posYi) && tablero.validarPosicionCampoJugador2(posXf, posYf))) {
			throw new excepciones.ExcepcionPosicionInvalida();
		}
		return tablero.rotarFicha(posXi, posYi, posXf, posYf, this);
	}

	//Esta función crea una lista con las fichas de la IA, para después elegir una pieza ficha al azar de esa lista y fijarse si tiene movimiento posibles,
	//si los tiene se hace el movimiento, sino busca otra pieza, así hasta que encuentre una con un movmiento posible.
	public boolean moverFicha(int posXi, int posYi, int posXf, int posYf, Tablero tablero) {
		
		ArrayList<int[]> posFichas = tablero.obtenerFichasDeUnJugador(this);
		java.util.Random random = new java.util.Random();
		int posicionRandom = random.nextInt(posFichas.size());
		int[] posFicha = posFichas.get(posicionRandom);
		
		posFichas.remove(posicionRandom);
		int posXicompu = posFicha[0];
		int posYicompu = posFicha[1];
	
		int[] movimientoPosible = null;
		movimientoPosible = tablero.obtenerFicha(posXicompu, posYicompu).movimientoPosible(posXicompu, posYicompu, tablero);
		while (posFichas.size() != 0) {
			
			while(movimientoPosible == null) {
				posicionRandom = random.nextInt(posFichas.size());
				posFicha = posFichas.get(posicionRandom);
				posFichas.remove(posicionRandom);
				posXicompu = posFicha[0];
				posYicompu = posFicha[1];
				movimientoPosible = tablero.obtenerFicha(posXicompu, posYicompu).movimientoPosible(posXicompu, posYicompu, tablero);
				
			}
			int posXfcompu = movimientoPosible[0];
			int posYfcompu = movimientoPosible[1];


			if(tablero.moverFicha(posXicompu, posYicompu, posXfcompu, posYfcompu, this)) {
				return true;
			}
		}
		
		return false;
		
			
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
