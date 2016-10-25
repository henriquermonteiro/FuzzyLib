package fuzzy.system;

import fuzzy.agregation.RuleAgregation;
import fuzzy.defuzzification.DefuzzificationOperation;
import fuzzy.implication.RuleImplication;
import fuzzy.rule.Rule;
import fuzzy.variable.FuzzyVariable;

/**
 * Classe que compõe um sistema de inferência fuzzy.
 * @author henrique
 */
public class FuzzySystem {

    /**
     * Regras do sistema.
     */
    private Rule[] rules;
    
    /**
     * Varíaves do domínio do sistema. (Entradas e saídas).
     */
    private FuzzyVariable[] variables;
    
    /**
     * Método de agregação das regras.
     */
    private RuleAgregation ruleAgregator;
    
    /**
     * Método de defuzzificação.
     */
    private DefuzzificationOperation defuzzify;
    
    /**
     * Método de implicação das regras.
     */
    private RuleImplication implication;

    /**
     * Contrutora do sistema fuzzy;
     * @param rules Lista de regras do sistema.
     * @param variables Lista de variáveis fuzzy do domínio do sistema.
     * @param ruleAgregator Agregador das regras.
     * @param defuzzify Defuzzificador.
     * @param implication Método de implicação.
     */
    public FuzzySystem(Rule[] rules, FuzzyVariable[] variables, RuleAgregation ruleAgregator,
            DefuzzificationOperation defuzzify, RuleImplication implication) {
        super();
        this.rules = rules;
        this.variables = variables;
        this.ruleAgregator = ruleAgregator;
        this.defuzzify = defuzzify;
        this.implication = implication;
    }

    /**
     * Método que avalia uma entrada crisp no sistema.
     * @param doubles Lista de entradas.
     * @return Resultante crisp.
     */
    public Double evaluateInputs(Double... doubles) {
        String[] strings = new String[doubles.length];

        for (int k = 0; k < strings.length; k++) {
            strings[k] = variables[k].getDomainName();
        }

        return defuzzify.defuzzify(ruleAgregator.agregate(implication.evaluate(rules, strings, doubles)));
    }
}
