package de.thm.se.calculator;

import de.thm.se.calculator.calc.Chain;
import de.thm.se.calculator.calc.Decimal;
import de.thm.se.calculator.calc.Operator;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
	
	// Parse TextField
	@FXML 
	TextField textField;
	
	@FXML
	Label resultLabel;
	
	// Collect the user input and create a calculatable later
	StringBuilder input = new StringBuilder();
	
	// This is the main calculatable
	Chain mainCalculatable = new Chain();
	
	public void shift() {
		System.out.println("SHIFT pressed");
	}

	public void left() {
		System.out.println("LEFT pressed");
	}

	public void top() {
		System.out.println("TOP pressed");
	}

	public void bottom() {
		System.out.println("BOTTOM pressed");
	}

	public void right() {
		System.out.println("RIGHT pressed");
	}

	@FXML
	public void zero() {
		input.append(0);
		
		textField.appendText("0");
		System.out.println("ZERO pressed");
	}

	@FXML
	public void one() {
		input.append(1);
		
		textField.appendText("1");
		System.out.println("ONE pressed");
	}

	@FXML
	public void two() {
		input.append(2);
		
		textField.appendText("2");
		System.out.println("TWO pressed");
	}

	@FXML
	public void three() {
		input.append(3);
		
		textField.appendText("3");
		System.out.println("THREE pressed");
	}

	@FXML
	public void four() {
		input.append(4);
		
		textField.appendText("4");
		System.out.println("FOUR pressed");
	}

	@FXML
	public void five() {
		input.append(5);
		
		textField.appendText("5");
		System.out.println("FIVE pressed");
	}
	
	@FXML
	public void six() {
		input.append(6);
		
		textField.appendText("6");
		System.out.println("SIX pressed");
	}
	
	@FXML	
	public void seven() {
		input.append(7);
		
		textField.appendText("7");
		System.out.println("SEVEN pressed");
	}

	@FXML
	public void eight() {
		input.append(8);
		
		textField.appendText("8");
		System.out.println("EIGHT pressed");
	}

	@FXML
	public void nine() {
		input.append(9);
		
		textField.appendText("9");
		System.out.println("NINE pressed");
	}

	@FXML
	public void comma() {
		input.append('.');
		
		textField.appendText(".");
		System.out.println("COMMA pressed");
	}

	@FXML
	public void plus_minus() {
		textField.appendText("-");
		System.out.println("PLUS_MINUS pressed");
	}

	@FXML
	public void clear() {
		input.setLength(0);
		mainCalculatable.clear();
		
		textField.clear();
		System.out.println("CLEAR pressed");
	}

	@FXML
	public void del() {
		System.out.println("DEL pressed");
	}

	@FXML
	public void multiply() {
		mainCalculatable.addLink(new Decimal(input.toString()));
		mainCalculatable.addOperator(Operator.MULTIPLY);
		input.setLength(0);
		
		textField.appendText("*");
		System.out.println("MULTIPLY pressed");
	}

	@FXML
	public void divide() {
		mainCalculatable.addLink(new Decimal(input.toString()));
		mainCalculatable.addOperator(Operator.DEVIDE);
		input.setLength(0);
		
		textField.appendText("/");
		System.out.println("DIVIDE pressed");
	}
		
	@FXML
	public void add() {
		mainCalculatable.addLink(new Decimal(input.toString()));
		mainCalculatable.addOperator(Operator.PLUS);
		input.setLength(0);
		
		textField.appendText("+");
		System.out.println("ADD pressed");
	}

	@FXML
	public void subtract() {
		mainCalculatable.addLink(new Decimal(input.toString()));
		mainCalculatable.addOperator(Operator.MINUS);
		input.setLength(0);
		
		textField.appendText("-");
		System.out.println("SUBTRACT pressed");
	}

	@FXML
	public void equals() {
		mainCalculatable.addLink(new Decimal(input.toString()));
		
		String calc = mainCalculatable.toString();
		String result = mainCalculatable.getValue().toString();
		
		input.setLength(0);
		mainCalculatable.clear();
		
		System.out.println(calc);
		System.out.println(result);
		
		String text = textField.getText();
		resultLabel.setText(text);
		System.out.println("EQUALS pressed");
	}

	public void last() {
		System.out.println("LAST pressed");
	}

	@FXML
	public void percent() {
		textField.appendText("%");
		System.out.println("PERCENT pressed");
	}

	@FXML
	public void pi() {
		textField.appendText("π");
		System.out.println("PI pressed");
	}
	
	@FXML
	public void e() {
		textField.appendText("e");
		System.out.println("E pressed");
	}

	public void power_e() {
		System.out.println("POWER_E pressed");
	}

	public void factorial() {
		textField.appendText("!");
		System.out.println("FACTORIAL pressed");
	}

	public void pleft() {
		System.out.println("PLEFT pressed");
	}

	public void pright() {
		System.out.println("PRIGHT pressed");
	}

	@FXML
	public void fracture() {
		textField.appendText("/");
		System.out.println("FRACTURE pressed");
	}

	@FXML
	public void sin() {
		textField.appendText("sin");
		System.out.println("SIN pressed");
	}

	@FXML
	public void cos() {
		textField.appendText("cos");
		System.out.println("COS pressed");
	}
	
	@FXML
	public void tan() {
		textField.appendText("tan");
		System.out.println("TAN pressed");
	}

	@FXML
	public void power() {
		textField.appendText("^");
		System.out.println("POWER pressed");
	}

	@FXML
	public void power_2() {
		textField.appendText("²");
		System.out.println("POWER_2 pressed");
	}
	
	@FXML
	public void root() {
		textField.appendText("√");
		System.out.println("ROOT pressed");
	}

	@FXML
	public void sroot() {
		textField.appendText("√");
		System.out.println("SROOT pressed");
	}

	@FXML
	public void log() {
		textField.appendText("log");
		System.out.println("LOG pressed");
	}

	@FXML
	public void ln() {
		textField.appendText("ln");
		System.out.println("LN pressed");
	}
}
