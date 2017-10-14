package de.thm.se.calculator.calc;

public class Sqrt extends Root {

	public Sqrt(Calculatable x) {
		super(x, new Decimal("2"));
	}
	
	public Sqrt() {
		super(new Decimal("0"), new Decimal("2"));
	}

	public void setY(Calculatable y) {
		throw new UnsupportedOperationException("Use Root not Sqrt to set y!");
	}
	
	@Override
	public String toString() {
		return "sqrt(" + this.x + ")";
	}

}
