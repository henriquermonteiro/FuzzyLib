/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuzzy.operation.impl;

import fuzzy.operation.BinaryOperation;
import fuzzy.variable.LinguisticVariable;
import fuzzy.variable.impl.LineFunctionVariable;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import no.geosoft.cc.geometry.Geometry;

/**
 *
 * @author henrique
 */
public class Minimum implements BinaryOperation {

    @Override
    public Double operateOverValue(Double evaluateForInput, Double evaluateForInput0) {
        return Math.min(evaluateForInput, evaluateForInput0);
    }

    @Override
    public LinguisticVariable operateOverVarible(LinguisticVariable varA, LinguisticVariable varB) {
        if (varA.getDomainName().equals(varB.getDomainName())) {
            if (varA instanceof LineFunctionVariable) {
                LineFunctionVariable lineF = new LineFunctionVariable("Min", varA.getDomainName());

                int iA = 1, iB = 1;

                LineFunctionVariable a = (LineFunctionVariable) varA;
                LineFunctionVariable b = (LineFunctionVariable) varB;

                lineF.addPoint(a.getPoint(0).getX(), Math.min(a.getPoint(0).getY(), b.getPoint(0).getY()));

                double x = a.getPoint(0).getX();
                double[] intersection = new double[2];

                double x11, x12, x21, x22, y11, y12, y21, y22;

                x11 = a.getPoint(0).getX();
                x21 = b.getPoint(0).getX();

                y11 = a.getPoint(0).getY();
                y21 = b.getPoint(0).getY();

                boolean flag = false;

                while (!flag) {
                    x12 = a.getPoint(iA).getX();
                    x22 = b.getPoint(iB).getX();

                    y12 = a.getPoint(iA).getY();
                    y22 = b.getPoint(iB).getY();

                    int r = Geometry.findLineSegmentIntersection(
                            x11, y11, x12, y12,
                            x21, y21, x22, y22,
                            intersection);

                    double aX = Math.min(x12, x22);

                    if (r == 1) {
                        if (intersection[0] - x11 > 0.0005) {
                            x11 = intersection[0];
                            y11 = intersection[1];
                            lineF.addPoint(x11, y11);
                        } else {
                            Geometry.findLineSegmentIntersection(x11, y11, x12, y12, aX, 0.0, aX, 1.0, intersection);

                            x11 = aX;
                            y11 = intersection[1];

                            Geometry.findLineSegmentIntersection(x21, y21, x22, y22, aX, 0.0, aX, 1.0, intersection);

                            x21 = aX;
                            y21 = intersection[1];

                            lineF.addPoint(aX, Math.min(y11, y21));
                        }
                    }

                    if (r < 1) {
                        double aY = Math.min(y12, y22);

                        lineF.addPoint(aX, aY);

                        Geometry.findLineSegmentIntersection(x11, y11, x12, y12, aX, 0.0, aX, 1.0, intersection);

                        x11 = aX;
                        y11 = intersection[1];

                        Geometry.findLineSegmentIntersection(x21, y21, x22, y22, aX, 0.0, aX, 1.0, intersection);

                        x21 = aX;
                        y21 = intersection[1];
                    }

                    boolean flag2 = true;
                    while (flag2) {
                        if (a.getPoints().size() > iA) {
                            if (a.getPoint(iA).getX() <= x11) {
                                iA++;
                            } else {
                                flag2 = false;
                            }
                        } else {
                            flag2 = false;
                        }
                    }

                    flag2 = true;
                    while (flag2) {
                        if (b.getPoints().size() > iB) {
                            if (b.getPoint(iB).getX() <= x11) {
                                iB++;
                            } else {
                                flag2 = false;
                            }
                        } else {
                            flag2 = false;
                        }
                    }

                    if (iA >= a.getPoints().size() || iB >= b.getPoints().size()) {
                        flag = true;
                    }
                }

                ArrayList<Point2D> remove = new ArrayList<>();
                Point2D p1 = null, p2 = null;
                for (Point2D point : lineF.getPoints()) {
                    if (p1 == null) {
                        p1 = point;
                    } else {
                        if (Math.abs(point.getY() - p1.getY()) <= 0.0005 && Math.abs(point.getX() - p1.getX()) <= 0.0005) {
                            remove.add(p1);
                        }
                        p1 = point;
                    }
                }

                lineF.getPoints().removeAll(remove);
                remove.clear();
                
                p1 = null;
                for (Point2D point : lineF.getPoints()) {
                    if (p1 == null || p2 == null) {
                        p2 = p1;
                        p1 = point;
                    } else if (Math.abs(point.getY() - p1.getY()) <= 0.0005 && Math.abs(p1.getY() - p2.getY()) <= 0.0005) {
                        remove.add(p1);
                        p1 = point;
                    } else {
                        p2 = p1;
                        p1 = point;
                    }
                }

                lineF.getPoints().removeAll(remove);
                
                for(Point2D p : lineF.getPoints()){
                    p.setLocation(Math.round(p.getX()*1000)/1000.0, Math.round(p.getY()*1000)/1000.0);
                }
                
                return lineF;
            }
        }

        return null;
    }

    public static void main(String... args) {
        LinguisticVariable v1 = new LineFunctionVariable("Teste1", "TesteDomain").addPoint(0.0, 0.0).addPoint(25.0, 0.0).addPoint(40.0, 0.8).addPoint(60.0, 0.8).addPoint(75.0, 0.0).addPoint(100.0, 0.0);
        LinguisticVariable v2 = new LineFunctionVariable("Teste2", "TesteDomain").addPoint(0.0, 0.0).addPoint(25.0, 0.0).addPoint(50.0, 1.0).addPoint(75.0, 0.0).addPoint(100.0, 0.0);

        Minimum min = new Minimum();
        LinguisticVariable l = min.operateOverVarible(v1, v2);

        System.out.println("");
    }
}
