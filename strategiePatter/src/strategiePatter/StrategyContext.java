package strategiePatter;

import java.util.ArrayList;

public class StrategyContext {
	private IStrategy strategy;
	public void setStrategy(IStrategy strategy){
		this.strategy=strategy;
	}
	public void executeStrategy(ArrayList<String> files){
		this.strategy.compress(files);
	}
}
