package tablero;

import ficha. *;

public class Tablero {
	private static final Ficha VACIO = null;
	private Ficha[][] tablero;
	
	public Tablero(int tam) {
		this.tablero = new Ficha[tam][tam];
		for (int i = 0; i < tam; i++) {
			for (int j = 0; j < tam; j++) {
				tablero[i][j] = VACIO;
			}
		}
	}
	
	//inicia el tablero con fichas al azar
	public void inicializarTablero(int pos_i, int pos_j) {
		//Ficha bomba = new Ficha(ficha.Valor.BOMBA, ficha.Color.ROJA);
		//Ficha bandera = new Ficha(ficha.Valor.BANDERA, ficha.Color.ROJA);
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
