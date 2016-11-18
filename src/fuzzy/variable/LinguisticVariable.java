/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuzzy.variable;

/**
 * Classe abstrata que define uma variável linguística.
 * @author henrique
 */
public abstract class LinguisticVariable {
    /**
     * Nome/Label da variável linguística.
     */
    protected String variableName;
    
    /**
     * Nome do domínio da variável fuzzy a que pertence.
     * É usadao para validar a entrada.
     */
    protected String domainName;

    /**
     * Construtora.
     * @param variableName Nome da variável linguística.
     * @param domainName Nome do domínio.
     */
    public LinguisticVariable(String variableName, String domainName) {
        this.variableName = variableName;
        this.domainName = domainName;
    }

    /**
     * Retorna o nome da variavel.
     * @return Nome da variável.
     */
    public String getVariableName() {
        return variableName;
    }

    /**
     * Retorna o nome do domínio da varável.
     * @return Nome do domínio.
     */
    public String getDomainName() {
        return domainName;
    }
    
    public abstract Double getHeight();
    
    /**
     * Avalia o grau de pertinência para um dado valor crisp.
     * @param input Valor crisp de entrada.
     * @return Grau de pertinência.
     */
    public abstract Double evaluateForInput(double input);
    
    /**
     * Retorna os intervalos de pertinância do alfa-corte.
     * @param alpha alfa do corte.
     * @return Lista de intervalos. (Múltiplo de 2)
     */
    public abstract double[] getAlphaCut(double alpha);
}
