/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuzzy.operation;

import fuzzy.variable.LinguisticVariable;

/**
 *
 * @author henrique
 */
public interface BinaryOperation extends Operation{

    public Double operateOverValue(Double evaluateForInput, Double evaluateForInput0);
    public LinguisticVariable operateOverVarible(LinguisticVariable varA, LinguisticVariable varB);
    
}
