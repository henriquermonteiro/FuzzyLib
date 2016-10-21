/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuzzy.operation.impl;

import fuzzy.operation.BinaryOperation;

/**
 *
 * @author henrique
 */
public class Minimum implements BinaryOperation{

    @Override
    public Double operateOverValue(Double evaluateForInput, Double evaluateForInput0) {
        return Math.min(evaluateForInput, evaluateForInput0);
    }
    
}
