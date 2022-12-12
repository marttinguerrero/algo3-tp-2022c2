
package algo3.javafx_tp;



import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import partida. *;

import java.io.File;
import java.io.IOException;



public class App extends Application {

	
	Media sound;
	File f = new File("src/main/java/partidaContraJugador.csv");
	String sonido = "res/sonidoFondo.wav";

    public void start(Stage stage) {
    	sound = new Media(getClass().getResource(sonido).toExternalForm());
    	new MediaPlayer(sound).setAutoPlay(true);
    	new MediaPlayer(sound).play();
    	Vista vista = new Vista(stage);
    	Controlador controlador = new Controlador(vista);
    	vista.dibujarMenu(stage);
    	

    	vista.apretarCargarPartida(event->{
    		try {
    			Partida partida = new Partida();
				partida = partida.cargarPartida(f, partida);
				controlador.cargarPartidaEnControlador(partida);
	        	vista.cargarPartidaEnVista(partida);  
	        	controlador.setearArmarEstrategiaTrue();
	        	controlador.iniciarPartida();
	        					
			} catch (ClassNotFoundException | IOException e1) {				
				e1.printStackTrace();
			}
    	});
    	

    	vista.empezarPartidaContraJugador(event->{
    		Partida partida = new PartidaContraJugador();
        	vista.cargarPartidaEnVista(partida);  
        	controlador.cargarPartidaEnControlador(partida);
        	controlador.iniciarPartida();

    	});

    	
    	vista.empezarPartidaContraIA(event->{
    		Partida partida = new PartidaContraComputadora();
    		vista.cargarPartidaEnVista(partida);
    		controlador.cargarPartidaEnControlador(partida);
    		controlador.iniciarPartida();
    		
    		
    	});
    		
    }   
    
    public static void main(String[] args) {
    	launch(args);
    }
}
