/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuzzy.operation;

/**
 *
 * @author henrique
 */
public interface UnaryOperation extends Operation{

    public Double operateOverValue(Double evaluateForInput);
    
}