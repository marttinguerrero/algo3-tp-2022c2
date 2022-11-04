
public class Pieza1 extends Pieza{

	public Pieza1(int x, int y, int rango, int color) {
		super(x, y, 1,color);
		}
	
	public Pieza copiar () {
	
		return new Pieza1(this.fila, this.columna, this.rango, this.color);
		
		}
	@Override
	public boolean validarMovimiento(Tablero tablero, int filaFinal, int columnaFinal) {
		int difFil, difCol;
		
		Pieza p;
		
		p = tablero.get(filaFinal, columnaFinal);
		
		difFil = this.fila - filaFinal;
		
		difCol = this.columna - columnaFinal;
		
		if(Math.abs(difFil) == 1 || Math.abs(difCol) == 1) {
			if(p!=null) {
				if(p.getColor()==this.color) {
					return false;
				}
				if(p.getRango()>1) {
					return false;
				}
			}
			return true;
		}
		else
			return false;
		
		
		
		
	}

	
	
}