
public class User {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Factory neueF=new Factory();
		IPizza ersteP= neueF.getPizza("PizzaDiavolo");
		ersteP.zubereitung();
		IPizza zweiteP= neueF.getPizza("PizzaMargarithta");
		zweiteP.zubereitung();

	}

}
