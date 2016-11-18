/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuzzy.variable.impl;

import fuzzy.util.LineUtils;
import fuzzy.variable.LinguisticVariable;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import no.geosoft.cc.geometry.Geometry;

/**
 * Implementação de uma variável linguística definida por retas de 1º grau. Uma
 * função deve definir o valor para todo resultante para todo o domínio em que
 * foi definida. Usada para definir constantes, triãngulos, trapézios e
 * similares. Não serve para curvas e e retas não contínuas ou com pontos com
 * pertinência aberta.
 *
 * @author henrique
 */
public class LineFunctionVariable extends LinguisticVariable {

    /**
     * Lista de pontos que definem a função..
     */
    private final ArrayList<Point2D> points;

    /**
     * Construtora.
     *
     * @param variableName Nome/Label da variável linguística
     * @param domainName Nome do domínio.
     */
    public LineFunctionVariable(String variableName, String domainName) {
        super(variableName, domainName);
        points = new ArrayList<>();
    }

    /**
     * Adiciona um ponto à função.
     *
     * @param X X do ponto.
     * @param Y Y do ponto.
     * @return Própria variável.
     */
    public LineFunctionVariable addPoint(Double X, Double Y) {
        points.add(new Point2D.Double(X, Y));
        return this;
    }

    /**
     * Retorna a lista de pontos que definem a função.
     *
     * @return Lista de pontos.
     */
    public ArrayList<Point2D> getPoints() {
        return points;
    }

    /**
     * Retorna o ponto de um dado índice.
     *
     * @param k Índice buscado.
     * @return Ponto do índice. (ArrayList.get)
     */
    public Point2D getPoint(int k) {
        return points.get(k);
    }

    /**
     * Avalia o grau de pertinência da variável para um dado valor crisp.
     *
     * @param input Entrada crisp.
     * @return Grau de pertinência.
     */
    @Override
    public Double evaluateForInput(double input) {
        Point2D p = null;

        for (Point2D n : points) {
            if (n.getX() >= input) {
                if (p == null) {
                    return n.getY();
                }

                double d = (n.getY() - p.getY());
                d /= (n.getX() - p.getX());
                d *= (input - p.getX());
                d += p.getY();

                double[] intersects = new double[2];
                int r = Geometry.findLineSegmentIntersection(p.getX(), p.getY(), n.getX(), n.getY(), input, 0.0, input, 1.0, intersects);

                if (r == 1) {
                    return intersects[1];
                }

                return d;
            }

            p = n;
        }

        return null;
    }

    /**
     * Retorna o intervalo do alfa-corte.
     *
     * @param alpha alfa do corte.
     * @return lista de intervalos. (Múltiplo de 2)
     */
    @Override
    public double[] getAlphaCut(double alpha) {
        ArrayList<Double> intervals = new ArrayList<>();

        Point2D aux = null;
        for (Point2D p : points) {
            if (aux != null) {
                double[] intersects = LineUtils.getIntersectionPoint(aux.getX(), aux.getY(), p.getX(), p.getY(), aux.getX(), alpha, p.getX(), alpha);

                int r = (int) intersects[0];

                if (r == 1) {
                    if (intersects[1] == aux.getX()) {
                        r = -2;
                    } else if (aux.getY() >= alpha) {
                        intervals.add(aux.getX());
                        intervals.add(intersects[1]);
                    } else {
                        intervals.add(intersects[1]);
                        intervals.add(p.getX());
                    }
                }

                if (r < 1) {
                    if (p.getY() >= alpha) {
                        intervals.add(aux.getX());
                        intervals.add(p.getX());
                    }
                }
            }
            aux = p;
        }

        Double lastV = null;
        ArrayList<Double> remove = new ArrayList<>();

        int k = 0;
        for (Double v : intervals) {
            if (v != null) {
                if (v.equals(lastV) && k % 2 == 0) {
                    remove.add(v);
                }
            }

            lastV = v;
            k++;
        }

        intervals.removeAll(remove);

        double[] ret = new double[intervals.size()];
        k = 0;
        for (Double d : intervals) {
            ret[k++] = d;
        }

        return ret;
    }

    /**
     * Teste LineFunctionVariable.
     *
     * @param args
     */
    public static void main(String[] args) {
        LineFunctionVariable l = new LineFunctionVariable("teste", "testeD").addPoint(0.0, 0.0).addPoint(10.0, 1.0).addPoint(20.0, 0.0).addPoint(30.0, 1.0).addPoint(40.0, 0.0).addPoint(50.0, 0.0).addPoint(100.0, 1.0);

        double[] cut = l.getAlphaCut(0.95);

        boolean f = true;
        for (double d : cut) {
            System.out.print(d + (f ? " " : " | "));
            
            f = !f;
        }

        System.out.println("");
    }

    @Override
    public Double getHeight() {
        Double max = Double.NEGATIVE_INFINITY;
        for(Point2D p : points){
            if(p.getY() > max){
                max = p.getY();
            }
        }
        
        return max;
    }
}
