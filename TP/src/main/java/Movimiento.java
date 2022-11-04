
public class Movimiento {
		
	Pieza p;
	int columnaFinal;
	int filaFinal;
	
	public Movimiento(Pieza p, int columnaFinal, int filaFinal) {
		this.p = p;
		this.columnaFinal = columnaFinal;
		this.filaFinal = filaFinal;
	}
	
	public Pieza getPieza () {
		
		return p;
	}
	public int getFilaFinal () {
		
		return filaFinal;
	}
	public int getColumnaFinal() {
	
		return columnaFinal;
	}
	
	
	
	
	
}
