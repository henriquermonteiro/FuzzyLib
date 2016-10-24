package fuzzy.defuzzification;

import fuzzy.variable.LinguisticVariable;

public interface DefuzzificationOperation {
	public Double defuzzify(LinguisticVariable var);
}
