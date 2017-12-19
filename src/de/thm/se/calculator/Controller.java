package de.thm.se.calculator;

import java.net.URL;
import java.util.ResourceBundle;

import de.thm.se.calculator.calc.Chain;
import de.thm.se.calculator.calc.Decimal;
import de.thm.se.calculator.calc.Factorial;
import de.thm.se.calculator.calc.Fracture;
import de.thm.se.calculator.calc.Ln;
import de.thm.se.calculator.calc.Log;
import de.thm.se.calculator.calc.Operator;
import de.thm.se.calculator.calc.Power;
import de.thm.se.calculator.calc.Root;
import de.thm.se.calculator.calc.Trigonometric;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;

public class Controller implements Initializable{
	
	// Parse TextField
	@FXML
	TextField textField;
	
	@FXML
	Button powerB;

	// Toggle Button for deg/rad
	@FXML
	ToggleButton degradButton;

	// Label for result of the calculation
	@FXML
	Label resultLabel;

	@FXML
	Label errorLabel;

	
	// Buffer for result
	String result;

	// Collect the user input and create a calculatable later
	StringBuilder input = new StringBuilder();

	// This is the main calculatable
	Chain mainCalculatable = new Chain();
	
	// Buffer Calculatable
	Chain focus = mainCalculatable;

	// Result Button
	@FXML
	Button answer;
	
	// Set Result as primary Button (Onlick --> Enter)
	public void initialize(URL location, ResourceBundle resources) {
		answer.setDefaultButton(true);
		
	}

	@FXML
	public void zero() {
		input.append(0);

		System.out.println("ZERO pressed");

		textField.appendText("0");
	}

	@FXML
	public void one() {
		input.append(1);

		System.out.println("ONE pressed");

		textField.appendText("1");
	}

	@FXML
	public void two() {
		input.append(2);

		System.out.println("TWO pressed");

		textField.appendText("2");
	}

	@FXML
	public void three() {
		input.append(3);

		System.out.println("THREE pressed");

		textField.appendText("3");
	}

	@FXML
	public void four() {
		input.append(4);

		System.out.println("FOUR pressed");

		textField.appendText("4");
	}

	@FXML
	public void five() {
		input.append(5);

		System.out.println("FIVE pressed");

		textField.appendText("5");
	}

	@FXML
	public void six() {
		input.append(6);

		System.out.println("SIX pressed");

		textField.appendText("6");
	}

	@FXML
	public void seven() {
		input.append(7);

		System.out.println("SEVEN pressed");

		textField.appendText("7");
	}

	@FXML
	public void eight() {
		input.append(8);

		System.out.println("EIGHT pressed");

		textField.appendText("8");
	}

	@FXML
	public void nine() {
		input.append(9);

		System.out.println("NINE pressed");

		textField.appendText("9");
	}

	@FXML
	public void comma() {
		input.append('.');

		System.out.println("COMMA pressed");

		textField.appendText(".");
	}

	@FXML
	public void plus_minus() {
		if(input.length() == 0) {
			input.append("-");

			textField.appendText("-");
		}
		System.out.println("PLUS_MINUS pressed");
	}

	@FXML
	public void clear() {
		input.setLength(0);
		mainCalculatable.clear();
		focus = mainCalculatable;

		System.out.println("CLEAR pressed");

		textField.clear();
	}

	@FXML
	public void del() {
		if(input.length() > 0) {
			input.setLength(input.length() - 1);
			textField.deleteText(textField.getLength() - 1, textField.getLength());
		}
		
		System.out.println("DEL pressed");
	}

	@FXML
	public void multiply() {
		if(input.length() > 0)
			focus.addLink(new Decimal(input.toString()));
		focus.addOperator(Operator.MULTIPLY);

		input.setLength(0);

		textField.appendText("*");
		System.out.println("MULTIPLY pressed");
	}

	@FXML
	public void divide() {
		if(input.length() > 0)
			focus.addLink(new Decimal(input.toString()));
		focus.addOperator(Operator.DEVIDE);
		input.setLength(0);

		textField.appendText("/");
		System.out.println("DIVIDE pressed");
	}

	@FXML
	public void add() {
		if(input.length() > 0)
			focus.addLink(new Decimal(input.toString()));
		focus.addOperator(Operator.PLUS);

		input.setLength(0);

		textField.appendText("+");
		System.out.println("ADD pressed");
	}

	@FXML
	public void subtract() {
		if(input.length() > 0)
			focus.addLink(new Decimal(input.toString()));
		focus.addOperator(Operator.MINUS);

		input.setLength(0);

		textField.appendText("-");
		System.out.println("SUBTRACT pressed");
	}

	@FXML
	public void equals() {
		// If Input is present convert to Calculatable
		if(input.length() > 0)
			focus.addLink(new Decimal(input.toString()));
		
		// Convert the Calculatable to a String
		String calc = mainCalculatable.toString();
		result = mainCalculatable.getValue().toString();

		// Clear the Calculatable/Input
		input.setLength(0);
		mainCalculatable.clear();

		
		// Trim Result to 30 Digits
		if(result.length() > 30) {
		result = result.substring(0, 29);
		}

		// Set Resultlabel and Textfield
		resultLabel.setText(textField.getText());
		textField.setText(result);
		input.append(result);
		
		System.out.println(calc);
		System.out.println(result);
		System.out.println("EQUALS pressed");
	}

