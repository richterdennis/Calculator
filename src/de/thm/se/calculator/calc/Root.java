package de.thm.se.calculator.calc;

import java.math.BigDecimal;

public class Root implements Calculatable {
	
	Calculatable x;
	Calculatable y;

	public Root(Calculatable x, Calculatable y) {
		this.setX(x);
		this.setY(y);
	}

	public Root(Calculatable x) {
		this(x, new Decimal("2"));
	}
	
	public Root() {
		this(new Decimal("0"), new Decimal("2"));
	}
	
	public Calculatable getX() {
		return x;
	}

	public void setX(Calculatable x) {
		// x < 0
		if(x.getValue().compareTo(BigDecimal.ZERO) < 0)
			throw new ArithmeticException("Can not root of negative numbers");
		
		this.x = x;
	}

	public Calculatable getY() {
		return y;
	}

	public void setY(Calculatable y) {
		this.y = y;
	}

	@Override
	public BigDecimal getValue() {
		return new Power(getX(), new Fracture(new Decimal("1"), getY())).getValue();
	}
	
	@Override
	public String toString() {
		return "sqrt_" + this.y + "(" + this.x + ")";
	}

}
