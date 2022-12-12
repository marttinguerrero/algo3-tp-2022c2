//package pruebas;
//
//import static org.junit.Assert.*;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.ArrayList;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import ficha.Color;
//import ficha.Ficha;
//import jugador.Jugador;
//import jugador.JugadorHumano;
//import partida.Partida;
//import partida.PartidaContraJugador;
//
//public class PartidaTest {
//
//	Partida partida;
//
//	@Before
//	public void init() {
//		partida = new PartidaContraJugador();
//
//	}
//
//
//	@Test
//	public void testInicializarPartida() {
//
//		assertTrue(partida.inicializarPartida());
//
//	}
//
//	@Test 
//	public void testValidarCantidadDePiezas() {
//
//		Jugador jugador = new JugadorHumano(Color.VERDE);
////		ArrayList<Ficha> piezas = partida.inicializarFichas(Color.VERDE, jugador);
//		int x = 40;
//		assertEquals(x,piezas.size());
//
//	}
//
//	@Test
//	public void testGuardarPartida() throws IOException {
//		File f = new File("src/main/java/partidaContraJugador.csv");
//
//
//		assertTrue(partida.guardarPartida(f, partida));
//
//	}
//
////	@Test
////	public void testCargarPartida() throws IOException, ClassNotFoundException {
////		File f = new File("src/main/java/partidaContraJugador.csv");
////
////		
////		Partida partida2 = new Partida();
////		partida2 = partida.cargarPartida(f, partida);
////		
////		assertEquals(partida,partida2);
////
////	}
//
//
//}