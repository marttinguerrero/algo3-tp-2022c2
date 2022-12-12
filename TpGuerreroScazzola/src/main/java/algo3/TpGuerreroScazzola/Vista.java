package algo3.TpGuerreroScazzola;

import ficha.TipoDeFicha;
import java.util.concurrent.TimeUnit;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import partida. *;
import tablero. *;
import ficha. *;

//JavaFX App

//App es el controlador
//Partida el modelo
//Vista la vista

public class Vista{

	
	private Button botonJugador;
	private Button botonComputadora;
	private Button botonCargarPartidaContraJugador;
	private Button botonIngresarNombres;

	
	//DIMENSIONES DE LA ESCENA
	private final int ALTO_ESCENA = 800;
	private final int ANCHO_ESCENA = 1200;
	
	//DIMENSIONES DEL TABLERO
	private final int TAM_CANVAS_TABLERO = 800;
	private final int CANT_CASILLAS = 10;
	private final int TAM_CASILLA = TAM_CANVAS_TABLERO / CANT_CASILLAS;
	
	//DIMENSIONES MENU INICIAL
	
	
	//DIMENSIONES Y UBICACION EN ESCENA DE: MENU DEL COSTADO
	private final int ANCHO_MENU_COSTADO = 400;
	private final int ALTO_MENU_COSTADO = ALTO_ESCENA;
	private final int UBICACION_X_MENU_COSTADO =  TAM_CANVAS_TABLERO;
	
	//DIMENSIONES Y UBICACION EN LA ESCENA DE: VENTANA DE AVISOS
	private final int ANCHO_CANVAS_AVISOS = ANCHO_MENU_COSTADO;
	private final int ALTO_CANVAS_AVISOS = 300;
	private final int UBICACION_X_AVISOS =  TAM_CANVAS_TABLERO; //+ (ANCHO_ESCENA - TAM_CANVAS_TABLERO) / 8;
	private final int UBICACION_Y_AVISOS = 200;
	
	//TEXTURAS TABLERO
	private final Image AGUA = new Image(getClass().getResourceAsStream("res/texturaAgua1.jpeg"));
	private final Image MOSAICO = new Image(getClass().getResourceAsStream("res/mosaico1.png"), TAM_CASILLA, TAM_CASILLA, false, false);
	
	private final Image IMAGEN_FIN_PARTIDA = new Image(getClass().getResourceAsStream("res/mision-entrenamiento-stratego-original.jpg"), 500, 500, false, false);
	//FICHAS AZULES
	
	private final Image EN_BLANCO_AZUL = new Image(getClass().getResourceAsStream("res/enBlancoAzul.png"), TAM_CASILLA, TAM_CASILLA, false, false);
	private final Image BANDERA_AZUL = new Image(getClass().getResourceAsStream("res/BanderaAzul.png"), TAM_CASILLA, TAM_CASILLA, false, false);
	private final Image ESPIA_AZUL = new Image(getClass().getResourceAsStream("res/UnoAzul.png"), TAM_CASILLA, TAM_CASILLA, false, false);
	private final Image DOS_AZUL = new Image(getClass().getResourceAsStream("res/DosAzul.png"), TAM_CASILLA, TAM_CASILLA, false, false);
	private final Image TRES_AZUL = new Image(getClass().getResourceAsStream("res/TresAzul.png"), TAM_CASILLA, TAM_CASILLA, false, false);
	private final Image CUATRO_AZUL = new Image(getClass().getResourceAsStream("res/CuatroAzul.png"), TAM_CASILLA, TAM_CASILLA, false, false);
	private final Image CINCO_AZUL = new Image(getClass().getResourceAsStream("res/CincoAzul.png"), TAM_CASILLA, TAM_CASILLA, false, false);
	private final Image SEIS_AZUL = new Image(getClass().getResourceAsStream("res/SeisAzul.png"), TAM_CASILLA, TAM_CASILLA, false, false);
	private final Image SIETE_AZUL = new Image(getClass().getResourceAsStream("res/SieteAzul.png"), TAM_CASILLA, TAM_CASILLA, false, false);
	private final Image OCHO_AZUL = new Image(getClass().getResourceAsStream("res/OchoAzul.png"), TAM_CASILLA, TAM_CASILLA, false, false);
	private final Image NUEVE_AZUL = new Image(getClass().getResourceAsStream("res/NueveAzul.png"), TAM_CASILLA, TAM_CASILLA, false, false);
	private final Image DIEZ_AZUL = new Image(getClass().getResourceAsStream("res/DiezAzul.png"), TAM_CASILLA, TAM_CASILLA, false, false);
	private final Image BOMBA_AZUL = new Image(getClass().getResourceAsStream("res/BombaAzul.png"), TAM_CASILLA, TAM_CASILLA, false, false);
	
