package partida;

import interfaceUsuario.InterfaceUsuario;
import jugador. *;

import tablero. *;

public class PartidaContraComputadora extends Partida{
	
	public PartidaContraComputadora(InterfaceUsuario interfaceUsuario) {
		super(new JugadorHumano(), new JugadorRobot(), interfaceUsuario);
	}
}
