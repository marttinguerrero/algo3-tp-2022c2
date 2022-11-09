package ficha;

public class Cinco implements Ficha{
	private Color color;
	
	public Cinco(Color color) {
		this.color = color;
	}
	
	public Cinco enfrentar(Bandera bandera) {
		return this;
	}
	
	public Bomba enfrentar(Bomba bomba) {
		return bomba;
	}
	
	public Cinco enfrentar(Dos dos) {
		return this;
	}
	
	public Cinco enfrentar(Tres tres) {
		return this;
	}
	
	public Cinco enfrentar(Cuatro cuatro) {
		return this;
	}
	
	public Cinco enfrentar(Cinco cinco) {
		return null;
	}
	
	public Seis enfrentar(Seis seis) {
		return seis;
	}
	
	public Siete enfrentar(Siete siete) {
		return siete;
	}
	
	public Ocho enfrentar(Ocho ocho) {
		return ocho;
	}
	
	public Nueve enfrentar(Nueve nueve) {
		return nueve;
	}
	
	public Diez enfrentar(Diez diez) {
		return diez;
	}
}
