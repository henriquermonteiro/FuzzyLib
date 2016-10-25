package fuzzy.agregation.impl;

import fuzzy.agregation.RuleAgregation;
import fuzzy.operation.impl.Maximum;
import fuzzy.rule.Rule;
import fuzzy.variable.LinguisticVariable;

/**
 * Classe que implementa o método de agregação de regras pelo método da soma.
 * @author henrique
 */
public class Sum implements RuleAgregation {

    /**
     * Classe auxiliar que realiza calculo do máximo entre duas variáveis linguísticas.
     */
    private Maximum max;

    /**
     * Construtora.
     * Inicializar o auxiliar max.
     */
    public Sum() {
        max = new Maximum();
    }

    /**
     * Agrega N variáveis linguísticas pelo método do máximo 2 a 2.
     * @param vars Lista de variáveis linguísticas a serem agragadas.
     * @return Variável de saída. Ou nulo se não houver entrada.
     */
    @Override
    public LinguisticVariable agregate(LinguisticVariable... vars) {
        if (vars.length > 0) {
            LinguisticVariable r = vars[0];
            
            for(int k = 1; k < vars.length; k++){
                r = max.operateOverVarible(r, vars[k]);
            }
            
            return r;
        }
        
        return null;
    }

    /**
     * NÃO IMPLEMENTADO.
     * Agrega N variáveis linguísticas pelo método do máximo 2 a 2.
     * Obtém as variáveis linguísticas ao avaliar as regras.
     * @param inputName Nomes das variáveis de entrada.
     * @param inputValue Valores das variáveis de entrada.
     * @param vars Regras a serem avaliadas e agregadas.
     * @return Variável resultante da agregação.
     */
    @Override
    public LinguisticVariable agregate(String[] inputName, Double[] inputValue, Rule... vars) {
//		if(vars.length == 2){
//			return max.operateOverVarible(vars[0].evaluateActivation(inputName, inputValue), vars[1].evaluateActivation(inputName, inputValue));
//		}

        return null;
    }

}
