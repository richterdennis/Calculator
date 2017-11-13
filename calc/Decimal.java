package de.thm.se.calculator.calc;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * This is the simplest Calculatable, a decimal number
 * 
 * @author Dennis Richter
 */
@SuppressWarnings("serial")
public class Decimal extends BigDecimal implements Calculatable {
	
	/**
	 * @param val
	 */
	public Decimal(BigInteger val) {
		super(val);
	}

	/**
	 * @param val
	 */
	public Decimal(double val) {
		super(val);
	}

	/**
	 * @param val
	 */
	public Decimal(int val) {
		super(val);
	}

	/**
	 * @param val
	 */
	public Decimal(long val) {
		super(val);
	}

	/**
	 * @param val
	 */
	public Decimal(String val) {
		super(val);
	}

	@Override
	public BigDecimal getValue() {
		return this;
	}

}
