package fuzzy.implication.impl;

import fuzzy.implication.Expression;
import fuzzy.variable.LinguisticVariable;

public class SimpleExpression implements Expression {

    private LinguisticVariable var;

    public SimpleExpression(LinguisticVariable var) {
        this.var = var;
    }

    @Override
    public Double evaluateExpression(String[] inputNames, Double[] inputValues) {
        for (int k = 0; k < inputNames.length; k++) {
            if (inputNames[k].equals(var.getDomainName())) {
                return var.evaluateForInput(inputValues[k]);
            }
        }

        return null;
    }

}
