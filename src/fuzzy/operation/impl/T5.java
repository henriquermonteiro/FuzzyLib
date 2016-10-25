/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuzzy.operation.impl;

/**
 * Implementação da Norma-T5
 * @author henrique
 */
public class T5 extends MaxMinOperation{
    private Double pt;
    
    public T5(Double pt) {
        if(pt < 0.0){
            throw new RuntimeException("Valor de pt inválido para norma-t5");
        }
        
        this.pt = pt;
    }

    /**
     * Retorna o nome da operação.
     * @return Nome da operação.
     */
    @Override
    protected String operationName() {
        return "Norma-T5";
    }

    /**
     * Realiza a operação sobre dois valores crisp.
     * @param evaluateForInput
     * @param evaluateForInput0
     * @return 
     */
    @Override
    public Double operateOverValue(Double evaluateForInput, Double evaluateForInput0) {
        double ret = evaluateForInput * evaluateForInput0;
        ret /= pt + ((1-pt)*(evaluateForInput + evaluateForInput0 - ret));
        
        return ret;
    }
    
}