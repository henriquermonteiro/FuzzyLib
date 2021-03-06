/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuzzy.util;

import java.awt.geom.Point2D;

/**
 * Classe que implementa um métod auxiliar para calculo das interseções de segmentos de retas.
 * @author henrique
 */
public class LineUtils {

    /**
     * Limiar de igualdade entre dois valores doubles.
     */
    public static double LIMIAR = 0.0000005;
    
    /**
     * Precisão em casas decimais do resultado.
     */
    public static long PRECISION = 1000000;

    /**
     * Teste do método de interseção.
     * @param args NÂO USADO.
     */
    public static void main(String[] args) {
        Point2D po1, pd1, po2, pd2;
        
        po1 = new Point2D.Double(0.0, 0.0);
        pd1 = new Point2D.Double(10.0, 0.0);
        
        po2 = new Point2D.Double(0.0, 1.0);
        pd2 = new Point2D.Double(5.0, 1.0);
        
        double[] vals = getIntersectionPoint(po1, pd1, po2, pd2);
        System.out.println("Paralelo: " + vals[0] + " " + (vals.length > 1 ? vals[1] : "") + " " + (vals.length > 2 ? vals[2] : ""));
        
        po2.setLocation(4.0, 0.0);
        pd2.setLocation(10.0, 0.0);
        
        vals = getIntersectionPoint(po1, pd1, po2, pd2);
        System.out.println("Paralelo Sobreposto: " + vals[0] + " " + (vals.length > 1 ? vals[1] : "") + " " + (vals.length > 2 ? vals[2] : ""));
        
        po1.setLocation(0.0, 0.5);
        pd1.setLocation(10.0, 0.5);
        
        po2.setLocation(5.0, 0.0);
        pd2.setLocation(5.0, 1.0);
        
        vals = getIntersectionPoint(po1, pd1, po2, pd2);
        System.out.println("Corte Transversal Dentro: " + vals[0] + " " + (vals.length > 1 ? vals[1] : "") + " " + (vals.length > 2 ? vals[2] : ""));
        
        po2.setLocation(10.5, 0.0);
        pd2.setLocation(10.5, 1.0);
        
        vals = getIntersectionPoint(po1, pd1, po2, pd2);
        System.out.println("Corte Transversal Dentro: " + vals[0] + " " + (vals.length > 1 ? vals[1] : "") + " " + (vals.length > 2 ? vals[2] : ""));
        
        po1.setLocation(13.0, 0.8);
        pd1.setLocation(25.0, 0.0);
        
        po2.setLocation(13.0, 0.2);
        pd2.setLocation(37.0, 0.2);
        
        vals = getIntersectionPoint(po1, pd1, po2, pd2);
        System.out.println("Interseção Dentro: " + vals[0] + " " + (vals.length > 1 ? vals[1] : "") + " " + (vals.length > 2 ? vals[2] : ""));
        
        po2.setLocation(25.0, 0.2);
        
        vals = getIntersectionPoint(po1, pd1, po2, pd2);
        System.out.println("Interseção fora: " + vals[0] + " " + (vals.length > 1 ? vals[1] : "") + " " + (vals.length > 2 ? vals[2] : ""));
    }
    
