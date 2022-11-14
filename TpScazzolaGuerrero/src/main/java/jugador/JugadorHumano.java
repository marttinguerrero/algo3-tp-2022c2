package jugador;

import tablero. *;



import ficha. *; 

public class JugadorHumano implements Jugador , java.io.Serializable{
	private static final long serialVersionUID = 1L;
	private int fichasVivas;	
	private int fichaBombaVivas;
	private boolean banderaViva;
	
	public JugadorHumano() {
		this.fichasVivas = 40;
		this.fichaBombaVivas = 6;
		this.banderaViva = true;
	}
	
	public void perderFicha(Ficha ficha) {
		if (ficha.obtenerValor() == TipoDeFicha.BOMBA.valor) {
			fichaBombaVivas = fichaBombaVivas - 1;
			
		}
		if (ficha.obtenerValor() == TipoDeFicha.BANDERA.valor) {
			banderaViva = false;
			
		}
		fichasVivas = fichasVivas - 1;	
	}
	
	public boolean moverFicha(int posXi, int posYi, int posXf, int posYf, Tablero tablero) {
		
		return tablero.moverFicha(posXi, posYi, posXf, posYf, this);
	}
	
	public boolean armarEstrategia() {
		return true;
	}
	
	public boolean perdio() {
		return (fichasVivas == 0 || fichaBombaVivas == fichasVivas || !banderaViva);
	}
}
