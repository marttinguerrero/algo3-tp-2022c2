package partida;

import jugador. *;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import interfaceUsuario. *; 
import capacidadEnfrentamiento. *;

import capacidadMovimiento. *;
import java.util.ArrayList;

import ficha. *; 
import tablero. *;

public class Partida {
	private Jugador jugador1;
	private Jugador jugador2;
	private Tablero tablero;
	private Jugador jugadorEnTurno;
	private InterfaceUsuario interfaceUsuario;
	
	public Partida(String nombreArchivo, InterfaceUsuario interfaceUsuario) {
		this.interfaceUsuario = interfaceUsuario;
		this.tablero = new Tablero();
		cargarPartida(nombreArchivo);
		this.jugadorEnTurno = jugador1;
	}
	
	public Partida(Jugador jugador1, Jugador jugador2, InterfaceUsuario interfaceUsuario) {
		this.interfaceUsuario = interfaceUsuario;
		this.jugador1 = jugador1;
		this.jugador2 = jugador2;
		ArrayList<Ficha> fichasRojas = inicializarFichas(Color.ROJA, jugador1);
		ArrayList<Ficha> fichasAzules = inicializarFichas(Color.AZUL, jugador2);
		this.tablero = new Tablero(fichasRojas, fichasAzules);
		this.jugadorEnTurno = jugador1;
	}
	
	//Ficha(Color color, int valor, CapacidadMovimiento capacidadMovimiento, CapacidadEnfrentamiento capacidadEnfrentamiento, Jugador jugador)
	
