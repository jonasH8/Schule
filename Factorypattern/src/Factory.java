
public class Factory {
	
	public IPizza getPizza(String PizzaSorte){
		if(PizzaSorte== null)
		{
			return null;
		}
		else if(PizzaSorte.equalsIgnoreCase("PizzaDiavolo")){
			return new PizzaDiavolo();
		}
		else if(PizzaSorte.equalsIgnoreCase("PizzaMargarithta")){
			return new PizzaMagarithta();
		}
		return null;
	}

}
