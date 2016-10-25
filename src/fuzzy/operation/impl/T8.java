/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuzzy.operation.impl;

/**
 * Implementação da Norma-T8
 * @author henrique
 */
public class T8 extends MaxMinOperation{

    /**
     * Retorna o nome da operação.
     * @return Nome da operação.
     */
    @Override
    protected String operationName() {
        return "Norma-T8";
    }

    /**
     * Realiza a operação sobre dois valores crisp.
     * @param evaluateForInput
     * @param evaluateForInput0
     * @return 
     */
    @Override
    public Double operateOverValue(Double evaluateForInput, Double evaluateForInput0) {
        return (evaluateForInput == 1 ? evaluateForInput0 : (evaluateForInput0 == 1 ? evaluateForInput : 0.0));
    }
    
}
