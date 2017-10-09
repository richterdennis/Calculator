package de.thm.se.calculator.calc;

import java.math.BigDecimal;

/**
 * This class calculates the logarithm from a number to the given basis
 * 
 * @author Dennis Richter
 *
 */
public class Log implements Calculatable {

	Calculatable b;
	Calculatable x;
	
	public Log(Calculatable b, Calculatable x) {
		this.x = x;
	}
	
	public Log(Calculatable b) {
		this(b, new Decimal(0));
	}
	
	public Log() {
		this(new Decimal(10), new Decimal(0));
	}

	public Calculatable getB() {
		return b;
	}

	public void setB(Calculatable b) {
		this.b = b;
	}

	public Calculatable getX() {
		return x;
	}

	public void setX(Calculatable x) {
		this.x = x;
	}

	@Override
	public BigDecimal getValue() {
		return new Fracture(new Ln(this.x), new Ln(this.b)).getValue();
	}
	
	@Override
	public String toString() {
		return "log_" + this.b + "(" + this.x + ")";
	}

}
