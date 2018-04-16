package strategiePatter;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// erzeugen des Context
		StrategyContext ctx =new StrategyContext();
		// setzen der Strategie
		
		ctx.setStrategy(new StrategyRar());
		//Daten erzeugen
		ArrayList<String>arrayList= new ArrayList<>();
		arrayList.add("file.txt");
		//ausführen der Strategie
		ctx.executeStrategy(arrayList);

	}

}
