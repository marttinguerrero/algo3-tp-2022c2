package inicio;

import tablero. *;
import ficha. *;
import interfaceUsuario. *;
import partida. *;

public class inicio {
	
	// valores constantes del juego
	static final int TAM_TABLERO= 10;
	static final int CANT_FICHAS_POR_JUGADOR= 40;
	
	//cantidad de fichas de cada tipo
	static final int CANT_BANDERA= 1;
	static final int CANT_BOMBA= 1;
	static final int CANT_DOS= 8;
	static final int CANT_TRES= 1;
	static final int CANT_CUATRO= 1;
	static final int CANT_CINCO= 1;
	static final int CANT_SEIS= 1;
	static final int CANT_SIETE= 3;
	static final int CANT_OCHO= 2;
	static final int CANT_NUEVE= 1;
	static final int CANT_DIEZ= 1;
	static final int CANT_ESPIA= 1;
	

	//static final ficha.Valor[] fichas = [ficha.Valor.BANDERA];
	
	public static void main(String[] args) {
		InterfaceUsuario interfaceUsuario = new InterfaceUsuario();		
		//String tipoPartida = interfaceUsuario.pedirTipoPartida();
		Partida partida = new PartidaContraJugador();
		
		/*if (tipoPartida == "contra jugador") {
			partida = new PartidaContraJugador(tablero);
		}*/
		// fijate, no se si esta bien comparar una cadena asi
		/*if (tipoPartida == "contra computadora") {
			System.out.println("entra a jugar contra la computadora");
			partida = new PartidaContraComputadora(tablero);
		}*/
		//partida.inicializarPartida()
	}
}
