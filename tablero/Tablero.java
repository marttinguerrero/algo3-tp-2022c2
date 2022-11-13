package tablero;

import ficha. *;
import jugador. *;

import java.util.ArrayList;

import capacidadEnfrentamiento. *;

public class Tablero {
	public int TAM_TABLERO = 10;
	public static final Ficha VACIO = null;
	private Ficha[][] tablero;
	
	
	public Tablero() {
		//fijate si contemplas aca las posiciones prohibidas
		this.tablero = new Ficha[TAM_TABLERO][TAM_TABLERO];
		for (int i = 0; i < TAM_TABLERO; i++) {
			for (int j = 0; j < TAM_TABLERO; j++) {
				tablero[i][j] = VACIO;
				}
			}
		}
	
	public Tablero(ArrayList<Ficha> fichasRojas, ArrayList<Ficha> fichasAzules) {
		//fijate si contemplas aca las posiciones prohibidas
		this.tablero = new Ficha[TAM_TABLERO][TAM_TABLERO];
		for (int i = 0; i < TAM_TABLERO; i++) {
			for (int j = 0; j < TAM_TABLERO; j++) {
				if (i < 4) {
					//System.out.print("entraa a poner fichas rojas\n");
					//System.out.print(10*i + j);
					//System.out.print("\n");
					tablero[i][j] = fichasRojas.get(10*i + j);
					//int v = tablero[i][j].obtenerValor();
					//String valor = String.format("%d\n", v);
					//System.out.print(valor);
				}
				else if (i > 5) {
					//System.out.print("entraa a poner fichas azules\n");
					//System.out.print(10*(i-6) + j);
					//System.out.print("\n");
					tablero[i][j] = fichasAzules.get(10*(i-6) + j);
					//int v = tablero[i][j].obtenerValor();
					//String valor = String.format("%d\n", v);
					//System.out.print(valor);
				}
				else{
					tablero[i][j] = VACIO;
				}
			}
		}
	}
	
	/*public ArrayList<Ficha> obtenerFichas(Jugador jugador) {
		ArrayList<Ficha> fichasDelJugador = new ArrayList<Ficha>();
				
		for (int i = 0; i < TAM_TABLERO; i++) {
			for (int j = 0; j < TAM_TABLERO; j++) {
				if (tablero[i][j] != VACIO && tablero[i][j].obtenerJugador().equals(jugador)) {
					fichasDelJugador.add(tablero[i][j]);
				}
			}
		}
		
		return fichasDelJugador;
	}*/
	
	public ArrayList<int[]> obtenerFichas(Jugador jugador) {
		ArrayList<int[]> posFichasDelJugador = new ArrayList<int[]>();
		System.out.print("entra a buscar las fichas del jugador\n");
				
		for (int i = 0; i < TAM_TABLERO; i++) {
			for (int j = 0; j < TAM_TABLERO; j++) {
				if (tablero[i][j] != VACIO && tablero[i][j].obtenerJugador().equals(jugador)) {
					int[] pos = new int[2];
					pos[0] = i;
					pos[1] = j;
					posFichasDelJugador.add(pos);
				}
			}
		}
		System.out.print("sale de buscar las fichas del jugador\n");
		return posFichasDelJugador;
	}
	
	//inicia el tablero con fichas al azar
	public void inicializarTablero(int pos_i, int pos_j) {
		//Ficha bomba = new Ficha(ficha.Valor.BOMBA, ficha.Color.ROJA);
		//Ficha bandera = new Ficha(ficha.Valor.BANDERA, ficha.Color.ROJA);
	}
	
	public Ficha obtenerFicha(int posX, int posY) {
		return tablero[posX][posY];
	}
	
	
	public void imprimirFichasEnEsasPosiciones(ArrayList<int[]> posFichas) {
		String cadena = "las fichas de la computadora son [";
		for (int i = 0; i < posFichas.size(); i++) {
			int v = tablero[posFichas.get(i)[0]][posFichas.get(i)[1]].obtenerValor();
			String valor = String.format(" %d;", v);
			cadena = cadena + valor;		
		}
		cadena = cadena + "]\n";	
		System.out.print(cadena);
		
	}
	
