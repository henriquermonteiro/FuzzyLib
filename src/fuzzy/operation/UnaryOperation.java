/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuzzy.operation;

import fuzzy.variable.LinguisticVariable;

/**
 * Interface que define uma operação unária.
 * @author henrique
 */
public interface UnaryOperation extends Operation{

    /**
     * Avalia uma operação unária sobre um valor crisp.
     * @param evaluateForInput Valor onde a operação será realizada.
     * @return Resultante.
     */
    public Double operateOverValue(Double evaluateForInput);
    
    /**
     * Avalia uma operação unária sobre um variável fuzzy.
     * @param var variável onde a operação será realizada.
     * @return Resultante da operação.
     */
    public LinguisticVariable operateOverVarible(LinguisticVariable var);
}
