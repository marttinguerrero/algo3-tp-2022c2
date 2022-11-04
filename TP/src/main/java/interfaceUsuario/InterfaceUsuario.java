package interfaceUsuario;

public class InterfaceUsuario {
	// esto si hacemos la primera entrega asi, que se pase por parametros
	public static final java.util.Scanner teclado = new java.util.Scanner(System.in);
	public static final java.io.PrintStream pantalla = new java.io.PrintStream(System.out);
	
	// retorn "contra jugador" o "contra computadora
	public String pedirTipoPartida() {
		pantalla.print("que tipo de partida quiere jugar contra jugador o contra compu: ");
		String tipoPartida = teclado.nextLine();
		return tipoPartida;
	}
}
