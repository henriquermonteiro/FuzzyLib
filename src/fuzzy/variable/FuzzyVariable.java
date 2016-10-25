/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuzzy.variable;

import java.util.ArrayList;

/**
 * Classe que define uma varíavel fuzzy do domínio.
 * @author henrique
 */
public class FuzzyVariable {
    /**
     * Nome do domínio.
     */
    private String domainName;
    
    /**
     * Limitante inferior do domínio.
     */
    private Double lowerBound;
    
    /**
     * Limitante superior do domínio.
     */
    private Double upperBound;
    
    /**
     * Lista de conjuntos fuzzy/variáveis linguísticas do domínio.
     */
    private ArrayList<LinguisticVariable> fuzzySet;

    /**
     * Construtor.
     */
    public FuzzyVariable() {
        fuzzySet = new ArrayList<>();
    }

    /**
     * Retorna o conjunto de varíaveis linguísticas do domínio.
     * @return Lista de varáveis linguísticas.
     */
    public ArrayList<LinguisticVariable> getFuzzySet() {
        return fuzzySet;
    }
    
    /**
     * Adiciona uma variável linguística ao domíno.
     * @param var Variável adicionada.
     * @return Próprio domínio.
     */
    public FuzzyVariable addLinguisticVariable(LinguisticVariable var){
        fuzzySet.add(var);
        return this;
    }

    /**
     * Retorna o nome do domínio.
     * @return Nome do domínio.
     */
    public String getDomainName() {
        return domainName;
    }

    /**
     * Define o nome do domínio.
     * @param domainName Nome do domínio.
     * @return Próprio domínio.
     */
    public FuzzyVariable setDomainName(String domainName) {
        this.domainName = domainName;
        return this;
    }

    /**
     * Retorna o limitante inferior do domínio.
     * @return Limite inferior.
     */
    public Double getLowerBound() {
        return lowerBound;
    }

    /**
     * Define o limite inferior do domínio.
     * @param lowerBound Limite inferior.
     * @return Próprio domínio.
     */
    public FuzzyVariable setLowerBound(Double lowerBound) {
        this.lowerBound = lowerBound;
        return this;
    }

    /**
     * Retorna o limite superior do domínio.
     * @return Limite superior.
     */
    public Double getUpperBound() {
        return upperBound;
    }

    /**
     * Define o limite superior do domínio.
     * @param upperBound Limite superior.
     * @return Próprio domínio.
     */
    public FuzzyVariable setUpperBound(Double upperBound) {
        this.upperBound = upperBound;
        return this;
    }

    /**
     * Retorna uma varável linguística para um dado nome. Nulo se não encontrar.
     * @param name Nome da varável procurada.
     * @return Variável linguística. Nulo se não for encontrada.
     */
    public LinguisticVariable getLinguisticVariable(String name) {
        for(LinguisticVariable v : fuzzySet){
            if(v.getVariableName().equals(name)){
                return v;
            }
        }
        
        return null;
    }
}
