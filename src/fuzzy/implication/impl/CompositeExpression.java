package fuzzy.implication.impl;

import fuzzy.implication.Expression;
import fuzzy.operation.BinaryOperation;

/**
 * Implementação de uma expressão composta. Pode ser aninhada a fim de gerar
 * expressões complexas.
 *
 * @author henrique
 */
public class CompositeExpression implements Expression {

    /**
     * Primeira expressão.
     */
    private Expression expA;
    
    /**
     * Segunda expressão.
     */
    private Expression expB;
    
    /**
     * Operação de agregação das expressões.
     */
    private BinaryOperation oper;

    /**
     * Construtora.
     * @param epxA Primeiro lado da expressão.
     * @param expB Segundo lado da expressão.
     * @param oper Operação de agregação da expressão.
     */
    public CompositeExpression(Expression epxA, Expression expB, BinaryOperation oper) {
        super();
        this.expA = epxA;
        this.expB = expB;
        this.oper = oper;
    }

    /**
     * Avalição da expressão.
     * Retorna o grau de ativação da regra.
     * @param inputNames Lista de nomes das entradas.
     * @param inputValues Lista de valores das entradas.
     * @return Grau de ativação.
     */
    @Override
    public Double evaluateExpression(String[] inputNames, Double[] inputValues) {
        return oper.operateOverValue(expA.evaluateExpression(inputNames, inputValues), expB.evaluateExpression(inputNames, inputValues));
    }

}
