/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuzzy.variable.impl;

import fuzzy.variable.LinguisticVariable;
import java.awt.geom.Point2D;
import java.util.ArrayList;

/**
 *
 * @author henrique
 */
public class LineFunctionVariable extends LinguisticVariable {

    private ArrayList<Point2D> points;

    public LineFunctionVariable(String variableName) {
        super(variableName);
        points = new ArrayList<>();
    }
    
    public LineFunctionVariable addPoint(Double X, Double Y){
        points.add(new Point2D.Double(X, Y));
        return this;
    }

    @Override
    public Double evaluateForInput(Double input) {
        Point2D p = null;

        for (Point2D n : points) {
            if (n.getX() > input) {
                if (p == null) {
                    return null;
                }
                
                return p.getY() + (input * ((n.getY() - p.getY())/(n.getX() - p.getX())));
            }
            
            p = n;
        }
        
        return null;
    }

}
