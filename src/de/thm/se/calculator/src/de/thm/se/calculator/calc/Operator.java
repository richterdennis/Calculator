package de.thm.se.calculator.calc;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * The Operator operates on to decimals
 * 
 * @author Dennis Richter
 */
public abstract class Operator {
	
	public static final Operator PLUS = new PlusOperator();
	public static final Operator MINUS = new MinusOperator();
	public static final Operator DEVIDE = new DevideOperator();
	public static final Operator MULTIPLY = new MultiplyOperator();
	
	private String operatorString;
	private boolean isPointOperator;

	private Operator(String operatorString, boolean isPointOperator) {
		this.operatorString = operatorString;
		this.isPointOperator = isPointOperator;
	}

	public boolean isPointOperator() {
		return this.isPointOperator;
	}
	
	public abstract BigDecimal operate(BigDecimal a, BigDecimal b);

	public String toString() {
		return " " + this.operatorString + " ";
	}
	
	private static class PlusOperator extends Operator {
		private PlusOperator() {
			super("+", false);
		}

		@Override
		public BigDecimal operate(BigDecimal a, BigDecimal b) {
			return a.add(b);
		}
	}
	
	private static class MinusOperator extends Operator {
		private MinusOperator() {
			super("-", false);
		}

		@Override
		public BigDecimal operate(BigDecimal a, BigDecimal b) {
			return a.subtract(b);
		}
	}
	
	private static class DevideOperator extends Operator {
		private DevideOperator() {
			super("/", true);
		}

		@Override
		public BigDecimal operate(BigDecimal a, BigDecimal b) {
			return a.divide(b, 32, RoundingMode.HALF_UP);
		}
	}
	
	private static class MultiplyOperator extends Operator {
		private MultiplyOperator() {
			super("*", true);
		}

		@Override
		public BigDecimal operate(BigDecimal a, BigDecimal b) {
			return a.multiply(b);
		}
	}
}
