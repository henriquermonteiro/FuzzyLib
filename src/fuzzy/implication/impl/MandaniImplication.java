package fuzzy.implication.impl;

import java.awt.geom.Point2D;

import fuzzy.implication.RuleImplication;
import fuzzy.operation.impl.Minimum;
import fuzzy.rule.Rule;
import fuzzy.variable.LinguisticVariable;
import fuzzy.variable.impl.LineFunctionVariable;
import no.geosoft.cc.geometry.Geometry;

/**
 * Classe que implementa a implicação do tipo Mandani (Minimo).
 * Usa a classe Minimum.
 * @author henrique
 */
public class MandaniImplication extends RuleImplication {

    /**
     * Avalia uma regra e retorna a variável linguística modificada pelo grau 
     * de ativação seguindo o método mandani.
     * @param rule Regra a ser avaliada.
     * @param inputNames Lista de nomes das entradas.
     * @param inputValues Lista de valores das entradas.
     * @return Variável resultante.
     */
    @Override
    public LinguisticVariable evaluate(Rule rule, String[] inputNames, Double[] inputValues) {
        if (rule.getResult() instanceof LineFunctionVariable) {
            LineFunctionVariable l = (LineFunctionVariable) rule.getResult();

            LineFunctionVariable res = new LineFunctionVariable(((LineFunctionVariable)rule.getResult()).getVariableName(), l.getDomainName());

            Double v = rule.getInput().evaluateExpression(inputNames, inputValues);

            if(v > 0){
                System.out.print("");
            }
            
            res.addPoint(l.getPoint(0).getX(), Math.min(l.getPoint(0).getY(), v));

            Point2D p = null, auxP = l.getPoint(0);

            int k = 1;
            for (; k < l.getPoints().size(); k++) {

                p = l.getPoint(k);

                double[] xy = new double[2];

                int r = Geometry.findLineSegmentIntersection(auxP.getX(), auxP.getY(), p.getX(), p.getY(), auxP.getX(), v, p.getX(), v, xy);

                if (r == 1) {
                    if (Math.abs(p.getX() - xy[0]) > 0.0005 && Math.abs(xy[0] - auxP.getX()) > 0.0005) {
                        res.addPoint(xy[0], xy[1]);
                    }
                }

                res.addPoint(p.getX(), Math.min(p.getY(), v));

                auxP = p;
            }

            return res;
        }

        return null;
    }

    /**
     * O método mandani não utiliza valores crisp no resultante das regras, 
     * este método não é suportado.
     * @param rule
     * @param inputNames
     * @param inputValues
     * @return
     */
    @Override
    public double evaluateAsDouble(Rule<Double> rule, String[] inputNames, Double[] inputValues) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Teste da implicação mandani.
     * @param args
     */
    public static void main(String... args) {
        LinguisticVariable v1 = new LineFunctionVariable("Teste1", "TesteDomain").addPoint(0.0, 0.0).addPoint(25.0, 0.0).addPoint(45.0, 0.8).addPoint(55.0, 0.8).addPoint(75.0, 0.0).addPoint(100.0, 0.0);
        LinguisticVariable v2 = new LineFunctionVariable("Teste2", "TesteDomain").addPoint(0.0, 0.0).addPoint(25.0, 0.0).addPoint(50.0, 1.0).addPoint(75.0, 0.0).addPoint(100.0, 0.0);

        MandaniImplication man = new MandaniImplication();
        LinguisticVariable l = man.evaluate(new Rule<>(v1, new CompositeExpression(new SimpleExpression(v1), new SimpleExpression(v2), new Minimum())), new String[]{"TesteDomain"}, new Double[]{50.0});

        System.out.println("");
    }
}
