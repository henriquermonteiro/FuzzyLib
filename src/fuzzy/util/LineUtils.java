/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuzzy.util;

import java.awt.geom.Point2D;

/**
 *
 * @author henrique
 */
public class LineUtils {

    public static Point2D getIntersectionPoint(Point2D line1OriginPoint, Point2D line1DestinyPoint, Point2D line2OriginPoint, Point2D line2DestinyPoint) {
        if (line1OriginPoint.getX() == line1DestinyPoint.getX()) {
            if (line2OriginPoint.getX() == line2DestinyPoint.getX()) {
                return null;
            } else {
                double m = (line2DestinyPoint.getY() - line2OriginPoint.getY()) / (line2DestinyPoint.getX() - line2OriginPoint.getX());

                double c = line2OriginPoint.getX() * m - line2OriginPoint.getY();

                double y = line1DestinyPoint.getX() * m + c;
                
                y *= 10000;
                y = Math.round(y);
                y /= 10000;

                if (y < Math.min(line2OriginPoint.getY(), line2DestinyPoint.getY())
                        || y > Math.max(line2OriginPoint.getY(), line2DestinyPoint.getY())) {
                    return null;
                }

                return new Point2D.Double(line1DestinyPoint.getX(), y);
            }
        }else{
            if(line2OriginPoint.getX() == line2DestinyPoint.getX()){
                double m = (line1DestinyPoint.getY() - line1OriginPoint.getY()) / (line1DestinyPoint.getX() - line1OriginPoint.getX());

                double c = line1OriginPoint.getX() * m - line1OriginPoint.getY();

                double y = line2DestinyPoint.getX() * m + c;
                
                y *= 10000;
                y = Math.round(y);
                y /= 10000;
                
                if(m == 0.0){
                    y *= -1;
                }

                if (y < Math.min(line1OriginPoint.getY(), line1DestinyPoint.getY())
                        || y > Math.max(line1OriginPoint.getY(), line1DestinyPoint.getY())) {
                    return null;
                }

                return new Point2D.Double(line2DestinyPoint.getX(), y);
            }
        }

        double m1 = (line1DestinyPoint.getY() - line1OriginPoint.getY()) / (line1DestinyPoint.getX() - line1OriginPoint.getX());
        double m2 = (line2DestinyPoint.getY() - line2OriginPoint.getY()) / (line2DestinyPoint.getX() - line2OriginPoint.getX());

        double c1 = line1OriginPoint.getX() * m1 - line1OriginPoint.getY();
        double c2 = line2OriginPoint.getX() * m2 - line2OriginPoint.getY();

        if (m1 == 0 && m2 == 0) {
            return null;
        }

        double x = (c2 - c1) / (m1 - m2);
        double y = x * m1 + c1;

        x *= -1;
        y *= -1;

        return new Point2D.Double(x, y);
    }

    public static Point2D getIntersectionPoint(double x0, double y0, double x1, double y1, double x2, double y2, double x3, double y3) {
        return getIntersectionPoint(new Point2D.Double(x0, y0), new Point2D.Double(x1, y1), new Point2D.Double(x2, y2), new Point2D.Double(x3, y3));
    }
}
