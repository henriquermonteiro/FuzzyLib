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
 * Classe que implementa a média dos máximos como método de defuzzificação.
 * @author henrique
 */
public class MeanOfMaximum implements DefuzzificationOperation{

    /**
     * Defuzzifica uma variável fuzzy pelo método da média dos máximos.
     * @param var
     * @return 
     */
    @Override
    public Double defuzzify(LinguisticVariable var) {
        if(var instanceof LineFunctionVariable){
            LineFunctionVariable v = (LineFunctionVariable)var;
            
            ArrayList<Double> maximuns = new ArrayList<>();
            Double maxV = 0.0;
            
            for(Point2D p : v.getPoints()){
                if(p.getY() == maxV){
                    maximuns.add(p.getX());
                    continue;
                }
                
                if(p.getY() > maxV){
                    maximuns.clear();
                    maximuns.add(p.getX());
                    maxV = p.getY();
                }
            }
            
            if(maxV == 0.0) return 0.0;
            
            Double xs = 0.0;
            for(Double d : maximuns) xs += d;
            
            return xs/maximuns.size();
        }
        
        return null;
    }
    
    /**
     * Teste de defuzzificação.
     * @param args NÃO USADO.
     */
    public static void main(String ... args){
        MeanOfMaximum mom = new MeanOfMaximum();
        
        LinguisticVariable v = new LineFunctionVariable("Teste", "TesteDomain").addPoint(0.0, 0.0).addPoint(25.0, 0.0).addPoint(45.0, 1.0).addPoint(55.0, 1.0).addPoint(75.0, 0.0).addPoint(100.0, 0.0);

        System.out.println(mom.defuzzify(v));
    }
}
