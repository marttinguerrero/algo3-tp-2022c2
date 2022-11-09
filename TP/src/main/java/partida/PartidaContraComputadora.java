package partida;

import jugador. *;
import tablero. *;

public class PartidaContraComputadora extends Partida{
	
	public PartidaContraComputadora(Tablero tablero) {
		super(new JugadorHumano(), new JugadorRobot(), tablero);
	}
}