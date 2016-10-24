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
    protected String domainName;

    public LinguisticVariable(String variableName, String domainName) {
        this.variableName = variableName;
        this.domainName = domainName;
    }

    public String getVariableName() {
        return variableName;
    }

    public String getDomainName() {
        return domainName;
    }
    
    public abstract Double evaluateForInput(Double input);
}
