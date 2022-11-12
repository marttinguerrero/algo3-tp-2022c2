package inicio;

import interfaceUsuario. *;
import partida. *;

public class inicio {

//static final ficha.Valor[] fichas = [ficha.Valor.BANDERA];
	
	public static void main(String[] args) {
		InterfaceUsuario interfaceUsuario = new InterfaceUsuario();		
		Partida partida = new PartidaContraJugador(interfaceUsuario);
		partida.comenzarPartida();
		partida.guardarPartida("partida1.csv");

	}
}




