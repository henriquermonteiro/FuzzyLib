package fuzzy.implication;

import fuzzy.rule.Rule;
import fuzzy.variable.LinguisticVariable;

public abstract class RuleImplication {
	public abstract LinguisticVariable evaluate(Rule rule, String[] inputNames, Double[] inputValues);
	
	public LinguisticVariable[] evaluate(Rule[] rules, String[] inputNames, Double[] inputValues){
		LinguisticVariable[] results = new LinguisticVariable[rules.length];
		
		int k = 0;
		for(Rule r : rules){
			results[k] = evaluate(r, inputNames, inputValues);
			
			k++;
		}
		
		return results;
	}
}
