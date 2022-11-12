package excepciones;

public class ExcepcionTurnoEquivocado extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public ExcepcionTurnoEquivocado(){
        super("Es turno del equipo contrario");
    }
}