	//FICHAS VERDES
	private final Image EN_BLANCO_VERDE = new Image(getClass().getResourceAsStream("res/enBlancoVerde.png"), TAM_CASILLA, TAM_CASILLA, false, false);
	private final Image BANDERA_VERDE = new Image(getClass().getResourceAsStream("res/BanderaVerde.png"), TAM_CASILLA, TAM_CASILLA, false, false);
	private final Image ESPIA_VERDE = new Image(getClass().getResourceAsStream("res/UnoVerde.png"), TAM_CASILLA, TAM_CASILLA, false, false);
	private final Image DOS_VERDE = new Image(getClass().getResourceAsStream("res/DosVerde.png"), TAM_CASILLA, TAM_CASILLA, false, false);
	private final Image TRES_VERDE = new Image(getClass().getResourceAsStream("res/TresVerde.png"), TAM_CASILLA, TAM_CASILLA, false, false);
	private final Image CUATRO_VERDE = new Image(getClass().getResourceAsStream("res/CuatroVerde.png"), TAM_CASILLA, TAM_CASILLA, false, false);
	private final Image CINCO_VERDE = new Image(getClass().getResourceAsStream("res/CincoVerde.png"), TAM_CASILLA, TAM_CASILLA, false, false);
	private final Image SEIS_VERDE = new Image(getClass().getResourceAsStream("res/SeisVerde.png"), TAM_CASILLA, TAM_CASILLA, false, false);
	private final Image SIETE_VERDE = new Image(getClass().getResourceAsStream("res/SieteVerde.png"), TAM_CASILLA, TAM_CASILLA, false, false);
	private final Image OCHO_VERDE = new Image(getClass().getResourceAsStream("res/OchoVerde.png"), TAM_CASILLA, TAM_CASILLA, false, false);
	private final Image NUEVE_VERDE = new Image(getClass().getResourceAsStream("res/NueveVerde.png"), TAM_CASILLA, TAM_CASILLA, false, false);
	private final Image DIEZ_VERDE = new Image(getClass().getResourceAsStream("res/DiezVerde.png"), TAM_CASILLA, TAM_CASILLA, false, false);
	private final Image BOMBA_VERDE = new Image(getClass().getResourceAsStream("res/BombaVerde.png"), TAM_CASILLA, TAM_CASILLA, false, false);
	
	//TITULO
	private final Image TITULO = new Image(getClass().getResourceAsStream("res/Titulo1.png"), 100, 400, false, false);
	
	Partida partida;
	Stage stage;
	Scene scene;
	
	GraphicsContext contextoCanvasTablero;
	Canvas canvasTablero;
	
	GraphicsContext contextoCanvasMenuCostado;
	Canvas canvasMenuCostado;
	
	Canvas canvasAvisos;
	
	GraphicsContext contextoCanvasAvisos;
	String aviso;
	String avisoEnfrentamiento;
	private Group group;
	
	
	public Vista(Stage stage) {
		this.stage = stage;
	}
	
	public void cargarPartidaEnVista(Partida partida) {
		this.partida = partida;
	}
	
	
	
	private Image obtenerImagenDeFicha(TipoDeFicha tipoDeFicha, ficha.Color color) {
		

		
		
		if (color.equals(ficha.Color.AZUL)) {
			if (partida.esTurnoAzules() || partida instanceof PartidaContraComputadora) {
				return EN_BLANCO_AZUL;
			}
			switch (tipoDeFicha) {
				case BANDERA:
					return BANDERA_AZUL;
				case ESPIA:
					return ESPIA_AZUL;
				case DOS:
					return DOS_AZUL;
				case TRES:
					return TRES_AZUL;
				case CUATRO:
					return CUATRO_AZUL;
				case CINCO:
					return CINCO_AZUL;
				case SEIS:
					return SEIS_AZUL;	
				case SIETE:
					return SIETE_AZUL;	
				case OCHO:
					return OCHO_AZUL;
				case NUEVE:
					return NUEVE_AZUL;	
				case DIEZ:
					return DIEZ_AZUL;	
				case BOMBA:
					return BOMBA_AZUL;
			default:
				break;	
			}
		}
		
		
		

		if (color.equals(ficha.Color.VERDE)){
			if (!partida.esTurnoAzules()) {
				return EN_BLANCO_VERDE;
			}
			switch (tipoDeFicha) {
				case BANDERA:
					return BANDERA_VERDE;
				case ESPIA:
					return ESPIA_VERDE;
				case DOS:
					return DOS_VERDE;
				case TRES:
					return TRES_VERDE;
				case CUATRO:
					return CUATRO_VERDE;
				case CINCO:
					return CINCO_VERDE;
				case SEIS:
					return SEIS_VERDE;	
				case SIETE:
					return SIETE_VERDE;	
				case OCHO:
					return OCHO_VERDE;
				case NUEVE:
					return NUEVE_VERDE;	
				case DIEZ:
					return DIEZ_VERDE;	
				case BOMBA:
					return BOMBA_VERDE;
			default:
				break;	
			}
		}
		
		return null;
	}
	