	private ArrayList<Ficha> inicializarFichas(Color color, Jugador jugador) {
		ArrayList<Ficha> fichas =  new ArrayList<Ficha>();
		//pasar todo esto utilizando la fabrica de fichas
		fichas.add(new Ficha(color, 0, new MovimientoDeUnaCasilla(), new CapacidadGanarMenores(), jugador));
		fichas.add(new Ficha(color, 1, new MovimientoDeUnaCasilla(), new CapacidadGanarMenoresYDiez(), jugador));
		for (int i = 0; i<8; i++) {
			fichas.add(new Ficha(color, 2, new MovimientoLineaRecta(), new CapacidadGanarMenores(), jugador));
		}
		for (int i = 0; i<5; i++) {
			fichas.add(new Ficha(color, 3, new MovimientoDeUnaCasilla(), new CapacidadGanarMenoresYBomba(), jugador));
		}
		for (int i = 0; i<4; i++) {
			fichas.add(new Ficha(color, 4, new MovimientoDeUnaCasilla(), new CapacidadGanarMenores(), jugador));
		}
		for (int i = 0; i<4; i++) {
			fichas.add(new Ficha(color, 5, new MovimientoDeUnaCasilla(), new CapacidadGanarMenores(), jugador));
		}
		for (int i = 0; i<4; i++) {
			fichas.add(new Ficha(color, 6, new MovimientoDeUnaCasilla(), new CapacidadGanarMenores(), jugador));
		}
		for (int i = 0; i<3; i++) {
			fichas.add(new Ficha(color, 7, new MovimientoDeUnaCasilla(), new CapacidadGanarMenores(), jugador));
		}
		fichas.add(new Ficha(color, 8, new MovimientoDeUnaCasilla(), new CapacidadGanarMenores(), jugador));
		fichas.add(new Ficha(color, 8, new MovimientoDeUnaCasilla(), new CapacidadGanarMenores(), jugador));
		fichas.add(new Ficha(color, 9, new MovimientoDeUnaCasilla(), new CapacidadGanarMenores(), jugador));
		fichas.add(new Ficha(color, 10, new MovimientoDeUnaCasilla(), new CapacidadGanarMenores(), jugador));
		for (int i = 0; i<6; i++) {
			fichas.add(new Ficha(color, 11, new IncapacidadMovimiento(), new CapacidadGanarMenores(), jugador));
		}
		return fichas;
		
	}

       
    public void guardarPartida(String nombreArchivo) {
    	String nombrePartida = nombreArchivo; // Nombre del archivo
        boolean existe = new File(nombrePartida).exists(); // Verifica si existe
        
        // Si existe un archivo llamado asi lo borra
        if(existe) {
        	//avisarle al jugador que se perdera la partida guardada anteriormente y elimino el archivo que se llamaba asi anteriormente
            File partida = new File(nombrePartida);
            partida.delete();
        }
        
        try {
            // Crea el archivo
        	//CSVWriter partida = new CsvWriter(new FileWriter(nombrePartida));
            CsvWriter partida = new CsvWriter(new FileWriter(nombrePartida), ';');
            for (int i = 0; i < 10; i++) {
            	for (int j = 0; j < 10; j++) {
            		
            		String nombreJugador1 = jugador1.obtenerNombre();
            		String tipoJugador1 = jugador1.obtenerTipo();
            		String colorJugador1 = jugador1.obtenerColor();
            		
            		String nombreJugador2 = jugador2.obtenerNombre();
            		String tipoJugador2 = jugador2.obtenerTipo();
            		String colorJugador2 = jugador2.obtenerColor();
            		
            		partida.write(valorFicha_str)
            		
            		String color_str;
            		String valor_str;
            		String tipoJugador;
            		
            		Ficha valorFicha = tablero.obtenerFicha(i, j);
            		if (valorFicha == null) {
            			valor_str = "-1";
            			
            		} else {
            			valor_str = Integer.toString(valorFicha.obtenerValor());
            			
            			Color col = valorFicha.obtenerColor();
            			if (col == Color.ROJA) {
            				color_str = "roja";
            			} else {
            				color_str = "azul";
            			}
            			
            			tipoJugador = jugador.obtenerTipoJugador();
            		}
            		
            		
            		
            		
            		
            		
            		 //capaz puedo pasarle el int directo, probar
            		partida.write(valorFicha_str);
            	}
            }
            
            partida.endRecord(); // Deja de escribir en el archivo
            
            partida.close(); // Cierra el archivo
            
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    
    public void cargarPartida(nombreArchivo) {
        try{
            //List<Usuario> usuarios = new ArrayList<Usuario>(); // Lista donde guardaremos los datos del archivo
            
            CsvReader tablero = new CsvReader(nombreArchivo);
            //leerUsuarios.readHeaders();
            
            // Mientras haya lineas obtenemos los datos del archivo
            while(tablero.readRecord()) {
                String nombre = leerUsuarios.get(0);
                String telefono = leerUsuarios.get(1);
                String email = leerUsuarios.get(2);
                
                usuarios.add(new Usuario(nombre, telefono, email)); // Añade la informacion a la lista
            }
            
            leerUsuarios.close(); // Cierra el archivo
            
            // Recorremos la lista y la mostramos en la pantalla
            for(Usuario user : usuarios) {
                System.out.println(user.getNombre() + " , "
                    + user.getTelefono() + " , "
                    +user.getEmail());
            }
            
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}

	public void cargarPartida(String nombreArchivo) {
        try{
            List<Usuario> usuarios = new ArrayList<Usuario>(); // Lista donde guardaremos los datos del archivo
            
            CsvReader leerUsuarios = new CsvReader(nombreArchivo);
            leerUsuarios.readHeaders();
            
            // Mientras haya lineas obtenemos los datos del archivo
            while(leerUsuarios.readRecord()) {
                String nombre = leerUsuarios.get(0);
                String telefono = leerUsuarios.get(1);
                String email = leerUsuarios.get(2);
                
                usuarios.add(new Usuario(nombre, telefono, email)); // Añade la informacion a la lista
            
	}
	
	
	
	
	public void comenzarPartida() {
		boolean seguirJugando = true;
		tablero.imprimir_tablero();
		while(!jugador1.perdio() && !jugador2.perdio() && seguirJugando) {
			int posXi = interfaceUsuario.perdirPosXi();
			int posYi = interfaceUsuario.perdirPosYi();
			int posXf = interfaceUsuario.perdirPosXf();
			int posYf = interfaceUsuario.perdirPosYf();
			while (!jugadorEnTurno.moverFicha(posXi, posYi, posXf, posYf, tablero)) {
				posXi = interfaceUsuario.perdirPosXi();
				posYi = interfaceUsuario.perdirPosYi();
				posXf = interfaceUsuario.perdirPosXf();
				posYf = interfaceUsuario.perdirPosYf();
			}
			tablero.imprimir_tablero();
			actualizarTurno();
			seguirJugando = interfaceUsuario.perdirSiQuiereSeguirJugando();
		}
	}
	
	//retorna true si se colocaron todas las fichas correctamente
	public boolean inicializarPartida() {
		return jugador1.armarEstrategia() && jugador2.armarEstrategia();
	}
	
	//seguro hay otra forma de hacer esto
	private void actualizarTurno() {
		if (jugadorEnTurno == jugador1) {
			jugadorEnTurno = jugador2;
		} else {
			jugadorEnTurno = jugador1;
		}
	}
	
	public boolean finDePartida() {
		return jugador1.perdio() || jugador2.perdio();
	}
}
