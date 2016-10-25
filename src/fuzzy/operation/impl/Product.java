/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuzzy.operation.impl;

/**
 *
 * @author henrique
 */
public class Product extends MaxMinOperation{

    /**
     * Definição da operação sobre dois valores crisp.
     * @param evaluateForInput valor 1.
     * @param evaluateForInput0 valor 2.
     * @return resultante.
     */
    @Override
    public Double operateOverValue(Double evaluateForInput, Double evaluateForInput0) {
        return evaluateForInput * evaluateForInput0;
    }

    /**
     * Nome da operação.
     * @return 'Prod.'.
     */
    @Override
    protected String operationName() {
        return "Prod.";
    }
    
}
