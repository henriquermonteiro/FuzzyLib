package fuzzy.implication;

import fuzzy.rule.Rule;
import fuzzy.variable.LinguisticVariable;

/**
 * Classe abstrata que define um molde para uma implicação de uma regra.
 * @author henrique
 */
public abstract class RuleImplication {

    /**
     * Avaliar uma regra e gerar a variável linguística correspondente.
     * @param rule Regra a ser avaliada.
     * @param inputNames Lista de nomes das variáveis de entrada.
     * @param inputValues Lista de valores de entrada.
     * @return Variável resultante.
     */
    public abstract LinguisticVariable evaluate(Rule<LinguisticVariable> rule, String[] inputNames, Double[] inputValues);

    /**
     * Avalia uma série de regras. Usa a implementação de evaluate para uma única regra.
     * @param rules Regras a serrem avaliadas.
     * @param inputNames Lista de nomes das entradas.
     * @param inputValues Lista de valores das entradas.
     * @return Lista de variáveis linguísticas resultantes.
     */
    public LinguisticVariable[] evaluate(Rule<LinguisticVariable>[] rules, String[] inputNames, Double[] inputValues) {
        LinguisticVariable[] results = new LinguisticVariable[rules.length];

        int k = 0;
        for (Rule r : rules) {
            results[k] = evaluate(r, inputNames, inputValues);

            k++;
        }

        return results;
    }
    
    /**
     * Avaliar uma regra e gerar o valor correspondente.
     * @param rule
     * @param inputNames
     * @param inputValues
     * @return 
     */
    public abstract double evaluateAsDouble(Rule<Double> rule, String[] inputNames, Double[] inputValues);
    
    /**
     * Avalia uma série de regras. Usa a implementação de evaluateAsDouble para uma única regra.
     * @param rules Regras a serrem avaliadas.
     * @param inputNames Lista de nomes das entradas.
     * @param inputValues Lista de valores das entradas.
     * @return Lista de valores resultantes.
     */
    public double[] evaluateAsDouble(Rule<Double>[] rules, String[] inputNames, Double[] inputValues){
        double[] results = new double[rules.length];

        int k = 0;
        for (Rule r : rules) {
            results[k] = evaluateAsDouble(r, inputNames, inputValues);

            k++;
        }

        return results;
    }
}
