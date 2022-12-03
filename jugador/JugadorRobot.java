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
	
public static double obtenerNumeroAlAzar(double min, double max){
	    double x = (int)(Math.random()*((max-min)+1))+min;
	    return x;
}
public Color obtenerColor() {
	return colorFichas;
}


//public boolean moverFicha(int posXi, int posYi, int posXf, int posYf, Tablero tablero) {
	
//	System.out.println("Estoy en moverFicha de jugadorRobot");
//	ArrayList<int[]> posFichas = tablero.obtenerFichasDeUnJugador(this);
//	java.util.Random random = new java.util.Random();
//	int posicionRandom = random.nextInt(posFichas.size());
//	int[] posFicha = posFichas.get(posicionRandom);
//	posFichas.remove(posicionRandom);
//	
//	int posXicompu = posFicha[0];
//	int posYicompu = posFicha[1];
//	
//	int posXi = (int) obtenerNumeroAlAzar(0, 9);
//	int posYi = (int) obtenerNumeroAlAzar(0, 9);

//	Ficha aMover = tablero.obtenerFicha(posXicompu, posYicompu);
//	while (aMover == null || aMover.obtenerJugador() != this) {
//		posXi = (int) obtenerNumeroAlAzar(0, 9);
//		posYi = (int) obtenerNumeroAlAzar(0, 9);
//		aMover = tablero.obtenerFicha(posXi, posYi);
//	}
	
//	posXf = (int) obtenerNumeroAlAzar(0, 9);
//	posYf = (int) obtenerNumeroAlAzar(0, 9);
	
//	while(tablero.moverFicha(posXicompu, posYicompu, posYf , posXf, this) != true) {
//		posXf = (int) obtenerNumeroAlAzar(0, 9);
//		posYf = (int) obtenerNumeroAlAzar(0, 9);
//		try {
//			tablero.moverFicha(posXi, posYi, posXf, posYf,this);
//		} catch (ExcepcionPosicionInvalida e ) {
//			continue;
//		} catch (ExcepcionTurnoEquivocado e) {
//			continue;
//		} catch (ExcepcionMovimientoInvalido e) {
//			continue;
//		}
		
		
//	}
//
//	return true;
	
//}

public String obtenerNombre() {
	return nombre;
}


public boolean armarEstrategiaJugador1(int posXi, int posYi, int posXf, int posYf, Tablero tablero) throws ExcepcionMovimientoInvalido, ExcepcionPosicionInvalida, ExcepcionTurnoEquivocado {
	System.out.print(String.format("Entra a armar la estrategia el jugador 1 con xi = %d, yi = %d, xf= %d, yf= %d \n", posXi, posYi, posXf, posYf));
	if (!(tablero.validarPosicionCampoJugador1(posXi, posYi) && tablero.validarPosicionCampoJugador1(posXf, posYf))) {
		throw new excepciones.ExcepcionPosicionInvalida();
	}
	return tablero.rotarFicha(posXi, posYi, posXf, posYf, this);
}


public boolean armarEstrategiaJugador2(int posXi, int posYi, int posXf, int posYf, Tablero tablero) throws ExcepcionMovimientoInvalido, ExcepcionPosicionInvalida, ExcepcionTurnoEquivocado {
	System.out.print(String.format("Entra a armar la estrategia el jugador 1 con xi = %d, yi = %d, xf= %d, yf= %d \n", posXi, posYi, posXf, posYf));
	if (!(tablero.validarPosicionCampoJugador2(posXi, posYi) && tablero.validarPosicionCampoJugador2(posXf, posYf))) {
		throw new excepciones.ExcepcionPosicionInvalida();
	}
	return tablero.rotarFicha(posXi, posYi, posXf, posYf, this);
}

public boolean moverFicha(int posXi, int posYi, int posXf, int posYf, Tablero tablero) {
		
		ArrayList<int[]> posFichas = tablero.obtenerFichasDeUnJugador(this);
//		System.out.print(String.format("Elige posicion en lista de fichas %d \n", posFichas.size()));
		java.util.Random random = new java.util.Random();
		int posicionRandom = random.nextInt(posFichas.size());
		System.out.println(posicionRandom);
//		int[] posFicha = posFichas.get(posicionRandom);
//		posFichas.remove(posicionRandom);
//		System.out.print(String.format("Elige posicion en lista de fichas %d \n",posFicha));
//		int posXicompu = posFicha[0];
	
//		int posYicompu = posFicha[1];
//		int posXicompu = (int) obtenerNumeroAlAzar(0, 9);
//		int posYicompu = (int) obtenerNumeroAlAzar(0, 9);
//	
//		Ficha aMover = tablero.obtenerFicha(posXicompu, posYicompu);
//		while (aMover == null || aMover.obtenerJugador() != this) {
//			posXi = (int) obtenerNumeroAlAzar(0, 9);
//			posYi = (int) obtenerNumeroAlAzar(0, 9);
//			aMover = tablero.obtenerFicha(posXi, posYi);
//		}
//		Ficha aMover = tablero.obtenerFicha(3, 0);
		System.out.print(String.format("Las posiciones de las fichas de la computadora son %d %d \n", 3, 0));		
		int[] movimientoPosible = null;

		
		
		movimientoPosible = tablero.obtenerFicha(6, 0).movimientoPosible(6, 0, tablero);
			
//			posicionRandom = random.nextInt(posFichas.size());
//			posFicha = posFichas.get(posicionRandom);
//			posFichas.remove(posicionRandom);
//			posXicompu = posFicha[0];
//			posYicompu = posFicha[1];
			//System.out.print(String.format("Esa ficha no tenia movimientos posibles y agarra las nuevas posiciones %d %d \n", posXicompu, posYicompu));		
		
		
		int posXfcompu = movimientoPosible[0];
		int posYfcompu = movimientoPosible[1];
		tablero.moverFicha(6, 0, posXfcompu, posYfcompu, this);
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
