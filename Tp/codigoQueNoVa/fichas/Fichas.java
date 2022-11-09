package fichas;

import ficha.Ficha;
import interfaceUsuario. *;

public class Fichas {
	private Ficha[][] fichas;
	private int fichasColocadas;
	private int fichasVivas;
	private int fichasMuertas;
	
	public Fichas(int cantFichasPorJugador) {
		this.fichas = new Ficha[cantFichasPorJugador][cantFichasPorJugador];
			
	}
	
	/*public void mostrarFichas() {
		interfaceUsuario.mostrarFichas(fichas);
	}*/
}
