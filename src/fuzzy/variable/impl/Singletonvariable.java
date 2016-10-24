package fuzzy.variable.impl;

import fuzzy.variable.LinguisticVariable;
	
public class Singletonvariable extends LinguisticVariable {
	private Double valuePoint;


	public Singletonvariable(String variableName, String domainName, Double valuePoint) {
		super(variableName, domainName);
		this.valuePoint = valuePoint;
	}


	@Override
	public Double evaluateForInput(Double input) {
		if(input == valuePoint) return 1.0;
		
		return 0.0;
	}

}
