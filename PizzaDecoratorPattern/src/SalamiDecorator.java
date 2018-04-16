
public class SalamiDecorator extends Decorator{

	public SalamiDecorator(Pizza pizza){
		this.pizza=pizza;
	}
	@Override
	public String getBeschreibung() {
		// TODO Auto-generated method stub
		return this.pizza.getBeschreibung()+" mit Salami";
	}

	@Override
	public float preis() {
		// TODO Auto-generated method stub
		return this.pizza.preis()+0.70f;
	}
	
}
