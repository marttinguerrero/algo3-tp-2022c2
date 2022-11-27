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
import ficha. *;

//JavaFX App

public class App extends Application {

    @Override
    public void start(Stage stage) {
    	//System.out.print(String.format("Entra a strat \n",null));
    	Vista vista = new Vista(stage);
    	Partida partida = new PartidaContraJugador();
    	
    	/*int tipoDePartida = vista.obtenerTipoDePartida();
    	
    	if (tipoDePartida == 0) {
    		partida = new PartidaContraJugador();
    	} else {
    		partida = new PartidaContraComputadora();
    	}*/
    	vista.cargarPartidaEnVista(partida);
    	
    	
    	Controlador controlador = new Controlador(vista);
    	
    	controlador.cargarPartidaEnControlador(partida);
    	controlador.iniciar();
    }
    
    public static void main(String[] args) {
    	launch(args);
    }
}




