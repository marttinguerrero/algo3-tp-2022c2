package pruebas;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import ficha.Color;
import ficha.Ficha;
import jugador.Jugador;
import jugador.JugadorHumano;
import partida.Partida;
import partida.PartidaContraJugador;
import tablero.Tablero;

public class TableroTest {


		Partida partida;
		Jugador jugador ;
		ArrayList<Ficha> piezas;
		Jugador jugador1 ;
		Jugador jugador2 ;

		ArrayList<Ficha> piezas1;
		ArrayList<Ficha> piezas2;



		@Before
		public void init(){
			Partida partida = new PartidaContraJugador();

			Jugador jugador = new JugadorHumano(Color.VERDE);
			piezas = partida.inicializarFichas(Color.VERDE, jugador);
			Jugador jugador1 = new JugadorHumano(Color.AZUL);
			Jugador jugador2 = new JugadorHumano(Color.VERDE);
			piezas1 = partida.inicializarFichas(Color.VERDE, jugador1);
			piezas2 = partida.inicializarFichas(Color.AZUL, jugador2);


		}
		@Test
		public void testTableroInicializadoConFichasChequeaRojaLaPrimera() {

			Tablero tablero = new Tablero(piezas1,piezas2);
			Ficha ficha = tablero.obtenerFicha(0, 0);
			assertEquals(ficha.obtenerColor(),Color.VERDE);
		}

		@Test
		public void testTableroInicializadoConFichasChequeaAzulLaUltima() {

			Tablero tablero = new Tablero(piezas1,piezas2);
			Ficha ficha = tablero.obtenerFicha(9, 9);
			assertEquals(ficha.obtenerColor(),Color.AZUL);
		}



		@Test (expected = excepciones.ExcepcionMovimientoInvalido.class)
		public void testMoverFichaMovimientoInvalidoHayFichaDeMismoColor() {
			Partida partida = new PartidaContraJugador();

			Jugador jugador1 = new JugadorHumano(Color.VERDE);
			Jugador jugador2 = new JugadorHumano(Color.AZUL);


			ArrayList<Ficha> piezas1 = partida.inicializarFichas(Color.VERDE, jugador1);
			ArrayList<Ficha> piezas2 = partida.inicializarFichas(Color.AZUL, jugador2);
			Tablero tablero = new Tablero(piezas1,piezas2);

			assertFalse(tablero.moverFicha(0, 0, 1, 0, jugador1));
		}


		@Test (expected = excepciones.ExcepcionMovimientoInvalido.class)
		public void testMovimientoInvalido() {
			Partida partida = new PartidaContraJugador();

			Jugador jugador1 = new JugadorHumano(Color.VERDE);
			Jugador jugador2 = new JugadorHumano(Color.AZUL);

			ArrayList<Ficha> piezas1 = partida.inicializarFichas(Color.VERDE, jugador1);
			ArrayList<Ficha> piezas2 = partida.inicializarFichas(Color.AZUL, jugador2);
			Tablero tablero = new Tablero(piezas1,piezas2);
			assertNull(tablero.moverFicha(3, 0, 4, 1, jugador1));


		}

		@Test (expected = excepciones.ExcepcionTurnoEquivocado.class)
		public void testMoverFichaDelOtroJugador() {
			Partida partida = new PartidaContraJugador();

			Jugador jugador1 = new JugadorHumano(Color.VERDE);
			Jugador jugador2 = new JugadorHumano(Color.AZUL);


			ArrayList<Ficha> piezas1 = partida.inicializarFichas(Color.VERDE, jugador1);
			ArrayList<Ficha> piezas2 = partida.inicializarFichas(Color.AZUL, jugador2);
			Tablero tablero = new Tablero(piezas1,piezas2);


			assertFalse(tablero.moverFicha(3, 0, 4, 0, jugador2));


		}




}