package de.thm.se.calculator.calc;

/**
 * This implements Calculatable and provides one variable x
 * This class saves some code lines due to reusable x var
 * 
 * @author Dennis Richter
 */
abstract class AbstractCalculatable implements Calculatable {

	/**
	 * This is the initial value to do some maths with it
	 */
	private Calculatable x;
	
	/**
	 * Implement this constructor on child class
	 * 
	 * @param x The initial value
	 */
	public AbstractCalculatable(Calculatable x) {
		this.x = x;
	}
	
	/**
	 * Implement this constructor on child class
	 */
	public AbstractCalculatable() {
		this(new Decimal(0));
	}

	/**
	 * Gets the x
	 * @return x The initial value
	 */
	public Calculatable getX() {
		return x;
	}

	/**
	 * Sets the x
	 * @param x The initial value
	 */
	public void setX(Calculatable x) {
		this.x = x;
	}

}
