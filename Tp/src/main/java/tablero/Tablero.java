package tablero;

import ficha. *;

import java.util.ArrayList;

import capacidadEnfrentamiento. *;

public class Tablero {
	private int TAM_TABLERO = 10;
	public static final Ficha VACIO = null;
	private Ficha[][] tablero;
	
	public Tablero(ArrayList<Ficha> fichasRojas, ArrayList<Ficha> fichasAzules) {
		//fijate si contemplas aca las posiciones prohibidas
		int indiceFR = 0;
		int indiceFA = 0;
		this.tablero = new Ficha[TAM_TABLERO][TAM_TABLERO];
		for (int i = 0; i < TAM_TABLERO; i++) {
			for (int j = 0; j < TAM_TABLERO; j++) {
				if (i < 4) {
					tablero[i][j] = fichasRojas.get(indiceFR);
					indiceFR = indiceFR +1;
				}
				if (i > 5) {
					tablero[i][j] = fichasAzules.get(indiceFA);
					indiceFA = indiceFA +1;
				}
				tablero[i][j] = VACIO;
			}
		}
	}
	
	//inicia el tablero con fichas al azar
	public void inicializarTablero(int pos_i, int pos_j) {
		//Ficha bomba = new Ficha(ficha.Valor.BOMBA, ficha.Color.ROJA);
		//Ficha bandera = new Ficha(ficha.Valor.BANDERA, ficha.Color.ROJA);
	}
	
	public Ficha obtenerFicha(int posX, int posY) {
		return tablero[posX][posY];
	}
	
	//las pos que llega a este met asumo que ya es una posicion dentro de las pos validas dentro del tablero
	public boolean moverFicha(int posXi, int posYi, int posXf, int posYf) {
		Ficha aMover = tablero[posXi][posYi];
		Ficha aComer = tablero[posXf][posYf];
		
		if (!aMover.validarMovimiento(posXf, posYf, this)) {
			return false;
		}
		
		if (aComer == VACIO) {
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
