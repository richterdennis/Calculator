package de.thm.se.calculator.calc;

import java.math.BigDecimal;

public class Fracture implements Calculatable {
	
	Calculatable numerator;
	Operator fractionOperator;
	Calculatable denominator;
	
	public Fracture(Calculatable numerator, Calculatable denominator) {
		this.fractionOperator = Operator.DEVIDE;
		
		this.setNumerator(numerator);
		this.setDenominator(denominator);
	}
	
	public Fracture() {
		this(new Decimal(0), new Decimal(1));
	}
	
	public Calculatable getNumerator() {
		return numerator;
	}

	public void setNumerator(Calculatable numerator) {
		this.numerator = numerator;
	}

	public Calculatable getDenominator() {
		return denominator;
	}

	public void setDenominator(Calculatable denominator) {
		if(denominator.getValue().equals(BigDecimal.ZERO))
			throw new ArithmeticException("Denominator can not be zero!");
		
		this.denominator = denominator;
	}

	@Override
	public BigDecimal getValue() {
		return fractionOperator.operate(numerator.getValue(), denominator.getValue());
	}
	
	@Override
	public String toString() {
		return "(" + this.numerator + "/" + this.denominator + ")";
	}

}
