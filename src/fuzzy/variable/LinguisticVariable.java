/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuzzy.variable;

/**
 *
 * @author henrique
 */
public abstract class LinguisticVariable {
    protected String variableName;

    public LinguisticVariable(String variableName) {
        this.variableName = variableName;
    }

    public String getVariableName() {
        return variableName;
    }
    
    public abstract Double evaluateForInput(Double input);
}