	@FXML
	public void percent() {
		focus.addLink(new Fracture(new Decimal(input.toString()), new Decimal(100)));

		input.setLength(0);

		textField.appendText("%");
		System.out.println("PERCENT pressed");
	}

	@FXML
	public void pi() {
		if(input.length() == 0) {
			focus.addLink(new Decimal(Math.PI));
			}
		else {
			focus.addLink(new Decimal(input.toString()));
			focus.addOperator(Operator.MULTIPLY);
			focus.addLink(new Decimal(Math.PI));
			input.setLength(0);
		}
		textField.appendText("π");
		System.out.println("pi pressed");
	}

	@FXML
	public void e() {
		if(input.length() == 0) {
			focus.addLink(new Decimal(Math.E));
			textField.appendText("e");
		}
		else {
			focus.addLink(new Decimal(input.toString()));
			focus.addOperator(Operator.MULTIPLY);
			focus.addLink(new Decimal(Math.E));
			textField.appendText("*e");
			
			input.setLength(0);
		}
		System.out.println("e pressed");

	}

	@FXML
	public void factorial() {
		if (input.length() != 0 ) {
				Factorial fac = new Factorial(new Decimal(input.toString()));
				textField.appendText("!");
				input.setLength(0);
				input.append(fac.getValue());
			}
		System.out.println("FACTORIAL pressed");
	}

	@FXML
	public void pleft() {
		Chain c = new Chain();
		
		if(input.length() == 0) {
			focus.addLink(c);
		}
		else {
			focus.addLink(new Decimal(input.toString()));
			focus.addOperator(Operator.MULTIPLY);
			focus.addLink(c);
			
			input.setLength(0);
		}
		
		c.setParent(focus);
		focus = c;
		
		textField.appendText("(");
		System.out.println("PLEFT pressed");
	}

	@FXML
	public void pright() {
		if(input.length() > 0)
			focus.addLink(new Decimal(input.toString()));

		input.setLength(0);
		
		focus = focus.getParent();
		
		textField.appendText(")");
		System.out.println("PRIGHT pressed");
	}

	@FXML
	public void fracture() {
		DialogCreator test = new DialogCreator("Bruch", "Bitte Zähler und Nenner eingeben", "Zähler", "Nenner");
		Chain c = new Chain();
		Fracture fra = new Fracture(new Decimal(test.getOne()), new Decimal(test.getTwo()));
		if(input.length() == 0) {
			focus.addLink(fra);
		}
		else {
			focus.addLink(new Decimal(input.toString()));
			focus.addOperator(Operator.MULTIPLY);
			focus.addLink(fra);
			input.setLength(0);
			textField.appendText("*");
		}

		c.setParent(focus);
		focus = c;
		textField.appendText(fra.toString());
		
		System.out.println("FRACTURE pressed");
	}

	@FXML
	public void sin() {
		Chain c = new Chain();
		
		if(input.length() == 0) {
			focus.addLink(new Trigonometric.Sin(c));
		}
		else {
			focus.addLink(new Decimal(input.toString()));
			focus.addOperator(Operator.MULTIPLY);
			focus.addLink(new Trigonometric.Sin(c));
			
			input.setLength(0);
		}
		
		c.setParent(focus);
		focus = c;
		
		textField.appendText("sin(");
		System.out.println("SIN pressed");
	}

	@FXML
	public void cos() {
		Chain c = new Chain();
		
		if(input.length() == 0) {
			focus.addLink(new Trigonometric.Cos(c));
		}
		else {
			focus.addLink(new Decimal(input.toString()));
			focus.addOperator(Operator.MULTIPLY);
			focus.addLink(new Trigonometric.Cos(c));
			
			input.setLength(0);
		}
		
		c.setParent(focus);
		focus = c;
		
		textField.appendText("cos(");
		System.out.println("COS pressed");
	}

	@FXML
	public void tan() {
		Chain c = new Chain();
		
		if(input.length() == 0) {
			focus.addLink(new Trigonometric.Tan(c));
		}
		else {
			focus.addLink(new Decimal(input.toString()));
			focus.addOperator(Operator.MULTIPLY);
			focus.addLink(new Trigonometric.Tan(c));
			
			input.setLength(0);
		}
		
		c.setParent(focus);
		focus = c;
		
		textField.appendText("tan(");
		System.out.println("TAN pressed");
	}

	@FXML
	public void arcsin() {
		Chain c = new Chain();
		
		if(input.length() == 0) {
			focus.addLink(new Trigonometric.Arcsin(c));
		}
		else {
			focus.addLink(new Decimal(input.toString()));
			focus.addOperator(Operator.MULTIPLY);
			focus.addLink(new Trigonometric.Arcsin(c));
			
			input.setLength(0);
		}
		
		c.setParent(focus);
		focus = c;
		
		textField.appendText("arcsin(");
		System.out.println("ARCSIN pressed");
	}

