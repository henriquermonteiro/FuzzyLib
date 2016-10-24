package fuzzy.implication.impl;

import java.awt.geom.Point2D;

import fuzzy.implication.RuleImplication;
import fuzzy.operation.impl.Minimum;
import fuzzy.rule.Rule;
import fuzzy.variable.LinguisticVariable;
import fuzzy.variable.impl.LineFunctionVariable;
import no.geosoft.cc.geometry.Geometry;

public class MandaniImplication extends RuleImplication {

    @Override
    public LinguisticVariable evaluate(Rule rule, String[] inputNames, Double[] inputValues) {
        if (rule.getResult() instanceof LineFunctionVariable) {
            LineFunctionVariable l = (LineFunctionVariable) rule.getResult();

            LineFunctionVariable res = new LineFunctionVariable("Implication", l.getDomainName());

            Double v = rule.getInput().evaluateExpression(inputNames, inputValues);

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

    public static void main(String... args) {
        LinguisticVariable v1 = new LineFunctionVariable("Teste1", "TesteDomain").addPoint(0.0, 0.0).addPoint(25.0, 0.0).addPoint(45.0, 0.8).addPoint(55.0, 0.8).addPoint(75.0, 0.0).addPoint(100.0, 0.0);
        LinguisticVariable v2 = new LineFunctionVariable("Teste2", "TesteDomain").addPoint(0.0, 0.0).addPoint(25.0, 0.0).addPoint(50.0, 1.0).addPoint(75.0, 0.0).addPoint(100.0, 0.0);

        MandaniImplication man = new MandaniImplication();
        LinguisticVariable l = man.evaluate(new Rule(v1, new CompositeExpression(new SimpleExpression(v1), new SimpleExpression(v2), new Minimum())), new String[]{"TesteDomain"}, new Double[]{50.0});

        System.out.println("");
    }
}
