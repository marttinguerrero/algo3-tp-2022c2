package ficha;

public class Bandera implements Ficha{
	private Color color;
	
	public Bandera(Color color) {
		this.color = color;
	}

	public Ficha enfrentar(Ficha ficha) {
		return this;
	}
}
