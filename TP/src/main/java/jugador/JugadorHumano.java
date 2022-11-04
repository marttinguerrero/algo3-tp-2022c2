package jugador;

public class JugadorHumano implements Jugador{
	//fichas colocadas sera la suma de estas dos
	private int fichasVivas;
	//private int fichasMuertas;
	private int fichaMineroVivas;
	private int fichaBombaVivas;
	
	public boolean moverFicha() {
		return true;
	}
	
	public boolean armarEstrategia() {
		return true;
	}
	
	public boolean perdio() {
		return !(fichasVivas == 0 || fichaMineroVivas == 0 || fichaBombaVivas == fichasVivas);
	}
}
