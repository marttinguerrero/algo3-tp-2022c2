package ficha;



import capacidadEnfrentamiento. *;
import capacidadMovimiento. *;
import tablero. *;
import jugador. *;

public class Ficha implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	private TipoDeFicha tipoDeFicha;
	private Color color;
	private CapacidadMovimiento capacidadMovimiento;
	private CapacidadEnfrentamiento capacidadEnfrentamiento;
	private Jugador jugador;
	
	public Ficha(Color color, TipoDeFicha tipoDeFicha, CapacidadMovimiento capacidadMovimiento, CapacidadEnfrentamiento capacidadEnfrentamiento, Jugador jugador) {
		this.color = color;
		this.tipoDeFicha = tipoDeFicha;
		this.capacidadMovimiento = capacidadMovimiento;
		this.capacidadEnfrentamiento = capacidadEnfrentamiento;
		this.jugador = jugador;
	}
	
	public void imprimirFicha() {
		System.out.print(tipoDeFicha.valor);
	}
	
	public Jugador obtenerJugador() {
		return jugador;
	}
	
	public boolean validarMovimiento(int posXi, int posYi, int posXf, int posYf, Tablero tablero) {
		return capacidadMovimiento.validarMovimiento(posXi, posYi, posXf, posYf, tablero);
	}
	
	public ResultadoEnfrentamiento enfrentar(Ficha ficha) {
		return capacidadEnfrentamiento.enfrentar(this, ficha);
	}
	
	public int[] movimientoPosible(int posXi, int posYi, Tablero tablero) {
		return capacidadMovimiento.movimientoPosible(posXi, posYi, tablero);
	}
	
	public int obtenerValor() {
		return tipoDeFicha.valor;
	}
	
	public TipoDeFicha obtenerTipoDeFicha() {
		return tipoDeFicha;
	}
	
	public Color obtenerColor() {
		return color;
		
	}
}