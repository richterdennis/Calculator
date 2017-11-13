package de.thm.se.calculator.calc;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * The Chain is the root Calculatable
 * It represents normal round brackets in a calculation
 * 
 * @author Dennis Richter
 *
 */
public class Chain implements Calculatable {

	private ArrayList<Operator> operators;
	private ArrayList<Calculatable> links;

	/**
	 * Create a chain with the first calculatable, the first chain link
	 * 
	 * @param firstlink
	 */
	public Chain(Calculatable firstlink) {
		this.operators = new ArrayList<>();
		this.links = new ArrayList<>();

		this.operators.add(Operator.PLUS);
		this.links.add(firstlink);
	}

	/**
	 * Create a chain
	 */
	public Chain() {
		this(new Decimal(0));
	}

	/**
	 * You can add operators without calculatables and add them later
	 * 
	 * @param operator The operator
	 * @return this for chaining
	 */
	public Chain addOperator(Operator operator) {
		this.operators.add(operator);
		
		return this;
	}

	/**
	 * If you add an operator before you can add a link without an operator, otherwise it uses PLUS as default operator
	 * 
	 * @param link
	 * @return this for chaining
	 */
	public Chain addLink(Calculatable link) {
		if(this.links.size() < this.operators.size()) {
			this.links.add(link);
			return this;
		}
			
		return this.addLink(Operator.PLUS, link);
	}

	/**
	 * Add a chain link to the chain
	 * 
	 * @param operator The operator
	 * @param link The calculatable
	 * @return this for chaining
	 */
	public Chain addLink(Operator operator, Calculatable link) {
		this.operators.add(operator);
		this.links.add(link);
		
		return this;
	}

	@Override
	public BigDecimal getValue() {
		BigDecimal val = BigDecimal.ZERO;
		Operator interimOperator = null;
		BigDecimal interim = null;

		for(int i = 0; i < this.links.size(); i++) {
			Operator operator = this.operators.get(i);
			Calculatable link = this.links.get(i);
			if(isPointOperator(i + 1) && interim == null) {
				interimOperator = operator;
				interim = link.getValue();
			}
			else if(isPointOperator(i + 1)) {
				interim = this.calc(interim, operator, link);
			}
			else if(interim == null) {
				val = this.calc(val, operator, link);
			}
			else {
				val = this.calc(val, interimOperator, this.calc(interim, operator, link));
				interim = null;
			}
		}

		if(interim != null) {
			val = this.calc(val, interimOperator, interim);
			interim = null;
		}

		return val;
	}

	private boolean isPointOperator(int pos) {
		if(pos >= this.links.size())
			return false;

		return this.operators.get(pos).isPointOperator();
	}

	private BigDecimal calc(BigDecimal a, Operator o, Calculatable b) {
		return this.calc(a, o, b.getValue());
	}

	private BigDecimal calc(BigDecimal a, Operator o, BigDecimal b) {
		return o.operate(a, b);
	}

	public String toString() {
		if(this.links.size() < 2)
			return this.links.get(0).toString();

		StringBuilder sb = new StringBuilder();
		
		sb.append("[ ");

		int i = 1;
		Calculatable firstlink = this.links.get(0);

		if(firstlink.getValue().equals(BigDecimal.ZERO)) {
			firstlink = this.links.get(1);
			i++;
		}

		sb.append(firstlink);

		for(; i < this.links.size(); i++) {
			sb.append(this.operators.get(i));
			sb.append(this.links.get(i));
		}
		
		sb.append(" ]");

		return sb.toString();
	}

}
