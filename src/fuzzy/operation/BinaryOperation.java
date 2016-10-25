/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuzzy.operation;

import fuzzy.variable.LinguisticVariable;

/**
 * Interface que deifine uma operação binária.
 * @author henrique
 */
public interface BinaryOperation extends Operation{

    /**
     * Realiza uma operação sobre dois valores crisp.
     * @param evaluateForInput valor 1.
     * @param evaluateForInput0 valor 2.
     * @return resultante.
     */
    public Double operateOverValue(Double evaluateForInput, Double evaluateForInput0);
    
    /**
     * Realiza uma operação sobre duas variáveis fuzzy.
     * @param varA variável 1.
     * @param varB variável 2.
     * @return resultante.
     */
    public LinguisticVariable operateOverVarible(LinguisticVariable varA, LinguisticVariable varB);
    
}
