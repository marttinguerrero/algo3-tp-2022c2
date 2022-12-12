package capacidadEnfrentamiento;

import ficha.Ficha;

public class CapacidadGanarMenores implements CapacidadEnfrentamiento , java.io.Serializable{
	
	private static final long serialVersionUID = 1L;

	
	
	//Está función retorna el resultado de un enfrentamiento de dos piezas. Retorna que perdió si el valor de la otra pieza es mayor, 
	//que ganó si la otra pieza tiene menor valor o que empató si tienen el mismo valor.
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
