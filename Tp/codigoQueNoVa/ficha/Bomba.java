package ficha;

public class Bomba implements Ficha{
	private Color color;
	private Celda celda;
	
	public Bomba(Color color) {
		this.color = color;
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
	
	public Bomba enfrentar(Seis seis) {
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
