/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import fuzzy.agregation.impl.Sum;
import fuzzy.defuzzification.impl.CentroidDefuzzification;
import fuzzy.implication.impl.CompositeExpression;
import fuzzy.implication.impl.MandaniImplication;
import fuzzy.implication.impl.SimpleExpression;
import fuzzy.operation.Operation;
import fuzzy.operation.impl.Minimum;
import fuzzy.rule.Rule;
import fuzzy.system.FuzzySystem;
import fuzzy.variable.FuzzyVariable;
import fuzzy.variable.LinguisticVariable;
import fuzzy.variable.impl.LineFunctionVariable;
import java.util.HashMap;

/**
 *
 * @author a1155997
 */
public class MotorMain {

    public static void main(String[] args) {
        FuzzyVariable velocidade = new FuzzyVariable().setDomainName("Velocidade").setLowerBound(0.0).setUpperBound(130.0);
        FuzzyVariable tensao = new FuzzyVariable().setDomainName("Tensão").setLowerBound(20.0).setUpperBound(240.0);
        FuzzyVariable deltaTensao = new FuzzyVariable().setDomainName("Variação da Tensão").setLowerBound(0.0).setUpperBound(240.0);

        String domain = velocidade.getDomainName();
        velocidade.addLinguisticVariable(new LineFunctionVariable("MI", domain).addPoint(0.0, 1.0).addPoint(13.0, 0.0).addPoint(130.0, 0.0));
        velocidade.addLinguisticVariable(new LineFunctionVariable("MME", domain).addPoint(0.0, 0.0).addPoint(13.0, 1.0).addPoint(26.0, 0.0).addPoint(130.0, 0.0));
        velocidade.addLinguisticVariable(new LineFunctionVariable("MP", domain).addPoint(0.0, 0.0).addPoint(13.0, 0.0).addPoint(26.0, 1.0).addPoint(39.0, 0.0).addPoint(130.0, 0.0));
        velocidade.addLinguisticVariable(new LineFunctionVariable("+-P", domain).addPoint(0.0, 0.0).addPoint(26.0, 0.0).addPoint(39.0, 1.0).addPoint(52.0, 0.0).addPoint(130.0, 0.0));
        velocidade.addLinguisticVariable(new LineFunctionVariable("PP", domain).addPoint(0.0, 0.0).addPoint(39.0, 0.0).addPoint(52.0, 1.0).addPoint(65.0, 0.0).addPoint(130.0, 0.0));
        velocidade.addLinguisticVariable(new LineFunctionVariable("ME", domain).addPoint(0.0, 0.0).addPoint(52.0, 0.0).addPoint(65.0, 1.0).addPoint(78.0, 0.0).addPoint(130.0, 0.0));
        velocidade.addLinguisticVariable(new LineFunctionVariable("PG", domain).addPoint(0.0, 0.0).addPoint(65.0, 0.0).addPoint(78.0, 1.0).addPoint(91.0, 0.0).addPoint(130.0, 0.0));
        velocidade.addLinguisticVariable(new LineFunctionVariable("+-G", domain).addPoint(0.0, 0.0).addPoint(78.0, 0.0).addPoint(91.0, 1.0).addPoint(104.0, 0.0).addPoint(130.0, 0.0));
        velocidade.addLinguisticVariable(new LineFunctionVariable("MG", domain).addPoint(0.0, 0.0).addPoint(91.0, 0.0).addPoint(104.0, 1.0).addPoint(117.0, 0.0).addPoint(130.0, 0.0));
        velocidade.addLinguisticVariable(new LineFunctionVariable("MMA", domain).addPoint(0.0, 0.0).addPoint(104.0, 0.0).addPoint(117.0, 1.0).addPoint(130.0, 0.0));
        velocidade.addLinguisticVariable(new LineFunctionVariable("MX", domain).addPoint(0.0, 0.0).addPoint(117.0, 0.0).addPoint(130.0, 1.0));

        domain = tensao.getDomainName();
        tensao.addLinguisticVariable(new LineFunctionVariable("MI", domain).addPoint(20.0, 1.0).addPoint(42.0, 0.0).addPoint(240.0, 0.0));
        tensao.addLinguisticVariable(new LineFunctionVariable("MME", domain).addPoint(20.0, 0.0).addPoint(42.0, 1.0).addPoint(64.0, 0.0).addPoint(240.0, 0.0));
        tensao.addLinguisticVariable(new LineFunctionVariable("MP", domain).addPoint(20.0, 0.0).addPoint(42.0, 0.0).addPoint(64.0, 1.0).addPoint(86.0, 0.0).addPoint(240.0, 0.0));
        tensao.addLinguisticVariable(new LineFunctionVariable("+-P", domain).addPoint(20.0, 0.0).addPoint(64.0, 0.0).addPoint(86.0, 1.0).addPoint(108.0, 0.0).addPoint(240.0, 0.0));
        tensao.addLinguisticVariable(new LineFunctionVariable("PP", domain).addPoint(20.0, 0.0).addPoint(86.0, 0.0).addPoint(108.0, 1.0).addPoint(130.0, 0.0).addPoint(240.0, 0.0));
        tensao.addLinguisticVariable(new LineFunctionVariable("ME", domain).addPoint(20.0, 0.0).addPoint(108.0, 0.0).addPoint(130.0, 1.0).addPoint(152.0, 0.0).addPoint(240.0, 0.0));
        tensao.addLinguisticVariable(new LineFunctionVariable("PG", domain).addPoint(20.0, 0.0).addPoint(130.0, 0.0).addPoint(152.0, 1.0).addPoint(174.0, 0.0).addPoint(240.0, 0.0));
        tensao.addLinguisticVariable(new LineFunctionVariable("+-G", domain).addPoint(20.0, 0.0).addPoint(152.0, 0.0).addPoint(174.0, 1.0).addPoint(196.0, 0.0).addPoint(240.0, 0.0));
        tensao.addLinguisticVariable(new LineFunctionVariable("MG", domain).addPoint(20.0, 0.0).addPoint(174.0, 0.0).addPoint(196.0, 1.0).addPoint(218.0, 0.0).addPoint(240.0, 0.0));
        tensao.addLinguisticVariable(new LineFunctionVariable("MMA", domain).addPoint(20.0, 0.0).addPoint(196.0, 0.0).addPoint(218.0, 1.0).addPoint(240., 0.0));
        tensao.addLinguisticVariable(new LineFunctionVariable("MX", domain).addPoint(20.0, 0.0).addPoint(218.0, 0.0).addPoint(240.0, 1.0));

        domain = deltaTensao.getDomainName();
        deltaTensao.addLinguisticVariable(new LineFunctionVariable("MI", domain).addPoint(0.0, 1.0).addPoint(24.0, 0.0).addPoint(240.0, 0.0));
        deltaTensao.addLinguisticVariable(new LineFunctionVariable("MME", domain).addPoint(0.0, 0.0).addPoint(24.0, 1.0).addPoint(48.0, 0.0).addPoint(240.0, 0.0));
        deltaTensao.addLinguisticVariable(new LineFunctionVariable("MP", domain).addPoint(0.0, 0.0).addPoint(24.0, 0.0).addPoint(48.0, 1.0).addPoint(72.0, 0.0).addPoint(240.0, 0.0));
        deltaTensao.addLinguisticVariable(new LineFunctionVariable("+-P", domain).addPoint(0.0, 0.0).addPoint(48.0, 0.0).addPoint(72.0, 1.0).addPoint(96.0, 0.0).addPoint(240.0, 0.0));
        deltaTensao.addLinguisticVariable(new LineFunctionVariable("PP", domain).addPoint(0.0, 0.0).addPoint(72.0, 0.0).addPoint(96.0, 1.0).addPoint(120.0, 0.0).addPoint(240.0, 0.0));
        deltaTensao.addLinguisticVariable(new LineFunctionVariable("ME", domain).addPoint(0.0, 0.0).addPoint(96.0, 0.0).addPoint(120.0, 1.0).addPoint(144.0, 0.0).addPoint(240.0, 0.0));
        deltaTensao.addLinguisticVariable(new LineFunctionVariable("PG", domain).addPoint(0.0, 0.0).addPoint(120.0, 0.0).addPoint(144.0, 1.0).addPoint(168.0, 0.0).addPoint(240.0, 0.0));
        deltaTensao.addLinguisticVariable(new LineFunctionVariable("+-G", domain).addPoint(0.0, 0.0).addPoint(144.0, 0.0).addPoint(168.0, 1.0).addPoint(192.0, 0.0).addPoint(240.0, 0.0));
        deltaTensao.addLinguisticVariable(new LineFunctionVariable("MG", domain).addPoint(0.0, 0.0).addPoint(168.0, 0.0).addPoint(192.0, 1.0).addPoint(216.0, 0.0).addPoint(240.0, 0.0));
        deltaTensao.addLinguisticVariable(new LineFunctionVariable("MMA", domain).addPoint(0.0, 0.0).addPoint(192.0, 0.0).addPoint(216.0, 1.0).addPoint(240., 0.0));
        deltaTensao.addLinguisticVariable(new LineFunctionVariable("MX", domain).addPoint(0.0, 0.0).addPoint(216.0, 0.0).addPoint(240.0, 1.0));

        String[][] consequentes = new String[][]{
            {"MI", "MI", "MME", "MME", "MME", "MME", "MP", "MP", "+-P", "PP", "+-G"},
            {"MME", "MME", "MI", "MI", "MI", "MME", "MME", "MME", "MME", "MP", "ME"},
            {"MP", "MP", "MME", "MME", "MME", "MME", "MI", "MI", "MME", "MME", "ME"},
            {"+-P", "+-P", "+-P", "MP", "MP", "MP", "MME", "MME", "MI", "MME", "PP"},
            {"PP", "+-P", "+-P", "+-P", "+-P", "+-P", "MP", "MP", "MME", "MI", "+-P"},
            {"ME", "PP", "PP", "PP", "PP", "+-P", "+-P", "+-P", "MP", "MP", "MP"},
            {"PG", "PG", "ME", "ME", "ME", "PP", "PP", "PP", "+-P", "+-P", "MME"},
            {"PG", "PG", "PG", "PG", "ME", "ME", "ME", "PP", "PP", "+-P", "MI"},
            {"+-G", "+-G", "+-G", "PG", "PG", "PG", "PG", "ME", "ME", "PP", "MME"},
            {"MG", "MG", "MG", "MG", "+-G", "+-G", "+-G", "PG", "PG", "ME", "MP"},
            {"MMA", "MMA", "MMA", "MG", "MG", "MG", "MG", "+-G", "+-G", "PG", "+-P"}
        };

        String[] indexes = new String[]{"MI", "MME", "MP", "+-P", "PP", "ME", "PG", "+-G", "MG", "MMA", "MX"};
        int dummy = 0;
        HashMap<String, Integer> valuesMap = new HashMap<>();
        for (; dummy < 11; dummy++) {
            valuesMap.put(indexes[dummy], dummy * 24);
        }

        Minimum min = new Minimum();
        Rule[] rules = new Rule[121];
        int chora = 0;
        for (int j = 0; j < 11; j++) {
            for (int k = 0; k < 11; k++) {
                rules[chora++] = new Rule(
                        deltaTensao.getLinguisticVariable(consequentes[j][k]),
                        new CompositeExpression(
                                new SimpleExpression(tensao.getLinguisticVariable(indexes[j])),
                                new SimpleExpression(velocidade.getLinguisticVariable(indexes[k])),
                                min
                        )
                );
            }
        }

//        FuzzySystem fis = new FuzzySystem(rules, new FuzzyVariable[]{velocidade, tensao, deltaTensao}, new Sum(), new CentroidDefuzzification(), new MandaniImplication());
//
//        System.out.println(fis.evaluateInputs(new Double[]{105.53, 55.2}));

        double r = evaluateMotor(valuesMap, rules, velocidade, tensao, new Double[]{105.53, 55.2});
        
//        System.out.println(r);
        
        Double[] tensoes = new Double[12];
        
        for(int e = 0; e < 12; e++){
            tensoes[e] = 42 + (e*4.4);
            tensoes[e] *= 10;
            tensoes[e] = Math.round(tensoes[e])/10.0;
        }
        
        Double[] rdns = new Double[]{40.7401, 51.0532, 60.7126, 69.5656, 77.5537, 84.6781, 90.9763, 96.5058, 101.3350, 105.5330, 109.1710, 112.3150};
        
        for(int q = 0; q < tensoes.length; q++){
            for(int o = 0; o < rdns.length; o++){
                Double res = evaluateMotor(valuesMap, rules, velocidade, tensao, new Double[]{rdns[o], tensoes[q]});
                Double erro = (tensoes[q] + res) - tensoes[o], erro2 = (tensoes[q] - res) - tensoes[o];
                
                if(Math.abs(erro2) < Math.abs(erro)){
                    erro = erro2;
                    res *= -1;
                }
                
                System.out.println("Tensao: " + tensoes[q] + "  - Rotacao: " + rdns[o] + "  - Resultado: " + res + "  - Erro: " + erro + " ("+tensoes[q]+" + " + res +" = "+tensoes[o]+")");
            }
        }
    }
    
    private static Double evaluateMotor(HashMap<String, Integer> valuesMap, Rule[] rules, FuzzyVariable velocidade, FuzzyVariable tensao, Double[] input){
        MandaniImplication impl = new MandaniImplication();

        LinguisticVariable[] vars = impl.evaluate(rules, new String[]{velocidade.getDomainName(), tensao.getDomainName()}, input);

        Double prodSum = 0.0;
        Double sumOfAllFears = 0.0;

        for (LinguisticVariable v : vars) {
            prodSum += v.getHeight() * valuesMap.get(v.getVariableName());
            sumOfAllFears += v.getHeight();
        }
        
        return prodSum / sumOfAllFears;
    }
}
