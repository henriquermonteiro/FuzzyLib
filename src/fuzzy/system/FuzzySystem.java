package fuzzy.system;

import fuzzy.agregation.RuleAgregation;
import fuzzy.defuzzification.DefuzzificationOperation;
import fuzzy.implication.RuleImplication;
import fuzzy.rule.Rule;
import fuzzy.variable.FuzzyVariable;

public class FuzzySystem {

    private Rule[] rules;
    private FuzzyVariable[] variables;
    private RuleAgregation ruleAgregator;
    private DefuzzificationOperation defuzzify;
    private RuleImplication implication;

    public FuzzySystem(Rule[] rules, FuzzyVariable[] variables, RuleAgregation ruleAgregator,
            DefuzzificationOperation defuzzify, RuleImplication implication) {
        super();
        this.rules = rules;
        this.variables = variables;
        this.ruleAgregator = ruleAgregator;
        this.defuzzify = defuzzify;
        this.implication = implication;
    }

    public Double evaluateInputs(Double... doubles) {
        String[] strings = new String[doubles.length];

        for (int k = 0; k < strings.length; k++) {
            strings[k] = variables[k].getDomainName();
        }

        return defuzzify.defuzzify(ruleAgregator.agregate(implication.evaluate(rules, strings, doubles)));
    }
}
