/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuzzy.defuzzification.impl;

import fuzzy.defuzzification.DefuzzificationOperation;
import fuzzy.variable.LinguisticVariable;
import fuzzy.variable.impl.LineFunctionVariable;
import java.awt.geom.Point2D;
import java.util.ArrayList;

/**
 * Classe que implementa o método da defuzzificação por centróide.
 * @author henrique
 */
public class CentroidDefuzzification implements DefuzzificationOperation {

    /**
     * Realiza a defuzzificação por centróide.
     * @param var Variável a ser defuzzificada.
     * @return O valor de X do ponto de centróide.
     */
    @Override
    public Double defuzzify(LinguisticVariable var) {
        if (var instanceof LineFunctionVariable) {
            ArrayList<Double> x_ = new ArrayList<>();
            ArrayList<Double> y_ = new ArrayList<>();
            ArrayList<Double> area = new ArrayList<>();

            Double xArea = 0.0, totalArea = 0.0;

            Point2D auxP = null;
            for (Point2D p : ((LineFunctionVariable) var).getPoints()) {
                if (auxP != null) {
                    x_.add(((p.getX() - auxP.getX()) / 2) + auxP.getX());
                    area.add((p.getX() - auxP.getX()) * Math.min(p.getY(), auxP.getY()));

                    xArea += x_.get(x_.size() - 1) * area.get(area.size() - 1);
                    totalArea += area.get(area.size() - 1);

                    if (auxP.getY() != p.getY()) {
                        if (p.getY() > auxP.getY()) {
                            x_.add((((p.getX() - auxP.getX()) / 3) * 2) + auxP.getX());
                            area.add(((p.getX() - auxP.getX()) * (Math.max(p.getY(), auxP.getY()) - Math.min(p.getY(), auxP.getY()))) / 2);
                        } else {
                            x_.add(((p.getX() - auxP.getX()) / 3) + auxP.getX());
                            area.add(((p.getX() - auxP.getX()) * (Math.max(p.getY(), auxP.getY()) - Math.min(p.getY(), auxP.getY()))) / 2);
                        }

                        xArea += x_.get(x_.size() - 1) * area.get(area.size() - 1);
                        totalArea += area.get(area.size() - 1);
                    }
                }

                auxP = p;
            }

            return xArea / totalArea;
        }

        return null;
    }

    /**
     * Teste do valor de centróide.
     * @param args NÃO USADO.
     */
    public static void main(String... args) {
        CentroidDefuzzification def = new CentroidDefuzzification();

        LinguisticVariable v = new LineFunctionVariable("Teste", "TesteDomain").addPoint(0.0, 0.0).addPoint(25.0, 0.0).addPoint(45.0, 1.0).addPoint(55.0, 1.0).addPoint(75.0, 0.0).addPoint(100.0, 0.0);

        System.out.println(def.defuzzify(v));
    }
}
