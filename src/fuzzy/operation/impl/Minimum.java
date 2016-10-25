/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuzzy.operation.impl;

/**
 *
 * @author henrique
 */
public class Minimum extends MaxMinOperation{

    @Override
    protected String operationName() {
        return "Min";
    }

    @Override
    public Double operateOverValue(Double evaluateForInput, Double evaluateForInput0) {
        return Math.min(evaluateForInput, evaluateForInput0);
    }
    
}
