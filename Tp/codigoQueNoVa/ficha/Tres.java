package ficha;

public class Tres implements Ficha{
	private Color color;
	private boolean capMatarBombas;
	
	public Tres(Color color) {
		this.color = color;
	}
	
	public Ficha enfrentar(Ficha ficha) {
		if (ficha instanceof Bomba) {
			ficha.fueraDeJuego()
		}
	}
	
}