    /**
     * Calcula a interseção de duas retas
     * Baseado em: http://geosoft.no/software/geometry/Geometry.java.html
     * @param line1OriginPoint ponto de origem da reta 1
     * @param line1DestinyPoint ponto de destino da reta 1
     * @param line2OriginPoint ponto de origem da reta 2
     * @param line2DestinyPoint ponto de destino da reta 2
     * @return [-2] se forem paralelas sobrepostas. [-1] se forem paralelas não
     * sobrepostas. [0, x, y] se a interseção for fora do intervalo passado. [1,
     * x, y] se a interseção estiver no intervalo definido.
     */
    public static double[] getIntersectionPoint(Point2D line1OriginPoint, Point2D line1DestinyPoint, Point2D line2OriginPoint, Point2D line2DestinyPoint) {

        boolean l1Ok = line1DestinyPoint.getX() == line1OriginPoint.getX();
        boolean l2Ok = line2DestinyPoint.getX() == line2OriginPoint.getX();

        if (l1Ok && l2Ok) {
            return (line1DestinyPoint.getY() == line2DestinyPoint.getY() ? new double[]{-2.0} : new double[]{-1.0});
        }

        if (l1Ok || l2Ok) {
            Point2D po = null, pd = null;
            double x = 0.0;

            if (l1Ok) {
                po = line2OriginPoint;
                pd = line2DestinyPoint;

                x = line1OriginPoint.getX();
            } else {
                po = line1OriginPoint;
                pd = line1DestinyPoint;

                x = line2OriginPoint.getX();
            }

            double m = pd.getY() - po.getY();
            m /= pd.getX() - po.getX();

            double c = po.getY();
            c -= m * po.getX();

            double y = m * x;
            y += c;

            y *= PRECISION;
            y = ((double) Math.round(y)) / PRECISION;

            if (x >= po.getX()) {
                if (x <= pd.getX()) {
                    return new double[]{1.0, x, y};
                }
            }
            
            return new double[]{0.0, x, y};
        }

        Point2D pl1o = null;
        Point2D pl1d = null;
        Point2D pl2o = null;
        Point2D pl2d = null;

        if (line1OriginPoint.getX() <= line1DestinyPoint.getX()) { // Se estão na ordem certa:
            pl1o = line1OriginPoint;                             // ponto da linha 1 origem 
            pl1d = line1DestinyPoint;
        } else {
            pl1o = line1DestinyPoint;
            pl1d = line1OriginPoint;
        }

        if (line2OriginPoint.getX() <= line2DestinyPoint.getX()) {
            pl2o = line2OriginPoint;
            pl2d = line2DestinyPoint;
        } else {
            pl2o = line2DestinyPoint;
            pl2d = line2OriginPoint;
        }

        double m1 = pl1d.getY() - pl1o.getY();
        m1 /= pl1d.getX() - pl1o.getX();

        double c1 = pl1o.getY();
        c1 -= m1 * pl1o.getX();

        double m2 = pl2d.getY() - pl2o.getY();
        m2 /= pl2d.getX() - pl2o.getX();

        double c2 = pl2o.getY();
        c2 -= m2 * pl2o.getX();

        if (Math.abs(m1 - m2) < LIMIAR) {
            return (Math.abs(c1 - c2) < LIMIAR ? new double[]{-2} : new double[]{-1});
        }

        double x = c2 - c1;
        x /= m1 - m2;

        x *= PRECISION;
        x = ((double) Math.round(x)) / PRECISION;

        double y = m1 * x;
        y += c1;

        y *= PRECISION;
        y = ((double) Math.round(y)) / PRECISION;

        if (x <= pl1d.getX()) {
            if (x >= pl1o.getX()) {
                if (x <= pl2d.getX()) {
                    if (x >= pl2o.getX()) {
                        return new double[]{1.0, x, y};
                    }
                }
            }
        }

        return new double[]{0, x, y};
    }

    /**
     * Calcula a interseção de duas retas.
     * Baseado em: http://geosoft.no/software/geometry/Geometry.java.html
     * Usa o método getIntersectionPoint com Point2D.
     * @param x0 X do ponto de Origem da linha 1.
     * @param y0 Y do ponto de Origem da linha 1.
     * @param x1 X do ponto de Destino da linha 1.
     * @param y1 Y do ponto de Destino da linha 1.
     * @param x2 X do ponto de Origem da linha 2.
     * @param y2 Y do ponto de Origem da linha 2.
     * @param x3 X do ponto de Destino da linha 2.
     * @param y3 Y do ponto de Destino da linha 2.
     * @return [-2] se forem paralelas sobrepostas. [-1] se forem paralelas não
     * sobrepostas. [0, x, y] se a interseção for fora do intervalo passado. [1,
     * x, y] se a interseção estiver no intervalo definido.
     */
    public static double[] getIntersectionPoint(double x0, double y0, double x1, double y1, double x2, double y2, double x3, double y3) {
        double[] ret = getIntersectionPoint(new Point2D.Double(x0, y0), new Point2D.Double(x1, y1), new Point2D.Double(x2, y2), new Point2D.Double(x3, y3));
        
        return ret;
    }
}
