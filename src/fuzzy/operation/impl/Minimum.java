/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuzzy.operation.impl;

/**
 * Classe que implementa o método Min para composição de variáveis linguísticas.
 * Funciona como um operador de conjunção sobre a lógica fuzzy.
 * @author henrique
 */
public class Minimum extends MaxMinOperation{

    /**
     * Nome da operação.
     * @return 'Min'
     */
    @Override
    protected String operationName() {
        return "Min";
    }

    /**
     * Definição da operação sobre valores crisp..
     * @param evaluateForInput valor 1.
     * @param evaluateForInput0 valor 2.
     * @return valor resultante.
     */
    @Override
    public Double operateOverValue(Double evaluateForInput, Double evaluateForInput0) {
        return Math.min(evaluateForInput, evaluateForInput0);
    }
    
}
