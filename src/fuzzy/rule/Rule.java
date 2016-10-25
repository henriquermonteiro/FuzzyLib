package fuzzy.rule;

import fuzzy.implication.Expression;

/**
 * Classe que exprime uma regra.
 * @author henrique
 * @param <R> Tipo de retorno da Regra.
 * Variável Linguística, Double ...
 */
public class Rule<R> {
	protected R result;
	protected Expression input;
	
        /**
         * Construtora da regra.
         * Recebe o valor resultante pela ativação e a expressão do antecedente.
         * @param result Resultante da regra.
         * @param input Antecedente da regra.
         */
	public Rule(R result, Expression input) {
		super();
		this.result = result;
		this.input = input;
	}
	
        /**
         * Retorna o valor do resultante.
         * @return 
         */
	public R getResult() {
		return result;
	}
	
        /**
         * Retorna a expressão da regra.
         * @return 
         */
	public Expression getInput() {
		return input;
	}
	
	
}
