/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuzzy.operation.impl;

import fuzzy.operation.UnaryOperation;

/**
 *
 * @author henrique
 */
public class SimpleNegation implements UnaryOperation{

    @Override
    public Double operateOverValue(Double evaluateForInput) {
        return 1 - evaluateForInput;
    }
    
}
