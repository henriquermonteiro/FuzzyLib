/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuzzy.operation.impl;

/**
 * Implementação da Norma-T@
 * @author henrique
 */
public class T2 extends MaxMinOperation{
    private Double pt;
    
    public T2(Double pt) {
        if(pt < -1.0){
            throw new RuntimeException("Valor de pt inválido para norma-t2");
        }
        
        this.pt = pt;
    }

    /**
     * Retorna o nome da operação.
     * @return Nome da operação.
     */
    @Override
    protected String operationName() {
        return "Norma-T2";
    }

    /**
     * Realiza a operação sobre dois valores crisp.
     * @param evaluateForInput
     * @param evaluateForInput0
     * @return 
     */
    @Override
    public Double operateOverValue(Double evaluateForInput, Double evaluateForInput0) {
        double ret = pt * evaluateForInput * evaluateForInput0;
        ret = ((1+pt) * (evaluateForInput + evaluateForInput0 - 1)) - ret;
        ret = Math.max(ret, 0);
        
        return ret;
    }
    
}