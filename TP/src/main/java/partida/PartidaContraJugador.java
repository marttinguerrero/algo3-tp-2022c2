package partida;

import jugador. *;
import tablero. *;

public class PartidaContraJugador extends Partida{
	
	public PartidaContraJugador(Tablero tablero) {
		super(new JugadorHumano(), new JugadorHumano(), tablero);
	}
}
