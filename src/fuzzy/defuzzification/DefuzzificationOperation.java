package fuzzy.defuzzification;

import fuzzy.variable.LinguisticVariable;

/**
 * Interface que define um método de defuzzificação.
 *
 * @author henrique
 */
public interface DefuzzificationOperation {

    /**
     * Defuzzifica uma varia´vel fuzzy.
     * @param var Variável a ser defuzzificada.
     * @return Um valor double resultante.
     */
    public Double defuzzify(LinguisticVariable var);
}
