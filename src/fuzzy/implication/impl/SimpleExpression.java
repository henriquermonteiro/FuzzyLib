package fuzzy.implication.impl;

import fuzzy.implication.Expression;
import fuzzy.variable.LinguisticVariable;

/**
 * Classe que representa uma expressão simples/atômica.
 * Representa uma expressão to tipo X é Var, onde X é a 
 * entrada e Var é a variável linguística.
 * @author henrique
 */
public class SimpleExpression implements Expression {

    /**
     * Variável linguística da expressão.
     */
    private LinguisticVariable var;

    /**
     * Construtora.
     * @param var Variável linguística da expressão.
     */
    public SimpleExpression(LinguisticVariable var) {
        this.var = var;
    }

    /**
     * Avalia a expressão, retornando o grau de ativação da expressão.
     * @param inputNames Lista de nomes das entradas.
     * @param inputValues Lista de valores das entradas.
     * @return Grau de ativação.
     */
    @Override
    public Double evaluateExpression(String[] inputNames, Double[] inputValues) {
        for (int k = 0; k < inputNames.length; k++) {
            if (inputNames[k].equals(var.getDomainName())) {
                return var.evaluateForInput(inputValues[k]);
            }
        }

        return null;
    }

}
