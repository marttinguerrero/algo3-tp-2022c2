package capacidadEnfrentamiento;

import ficha. *;

public class CapacidadGanarMenoresYBomba implements CapacidadEnfrentamiento , java.io.Serializable{
	
	private static final long serialVersionUID = 1L;


	
	//Está función devuelve el resultado del enfrentamiento de dos piezas, retorna que perdió si el valor de la otra pieza es mayor, que empató
	//si tienen el mismo valor o que ganó si es una bomba o tiene mayor valor.
	public ResultadoEnfrentamiento enfrentar(Ficha ficha, Ficha fichaOponente) {
		if (fichaOponente.obtenerValor() == TipoDeFicha.BOMBA.valor || ficha.obtenerValor() > fichaOponente.obtenerValor()) {
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
