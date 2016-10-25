/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuzzy.operation.impl;

/**
 * Implementação da Co-Norma-S1
 * @author henrique
 */
public class S1 extends MaxMinOperation{
    private Double pt;
    
    public S1(Double pt) {
        if(pt <= 0.0){
            throw new RuntimeException("Valor de pt inválido para co-norma-s1");
        }
        
        this.pt = pt;
    }

    /**
     * Retorna o nome da operação.
     * @return Nome da operação.
     */
    @Override
    protected String operationName() {
        return "Co-Norma-S1";
    }

    /**
     * Realiza a operação sobre dois valores crisp.
     * @param evaluateForInput
     * @param evaluateForInput0
     * @return 
     */
    @Override
    public Double operateOverValue(Double evaluateForInput, Double evaluateForInput0) {
        double ret = Math.pow(evaluateForInput/(1-evaluateForInput),pt) + Math.pow(evaluateForInput0/(1-evaluateForInput0),pt);
        ret = 1/(1+Math.pow(ret, 1/pt));
        
        return ret;
    }
    
}