	public void imprimir_tablero() {
		
		String tablero_str = "el tablero es [\n";
		for (int i = 0; i < TAM_TABLERO; i++) {
			tablero_str = tablero_str + "[";
			for (int j = 0; j < TAM_TABLERO; j++) {
				//System.out.print("llega\n");
				if (tablero[i][j] != VACIO) {
					int v = tablero[i][j].obtenerValor();
					String valor;
					if (v != 11) {
						valor = String.format(" %d", v);
					}
					else {
						valor = String.format("%d", v);
					}
					if (j != 9) {
						tablero_str = tablero_str + valor + ",";
					}
					else {
						tablero_str = tablero_str + valor + " ";
					}
				}else {
					if (j != 9) {
						tablero_str = tablero_str + " 0" + ",";
					}
					else {
						tablero_str = tablero_str + " 0 ";
					}
				}
			}
			tablero_str = tablero_str + "], \n";
		}
		tablero_str = tablero_str + "]";
		System.out.print(tablero_str);
	}
	
	public boolean validarPosicion(int posX, int posY) {
		if ((posX >= 0 && posX < 10) && (posY >= 0 && posY < 10)) {
			return true;
		}
		return false;
	}
	
	private boolean validarAMoverPertenescaAJugadorEnTurno(Ficha ficha, Jugador jugador) {
		if (ficha.obtenerJugador().equals(jugador)) {
			return true;
		}
		return false;
	}
	
	//las pos que llega a este met asumo que ya es una posicion dentro de las pos validas dentro del tablero
	public boolean moverFicha(int posXi, int posYi, int posXf, int posYf, Jugador jugador) {
		Ficha aMover = tablero[posXi][posYi];
		Ficha aComer = tablero[posXf][posYf];
		//int vaComer = aComer.obtenerValor();
		
		//int vaMover = aMover.obtenerValor();
		//String valor1 = String.format(" %d", vaComer);
		//String valor2 = String.format(" %d", vaMover);
		//String valor1 = "vacio";
		//String cadena = valor2 + " --> " + valor1 + "\n";
		//System.out.print(cadena);
		if (!validarPosicion(posXi,posYi) || !validarPosicion(posXf,posYf)) {
			throw new excepciones.ExcepcionPosicionInvalida();
		}
		
		if (!validarAMoverPertenescaAJugadorEnTurno(aMover, jugador)) {
			throw new excepciones.ExcepcionTurnoEquivocado();
		}
		
		if (!aMover.validarMovimiento(posXi, posYi, posXf, posYf, this)) {
			throw new excepciones.ExcepcionMovimientoInvalido("movimiento invalido");
		}
		
		if (aComer == VACIO) {
			System.out.print("entra ya que la pos a comer es vacio");
			tablero[posXf][posYf] = aMover;
			tablero[posXi][posYi] = VACIO;
			return true;
		}
		
		ResultadoEnfrentamiento res= aMover.enfrentar(aComer);
		if (res == ResultadoEnfrentamiento.GANO) {
			tablero[posXf][posYf] = aMover;
			tablero[posXi][posYi] = VACIO;
		}
		if (res == ResultadoEnfrentamiento.PERDIO) {
			tablero[posXi][posYi] = VACIO;
		}
		if (res == ResultadoEnfrentamiento.EMPATO) {
			tablero[posXi][posYi] = VACIO;
			tablero[posXf][posYf] = VACIO;
		}
		return true;
	}
	
	//retorna true si la casilla esta vacia
	/*public boolean posicionDelTableroVacia(int pos_i, int pos_j) {
		return tablero[pos_i][pos_j] == VACIO;
	}*/
	
	//retorna la ficha del oponente o por lo contrario null
	/*public Ficha posicionDelTableroOcupadaPorOponente(int pos_i, int pos_j, ) {
		return 
	}*/
	
}
