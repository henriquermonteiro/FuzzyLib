/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuzzy.operation.impl;

import fuzzy.operation.UnaryOperation;
import fuzzy.variable.LinguisticVariable;
import fuzzy.variable.impl.LineFunctionVariable;
import java.awt.geom.Point2D;

/**
 * Classe que implementa a operação de negação/complemento simples.
 *
 * @author henrique
 */
public class SimpleNegation implements UnaryOperation {

    /**
     * Faz o complemento 1 de um valor crisp.
     *
     * @param evaluateForInput Valor de entrada.
     * @return Complemento 1.
     */
    @Override
    public Double operateOverValue(Double evaluateForInput) {
        return 1 - evaluateForInput;
    }

    /**
     * Faz o complemento 1 de uma variável fuzzy.
     *
     * @param var Variável.
     * @return Complemento 1 da variável.
     */
    @Override
    public LinguisticVariable operateOverVarible(LinguisticVariable var) {
        if (var instanceof LineFunctionVariable) {
            LineFunctionVariable lineF = new LineFunctionVariable("Not", var.getDomainName());

            LineFunctionVariable a = (LineFunctionVariable) var;

            for (Point2D p : a.getPoints()) {
                lineF.addPoint(p.getX(), 1 - p.getY());
            }

            return lineF;
        }

        return null;
    }

}
