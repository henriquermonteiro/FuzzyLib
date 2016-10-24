package fuzzy.agregation;

import fuzzy.rule.Rule;
import fuzzy.variable.LinguisticVariable;

public interface RuleAgregation {
	public LinguisticVariable agregate(LinguisticVariable ... vars);
	public LinguisticVariable agregate(String[] inputName, Double[] inputValue, Rule ... vars);
}
