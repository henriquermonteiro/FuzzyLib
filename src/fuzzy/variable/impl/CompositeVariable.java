/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuzzy.variable.impl;

import fuzzy.operation.BinaryOperation;
import fuzzy.operation.Operation;
import fuzzy.operation.UnaryOperation;
import fuzzy.variable.LinguisticVariable;

/**
 *
 * @author henrique
 */
public class CompositeVariable extends LinguisticVariable{
    private LinguisticVariable var1;
    private LinguisticVariable var2;
    private Operation operation;

    
    public CompositeVariable(LinguisticVariable var1, Operation operation, String variableName, String domainName) {
        super(variableName, domainName);
        this.var1 = var1;
        this.var2 = null;
        this.operation = operation;
    }
    
    public CompositeVariable(LinguisticVariable var1, LinguisticVariable var2, Operation operation, String variableName, String domainName) {
        super(variableName, domainName);
        this.var1 = var1;
        this.var2 = var2;
        this.operation = operation;
    }

    @Override
    public Double evaluateForInput(Double input) {
        if(operation instanceof UnaryOperation){
            return ((UnaryOperation)operation).operateOverValue(var1.evaluateForInput(input));
        }
        
        if(operation instanceof BinaryOperation){
            return ((BinaryOperation)operation).operateOverValue(var1.evaluateForInput(input), var2.evaluateForInput(input));
        }
        
        return null;
    }
    
}
