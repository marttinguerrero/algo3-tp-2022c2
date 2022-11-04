
public abstract class Pieza {
	
	boolean comida = false;
	int fila;
	int columna;
	int rango;
	int color;
	
	public Pieza(int x, int y, int rango,int color) {
		fila = x;
		columna = y;
		this.rango = rango;
		this.color = color;
	}
	
	public int getColor() {
		
		return color;
	}
	
	public int getRango() {
		
		return rango;
	}
	public void	setPosicion(int fila, int columna) {
		
		this.fila = fila;
		this.columna = columna;
	}
	public int getFila() {
		
		return fila;
	}
	
	public int getColumna() {
		
		return columna;
		
	}
	public void setEstado(boolean comida) {
		
		this.comida = comida;
	}
	
	public boolean getEstado () {
		
		return comida;
	}
	
	public abstract boolean validarMovimiento (Tablero tablero,	int filaFinal, int columnaFinal);
	
	public abstract Pieza copiar();
	
	
}
