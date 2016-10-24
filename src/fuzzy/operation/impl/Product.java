/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuzzy.operation.impl;

import fuzzy.operation.BinaryOperation;
import fuzzy.variable.LinguisticVariable;

/**
 *
 * @author henrique
 */
public class Product implements BinaryOperation{

    @Override
    public Double operateOverValue(Double evaluateForInput, Double evaluateForInput0) {
        return evaluateForInput * evaluateForInput0;
    }

    @Override
    public LinguisticVariable operateOverVarible(LinguisticVariable varA, LinguisticVariable varB) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
