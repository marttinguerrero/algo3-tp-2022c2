package inicio;

import java.io.IOException;

import interfaceUsuario. *;
import partida. *;

public class inicio implements java.io.Serializable{

//static final ficha.Valor[] fichas = [ficha.Valor.BANDERA];
	
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) throws IOException {
		InterfaceUsuario interfaceUsuario = new InterfaceUsuario();		
		Partida partida = new PartidaContraJugador(interfaceUsuario);
		partida.comenzarPartida();
		partida.guardarPartida("/home/martin/Algoritmos 3/tpsi/src/main/java/partida5.csv", partida);

	}
}




