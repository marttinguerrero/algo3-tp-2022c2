package excepciones;

public class ExcepcionTurnoEquivocado extends RuntimeException {
	public ExcepcionTurnoEquivocado(){
        super("Es turno del equipo contrario");
    }
}
