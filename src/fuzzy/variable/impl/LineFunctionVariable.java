/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuzzy.variable.impl;

import fuzzy.variable.LinguisticVariable;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import no.geosoft.cc.geometry.Geometry;

/**
 *
 * @author henrique
 */
public class LineFunctionVariable extends LinguisticVariable {

    private ArrayList<Point2D> points;

    public LineFunctionVariable(String variableName, String domainName) {
        super(variableName, domainName);
        points = new ArrayList<>();
    }

    public LineFunctionVariable addPoint(Double X, Double Y) {
        points.add(new Point2D.Double(X, Y));
        return this;
    }

    public ArrayList<Point2D> getPoints() {
        return points;
    }

    public Point2D getPoint(int k) {
        return points.get(k);
    }

    @Override
    public Double evaluateForInput(Double input) {
        Point2D p = null;

        for (Point2D n : points) {
            if (n.getX() >= input) {
                if (p == null) {
                    return n.getY();
                }

                double d =  (n.getY() - p.getY());
                d /= (n.getX() - p.getX());
                d *= (input-p.getX());
                d += p.getY();
                
                double[] intersects = new double[2];
                int r = Geometry.findLineSegmentIntersection(p.getX(), p.getY(), n.getX(), n.getY(), input, 0.0, input, 1.0, intersects);
                
                if(r == 1){
                    return intersects[1];
                }
                
                return d;
            }

            p = n;
        }

        return null;
    }

}
