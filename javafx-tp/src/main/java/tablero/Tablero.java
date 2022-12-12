package tablero;

import ficha. *;
import jugador. *;
import partida.Partida;
import excepciones.*; 

import java.util.ArrayList;

import capacidadEnfrentamiento. *;

public class Tablero implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	public int TAM_TABLERO = 10;
	public static final Ficha VACIO = null;
	public static final Ficha AGUA = new Ficha(null, TipoDeFicha.AGUA, null, null, null);
	private Ficha[][] tablero;
	Partida partida = new Partida();
	private String enfrentamiento = null;
	
	
	
	//Este es el constructor de la clase Tablero y lo que hace es recibir dos listas de fichas, una de cada jugador, e ir ubicando las piezas
	//de manera que queden las piezas del mismo jugador ubicadas en el mismo sector del tablero.
	public Tablero(ArrayList<Ficha> fichasVerdes, ArrayList<Ficha> fichasAzules) {
		
		this.tablero = new Ficha[TAM_TABLERO][TAM_TABLERO];
		for (int i = 0; i < TAM_TABLERO; i++) {
			for (int j = 0; j < TAM_TABLERO; j++) {
				
				if (i < 4) {
					tablero[i][j] = fichasVerdes.get(10*i + j);
				}
				else if (i > 5) {
					tablero[i][j] = fichasAzules.get(10*(i-6) + j);
				} else{
					
					if ((j == 2 || j == 3 || j == 6 || j == 7)) {
						tablero[i][j] = AGUA;
					}else {
						tablero[i][j] = VACIO;
					}
				}
			}
		}
	}
	

	public ArrayList<int[]> obtenerFichasDeUnJugador(Jugador jugador) {
		ArrayList<int[]> posFichasDelJugador = new ArrayList<int[]>();

		for (int i = 0; i < TAM_TABLERO; i++) {
			for (int j = 0; j < TAM_TABLERO; j++) {
				if (tablero[i][j] != VACIO && !tablero[i][j].equals(ficha.TipoDeFicha.AGUA) && tablero[i][j].obtenerJugador() instanceof JugadorRobot) {
					int[] pos = new int[2];
					pos[0] = i;
					pos[1] = j;
					posFichasDelJugador.add(pos);
					
				}
			}
		}
		
		return posFichasDelJugador;
	}
	
	public String huboEnfrentamiento() {
		return enfrentamiento;
	}

	//Esta función retorna true si se pudo rotar con éxito una pieza, lanza una excepción si una de las piezas clickeadas es del
	//otro jugador o si trata de mover una pieza hacia delante, pero todavía no se terminó de hacer la estrategia.
	public boolean rotarFicha(int posXi, int posYi, int posXf, int posYf, Jugador jugador) throws ExcepcionTurnoEquivocado {
		Ficha aMover = tablero[posXi][posYi];
		Ficha aComer = tablero[posXf][posYf];
		
		if (!validarAMoverPertenezcaAJugadorEnTurno(aMover, jugador)) {
			throw new excepciones.ExcepcionTurnoEquivocado();
		}
		
		tablero[posXf][posYf] = aMover;
		tablero[posXi][posYi] = aComer;
		return true;
	}
	
	public boolean validarPosicionCampoJugador1(int posX, int posY) {
		if (posX < 0 || posX >= 4 || posY < 0 || posY >= 10) {
			return false;
		}
		return true;
	}
	

	public boolean validarPosicionCampoJugador2(int posX, int posY) {
		if (posX < 6 || posX >= 10 || posY < 0 || posY >= 10) {
			return false;
		}
		return true;
	}
	
	public Ficha obtenerFicha(int posX, int posY) {
		return tablero[posX][posY];
	}
	
	
	public boolean validarPosicion(int posX, int posY) {
		if ((posY == 2 || posY == 3 || posY == 6 || posY == 7) && (posX == 4 || posX == 5)) {
			return false;	
		}
		if (posX < 0 || posX >= 10 || posY < 0 || posY >= 10) {
			return false;
		}
		return true;
	}
	
	private boolean validarAMoverPertenezcaAJugadorEnTurno(Ficha ficha, Jugador jugador) {
		if (ficha.obtenerJugador().equals(jugador)) {
			return true;
		}
		return false;
	}
	

	//Esta función se encarga de que se muevan las piezas. Si la pieza aMover puede comer a la pieza aComer entonces la come, sino pierde
	// o empata, depende el caso, siempre poniendo en null el casillero en el que estaba la pieza aMover. 
	//Además si se intenta hacer un movimiento inválido o se clickea piezas del rival lanza excepciones.
	//También si en el lugar que al que se mueve la pieza no hay nada se mueve correctamente.
	
	public boolean moverFicha(int posXi, int posYi, int posXf, int posYf, Jugador jugador) throws ExcepcionMovimientoInvalido, ExcepcionPosicionInvalida, ExcepcionTurnoEquivocado{
		
		Ficha aMover = tablero[posXi][posYi];
		Ficha aComer = tablero[posXf][posYf];

		enfrentamiento = null;
		
		if (!validarPosicion(posXi,posYi) || !validarPosicion(posXf,posYf)) {
			throw new excepciones.ExcepcionPosicionInvalida();
		}
		
		if (!validarAMoverPertenezcaAJugadorEnTurno(aMover, jugador)) {
			throw new excepciones.ExcepcionTurnoEquivocado();
		}
		
		if (!aMover.validarMovimiento(posXi, posYi, posXf, posYf, this)) {
			throw new excepciones.ExcepcionMovimientoInvalido("movimiento invalido");
		}
		
		if (aComer == VACIO) {			
			tablero[posXf][posYf] = aMover;
			tablero[posXi][posYi] = VACIO;
			return true;
		}
		
		ResultadoEnfrentamiento resultado = aMover.enfrentar(aComer);
		if (resultado == ResultadoEnfrentamiento.GANO) {
			tablero[posXf][posYf] = aMover;
			tablero[posXi][posYi] = VACIO;
			enfrentamiento = String.format("La ficha %d %s le gano a la ficha %d %s", aMover.obtenerValor(), aMover.obtenerColor(), aComer.obtenerValor(), aComer.obtenerColor());
		}
		if (resultado == ResultadoEnfrentamiento.PERDIO) {
			tablero[posXi][posYi] = VACIO;
			enfrentamiento = String.format("La ficha %d %s le gano a la ficha %d %s", aComer.obtenerValor(), aComer.obtenerColor(), aMover.obtenerValor(), aMover.obtenerColor());
		}
		if (resultado == ResultadoEnfrentamiento.EMPATO) {
			tablero[posXi][posYi] = VACIO;
			tablero[posXf][posYf] = VACIO;
			enfrentamiento = String.format("La ficha %d %s y la ficha %d %s, empataron", aMover.obtenerValor(), aMover.obtenerColor(), aComer.obtenerValor(), aComer.obtenerColor());
		}
		return true;
	}
	


	public boolean posicionDelTableroVacia(int pos_i, int pos_j) {
		return tablero[pos_i][pos_j] == VACIO;
	}
	

	
}