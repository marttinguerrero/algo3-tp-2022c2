package excepciones;

public class ExcepcionPosicionInvalida extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public ExcepcionPosicionInvalida(){
	       super("Posicion invalida");
	   }
}
