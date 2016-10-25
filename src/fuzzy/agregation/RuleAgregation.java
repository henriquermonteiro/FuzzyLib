package fuzzy.agregation;

import fuzzy.rule.Rule;
import fuzzy.variable.LinguisticVariable;

/**
 * Interface de métodos de agragação de regras.
 *
 * @author henrique
 */
public interface RuleAgregation {

    /**
     * Agrega N variaveis linguísticas.
     * @param vars N variáveis linguísticas a serem agregadas.
     * @return Variável composta pela agragação.
     */
    public LinguisticVariable agregate(LinguisticVariable... vars);

    /**
     * Agrega N variaveis linguísticas resultantes de N regras.
     *  -- Não usado --
     * @param inputName Lista de nomes das variáveis de entrada.
     * @param inputValue Lista de valores da entrada.
     * @param vars Regras que devem ser avaliadas e agregadas.
     * @return Variável agregada.
     */
    public LinguisticVariable agregate(String[] inputName, Double[] inputValue, Rule... vars);
}