	@FXML
	public void arccos() {
		Chain c = new Chain();
		
		if(input.length() == 0) {
			focus.addLink(new Trigonometric.Arccos(c));
		}
		else {
			focus.addLink(new Decimal(input.toString()));
			focus.addOperator(Operator.MULTIPLY);
			focus.addLink(new Trigonometric.Arccos(c));
			
			input.setLength(0);
		}
		
		c.setParent(focus);
		focus = c;
		
		textField.appendText("arccos(");
		System.out.println("ARCCOS pressed");
	}

	@FXML
	public void arctan() {
		Chain c = new Chain();
		
		if(input.length() == 0) {
			focus.addLink(new Trigonometric.Arctan(c));
		}
		else {
			focus.addLink(new Decimal(input.toString()));
			focus.addOperator(Operator.MULTIPLY);
			focus.addLink(new Trigonometric.Arctan(c));
			
			input.setLength(0);
		}
		
		c.setParent(focus);
		focus = c;
		
		textField.appendText("arctan(");
		System.out.println("ARCTAN pressed");
	}

	@FXML
	public void power() {
		DialogCreator test = new DialogCreator("Exponential", "Bitte Exponent und Basis eingeben", "Basis", "Exponent");
	
		Chain c = new Chain();
		Power pow = new Power(new Decimal(test.getOne()), new Decimal(test.getTwo()));
		if(input.length() == 0) {
			focus.addLink(pow);
		}
		else {
			focus.addLink(new Decimal(input.toString()));
			focus.addOperator(Operator.MULTIPLY);
			focus.addLink(pow);
			input.setLength(0);
			textField.appendText("*");
		}

		c.setParent(focus);
		focus = c;
		textField.appendText(pow.toString());
		System.out.println("POWER pressed");
	}

	@FXML
	public void power_2() {
		if(input.length() != 0) {
			Power pow = new Power(new Decimal(input.toString()), new Decimal(2));
			textField.appendText("²");
			input.setLength(0);
			input.append(pow.getValue());
		}
		System.out.println("POWER2 pressed");

	}

	@FXML
	public void root() {
		DialogCreator test = new DialogCreator("Wurzel", "Bitte Wurzelexponent und Radikant eingeben", "Wurzelexponent", "Radikant");

		Chain c = new Chain();
		Root roo = new Root(new Decimal(test.getTwo()), new Decimal(test.getOne()));
		if(input.length() == 0) {
			focus.addLink(roo);
		}
		else {
				focus.addLink(new Decimal(input.toString()));
				focus.addOperator(Operator.MULTIPLY);
				focus.addLink(roo);
				input.setLength(0);
				textField.appendText("*");
		}
		c.setParent(focus);
		focus = c;
		textField.appendText(roo.toString());
		System.out.println("ROOT pressed");

	}

	@FXML
	public void sroot() {
		Chain c = new Chain();
		
		if(input.length() == 0) {
			focus.addLink(new Root(c));
		}
		else {
			focus.addLink(new Decimal(input.toString()));
			focus.addOperator(Operator.MULTIPLY);
			focus.addLink(new Root(c));
			input.setLength(0);
		}
		
		c.setParent(focus);
		focus = c;
		textField.appendText("sqrt(");
		
		System.out.println("SROOT pressed");
	}

	@FXML
	public void log() {
		DialogCreator test = new DialogCreator("Logarithmus", "Bitte Basis und Numerus eingeben", "Basis", "Numerus");
		Chain c = new Chain();
		Log log = new Log(new Decimal(test.getOne()), new Decimal(test.getTwo()));
		if(input.length() == 0) {
			focus.addLink(log);
		}
		else {
			focus.addLink(new Decimal(input.toString()));
			focus.addOperator(Operator.MULTIPLY);
			focus.addLink(log);
			input.setLength(0);
			textField.appendText("*");
		}

		c.setParent(focus);
		focus = c;
		textField.appendText(log.toString());
		System.out.println("LOG pressed");
	}

	@FXML
	public void ln() {
		Chain c = new Chain();
		
		if(input.length() == 0) {
			focus.addLink(new Ln(c));
		}
		else {
			focus.addLink(new Decimal(input.toString()));
			focus.addOperator(Operator.MULTIPLY);
			focus.addLink(new Ln(c));
			
			input.setLength(0);
		}
		
		c.setParent(focus);
		focus = c;
		
		textField.appendText("ln(");
		System.out.println("LN pressed");
	}
	
	@FXML
	public void e_power() {
		Chain c = new Chain();
		
		if(input.length() == 0) {
			focus.addLink(new Power(new Decimal(Math.E), c));
		}
		else {
			focus.addLink(new Decimal(input.toString()));
			focus.addOperator(Operator.MULTIPLY);
			focus.addLink(new Power(new Decimal(Math.E), c));
			
			input.setLength(0);
		}
		
		c.setParent(focus);
		focus = c;
		
		textField.appendText("e^");
		
		System.out.println("EPOWER pressed");
		
	}

	@FXML
	public void ans() {
		textField.appendText(result);
		input.append(result);
		
		System.out.println("ANS pressed");
	}
}
