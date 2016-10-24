/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuzzy.operation.impl;

import fuzzy.operation.BinaryOperation;
import fuzzy.util.LineUtils;
import fuzzy.variable.LinguisticVariable;
import fuzzy.variable.impl.LineFunctionVariable;

/**
 *
 * @author henrique
 */
public class Maximum implements BinaryOperation {

    @Override
    public Double operateOverValue(Double evaluateForInput, Double evaluateForInput0) {
        return Math.max(evaluateForInput, evaluateForInput0);
    }

    @Override
    public LinguisticVariable operateOverVarible(LinguisticVariable varA, LinguisticVariable varB) {
        if (varA.getDomainName().equals(varB.getDomainName())) {
            if (varA instanceof LineFunctionVariable) {
                LineFunctionVariable lineF = new LineFunctionVariable("Max", varA.getDomainName());

                int iA = 1, iB = 1;

                LineFunctionVariable a = (LineFunctionVariable) varA;
                LineFunctionVariable b = (LineFunctionVariable) varB;

                if (a.getPoint(0).getX() != b.getPoint(0).getX()) {
                    throw new RuntimeException("Erro nas variáveis linguísticas.");
                }

                double iX = a.getPoint(0).getX();

                double iAY = a.getPoint(0).getY();
                double iBY = b.getPoint(0).getY();

                lineF.addPoint(iX, Math.max(iAY, iBY));

                double[] intersection;

                while (true) {
                    intersection = LineUtils.getIntersectionPoint(iX, iAY, a.getPoint(iA).getX(), a.getPoint(iA).getY(), iX, iBY, b.getPoint(iB).getX(), b.getPoint(iB).getY());

                    boolean intersects = intersection[0] == 1.0;
                    if (intersects) {
                        if (intersection[1] != iX) {
                            lineF.addPoint(intersection[1], intersection[2]);

                            iX = intersection[1];

                            iAY = LineUtils.getIntersectionPoint(a.getPoint(iA - 1).getX(), a.getPoint(iA - 1).getY(), a.getPoint(iA).getX(), a.getPoint(iA).getY(), iX, 0.0, iX, 0.0)[2];

                            iBY = LineUtils.getIntersectionPoint(b.getPoint(iB - 1).getX(), b.getPoint(iB - 1).getY(), b.getPoint(iB).getX(), b.getPoint(iB).getY(), iX, 0.0, iX, 1.0)[2];
                        }else{
                            intersects = false;
                        }
                    } 
                    
                    if(!intersects) {
                        iX = Math.min(a.getPoint(iA).getX(), b.getPoint(iB).getX());

                        iAY = LineUtils.getIntersectionPoint(a.getPoint(iA - 1).getX(), a.getPoint(iA - 1).getY(), a.getPoint(iA).getX(), a.getPoint(iA).getY(), iX, 0.0, iX, 0.0)[2];

                        iBY = LineUtils.getIntersectionPoint(b.getPoint(iB - 1).getX(), b.getPoint(iB - 1).getY(), b.getPoint(iB).getX(), b.getPoint(iB).getY(), iX, 0.0, iX, 1.0)[2];

                        lineF.addPoint(iX, Math.max(iAY, iBY));
                    }

                    if (a.getPoint(iA).getX() <= iX) {
                        iA++;
                    }

                    if (b.getPoint(iB).getX() <= iX) {
                        iB++;
                    }

                    if (iA >= a.getPoints().size() || iB >= b.getPoints().size()) {
                        break;
                    }
                }

                return lineF;
            }
        }

        return null;
    }

}
