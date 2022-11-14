package fabricaDeFichas;

import capacidadEnfrentamiento. *;
import capacidadMovimiento. *;
import ficha. *;
import jugador.Jugador;

public class FabricaDeFichas {
	//fichas.add(new Ficha(color, 0, new MovimientoDeUnaCasilla(), new CapacidadGanarMenores(), jugador));
	//dejo el jugador para asignarlo despues
	public Ficha crearFicha(String nombreColor, int valor, Jugador jugador) {
		
		Color color = null;
		CapacidadMovimiento capacidadDeMovimiento = null;
		CapacidadEnfrentamiento capacidadDeEnfrentamiento = null;
		
		if (nombreColor.equals("roja")) {
			color = Color.ROJA;
		}
		else if (nombreColor.equals("azul")) {
			color = Color.AZUL;
		}
		
		if (valor == 11) {
			capacidadDeMovimiento = new IncapacidadMovimiento();
		}
		else if (valor == 2) {
			capacidadDeMovimiento = new MovimientoLineaRecta();
		}
		else {
			capacidadDeMovimiento = new MovimientoDeUnaCasilla();
		}
		
		if (valor == 1) {
			capacidadDeEnfrentamiento = new CapacidadGanarMenoresYDiez();
		}
		else if (valor == 3) {
			capacidadDeEnfrentamiento = new CapacidadGanarMenoresYBomba();
		}
		else {
			capacidadDeEnfrentamiento = new CapacidadGanarMenores();
		}
		return new Ficha(color, valor, capacidadDeMovimiento, capacidadDeEnfrentamiento, jugador);
	}
}
