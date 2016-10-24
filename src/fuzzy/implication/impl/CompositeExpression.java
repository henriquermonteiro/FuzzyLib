package fuzzy.implication.impl;

import fuzzy.implication.Expression;
import fuzzy.operation.BinaryOperation;

public class CompositeExpression implements Expression{
	private Expression expA;
	private Expression expB;
	private BinaryOperation oper;
	
	public CompositeExpression(Expression epxA, Expression expB, BinaryOperation oper) {
		super();
		this.expA = epxA;
		this.expB = expB;
		this.oper = oper;
	}

	@Override
	public Double evaluateExpression(String[] inputNames, Double[] inputValues) {
		return oper.operateOverValue(expA.evaluateExpression(inputNames, inputValues), expB.evaluateExpression(inputNames, inputValues));
	}
	
	
}
