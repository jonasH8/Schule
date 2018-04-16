
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pizza neuePizza= new SchinkenDecorator(new DiavoloPizza());
		
		System.out.println(neuePizza.getBeschreibung());
		System.out.println("EUR:"+ neuePizza.preis());
		
		Pizza zweitePizza=new SalamiDecorator(new SchinkenPizza());
		System.out.println(zweitePizza.getBeschreibung());
		System.out.println("EUR:"+ zweitePizza.preis());
		
	}

}
