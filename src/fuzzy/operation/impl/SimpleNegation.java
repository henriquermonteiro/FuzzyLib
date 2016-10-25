/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuzzy.operation.impl;

import fuzzy.operation.UnaryOperation;
import fuzzy.variable.LinguisticVariable;

/**
 * Classe que implementa a operação de negação/complemento simples.
 * @author henrique
 */
public class SimpleNegation implements UnaryOperation{

    /**
     * Faz o complemento 1 de um valor crisp.
     * @param evaluateForInput Valor de entrada.
     * @return Complemento 1.
     */
    @Override
    public Double operateOverValue(Double evaluateForInput) {
        return 1 - evaluateForInput;
    }

    /**
     * nÂO IMPLEMENTADO.
     * @param var
     * @return 
     */
    @Override
    public LinguisticVariable operateOverVarible(LinguisticVariable var) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
