package test;

import fuzzy.agregation.impl.Sum;
import fuzzy.defuzzification.impl.CentroidDefuzzification;
import fuzzy.implication.impl.CompositeExpression;
import fuzzy.implication.impl.MandaniImplication;
import fuzzy.implication.impl.SimpleExpression;
import fuzzy.operation.impl.Minimum;
import fuzzy.rule.Rule;
import fuzzy.system.FuzzySystem;
import fuzzy.variable.FuzzyVariable;
import fuzzy.variable.impl.LineFunctionVariable;
import no.geosoft.cc.geometry.Geometry;

public class Main {

    public static void main(String... args) {
        FuzzyVariable tempo = new FuzzyVariable().setDomainName("Tempo").setLowerBound(0.0).setUpperBound(60.0);
        FuzzyVariable sujeira = new FuzzyVariable().setDomainName("Sujeira").setLowerBound(0.0).setUpperBound(100.0);
        FuzzyVariable mancha = new FuzzyVariable().setDomainName("Mancha").setLowerBound(0.0).setUpperBound(100.0);

        sujeira.addLinguisticVariable(new LineFunctionVariable("PS", "Sujeira").addPoint(0.0, 1.0).addPoint(50.0, 0.0).addPoint(100.0, 0.0));
        sujeira.addLinguisticVariable(new LineFunctionVariable("MS", "Sujeira").addPoint(0.0, 0.0).addPoint(50.0, 1.0).addPoint(100.0, 0.0));
        sujeira.addLinguisticVariable(new LineFunctionVariable("GS", "Sujeira").addPoint(0.0, 0.0).addPoint(50.0, 0.0).addPoint(100.0, 1.0));

        mancha.addLinguisticVariable(new LineFunctionVariable("SM", "Mancha").addPoint(0.0, 1.0).addPoint(50.0, 0.0).addPoint(100.0, 0.0));
        mancha.addLinguisticVariable(new LineFunctionVariable("MM", "Mancha").addPoint(0.0, 0.0).addPoint(50.0, 1.0).addPoint(100.0, 0.0));
        mancha.addLinguisticVariable(new LineFunctionVariable("GM", "Mancha").addPoint(0.0, 0.0).addPoint(50.0, 0.0).addPoint(100.0, 1.0));

        tempo.addLinguisticVariable(new LineFunctionVariable("MC", "Tempo").addPoint(0.0, 1.0).addPoint(10.0, 0.0).addPoint(60.0, 0.0));
        tempo.addLinguisticVariable(new LineFunctionVariable("C", "Tempo").addPoint(0.0, 0.0).addPoint(10.0, 1.0).addPoint(25.0, 0.0).addPoint(60.0, 0.0));
        tempo.addLinguisticVariable(new LineFunctionVariable("M", "Tempo").addPoint(0.0, 0.0).addPoint(10.0, 0.0).addPoint(25.0, 1.0).addPoint(40.0, 0.0).addPoint(60.0, 0.0));
        tempo.addLinguisticVariable(new LineFunctionVariable("L", "Tempo").addPoint(0.0, 0.0).addPoint(25.0, 0.0).addPoint(40.0, 1.0).addPoint(60.0, 0.0));
        tempo.addLinguisticVariable(new LineFunctionVariable("ML", "Tempo").addPoint(0.0, 0.0).addPoint(40.0, 0.0).addPoint(60.0, 1.0));
        
        Minimum min = new Minimum();
        Rule[] rules = new Rule[9];
        rules[0] = new Rule(
                tempo.getLinguisticVariable("MC"),
                new CompositeExpression(
                        new SimpleExpression(sujeira.getLinguisticVariable("PS")), 
                        new SimpleExpression(mancha.getLinguisticVariable("SM")), 
                        min
                )
        );
        rules[1] = new Rule(
                tempo.getLinguisticVariable("M"),
                new CompositeExpression(
                        new SimpleExpression(sujeira.getLinguisticVariable("PS")), 
                        new SimpleExpression(mancha.getLinguisticVariable("MM")), 
                        min
                )
        );
        rules[2] = new Rule(
                tempo.getLinguisticVariable("L"),
                new CompositeExpression(
                        new SimpleExpression(sujeira.getLinguisticVariable("PS")), 
                        new SimpleExpression(mancha.getLinguisticVariable("GM")), 
                        min
                )
        );
        rules[3] = new Rule(
                tempo.getLinguisticVariable("C"),
                new CompositeExpression(
                        new SimpleExpression(sujeira.getLinguisticVariable("MS")), 
                        new SimpleExpression(mancha.getLinguisticVariable("SM")), 
                        min
                )
        );
        rules[4] = new Rule(
                tempo.getLinguisticVariable("M"),
                new CompositeExpression(
                        new SimpleExpression(sujeira.getLinguisticVariable("MS")), 
                        new SimpleExpression(mancha.getLinguisticVariable("MM")), 
                        min
                )
        );
        rules[5] = new Rule(
                tempo.getLinguisticVariable("L"),
                new CompositeExpression(
                        new SimpleExpression(sujeira.getLinguisticVariable("MS")), 
                        new SimpleExpression(mancha.getLinguisticVariable("GM")), 
                        min
                )
        );
        rules[6] = new Rule(
                tempo.getLinguisticVariable("M"),
                new CompositeExpression(
                        new SimpleExpression(sujeira.getLinguisticVariable("GS")), 
                        new SimpleExpression(mancha.getLinguisticVariable("SM")), 
                        min
                )
        );
        rules[7] = new Rule(
                tempo.getLinguisticVariable("L"),
                new CompositeExpression(
                        new SimpleExpression(sujeira.getLinguisticVariable("GS")), 
                        new SimpleExpression(mancha.getLinguisticVariable("MM")), 
                        min
                )
        );
        rules[8] = new Rule(
                tempo.getLinguisticVariable("ML"),
                new CompositeExpression(
                        new SimpleExpression(sujeira.getLinguisticVariable("GS")), 
                        new SimpleExpression(mancha.getLinguisticVariable("GM")), 
                        min
                )
        );
        
        FuzzySystem sys = new FuzzySystem(rules, new FuzzyVariable[]{sujeira, mancha, tempo}, new Sum(), new CentroidDefuzzification(), new MandaniImplication());
        
//        System.out.println(Geometry.computePolygonCentroid(new double[]{0.0, 10.0, 22.0, 28.0, 37.0, 56.0, 60.0}, new double[]{0.0, 0.0, 0.8, 0.8, 0.2, 0.2, 0.0})[0]);
//        sys.evaluateInputs(new Double[]{0.0, 100.0});
        
        for(int k = 0; k <= 100; k += 10){
            for(int t = 0; t <= 100; t += 10){
//                System.out.println("k: " + k + " t: " + t + " " + sys.evaluateInputs(new Double[]{(double)k, (double)t}));
                System.out.println(sys.evaluateInputs(new Double[]{(double)k, (double)t}));
            }
        }
    }
}