	//Esta función dibuja el canvas de cuando ya terminó la partida, indicando que jugador ganó.
	public void terminarPartida(String nombre_ganador) {
		
		Canvas canvasFinDePartida = new Canvas(500, 500);	
		GraphicsContext contextoCanvasFinDePartida = canvasFinDePartida.getGraphicsContext2D();
		
		contextoCanvasFinDePartida.drawImage(IMAGEN_FIN_PARTIDA, 0, 0);
		
		contextoCanvasFinDePartida.setStroke(Color.AQUA);
		contextoCanvasFinDePartida.setFill(Color.SLATEGRAY);
		contextoCanvasFinDePartida.fillRect(50, 100, 400, 100);
		contextoCanvasFinDePartida.setLineWidth(10);
		contextoCanvasFinDePartida.setFont(new Font("Verdana", 15));
		contextoCanvasFinDePartida.setFill(Color.BLACK);
		contextoCanvasFinDePartida.fillText(String.format("Felicitaciones %s has ganado !! ", nombre_ganador), 80, 150);

		
		Group group = new Group();
		group.getChildren().add(canvasFinDePartida);
		
		this.group = group;
		this.scene = new Scene(group, 500, 500);
		
	}
	

	
	public int obtenerTamañoDeCasilla() {
		return TAM_CASILLA;
	}
	
	public int obtenerTipoDePartida() {
		return 0;
	}
	
	
	public void avisarPosicionInvalida(){
		
		this.aviso = "Posición inválida";
		Media sound = new Media(getClass().getResource("res/invalid.wav").toExternalForm());
    	new MediaPlayer(sound).play();
	}
	
	public void avisarTurnoEquivocado() {
		this.aviso = "Turno equivocado ";
		Media sound = new Media(getClass().getResource("res/invalid.wav").toExternalForm());
    	new MediaPlayer(sound).play();
	}
	public void avisarPartidaTermianda() {
		this.aviso = "Partida terminada";
	}
	
	public void avisarMovimientoInvalido() {
		this.aviso = "Movimiento inválido ";
		Media sound = new Media(getClass().getResource("res/invalid.wav").toExternalForm());
    	new MediaPlayer(sound).play();
	}
	
	public void avisarEnfrentamiento(String enfrentamiento){
		this.aviso = enfrentamiento;
	}
	
	
	//Esta función dibuja el canvas con el tablero en la pantalla.
	private void dibujarTablero(Tablero tablero, GraphicsContext contextoCanvas) {
		  
       	for (int i = 0; i < 10; i++) {
    		for (int j = 0; j < 10; j++) {
    			
    			Ficha fichaAMostrar = tablero.obtenerFicha(i, j);
    			
    			contextoCanvas.drawImage(MOSAICO, 0, 0, TAM_CASILLA, TAM_CASILLA, j * TAM_CASILLA, i * TAM_CASILLA, TAM_CASILLA, TAM_CASILLA);
    			
    			if (fichaAMostrar != null && fichaAMostrar.obtenerTipoDeFicha().equals(ficha.TipoDeFicha.AGUA)) {
    				
    				contextoCanvas.drawImage(AGUA, 0, 0, TAM_CASILLA, TAM_CASILLA, j * TAM_CASILLA, i * TAM_CASILLA, TAM_CASILLA, TAM_CASILLA);
    				
    			} else if (fichaAMostrar != null){
    				
            		Image imagenFicha = obtenerImagenDeFicha(fichaAMostrar.obtenerTipoDeFicha(), fichaAMostrar.obtenerColor());
            	    double altoImagenFicha = imagenFicha.getHeight();
            	    double anchoImagenFicha = imagenFicha.getWidth();
            	    	
            	    contextoCanvas.drawImage(imagenFicha, 0, 0, altoImagenFicha, anchoImagenFicha, j * TAM_CASILLA, i * TAM_CASILLA, TAM_CASILLA, TAM_CASILLA);
    			}
    			
    			contextoCanvas.strokeRect(j * TAM_CASILLA, i * TAM_CASILLA ,TAM_CASILLA,TAM_CASILLA);
    			
    		}
    	}

	}

