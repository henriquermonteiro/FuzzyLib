/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuzzy.operation.impl;

/**
 * Implementação da Norma-T7
 * @author henrique
 */
public class T7 extends MaxMinOperation{
    private Double pt;
    
    public T7(Double pt) {
        if(pt <= 0.0){
            throw new RuntimeException("Valor de pt inválido para norma-t7");
        }
        
        this.pt = pt;
    }

    /**
     * Retorna o nome da operação.
     * @return Nome da operação.
     */
    @Override
    protected String operationName() {
        return "Norma-T7";
    }

    /**
     * Realiza a operação sobre dois valores crisp.
     * @param evaluateForInput
     * @param evaluateForInput0
     * @return 
     */
    @Override
    public Double operateOverValue(Double evaluateForInput, Double evaluateForInput0) {
        double ret = Math.max(0, Math.pow(evaluateForInput,pt) + Math.pow(evaluateForInput0,pt) - 1);
        ret = Math.pow(ret, 1/pt);
        
        return ret;
    }
    
}