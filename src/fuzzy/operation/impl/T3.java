/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuzzy.operation.impl;

/**
 * Implementação da Norma-T#
 * @author henrique
 */
public class T3 extends MaxMinOperation{
    private Double pt;
    
    public T3(Double pt) {
        if(pt <= 0.0){
            throw new RuntimeException("Valor de pt inválido para norma-t3");
        }
        
        this.pt = pt;
    }

    /**
     * Retorna o nome da operação.
     * @return Nome da operação.
     */
    @Override
    protected String operationName() {
        return "Norma-T3";
    }

    /**
     * Realiza a operação sobre dois valores crisp.
     * @param evaluateForInput
     * @param evaluateForInput0
     * @return 
     */
    @Override
    public Double operateOverValue(Double evaluateForInput, Double evaluateForInput0) {
        double ret = Math.pow(1-evaluateForInput, pt);
        ret += Math.pow(1-evaluateForInput0, pt);
        ret = Math.pow(ret, 1/pt);
        
        ret = 1 - Math.min(ret, 1);
        
        return ret;
    }
    
}