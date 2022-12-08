package algo3.javafx_tp;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import partida. *;

import java.io.File;
import java.io.IOException;

import excepciones.ExcepcionMovimientoInvalido;
import excepciones.ExcepcionPosicionInvalida;
import excepciones.ExcepcionTurnoEquivocado;


public class Controlador {
	private Vista vista;
	Media sound;
	private static Partida partida;
	private boolean esTurnoIA = false;
	boolean jugadorEstrategia1 = false;
	boolean jugadorEstrategia2 = false;
	File f = new File("src/main/java/partidaContraJugador.csv");
	File f1 = new File("src/main/java/partidaContraIA.csv");
	String sonidoGuardar = "res/sonidoGuardar.wav";
	String sonidoEstrategia = "res/done.wav";
	
	
	private static int[] casillaSelecionada = null;
	
	public Controlador(Vista vista) {
		this.vista = vista;
	}
	
	public void cargarPartidaEnControlador(Partida partida) {
		this.partida = partida;
	}
		
	public void seleccionarCasilla(int posX, int posY) {
		if (casillaSelecionada == null) {
			casillaSelecionada = new int[2];
			casillaSelecionada[0] = posX;
			casillaSelecionada[1] = posY;
		}
		else {
			if (casillaSelecionada.equals(partida.obtenerTablero().obtenerFicha(posX, posY))) {
				casillaSelecionada = null;
			} 
			else if (!jugadorEstrategia1){			
				try {
					partida.armarEstrategiaJugador1(casillaSelecionada[1], casillaSelecionada[0], posY, posX);
				} catch (ExcepcionPosicionInvalida e) {
//					vista.insertarSonidoInvalido();
					vista.avisarPosicionInvalida();
				} catch (ExcepcionTurnoEquivocado e) {
//					vista.insertarSonidoInvalido();
					vista.avisarTurnoEquivocado();
				} catch (ExcepcionMovimientoInvalido e) {
//					vista.insertarSonidoInvalido();
					vista.avisarMovimientoInvalido();
				}
				casillaSelecionada = null;
			}
			else if ((!jugadorEstrategia2  && !(partida instanceof PartidaContraComputadora))) {
				try {
					partida.armarEstrategiaJugador2(casillaSelecionada[1], casillaSelecionada[0], posY, posX);
					
//					vista.mostrarAvisoEnfrentamiento();
				} catch (ExcepcionPosicionInvalida e) {
//					vista.insertarSonidoInvalido();
					vista.avisarPosicionInvalida();
				} catch (ExcepcionTurnoEquivocado e) {
//					vista.insertarSonidoInvalido();
					vista.avisarTurnoEquivocado();
				} catch (ExcepcionMovimientoInvalido e) {
					vista.avisarMovimientoInvalido();
				}
				casillaSelecionada = null;
			}
			else {
				try {					
					partida.moverFicha(casillaSelecionada[1], casillaSelecionada[0], posY, posX);
					esTurnoIA = true;
					if (partida.huboEnfrentamiento() != null) {
						vista.avisarEnfrentamiento(partida.huboEnfrentamiento());
					}
					
				} catch (ExcepcionPosicionInvalida e) {
//					vista.insertarSonidoInvalido();
					vista.avisarPosicionInvalida();
				} catch (ExcepcionTurnoEquivocado e) {
//					vista.insertarSonidoInvalido();
					vista.avisarTurnoEquivocado();
				} catch (ExcepcionMovimientoInvalido e) {
//					vista.insertarSonidoInvalido();
					vista.avisarMovimientoInvalido();
				}
//				vista.avisarEnfrentamientos();
				
				esTurnoIA = true;
				casillaSelecionada = null;
			}
		}
	}	
	
	
		private int obtenerIndiceTablero(double coordenadaPixel) {
			return (int) (coordenadaPixel / vista.obtenerTamañoDeCasilla());
		}
		

		public void setearArmarEstrategiaTrue() {
			jugadorEstrategia1 = true;
			jugadorEstrategia2 = true;
		}


  		public void iniciarPartida() {
		    
	    	
	    	vista.inicializarCanvas();
	    	vista.render();
	    	
	    	
	    	if ((!jugadorEstrategia1 || ((!(partida instanceof PartidaContraComputadora)) && (!jugadorEstrategia2)))) {
	    		
	    		vista.agregarEventoMenuCostado(event->{
		    		double x = event.getX();
		            double y = event.getY();
		            int i = obtenerIndiceTablero(x);
		            int j = obtenerIndiceTablero(y);
		    	
		    		
		            if(i == 0 && j==2 ) {		      
		            	jugadorEstrategia1 = true;
		            	partida.actualizarTurno();
		            	vista.render();
		                vista.insertarSonido(sonidoEstrategia);
	                }else if((i == 0 && j==6 )  || (partida instanceof PartidaContraComputadora)){
		            	jugadorEstrategia2 = true;
		            	partida.actualizarTurno();
		            	vista.render();
		            	vista.insertarSonido(sonidoEstrategia);
		            }
	                else if((i == 1 && j == 8) || (i == 0 && j == 8)) {

	            		try {
						partida.guardarPartida(f, partida);
						vista.insertarSonido(sonidoGuardar);
					} catch (IOException e) {
						e.printStackTrace();
						}	            		
	            	}	            
	    		});
	    		vista.agregarEventoDeMouse(event -> {
		    		double x = event.getX();
		        	double y = event.getY();

		            int i = obtenerIndiceTablero(x);
		            int j = obtenerIndiceTablero(y);
		     
		            
		            
		            seleccionarCasilla(i, j);
		            if (partida.hayGanador() != null) {
		            	vista.terminarPartida(partida.hayGanador());
		            }
		            vista.render();
		                
		             
		            if(partida instanceof PartidaContraComputadora && esTurnoIA == true) {
		            	partida.moverFicha(-1, -1, -1, -1);
		            	vista.render();
		            	esTurnoIA = false;
		            }
		        });
	    		
	    	}
	    	
	    	else{
	    		vista.agregarEventoDeMouse(event -> {
		    		double x = event.getX();
		        	double y = event.getY();

		            int i = obtenerIndiceTablero(x);
		            int j = obtenerIndiceTablero(y);
		                
		            seleccionarCasilla(i, j);
		            if (partida.hayGanador() != null) {
		            	vista.terminarPartida(partida.hayGanador());
		            }
		            vista.render();
		                
		             
		            if(partida instanceof PartidaContraComputadora && esTurnoIA == true) {
		            	partida.moverFicha(-1, -1, -1, -1);
		            	vista.render();
		            	esTurnoIA = false;
		            	try {
		            		vista.generarRetraso();
		            	} catch (InterruptedException e) {
		            		e.printStackTrace();
		            	}
		            }
		        });
	    		
			    vista.agregarEventoMenuCostado(event->{
				    	double x = event.getX();
			            double y = event.getY();
			            int i = obtenerIndiceTablero(x);
			            int j = obtenerIndiceTablero(y);
			            
			            if((i == 1 && j == 8) || (i == 0 && j == 8)) {

			            		try {
								partida.guardarPartida(f, partida);
								vista.insertarSonido(sonidoGuardar);
							} catch (IOException e) {
								e.printStackTrace();
								}	            		
			            	}
		
			                
				    	});

	    	}
  		}
}
		    

	    		
  			    		

    	

    

