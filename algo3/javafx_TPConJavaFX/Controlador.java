package algo3.javafx_TPConJavaFX;

import ficha.TipoDeFicha;


import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import partida. *;
import tablero. *;
import excepciones.ExcepcionMovimientoInvalido;
import excepciones.ExcepcionPosicionInvalida;
import excepciones.ExcepcionTurnoEquivocado;
import ficha. *;

//JavaFX App

public class Controlador {
	private Vista vista;
	private static Partida partida;
	
	private static int[] casillaSelecionada = null;
	
	public Controlador(Vista vista) {
		this.vista = vista;
		//this.partida = partida;
	}
	
	public void cargarPartidaEnControlador(Partida partida) {
		this.partida = partida;
	}
	
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
			else {
				System.out.print(String.format("Entra a mover ficha con xi: %d, yi: %d, xf: %d, yf: %d\n", casillaSelecionada[1], casillaSelecionada[0], posY, posX));
				try {
					partida.moverFicha(casillaSelecionada[1], casillaSelecionada[0], posY, posX);
				} catch (ExcepcionPosicionInvalida e) {
					vista.avisarPosicionInvalida();
				} catch (ExcepcionTurnoEquivocado e) {
					vista.avisarTurnoEquivocado();
				} catch (ExcepcionMovimientoInvalido e) {
					vista.avisarMovimientoInvalido();
				}
				casillaSelecionada = null;
			}
		}
	}
	
	
	private int obtenerIndiceTablero(double coordenadaPixel) {
		return (int) (coordenadaPixel / vista.obtenerTamañoDeCasilla());
	}
	

    public void iniciar() {
    
    	//vista.mostrarMenu();
    	
    	//vista.cargarPartidaEnVista(partida);
    	
    	vista.inicializarCanvas();
    	vista.render();
    	
    	vista.agregarEventoDeMouse(event -> {
            	//System.out.print("entra al evento de mouse\n");
            	double x = event.getX();
            	double y = event.getY();

                int i = obtenerIndiceTablero(x);
                int j = obtenerIndiceTablero(y);
                
                System.out.print(String.format("Entra a evento de mouse con la coordenada i: %d y la coordenada j; %d\n", i, j));
                seleccionarCasilla(i, j);
                vista.render();
        });
    	
    }

    
    

}