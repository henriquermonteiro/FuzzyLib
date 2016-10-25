/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuzzy.operation.impl;

/**
 * Implementação da Co-Norma-S6
 * @author henrique
 */
public class S6 extends MaxMinOperation{
    private Double pt;
    
    public S6(Double pt) {
        if(pt <= 0.0){
            throw new RuntimeException("Valor de pt inválido para co-norma-s6");
        }
        
        this.pt = pt;
    }

    /**
     * Retorna o nome da operação.
     * @return Nome da operação.
     */
    @Override
    protected String operationName() {
        return "Co-Norma-S6";
    }

    /**
     * Realiza a operação sobre dois valores crisp.
     * @param evaluateForInput
     * @param evaluateForInput0
     * @return 
     */
    @Override
    public Double operateOverValue(Double evaluateForInput, Double evaluateForInput0) {
        double ret = (1/Math.pow(1-evaluateForInput, pt)) + (1/Math.pow(1-evaluateForInput0, pt)) - 1;
        ret = Math.pow(ret, 1/pt);
        ret = 1 - (1/ret);
        
        return ret;
    }
    
}