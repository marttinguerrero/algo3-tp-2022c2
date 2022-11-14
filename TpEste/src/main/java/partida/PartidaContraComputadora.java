package partida;

import interfaceUsuario.InterfaceUsuario;
import jugador. *;

public class PartidaContraComputadora extends Partida{
	
	private static final long serialVersionUID = 1L;

	public PartidaContraComputadora(InterfaceUsuario interfaceUsuario) {
		super(new JugadorHumano(), new JugadorRobot(), interfaceUsuario);
	}
}
