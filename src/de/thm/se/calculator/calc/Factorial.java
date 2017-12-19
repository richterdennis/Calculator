package de.thm.se.calculator.calc;

import java.math.BigDecimal;
import java.math.BigInteger;

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
		long n = this.n.getValue().longValue();
		
		if(n <= 1)
			return BigDecimal.ONE;
		
        long r = 1;
		for(long i = 2; i <= n; i++) r *= i;
        return new BigDecimal(r);
	}
	
	@Override
	public String toString() {
		return this.n + "!";
	}

}
