package algo3.javafx_tp;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import partida. *;
import tablero. *;

import java.io.IOException;

import excepciones.ExcepcionMovimientoInvalido;
import excepciones.ExcepcionPosicionInvalida;
import excepciones.ExcepcionTurnoEquivocado;
import ficha. *;

//JavaFX App

public class Controlador {
	private Vista vista;
	Media sound;
	private static Partida partida;
	private boolean esTurnoIA = false;
	boolean jugadorEstrategia1 = false;
	boolean jugadorEstrategia2 = false;
	private boolean hola = true;
	private String archivoContraJugador = "/home/martin/Algoritmos 3/javafx-tp/src/main/java/partidaContraJugador.csv";
	private String archivoContraIA = "/home/martin/Algoritmos 3/javafx-tp/src/main/java/partidaContraIA.csv";
	
	private static int[] casillaSelecionada = null;
	
	public Controlador(Vista vista) {
		this.vista = vista;
		//this.partida = partida;
	}
	
	public void cargarPartidaEnControlador(Partida partida) {
		this.partida = partida;
	}
	
//	public void seleccionarCasilla(int posX, int posY) {
//		if (casillaSelecionada == null) {
//			System.out.print(String.format("Entra a seleccionar la casilla con la coordenada i: %d y la coordenada j; %d\n", posX, posY));
//			casillaSelecionada = new int[2];
//			casillaSelecionada[0] = posX;
//			casillaSelecionada[1] = posY;
//		}
//		else {
//			if (casillaSelecionada.equals(partida.obtenerTablero().obtenerFicha(posX, posY))) {
//				//System.out.print(String.format("Entra a deseleccionar casilla con la coordenada i: %d y la coordenada j; %d\n", posX, posY));
//				casillaSelecionada = null;
//			}
//			else {
//				System.out.print(String.format("Entra a mover ficha con xi: %d, yi: %d, xf: %d, yf: %d\n", casillaSelecionada[1], casillaSelecionada[0], posY, posX));
//				try {
//					partida.moverFicha(casillaSelecionada[1], casillaSelecionada[0], posY, posX);	
//					
//					
//				} catch (ExcepcionPosicionInvalida e) {
//					vista.avisarPosicionInvalida();
//				} catch (ExcepcionTurnoEquivocado e) {
//					vista.avisarTurnoEquivocado();
//				} catch (ExcepcionMovimientoInvalido e) {
//					vista.avisarMovimientoInvalido();
//				}
//				esTurnoIA = true;
//				casillaSelecionada = null;
//			}
//		}
//	}
	
	
	public void seleccionarCasilla(int posX, int posY) {
		if (casillaSelecionada == null) {
			//System.out.print(String.format("Entra a seleccionar la casilla con la coordenada i: %d y la coordenada j; %d\n", posX, posY));
			casillaSelecionada = new int[2];
			casillaSelecionada[0] = posX;
			casillaSelecionada[1] = posY;
		}
		else {
			if (casillaSelecionada.equals(partida.obtenerTablero().obtenerFicha(posX, posY))) {
				//System.out.print(String.format("Entra a deseleccionar casilla con la coordenada i: %d y la coordenada j; %d\n", posX, posY));
				casillaSelecionada = null;
			} 
			else if (!jugadorEstrategia1){			
				try {
					partida.armarEstrategiaJugador1(casillaSelecionada[1], casillaSelecionada[0], posY, posX);
				} catch (ExcepcionPosicionInvalida e) {
					sound = new Media(getClass().getResource("res/invalid.wav").toExternalForm());
                	new MediaPlayer(sound).play();
					vista.avisarPosicionInvalida();
				} catch (ExcepcionTurnoEquivocado e) {
					sound = new Media(getClass().getResource("res/invalid.wav").toExternalForm());
                	new MediaPlayer(sound).play();
					vista.avisarTurnoEquivocado();
				} catch (ExcepcionMovimientoInvalido e) {
					sound = new Media(getClass().getResource("res/invalid.wav").toExternalForm());
                	new MediaPlayer(sound).play();
					vista.avisarMovimientoInvalido();
				}
				casillaSelecionada = null;
			}
			else if ((!jugadorEstrategia2  && !(partida instanceof PartidaContraComputadora))) {
				try {
					partida.armarEstrategiaJugador2(casillaSelecionada[1], casillaSelecionada[0], posY, posX);
				} catch (ExcepcionPosicionInvalida e) {
					sound = new Media(getClass().getResource("res/invalid.wav").toExternalForm());
                	new MediaPlayer(sound).play();
					vista.avisarPosicionInvalida();
				} catch (ExcepcionTurnoEquivocado e) {
					sound = new Media(getClass().getResource("res/invalid.wav").toExternalForm());
                	new MediaPlayer(sound).play();
					vista.avisarTurnoEquivocado();
				} catch (ExcepcionMovimientoInvalido e) {
					sound = new Media(getClass().getResource("res/invalid.wav").toExternalForm());
                	new MediaPlayer(sound).play();
					vista.avisarMovimientoInvalido();
				}
				casillaSelecionada = null;
			}
			else {
//				System.out.print(String.format("Entra a mover ficha con xi: %d, yi: %d, xf: %d, yf: %d\n", casillaSelecionada[1], casillaSelecionada[0], posY, posX));
				try {
					partida.moverFicha(casillaSelecionada[1], casillaSelecionada[0], posY, posX);
				} catch (ExcepcionPosicionInvalida e) {
					sound = new Media(getClass().getResource("res/invalid.wav").toExternalForm());
                	new MediaPlayer(sound).play();
					vista.avisarPosicionInvalida();
				} catch (ExcepcionTurnoEquivocado e) {
					sound = new Media(getClass().getResource("res/invalid.wav").toExternalForm());
                	new MediaPlayer(sound).play();
					vista.avisarTurnoEquivocado();
				} catch (ExcepcionMovimientoInvalido e) {
					sound = new Media(getClass().getResource("res/invalid.wav").toExternalForm());
                	new MediaPlayer(sound).play();
					vista.avisarMovimientoInvalido();
				}
				casillaSelecionada = null;
			}
		}
	}	
	
	
	private int obtenerIndiceTablero(double coordenadaPixel) {
		return (int) (coordenadaPixel / vista.obtenerTamañoDeCasilla());
	}
	

