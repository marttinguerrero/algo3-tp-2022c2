package partida;

import interfaceUsuario.InterfaceUsuario;
import jugador. *;
//import tablero. *;

public class PartidaContraJugador extends Partida{
	
	public PartidaContraJugador(InterfaceUsuario interfaceUsuario) {
		super(new JugadorHumano(), new JugadorHumano(), interfaceUsuario);
	}
}
