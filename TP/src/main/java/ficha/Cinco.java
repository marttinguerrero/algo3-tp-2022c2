package ficha;

public class Cinco {
	
	public Cinco(ficha.Color color) {
		super(color);
	}
	
	public Cinco enfrentar(Bandera bandera) {
		return this;
	}
	
	public Bomba enfrentar(Bomba bomba) {
		return bomba;
	}
	
	public Bomba enfrentar(Dos dos) {
		return this;
	}
	
	public Tres enfrentar(Tres tres) {
		return tres;
	}
	
	public Bomba enfrentar(Cuatro cuatro) {
		return this;
	}
	
	public Bomba enfrentar(Cinco cinco) {
		return this;
	}
	
	public Bomba enfrentar(Sies seis) {
		return this;
	}
	
	public Bomba enfrentar(Siete siete) {
		return this;
	}
	
	public Bomba enfrentar(Ocho ocho) {
		return this;
	}
	
	public Bomba enfrentar(Nueve nueve) {
		return this;
	}
	
	public Bomba enfrentar(Diez diez) {
		return this;
	}
}