    public void iniciarContraJugador() {
//    		vista.dibujarMenu();
    		vista.inicializarCanvas();
	    	vista.render();
    	
    	vista.agregarEventoDeMouse(event -> {
            	//System.out.print("entra al evento de mouse\n");
            	double x = event.getX();
            	double y = event.getY();

                int i = obtenerIndiceTablero(x);
                int j = obtenerIndiceTablero(y);
                
//                System.out.print(String.format("Entra a evento de mouse con la coordenada i: %d y la coordenada j; %d\n", i, j));
                seleccionarCasilla(i, j);
                
                vista.render();
                System.out.println("Se movio");
        });
    	
    	    	
    	
    }
    
//    public void iniciarPartida() {
//		vista.inicializarCanvas();
//    	vista.render();
// 
//    	if(partida.obtenerJugador() == 2) {
////    		System.out.println("Buenassssss");
//    		partida.moverFicha(0, 0, 0, 0);
//    		vista.render();
//    	}
//    	
//		vista.agregarEventoDeMouse(event -> {
//			
//        	//System.out.print("entra al evento de mouse\n");
//        	double x = event.getX();
//        	double y = event.getY();
//
//            int i = obtenerIndiceTablero(x);
//            int j = obtenerIndiceTablero(y);
//            
//            System.out.print(String.format("Entra a evento de mouse con la coordenada i: %d y la coordenada j; %d\n", i, j));
//            seleccionarCasilla(i, j);      
//            vista.render();
//            if(partida instanceof PartidaContraComputadora) {
//            	partida.moverFicha(-1, -1, -1, -1);
//            	vista.render();
////            	esTurnoIA = false;
//            	try {
//            		vista.generarRetraso();
//            	} catch (InterruptedException e) {
//            		e.printStackTrace();
//            	}
//            	}
//            
//            
//	});
   
    

