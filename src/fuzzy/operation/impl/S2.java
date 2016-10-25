/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuzzy.operation.impl;

/**
 * Implementação da Co-Norma-S2
 * @author henrique
 */
public class S2 extends MaxMinOperation{
    private Double pt;
    
    public S2(Double pt) {
        if(pt < 0.0){
            throw new RuntimeException("Valor de pt inválido para co-norma-s2");
        }
        
        this.pt = pt;
    }

    /**
     * Retorna o nome da operação.
     * @return Nome da operação.
     */
    @Override
    protected String operationName() {
        return "Co-Norma-S2";
    }

    /**
     * Realiza a operação sobre dois valores crisp.
     * @param evaluateForInput
     * @param evaluateForInput0
     * @return 
     */
    @Override
    public Double operateOverValue(Double evaluateForInput, Double evaluateForInput0) {
        double ret = Math.min(1, evaluateForInput + evaluateForInput0 - (pt*evaluateForInput*evaluateForInput0));
        
        return ret;
    }
    
}