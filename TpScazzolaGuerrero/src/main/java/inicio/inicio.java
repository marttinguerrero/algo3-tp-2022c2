package inicio;

import java.io.IOException;

import interfaceUsuario. *;
import partida. *;

public class inicio implements java.io.Serializable{

	
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) throws IOException {
		InterfaceUsuario interfaceUsuario = new InterfaceUsuario();		
		Partida partida = new PartidaContraJugador(interfaceUsuario);
		partida.comenzarPartida();
		

	}
}




