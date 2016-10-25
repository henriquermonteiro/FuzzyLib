/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuzzy.operation.impl;

/**
 * Implementação da Norma-T6
 * @author henrique
 */
public class T6 extends MaxMinOperation{
    private Double pt;
    
    public T6(Double pt) {
        this.pt = pt;
    }

    /**
     * Retorna o nome da operação.
     * @return Nome da operação.
     */
    @Override
    protected String operationName() {
        return "Norma-T6";
    }

    /**
     * Realiza a operação sobre dois valores crisp.
     * @param evaluateForInput
     * @param evaluateForInput0
     * @return 
     */
    @Override
    public Double operateOverValue(Double evaluateForInput, Double evaluateForInput0) {
        double ret = -1.0;
        ret += 1/Math.pow(evaluateForInput,pt);
        ret += 1/Math.pow(evaluateForInput0,pt);
        ret = Math.pow(ret, 1/pt);
        
        ret = 1/ret;
        
        return ret;
    }
    
}