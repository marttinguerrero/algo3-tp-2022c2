package partida;

import interfaceUsuario.InterfaceUsuario;
import jugador. *;



public class PartidaContraJugador extends Partida{
	
	private static final long serialVersionUID = 1L;

	public PartidaContraJugador(InterfaceUsuario interfaceUsuario) {
		super(new JugadorHumano(), new JugadorHumano(), interfaceUsuario);
	}
}
