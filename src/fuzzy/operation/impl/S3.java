/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuzzy.operation.impl;

/**
 * Implementação da Co-Norma-S3
 * @author henrique
 */
public class S3 extends MaxMinOperation{
    private Double pt;
    
    public S3(Double pt) {
        if(pt <= 0.0){
            throw new RuntimeException("Valor de pt inválido para co-norma-s3");
        }
        
        this.pt = pt;
    }

    /**
     * Retorna o nome da operação.
     * @return Nome da operação.
     */
    @Override
    protected String operationName() {
        return "Co-Norma-S3";
    }

    /**
     * Realiza a operação sobre dois valores crisp.
     * @param evaluateForInput
     * @param evaluateForInput0
     * @return 
     */
    @Override
    public Double operateOverValue(Double evaluateForInput, Double evaluateForInput0) {
        double ret = Math.pow(evaluateForInput,pt) + Math.pow(evaluateForInput0,pt);
        ret = Math.pow(ret, 1/pt);
        
        return Math.min(1, ret);
    }
    
}