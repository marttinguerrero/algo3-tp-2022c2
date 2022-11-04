
public class Tablero {
	private final Pieza VACIO = '-';
	private Pieza tablero[][];
	private boolean turno;
	
	
	public Tablero(boolean turno) {
		this.turno = turno;
        this.tablero = new Pieza[10][10];
        this.inicializarTablero();
    }


	private Pieza[][] inicializarTablero() {
		for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                tablero[i][j] = VACIO;
            }
        }
		return tablero;
		
	}
    public void mostrarTablero() {

        for (int i = 0; i < this.tablero.length; i++) {
            for (int j = 0; j < this.tablero[0].length; j++) {
                System.out.print(this.tablero[i][j] + " ");
            }
            System.out.println("");
        }

    }
    
    public void add (int x, int y, Pieza p) {
   
    	tablero[x][y] = p;
   }
   public Pieza get (int f, int c) {
   
	   return tablero[f][c];
   }
	
	
	
	
}
	
