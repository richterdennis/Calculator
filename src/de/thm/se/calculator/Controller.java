package de.thm.se.calculator;

import java.util.Optional;

import de.thm.se.calculator.calc.Chain;
import de.thm.se.calculator.calc.Decimal;
import de.thm.se.calculator.calc.Fracture;
import de.thm.se.calculator.calc.Operator;
import de.thm.se.calculator.calc.Power;
import de.thm.se.calculator.calc.Trigonometric;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.util.Pair;

public class Controller{
	
	// Parse TextField
	@FXML 
	TextField textField;
	
	@FXML
	Button powerB;
	
	String bas;
	String exp;
	
	String textFieldString ="";
	
	@FXML
	Label resultLabel;
	
	// Collect the user input and create a calculatable later
	StringBuilder input = new StringBuilder();
	
	// This is the main calculatable
	Chain mainCalculatable = new Chain();
	
/* public void shift() {
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
*/

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
		if (input.length() == 0){
			input.append("-");
			
			textField.appendText("-");
		}
		System.out.println("PLUS_MINUS pressed");
	}

	@FXML
	public void clear() {
		input.setLength(0);
		mainCalculatable.clear();
		
		System.out.println("CLEAR pressed");
		
		textField.clear();
	}

	@FXML
	public void del() {
		System.out.println("DEL pressed");
		if (input.length() > 0) {
            input.setLength(input.length() - 1);
            textField.deleteText(textField.getLength() - 1, textField.getLength());
        }
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
		
		textFieldString = textFieldString + "-";
		textField.clear();
		textField.appendText(textFieldString);
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
		
		resultLabel.setText(textField.getText());
		textField.setText(result);
		input.append(result);
		System.out.println("EQUALS pressed");
	}

	@FXML
	public void percent() {
		Fracture per = new Fracture(new Decimal(input.toString()), new Decimal(100));
		input.setLength(0);
		input.append(per.getValue().toString());
		
		textField.appendText("%");
		System.out.println("PERCENT pressed");
		
		/* Fracture per = new Fracture(new Decimal(input.toString()), new Decimal(100));
		System.out.println(per);
		System.out.println(input);
		input.setLength(0);
		System.out.println(input);
		input.append(per.toString());
		System.out.println(input);
		textField.appendText("%");
		System.out.println("Percent pressed"); */
	}

	@FXML
	public void pi() {
		//if (input.length() == 0 ) {
		
		input.append(Math.PI); 
		/*}
		else {
			mainCalculatable.addLink(new Decimal(input.toString()));
			mainCalculatable.addOperator(Operator.MULTIPLY);
			input.setLength(0);
			input.append(Math.PI);
		} */
		textField.appendText("π");
		System.out.println("PI pressed");
	}
	
	@FXML
	public void e() {
	//if (input.length() == 0 ) {
		
		input.append(Math.E); 
		/*}
		else {
			mainCalculatable.addLink(new Decimal(input.toString()));
			mainCalculatable.addOperator(Operator.MULTIPLY);
			input.setLength(0);
			input.append(Math.PI);
		} */
		textField.appendText("e");
		System.out.println("e pressed");
		
	}

	@FXML
	public void power_e() {
				// Create a temporary String to save the Value for the e
				String temp = input.toString();
				// Create new e-Object
				Double exp = Math.exp(new Double(temp));
				// Replace the Number with e-expression
				temp = temp.replace(input.toString(), "e^" + temp);
				// Delete the converted e out of the Textfield
				textField.deleteText(textField.getLength() - input.toString().length(), textField.getLength());
				// Append the Sin-expression from temporary String into the Textfield
				textField.appendText(temp);
				// Clear Inputstring
				input.setLength(0);
				// Append the Value of the e-Expression to the Inputstring
				input.append(exp.toString());
				// Test Systemout
				System.out.println(textFieldString);
	}

	@FXML
	public void factorial() {
		textField.appendText("!");
		System.out.println("FACTORIAL pressed");
	}
	
	@FXML
	public void pleft() {
		input.append('(');
		textField.appendText("(");
		System.out.println("PLEFT pressed");
	}

	@FXML
	public void pright() {
		input.append(')');
		textField.appendText(")");
		System.out.println("PRIGHT pressed");
	}

	@FXML
	public void fracture() {
		textField.appendText("/");
		System.out.println("FRACTURE pressed");
	}

	@FXML
	public void sin() {
		// Create new Sin-Object
		Trigonometric.Sin sinus = new Trigonometric.Sin(new Decimal(input.toString()));
		// Create a temporary String to save the Value for the Sin
		String temp = input.toString();
		// Replace the Number with Sin-expression
		temp = temp.replace(input.toString(), sinus.toString());
		
		// Delete the Converted Sin out of the Textfield
		textField.deleteText(textField.getLength() - input.toString().length(), textField.getLength());
		// Append the Sin-expression from temporary String into the Textfield
		textField.appendText(temp);
		// Clear Inputstring
		input.setLength(0);
		// Append the Value of the Sin to the Inputstring
		input.append(sinus.getValue().toString());
		// Test Systemout
		System.out.println(textFieldString);
	}

	@FXML
	public void cos() {
		Trigonometric.Cos cosinus = new Trigonometric.Cos(new Decimal(input.toString()));
		String temp = input.toString();
		temp = temp.replace(input.toString(), cosinus.toString());
		
		textField.deleteText(textField.getLength() - input.toString().length(), textField.getLength());
		textField.appendText(temp);
		input.setLength(0);
		input.append(cosinus.getValue().toString());
		System.out.println(textFieldString);
	}
	
	@FXML
	public void tan() {
		Trigonometric.Tan tangens = new Trigonometric.Tan(new Decimal(input.toString()));
		textFieldString = textFieldString.replace(input.toString(), tangens.toString());
		
		String temp = input.toString();
		temp = temp.replace(input.toString(), tangens.toString());
		
		textField.deleteText(textField.getLength() - input.toString().length(), textField.getLength());
		textField.appendText(temp);
		input.setLength(0);
		input.append(tangens.getValue().toString());
		System.out.println(textFieldString);
	}
	
	@FXML
	public void arcsin() {
		// Create new Sin-Object
		Trigonometric.Arcsin arcsinus = new Trigonometric.Arcsin(new Decimal(input.toString()));
		// Create a temporary String to save the Value for the Sin
		String temp = input.toString();
		// Replace the Number with Sin-expression
		temp = temp.replace(input.toString(), arcsinus.toString());
		
		// Delete the Converted Sin out of the Textfield
		textField.deleteText(textField.getLength() - input.toString().length(), textField.getLength());
		// Append the Sin-expression from temporary String into the Textfield
		textField.appendText(temp);
		// Clear Inputstring
		input.setLength(0);
		// Append the Value of the Sin to the Inputstring
		input.append(arcsinus.getValue().toString());
		// Test Systemout
		System.out.println(textFieldString);
	}
	
	@FXML
	public void arccos() {
		Trigonometric.Arccos arccosinus = new Trigonometric.Arccos(new Decimal(input.toString()));
		String temp = input.toString();
		temp = temp.replace(input.toString(), arccosinus.toString());
		
		textField.deleteText(textField.getLength() - input.toString().length(), textField.getLength());
		textField.appendText(temp);
		input.setLength(0);
		input.append(arccosinus.getValue().toString());
		System.out.println(textFieldString);
	}
	
	@FXML
	public void arctan() {
		Trigonometric.Arctan arctangens = new Trigonometric.Arctan(new Decimal(input.toString()));
		textFieldString = textFieldString.replace(input.toString(), arctangens.toString());
		
		String temp = input.toString();
		temp = temp.replace(input.toString(), arctangens.toString());
		
		textField.deleteText(textField.getLength() - input.toString().length(), textField.getLength());
		textField.appendText(temp);
		input.setLength(0);
		input.append(arctangens.getValue().toString());
		System.out.println(textFieldString);
		
	}
	
	

	@FXML
	public void power() {
		    DialogCreator test = new DialogCreator("Bitte Exponent und Basis eingeben", "Basis", "Exponent");
		    test.show();
		    Power pow = new Power(new Decimal(test.getOne()), new Decimal(test.getTwo()));
		    System.out.println(pow.toString());
		    System.out.println(pow.getValue().toString());
		    input.append(pow.getValue().toString());
		    textField.appendText(pow.toString());
		    
		
	}

	@FXML
	public void power_2() {
		textField.appendText("Â²");
		System.out.println("POWER_2 pressed");
	}
	
	@FXML
	public void root() {
		textField.appendText("âˆš");
		System.out.println("ROOT pressed");
	}

	@FXML
	public void sroot() {
		textField.appendText("âˆš");
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
	
	@FXML
	public void deg() {
	}
	
	@FXML
	public void rad() {
	}
}

/* // Create a temporary String to save the Value for the e
String temp = input.toString();
// Create new e-Object
Double exp = Math.exp(new Double(temp));
// Replace the Number with e-expression
temp = temp.replace(input.toString(), "e^" + temp);
// Delete the converted e out of the Textfield
textField.deleteText(textField.getLength() - input.toString().length(), textField.getLength());
// Append the Sin-expression from temporary String into the Textfield
textField.appendText(temp);
// Clear Inputstring
input.setLength(0);
// Append the Value of the e-Expression to the Inputstring
input.append(exp.toString());
// Test Systemout
System.out.println(textFieldString); */