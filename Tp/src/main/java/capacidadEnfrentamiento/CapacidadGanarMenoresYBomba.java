package capacidadEnfrentamiento;

import ficha. *;

public class CapacidadGanarMenoresYBomba {
	
	public ResultadoEnfrentamiento enfrentar(Ficha ficha, int valor) {
		if (ficha.obtenerValor() == 11) {
			return ResultadoEnfrentamiento.GANO;
		}
		if (valor < ficha.obtenerValor()) {
			return ResultadoEnfrentamiento.PERDIO;
		}
		else if (valor == ficha.obtenerValor()) {
			return ResultadoEnfrentamiento.EMPATO;
		}
		return ResultadoEnfrentamiento.GANO;
		
	}
}
