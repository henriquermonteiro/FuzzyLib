/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuzzy.variable;

import java.util.ArrayList;

/**
 *
 * @author henrique
 */
public class FuzzyVariable {
    private String domainName;
    private Double lowerBound;
    private Double upperBound;
    private ArrayList<LinguisticVariable> fuzzySet;

    public FuzzyVariable() {
        fuzzySet = new ArrayList<>();
    }

    public ArrayList<LinguisticVariable> getFuzzySet() {
        return fuzzySet;
    }
    
    public FuzzyVariable addLinguisticVariable(LinguisticVariable var){
        fuzzySet.add(var);
        return this;
    }

    public String getDomainName() {
        return domainName;
    }

    public FuzzyVariable setDomainName(String domainName) {
        this.domainName = domainName;
        return this;
    }

    public Double getLowerBound() {
        return lowerBound;
    }

    public FuzzyVariable setLowerBound(Double lowerBound) {
        this.lowerBound = lowerBound;
        return this;
    }

    public Double getUpperBound() {
        return upperBound;
    }

    public FuzzyVariable setUpperBound(Double upperBound) {
        this.upperBound = upperBound;
        return this;
    }

    public LinguisticVariable getLinguisticVariable(String name) {
        for(LinguisticVariable v : fuzzySet){
            if(v.getVariableName().equals(name)){
                return v;
            }
        }
        
        return null;
    }
}
