package fuzzy.implication;

/**
 * Interface que define a regra de um expressão. Expressões são os antecedentes
 * de regras.
 *
 * @author henrique
 */
public interface Expression {

    /**
     * Avalia uma expressão e retorna o grau de ativação de uma regra.
     * @param inputNames Nomes das variáveis de entrada.
     * @param inputValues Valores das variáveis de entrada.
     * @return Grau de ativação da expressão/regra.
     */
    public Double evaluateExpression(String[] inputNames, Double[] inputValues);
}
