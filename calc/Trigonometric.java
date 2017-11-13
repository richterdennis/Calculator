package de.thm.se.calculator.calc;

import java.math.BigDecimal;

public final class Trigonometric {
		
	public static class Sin extends AbstractCalculatable {
		
		public Sin() {
			super();
		}

		public Sin(Calculatable x) {
			super(x);
		}

		@Override
		public BigDecimal getValue() {
			return new BigDecimal(Math.sin(getX().getValue().doubleValue()));
		}
		
		@Override
		public String toString() {
			return "sin(" + this.getX() + ")";
		}
	}
	
	public static class Cos extends AbstractCalculatable {
		
		public Cos() {
			super();
		}

		public Cos(Calculatable x) {
			super(x);
		}
		
		@Override
		public BigDecimal getValue() {
			return new BigDecimal(Math.cos(getX().getValue().doubleValue()));
		}
		
		@Override
		public String toString() {
			return "cos(" + this.getX() + ")";
		}
	}
	
	public static class Tan extends AbstractCalculatable {
		
		public Tan() {
			super();
		}

		public Tan(Calculatable x) {
			super(x);
		}
		
		@Override
		public BigDecimal getValue() {
			return new BigDecimal(Math.tan(getX().getValue().doubleValue()));
		}
		
		@Override
		public String toString() {
			return "tan(" + this.getX() + ")";
		}
	}

}
