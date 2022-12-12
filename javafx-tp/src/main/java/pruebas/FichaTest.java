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


public class FichaTest {

	Partida partida;
	Jugador jugador ;
	ArrayList<Ficha> piezas ;



	@Before
	public void init() {
		partida = new PartidaContraJugador();

		jugador = new JugadorHumano(Color.VERDE);
		piezas = partida.inicializarFichas(Color.VERDE, jugador);
	}

	
	
	
	@Test
	public void testCantidadPiezas2() {
		
		int contador = 0;
		for(int i = 0; i<piezas.size();i++) {
			Ficha ficha = piezas.get(i);
			if(ficha.obtenerValor() == 2) {
				contador++;
			}
		}
		assertEquals(contador,8);
	}
		
		
	@Test
	public void testCantidadPiezas1() {
			
		int contador = 0;
		for(int i = 0; i<piezas.size();i++) {
			Ficha ficha = piezas.get(i);
			if(ficha.obtenerValor() == 1) {
				contador++;
			}
		}
		assertEquals(contador,1);
	}
	
	
	@Test
	public void testCantidadPiezas3() {
			
		int contador = 0;
		for(int i = 0; i<piezas.size();i++) {
			Ficha ficha = piezas.get(i);
			if(ficha.obtenerValor() == 3) {
				contador++;
			}
		}
		assertEquals(contador,5);
	}
	
	
	@Test
	public void testCantidadPiezas4() {
			
		int contador = 0;
		for(int i = 0; i<piezas.size();i++) {
			Ficha ficha = piezas.get(i);
			if(ficha.obtenerValor() == 4) {
				contador++;
			}
		}
		assertEquals(contador,4);
	}
	
	
	@Test
	public void testCantidadPiezas5() {
			
		int contador = 0;
		for(int i = 0; i<piezas.size();i++) {
			Ficha ficha = piezas.get(i);
			if(ficha.obtenerValor() == 5) {
				contador++;
			}
		}
		assertEquals(contador,4);
	}
	
	@Test
	public void testCantidadPiezas6() {
			
		int contador = 0;
		for(int i = 0; i<piezas.size();i++) {
			Ficha ficha = piezas.get(i);
			if(ficha.obtenerValor() == 6) {
				contador++;
			}
		}
		assertEquals(contador,4);
	}
	
	@Test
	public void testCantidadPiezas7() {
			
		int contador = 0;
		for(int i = 0; i<piezas.size();i++) {
			Ficha ficha = piezas.get(i);
			if(ficha.obtenerValor() == 7) {
				contador++;
			}
		}
		assertEquals(contador,3);
	}
	
	@Test
	public void testCantidadPiezas8() {
			
		int contador = 0;
		for(int i = 0; i<piezas.size();i++) {
			Ficha ficha = piezas.get(i);
			if(ficha.obtenerValor() == 8) {
				contador++;
			}
		}
		assertEquals(contador,2);
	}
	
	@Test
	public void testCantidadPiezas9() {
			
		int contador = 0;
		for(int i = 0; i<piezas.size();i++) {
			Ficha ficha = piezas.get(i);
			if(ficha.obtenerValor() == 1) {
				contador++;
			}
		}
		assertEquals(contador,1);
	}
	@Test
	public void testCantidadPiezas10() {
			
		int contador = 0;
		for(int i = 0; i<piezas.size();i++) {
			Ficha ficha = piezas.get(i);
			if(ficha.obtenerValor() == 10) {
				contador++;
			}
		}
		assertEquals(contador,1);
	}

	@Test
	public void testCantidadPiezasBomba() {
			
		int contador = 0;
		for(int i = 0; i<piezas.size();i++) {
			Ficha ficha = piezas.get(i);
			if(ficha.obtenerValor() == 11) {
				contador++;
			}
		}
		assertEquals(contador,6);
	}
	
	@Test
	public void testCantidadPiezasBandera() {
			
		int contador = 0;
		for(int i = 0; i<piezas.size();i++) {
			Ficha ficha = piezas.get(i);
			if(ficha.obtenerValor() == 0) {
				contador++;
			}
		}
		assertEquals(contador,1);
	}



	@Test
	public void testPiezaColorRojo() {


		Ficha ficha = piezas.get(0);
		assertEquals(ficha.obtenerColor(),Color.VERDE);
	}

	@Test
	public void testPiezaColorAzul() {

		ArrayList<Ficha> piezas = partida.inicializarFichas(Color.AZUL, jugador);

		Ficha ficha = piezas.get(0);
		assertEquals(ficha.obtenerColor(),Color.AZUL);
	}



}