  		public void iniciarPartida() {
		    
	    	//vista.mostrarMenu();
	    	
	    	//vista.cargarPartidaEnVista(partida);
//			vista.dibujarMenuNombres(stage);
	    	vista.inicializarCanvas();
	    	vista.render();
//	    	vista.agregarEventoMenuCostado(event->{
//	    	double x = event.getX();
//            double y = event.getY();
//            int i = obtenerIndiceTablero(x);
//            int j = obtenerIndiceTablero(y);
//            if(partida instanceof PartidaContraJugador) {
//                	 if(i == 0 && j==2 ) {
//                     	jugadorEstrategia1 = true;
//                     	System.out.print(String.format("Se está haciendo click en el boton de temrinar estrategia del jugador 1\n"));
//                     }
//                	 else if(i == 0 && j==6 ) {
//                     	jugadorEstrategia2 = true;
//                     	System.out.print(String.format("Se está haciendo click en el boton de temrinar estrategia del jugador 2\n"));
//                     }
//                	
//                }
//                
//	    	});
//	    	clickMenuCostado();
	    	
//	    	while(hola) {
//	    	if(hola) {
	    	
	    	

	    	
	    	vista.agregarEventoMenuCostado(event->{
		    	double x = event.getX();
	            double y = event.getY();
	            int i = obtenerIndiceTablero(x);
	            int j = obtenerIndiceTablero(y);
	            
	            if((i == 1 && j == 8) || (i == 0 && j == 8)) {
	            	if(partida instanceof PartidaContraJugador) {
	            		try {
							partida.guardarPartida(archivoContraJugador, partida);
							System.out.println("Partida guardada con exito");
							sound = new Media(getClass().getResource("res/sonidoGuardar.wav").toExternalForm());
	                    	new MediaPlayer(sound).play();
						} catch (IOException e) {
							e.printStackTrace();
						}
	            	}
	            	else {
	            		try {
						partida.guardarPartida(archivoContraIA, partida);
						sound = new Media(getClass().getResource("res/sonidoGuardar.wav").toExternalForm());
                    	new MediaPlayer(sound).play();
						System.out.println("Partida guardada con exito");
					} catch (IOException e) {
						e.printStackTrace();
					}
	            		
	            	}
	            	
	            }
	            System.out.print(String.format("Coordenada i: %d y j: %d\n",i,j));
	            if(partida instanceof PartidaContraJugador) {
	                	 if(i == 0 && j==2 ) {
	                     	jugadorEstrategia1 = true;
	                     	sound = new Media(getClass().getResource("res/done.wav").toExternalForm());
	                    	new MediaPlayer(sound).play();
	                     	System.out.print(String.format("Se está haciendo click en el boton de temrinar estrategia del jugador 1\n"));
	                     }
	                	 else if(i == 0 && j==6 ) {
	                     	jugadorEstrategia2 = true;
	                     	sound = new Media(getClass().getResource("res/done.wav").toExternalForm());
	                    	new MediaPlayer(sound).play();
	                     	System.out.print(String.format("Se está haciendo click en el boton de temrinar estrategia del jugador 2\n"));
	                     }
//	                	 if(jugadorEstrategia1 && jugadorEstrategia2 ) {
//	                		 hola = false;
//	                	 }
	                }
	            else {
	            	if(i == 0 && j==2 ) {
                     	jugadorEstrategia1 = true;
                     	sound = new Media(getClass().getResource("res/done.wav").toExternalForm());
                    	new MediaPlayer(sound).play();
                     	System.out.print(String.format("Se está haciendo click en el boton de temrinar estrategia del jugador 1\n"));
                     }
//	            	if(jugadorEstrategia1) {
//               		 hola = false;
//               	 }
	            }
	            
	            
	                
		    	});
//	    	}

	    	if ((!jugadorEstrategia1|| ((!(partida instanceof PartidaContraComputadora)) && (!jugadorEstrategia2)))) {

	    	
//	    	if ((!jugadorEstrategia1 || !jugadorEstrategia2)) {
	    		
	        	vista.agregarEventoDeMouse(event -> {
//	            	System.out.print("entra al evento de mouse\n");
	        		
	            	double x = event.getX();
	            	double y = event.getY();
	            	
	                int i = obtenerIndiceTablero(x);
	                int j = obtenerIndiceTablero(y);
	                System.out.println("Se están rotando las piezas");
//	                System.out.print(String.format("Entra a evento de mouse con la coordenada i: %d y la coordenada j; %d\n", i, j));
	                seleccionarCasilla(i, j);
	                if(jugadorEstrategia1) {
	        			System.out.println("El jugador 1 ya terminó de armar su estrategia");
	        		}
	        		if(jugadorEstrategia2) {
	        			System.out.println("El jugador 2 ya terminó de armar su estrategia");
	        		}
	                vista.render();
	        	});
	        	
	        	
	        	
	        	
	        	
	    	} 
	    	else {
	    		System.out.println("Empezo la partida");
	    		vista.agregarEventoDeMouse(event -> {
	            	//System.out.print("entra al evento de mouse\n");
	            	double x = event.getX();
	            	double y = event.getY();

	                int i = obtenerIndiceTablero(x);
	                int j = obtenerIndiceTablero(y);
	                
	                System.out.print(String.format("Entra a evento de mouse con la coordenada i: %d y la coordenada j; %d\n", i, j));
	                seleccionarCasilla(i, j);
	                vista.render();
//	                if(vista.terminarPartida()) {
//	                	vista.inicializarCanvas();
//	        	    	vista.render();
//	                }
//	                
	                
	             
	              if(partida instanceof PartidaContraComputadora) {
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
	    	}
	    	
	    }
//		System.out.println("Holaaaaaaaa");

			
		
	

	public void iniciarPartidaEmpezada() {
	    
    	
		
    	vista.inicializarCanvas();
    	vista.render();
    	vista.agregarEventoMenuCostado(event->{
    		jugadorEstrategia1 = true;
			jugadorEstrategia2 = true;
	    	double x = event.getX();
            double y = event.getY();
            int i = obtenerIndiceTablero(x);
            int j = obtenerIndiceTablero(y);
            
            if((i == 1 && j == 8) || (i == 0 && j == 8)) {
            	if(partida instanceof PartidaContraJugador) {
            		try {
						partida.guardarPartida(archivoContraJugador, partida);
						System.out.println("Partida guardada con exito");
						sound = new Media(getClass().getResource("res/sonidoGuardar.wav").toExternalForm());
                    	new MediaPlayer(sound).play();
					} catch (IOException e) {
						e.printStackTrace();
					}
            	}
            	else {
            		try {
					partida.guardarPartida(archivoContraIA, partida);
					System.out.println("Partida guardada con exito");
					sound = new Media(getClass().getResource("res/sonidoGuardar.wav").toExternalForm());
                	new MediaPlayer(sound).play();
				} catch (IOException e) {
					e.printStackTrace();
				}
            		
            	}
            	
            }
            System.out.print(String.format("Coordenada i: %d y j: %d\n",i,j));
            if(partida instanceof PartidaContraJugador) {
                	 if(i == 0 && j==2 ) {
                     	sound = new Media(getClass().getResource("res/invalid.wav").toExternalForm());
                    	new MediaPlayer(sound).play();
                     	System.out.print(String.format("Se está haciendo click en el boton de temrinar estrategia del jugador 1\n"));
                     }
                	 else if(i == 0 && j==6 ) {
                     	sound = new Media(getClass().getResource("res/invalid.wav").toExternalForm());
                    	new MediaPlayer(sound).play();
                     	System.out.print(String.format("Se está haciendo click en el boton de temrinar estrategia del jugador 2\n"));
                     }
//                	 if(jugadorEstrategia1 && jugadorEstrategia2 ) {
//                		 hola = false;
//                	 }
                }
            else {
            	if(i == 0 && j==2 ) {
                 	sound = new Media(getClass().getResource("res/invalid.wav").toExternalForm());
                	new MediaPlayer(sound).play();
                 	System.out.print(String.format("Se está haciendo click en el boton de temrinar estrategia del jugador 1\n"));
                 }
//            	if(jugadorEstrategia1) {
//           		 hola = false;
//           	 }
            }
            
            
                
	    	});
    	
    		vista.agregarEventoDeMouse(event -> {
    			jugadorEstrategia1 = true;
    			jugadorEstrategia2 = true;
            	double x = event.getX();
            	double y = event.getY();

                int i = obtenerIndiceTablero(x);
                int j = obtenerIndiceTablero(y);
                
               
                System.out.print(String.format("Entra a evento de mouse con la coordenada i: %d y la coordenada j; %d\n", i, j));
                seleccionarCasilla(i, j);
                vista.render();
                
                
                
             
              if(partida instanceof PartidaContraComputadora) {
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
    	}
    	
    
    
    }
    
//	System.out.println("Holaaaaaaaa");

		
	
//}
		
//		System.out.println("Chauuuuuu");
//    	if(partida.obtenerJugador() == 1) {
// 
//    		partida.moverFicha(0, 0, 0, 0);
//    		vista.render();

//    	else {
//    		System.out.println("HOLAAAAAAAAAAA");
//    		partida.moverFicha(0, 0, 0, 0);
//    	}

    	
//    	else {
//    		System.out.println(partida.obtenerJugador());
//    		
//    	}
//    	vista.render();
//    	System.out.println(partida.obtenerJugador());
//    	seleccionarCasillaComputadora(0,0,0,0);
	
//	vista.agregarEventoDeMouse(event -> {
//        	//System.out.print("entra al evento de mouse\n");
//        	double x = event.getX();
//        	double y = event.getY();
//
//            int i = obtenerIndiceTablero(x);
//            int j = obtenerIndiceTablero(y);
//            
//            System.out.print(String.format("Entra a evento de mouse con la coordenada i: %d y la coordenada j; %d\n", i, j));
//            seleccionarCasilla(i, j);
//            
//            
//            vista.render();
//            
//    });
//	if(partida.obtenerJugador()== 0) {
		
//		partida.moverFicha(6, 4, 5, 4);
//	}
	
    	

    

