package capacidadEnfrentamiento;

import ficha.Ficha;

public class CapacidadGanarMenoresYDiez implements CapacidadEnfrentamiento , java.io.Serializable{
	
	private static final long serialVersionUID = 1L;

	public ResultadoEnfrentamiento enfrentar(Ficha ficha, Ficha fichaOponente) {
		if (fichaOponente.obtenerValor() == 10 || ficha.obtenerValor() > fichaOponente.obtenerValor()) {
			fichaOponente.obtenerJugador().perderFicha(fichaOponente);
			return ResultadoEnfrentamiento.GANO;
		}
		if (ficha.obtenerValor() < fichaOponente.obtenerValor()) {
			ficha.obtenerJugador().perderFicha(ficha);
			return ResultadoEnfrentamiento.PERDIO;
		}
		fichaOponente.obtenerJugador().perderFicha(fichaOponente);
		ficha.obtenerJugador().perderFicha(ficha);
		return ResultadoEnfrentamiento.EMPATO;
		
	}
}
