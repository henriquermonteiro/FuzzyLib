package fuzzy.rule;

import fuzzy.implication.Expression;
import fuzzy.variable.LinguisticVariable;

public class Rule {
	protected LinguisticVariable result;
	protected Expression input;
	
	public Rule(LinguisticVariable result, Expression input) {
		super();
		this.result = result;
		this.input = input;
	}
	
	public LinguisticVariable getResult() {
		return result;
	}
	
	public Expression getInput() {
		return input;
	}
	
	
}
