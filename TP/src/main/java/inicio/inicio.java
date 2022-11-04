package inicio;

import tablero. *;
import ficha. *;
import interfaceUsuario. *;
import partida. *;

public class inicio {
	
	// valores constantes del juego
	static final int TAM_TABLERO= 10;
	static final int CANT_FICHAS_POR_JUGADOR= 40;
	//static final ficha.Valor[] fichas = [ficha.Valor.BANDERA];
	
	public static void main(String[] args) {
		//Ficha[] fichas = ;
		System.out.println(ficha.Valor.BANDERA);
		Tablero tablero = new Tablero(TAM_TABLERO);	
		InterfaceUsuario interfaceUsuario = new InterfaceUsuario();		
		String tipoPartida = interfaceUsuario.pedirTipoPartida();
		Partida partida = null;
		
		if (tipoPartida == "contra jugador") {
			partida = new PartidaContraJugador(tablero);
		}
		// fijate, no se si esta bien comparar una cadena asi
		if (tipoPartida == "contra computadora") {
			System.out.println("entra a jugar contra la computadora");
			partida = new PartidaContraComputadora(tablero);
		}
		//partida.inicializarPartida()
	}
}
