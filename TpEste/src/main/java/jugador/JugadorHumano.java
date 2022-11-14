package jugador;

import tablero. *;



import ficha. *; 

public class JugadorHumano implements Jugador , java.io.Serializable{
	private static final long serialVersionUID = 1L;
	//fichas colocadas sera la suma de estas dos
	private int fichasVivas;
	//private int fichasMuertas;
	private int fichaMineroVivas;
	private int fichaBombaVivas;
	private boolean banderaViva;
	
	public JugadorHumano() {
		this.fichasVivas = 40;
		this.fichaMineroVivas = 3;
		this.fichaBombaVivas = 6;
		this.banderaViva = true;
	}
	
	public void perderFicha(Ficha ficha) {
		if (ficha.obtenerValor() == 3) {
			fichaMineroVivas = fichaMineroVivas - 1;
		}
		else if (ficha.obtenerValor() == 11) {
			fichaBombaVivas = fichaBombaVivas - 1;
			
		}
		else if (ficha.obtenerValor() == 0) {
			banderaViva = false;
			
		}
		fichasVivas = fichasVivas - 1;	
	}
	
	public boolean moverFicha(int posXi, int posYi, int posXf, int posYf, Tablero tablero) {
		System.out.print("entra a jugar el humano\n");
		return tablero.moverFicha(posXi, posYi, posXf, posYf, this);
	}
	
	public boolean armarEstrategia() {
		return true;
	}
	
	public boolean perdio() {
		return (fichasVivas == 0 || fichaBombaVivas == fichasVivas || !banderaViva);
	}
}
