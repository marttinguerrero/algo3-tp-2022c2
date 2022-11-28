package partida;
import jugador. *;



public class PartidaContraJugador extends Partida{
	
	private static final long serialVersionUID = 1L;

	public PartidaContraJugador() {
		super(new JugadorHumano(), new JugadorHumano());
	}
}
