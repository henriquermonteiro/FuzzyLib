package fuzzy.agregation.impl;

import fuzzy.agregation.RuleAgregation;
import fuzzy.operation.impl.Maximum;
import fuzzy.operation.impl.Maximum;
import fuzzy.rule.Rule;
import fuzzy.variable.LinguisticVariable;

public class Sum implements RuleAgregation {

    private Maximum max;

    public Sum() {
        max = new Maximum();
    }

    @Override
    public LinguisticVariable agregate(LinguisticVariable... vars) {
        if (vars.length > 0) {
            LinguisticVariable r = vars[0];
            
            for(int k = 1; k < vars.length; k++){
                r = max.operateOverVarible(r, vars[k]);
            }
            
            return r;
        }
        
        return null;
    }

    @Override
    public LinguisticVariable agregate(String[] inputName, Double[] inputValue, Rule... vars) {
//		if(vars.length == 2){
//			return max.operateOverVarible(vars[0].evaluateActivation(inputName, inputValue), vars[1].evaluateActivation(inputName, inputValue));
//		}

        return null;
    }

}
