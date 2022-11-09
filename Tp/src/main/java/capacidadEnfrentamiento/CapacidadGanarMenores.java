package capacidadEnfrentamiento;

import ficha.Ficha;

public class CapacidadGanarMenores implements CapacidadEnfrentamiento {
	
	public ResultadoEnfrentamiento enfrentar(Ficha ficha, Ficha fichaOponente) {
		if (ficha.obtenerValor() < fichaOponente.obtenerValor()) {
			ficha.obtenerJugador().perderFicha(ficha);
			return ResultadoEnfrentamiento.PERDIO;
		}
		else if (ficha.obtenerValor() > fichaOponente.obtenerValor()) {
			fichaOponente.obtenerJugador().perderFicha(fichaOponente);
			return ResultadoEnfrentamiento.GANO;
		}
		ficha.obtenerJugador().perderFicha(ficha);
		fichaOponente.obtenerJugador().perderFicha(fichaOponente);
		return ResultadoEnfrentamiento.EMPATO;
		
	}
}
