package de.thm.se.calculator.calc;

import java.math.BigDecimal;

public class Power implements Calculatable {
	
	Calculatable x;
	Calculatable y;
	
	public Power(Calculatable x, Calculatable y) {
		this.x = x;
		this.y = y;
	}
	
	public Power() {
		this(new Decimal(0),new Decimal(1));
	}

	public Calculatable getX() {
		return x;
	}

	public void setX(Calculatable x) {
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
		return new BigDecimal(Math.pow(x.getValue().doubleValue(), y.getValue().doubleValue()));
	}
	
	@Override
	public String toString() {
		return "(" + this.x + "^" + this.y + ")";
	}

}
