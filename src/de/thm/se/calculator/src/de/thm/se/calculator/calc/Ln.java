package de.thm.se.calculator.calc;

import java.math.BigDecimal;

/**
 * The ln is the natural logarithm for the basis e
 * 
 * @author Dennis Richter
 *
 */
public class Ln extends AbstractCalculatable {
	
	public Ln() {
		super();
	}

	public Ln(Calculatable x) {
		super(x);
	}

	@Override
	public BigDecimal getValue() {
		return new BigDecimal(Math.log(this.getX().getValue().doubleValue()));
	}
	
	@Override
	public String toString() {
		return "ln(" + this.getX() + ")";
	}

}
