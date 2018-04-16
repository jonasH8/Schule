
public class SchinkenDecorator extends Decorator{

	
	public SchinkenDecorator(Pizza pizza){
		this.pizza=pizza;
	}
	@Override
	public String getBeschreibung() {
		// TODO Auto-generated method stub
		return this.pizza.getBeschreibung()+" mit Schinken";
	}

	@Override
	public float preis() {
		// TODO Auto-generated method stub
		return this.pizza.preis()+0.90f;
	}

}