	//Esta función dibuja el menu del costado en donde está el título del juego y las opciones de guardar estrategias de los jugadores 
	//y de guardar la partida.
	public void dibujarMenuCostado(Canvas canvas, GraphicsContext contextoCanvas) {
		Image MOSAICO2 = new Image(getClass().getResourceAsStream("res/mosaico1.png"), 500, 20, false, false);
		Image MOSAICO3 = new Image(getClass().getResourceAsStream("res/mosaico1.png"), 20, 900, false, false);
		Image MOSAICO4 = new Image(getClass().getResourceAsStream("res/mosaico1.png"), 400, 100, false, false);
		Image TerminarEstrategia1 = new Image(getClass().getResourceAsStream("res/botonTerminarEstrategia.png"), 400, 100, false, false);
		Image TerminarEstrategia2 = new Image(getClass().getResourceAsStream("res/botonTerminarEstrategia.png"), 400, 100, false, false);
		Image Fondo1 = new Image(getClass().getResourceAsStream("res/botonTerimnar.png"), 400, 100, false, false);
		Image Fondo2 = new Image(getClass().getResourceAsStream("res/botonTerimnar.png"), 400, 100, false, false);
		Image Fondo3 = new Image(getClass().getResourceAsStream("res/BotonGuardar.png"), 400, 100, false, false);
		contextoCanvas.setFill(Color.LIGHTGRAY);
		contextoCanvas.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
		contextoCanvas.drawImage(MOSAICO2, 50, 0, 400, 20, 0, 0, 400, 20);
		contextoCanvas.drawImage(MOSAICO2, 50, 0, 400, 20, 0, 780, 400, 20);
		contextoCanvas.drawImage(MOSAICO3, 0, 50, 20, 800, 0, 0, 20, 800);
		contextoCanvas.drawImage(MOSAICO3, 0, 50, 20, 800, 380, 0, 20, 800);
		contextoCanvas.drawImage(MOSAICO4, 20, 0, 360, 100, 20, 20, 360, 100);


		contextoCanvas.drawImage(Fondo1, 20, 0, 360, 100, 20, 150, 50, 50);
		contextoCanvas.drawImage(TerminarEstrategia2, 20, 0, 360, 100, 80, 150, 150, 40);
		
		if (!(partida instanceof PartidaContraComputadora)) {
			contextoCanvas.drawImage(Fondo2, 20, 0, 360, 100, 20, 500, 50, 50);
			contextoCanvas.drawImage(TerminarEstrategia1, 20, 0, 360, 100, 80, 500, 150, 40);
		}
		
		
		contextoCanvas.drawImage(Fondo3, 20, 0, 360, 100, 20, 690, 100, 40);
		contextoCanvas.setFill(Color.BLACK);

		
		
		contextoCanvas.setFont(Font.font("Verdana", FontWeight.LIGHT, FontPosture.ITALIC, 60.0));
		contextoCanvas.fillText("Stratego", 60.0, 80.0);

	}
	
	public void dibujarAviso(String aviso, GraphicsContext contextoCanvas) {
		contextoCanvas.setFont(Font.font("Verdana", FontWeight.LIGHT, FontPosture.REGULAR, 15.0));
		contextoCanvas.fillText(aviso, 25, 150);
		
		this.aviso = "";
	}
	
