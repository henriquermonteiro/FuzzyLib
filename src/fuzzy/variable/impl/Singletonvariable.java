package fuzzy.variable.impl;

import fuzzy.variable.LinguisticVariable;

/**
 * Classe que define uma varável singleton.
 * @author henrique
 */
public class Singletonvariable extends LinguisticVariable {

    /**
     * Ponto do singleton.
     */
    private Double valuePoint;
    
    private Double pertinence;

    /**
     * Construtora.
     * @param variableName Nome/Label da varíavel.
     * @param domainName Nome do domínio.
     * @param valuePoint Ponto do singleton.
     */
    public Singletonvariable(String variableName, String domainName, Double valuePoint) {
        super(variableName, domainName);
        this.valuePoint = valuePoint;
        this.pertinence = 1.0;
    }

    /**
     * Construtora.
     * @param variableName Nome/Label da varíavel.
     * @param domainName Nome do domínio.
     * @param valuePoint Ponto do singleton.
     * @param pertinence Grau de pertinência no ponto.
     */
    public Singletonvariable(String variableName, String domainName, Double valuePoint, Double pertinence) {
        super(variableName, domainName);
        this.valuePoint = valuePoint;
        this.pertinence = pertinence;
    }

    /**
     * Avalia o grau de pertinência de um valor crisp.
     * @param input Entrada crisp.
     * @return Grau de pertinência.
     */
    @Override
    public Double evaluateForInput(double input) {
        if (input == valuePoint) {
            return pertinence;
        }

        return 0.0;
    }

    /**
     * Retorna o intervalo do alfa-corte.
     * @param alpha alfa do corte.
     * @return lista de intervalos. (Múltiplo de 2)
     */
    @Override
    public double[] getAlphaCut(double alpha) {
        if(pertinence >= alpha){
            return new double[]{valuePoint, valuePoint};
        }
        
        return new double[0];
    }

}
