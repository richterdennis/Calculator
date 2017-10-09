package de.thm.se.calculator.calc;

import java.math.BigDecimal;

/**
 * A factorial is the product of all positive integers less than or equal to n
 * 
 * @author Dennis Richter
 */
public class Factorial implements Calculatable {
	
	Calculatable n;
	
	public Factorial(Calculatable n) {
		this.n = n;
	}
	
	public Factorial() {
		this(new Decimal(0));
	}

	public Calculatable getN() {
		return n;
	}

	public void setN(Calculatable n) {
		this.n = n;
	}

	@Override
	public BigDecimal getValue() {
		int n = this.n.getValue().intValue();
		
		if(n <= 1)
			return BigDecimal.ONE;
		
        int r = 1;
		for(int i = 2; i <= n; i++) r *= i;
        return new BigDecimal(r);
	}
	
	@Override
	public String toString() {
		return this.n + "!";
	}

}