	public void insertarSonido(String sonido) {
		Media sound = new Media(getClass().getResource(sonido).toExternalForm());
    	new MediaPlayer(sound).play();
	}

	
	//Esta función se encarga de dibujar el menú principal de juego con los respectivos botones, para inciar cualquier tipo de partida
	//o para cargar una partoda guardada.
	public void dibujarMenu(Stage escenario)     {
		
		Image Fondo2 = new Image(getClass().getResourceAsStream("res/Fondo.png"), 800, 1200, true, true);
		ImageView Fondo = new ImageView(Fondo2);
		Label label = new Label("El Estratego");
		botonJugador = new Button("Partida contra jugador");
		botonComputadora = new Button("Partida contra IA");
		botonCargarPartidaContraJugador = new Button("Cargar partida");
		StackPane root = new StackPane();
		root.getChildren().addAll(Fondo);
		root.getChildren().add(label);
		root.getChildren().add(botonJugador);

		root.getChildren().add(botonComputadora);
		root.getChildren().add(botonCargarPartidaContraJugador);

		label.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 60.0));
		label.setTextFill(Color.WHITE);
		label.setTranslateY(-200);
		botonJugador.setTranslateY(-100);
		botonComputadora.setTranslateY(-50);
		botonCargarPartidaContraJugador.setTranslateY(0);
		Scene scene = new Scene(root);
		escenario.setTitle("Menu principal");
		escenario.setResizable(true);
		escenario.setScene(scene);
		escenario.show();		


    }

	public void empezarPartidaContraJugador(EventHandler<MouseEvent> eventHandler) {
		botonJugador.setOnMouseClicked(eventHandler);
	}
	
	public void empezarPartidaContraIA(EventHandler<MouseEvent> eventHandler) {
		botonComputadora.setOnMouseClicked(eventHandler);
	}


	
	public void apretarIngresarNombres(EventHandler<MouseEvent> eventHandler) {
		botonIngresarNombres.setOnMouseClicked(eventHandler);
	}
	
	public void apretarCargarPartida(EventHandler<MouseEvent> eventHandler) {
		botonCargarPartidaContraJugador.setOnMouseClicked(eventHandler);
	}

	
	//Esta función inicializa la escena
	public void inicializarCanvas() {
		
		Canvas canvasMenuCostado = new Canvas(400, 800);	
    	GraphicsContext contextoCanvasMenuCostado = canvasMenuCostado.getGraphicsContext2D();
		
    	this.canvasMenuCostado = canvasMenuCostado;
    	this.contextoCanvasMenuCostado = contextoCanvasMenuCostado;
    	
    	canvasMenuCostado.setTranslateX(TAM_CANVAS_TABLERO);
    	
    	dibujarMenuCostado(canvasMenuCostado, contextoCanvasMenuCostado);
    	
    		
		//CANVAS TABLERO
		Canvas canvasTablero = new Canvas(TAM_CANVAS_TABLERO, TAM_CANVAS_TABLERO);	
    	GraphicsContext contextoCanvasTablero = canvasTablero.getGraphicsContext2D();
    	
    	this.canvasTablero = canvasTablero;
    	this.contextoCanvasTablero = contextoCanvasTablero;
    	
    	canvasTablero.setTranslateY(ALTO_ESCENA - TAM_CANVAS_TABLERO);
    	
    	
    	//CANVAS AVISOS
    	Canvas canvasAvisos = new Canvas(ANCHO_CANVAS_AVISOS , ALTO_CANVAS_AVISOS);	
    	GraphicsContext contextoCanvasAvisos = canvasAvisos.getGraphicsContext2D();
    	
    	this.canvasAvisos = canvasAvisos;
    	this.contextoCanvasAvisos  = contextoCanvasAvisos ;
    	this.aviso = null;
    	
    	canvasAvisos.setTranslateX(UBICACION_X_AVISOS);
    	canvasAvisos.setTranslateY(UBICACION_Y_AVISOS);
    	Group group = new Group(); 
    	group.getChildren().add(canvasMenuCostado);
    	group.getChildren().add(canvasTablero);
    	group.getChildren().add(canvasAvisos);
    	
    	this.group = group;
    	this.scene = new Scene(group, ANCHO_ESCENA, ALTO_ESCENA);
	}


	
	
	//Esta función se encarga de ir actualizando la pantalla a medida que se van generando cambios
    public void render() {
    	contextoCanvasTablero.clearRect(0, 0, canvasTablero.getWidth(), canvasTablero.getHeight());
    	contextoCanvasAvisos.clearRect(0, 0, canvasAvisos.getWidth(), canvasAvisos.getHeight());
    	
    	dibujarTablero(partida.obtenerTablero(), contextoCanvasTablero);
    	dibujarAviso(aviso, contextoCanvasAvisos);
    	
        stage.setScene(scene);
        stage.show();
        
    }
	
	public void agregarEventoDeMouse(EventHandler<MouseEvent> eventHandler) {
		canvasTablero.setOnMouseClicked(eventHandler);
	}
	
	public void agregarEventoMenuCostado(EventHandler<MouseEvent> eventHandler) {
		canvasMenuCostado.setOnMouseClicked(eventHandler);
	}

	public void generarRetraso() throws InterruptedException {
		TimeUnit.SECONDS.sleep(5);
				
	}
	
	
	public boolean chequeaJugador1() {
		return true;
	}



}

