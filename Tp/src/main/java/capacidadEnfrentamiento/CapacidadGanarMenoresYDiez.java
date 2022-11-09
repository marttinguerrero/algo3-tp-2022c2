package capacidadEnfrentamiento;

import ficha.Ficha;

public class CapacidadGanarMenoresYDiez {
	
	public ResultadoEnfrentamiento enfrentar(Ficha ficha, int valor) {
		if (ficha.obtenerValor() == 10) {
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
