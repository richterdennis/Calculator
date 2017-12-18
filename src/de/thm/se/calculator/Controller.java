package de.thm.se.calculator;

import de.thm.se.calculator.calc.Chain;
import de.thm.se.calculator.calc.Decimal;
import de.thm.se.calculator.calc.Operator;
import de.thm.se.calculator.calc.Trigonometric;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller{
	
	// Parse TextField
	@FXML 
	TextField textField;
	
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
		
		textFieldString = textFieldString + "0";
		textField.clear();
		textField.appendText(textFieldString);
	}

	@FXML
	public void one() {
		input.append(1);
		
		System.out.println("ONE pressed");
		
		textFieldString = textFieldString + "1";
		textField.clear();
		textField.appendText(textFieldString);
	}

	@FXML
	public void two() {
		input.append(2);
		
		System.out.println("TWO pressed");
		
		textFieldString = textFieldString + "2";
		textField.clear();
		textField.appendText(textFieldString);
	}

	@FXML
	public void three() {
		input.append(3);
		
		System.out.println("THREE pressed");
		
		textFieldString = textFieldString + "3";
		textField.clear();
		textField.appendText(textFieldString);
	}

	@FXML
	public void four() {
		input.append(4);
		
		System.out.println("FOUR pressed");
		
		textFieldString = textFieldString + "4";
		textField.clear();
		textField.appendText(textFieldString);
	}

	@FXML
	public void five() {
		input.append(5);
		
		System.out.println("FIVE pressed");
		
		textFieldString = textFieldString + "5";
		textField.clear();
		textField.appendText(textFieldString);
	}
	
	@FXML
	public void six() {
		input.append(6);
		
		System.out.println("SIX pressed");
		
		textFieldString = textFieldString + "6";
		textField.clear();
		textField.appendText(textFieldString);
	}
	
	@FXML	
	public void seven() {
		input.append(7);
		
		System.out.println("SEVEN pressed");
		
		textFieldString = textFieldString + "7";
		textField.clear();
		textField.appendText(textFieldString);
	}

	@FXML
	public void eight() {
		input.append(8);
		
		System.out.println("EIGHT pressed");
		
		textFieldString = textFieldString + "8";
		textField.clear();
		textField.appendText(textFieldString);
	}

	@FXML
	public void nine() {
		input.append(9);
		
		System.out.println("NINE pressed");
		
		textFieldString = textFieldString + "9";
		textField.clear();
		textField.appendText(textFieldString);
	}

	@FXML
	public void comma() {
		input.append('.');
		
		System.out.println("COMMA pressed");
		
		textFieldString = textFieldString + ".";
		textField.clear();
		textField.appendText(textFieldString);
	}

	@FXML
	public void plus_minus() {
		if (input.length() == 0){
			input.append("-");
			
			textFieldString = textFieldString + "-";
			textField.clear();
			textField.appendText(textFieldString);
		}
		System.out.println("PLUS_MINUS pressed");
	}

	@FXML
	public void clear() {
		input.setLength(0);
		mainCalculatable.clear();
		
		System.out.println("CLEAR pressed");
		
		textFieldString = "";
		textField.clear();
		textField.appendText(textFieldString);
	}

	@FXML
	public void del() {
		System.out.println("DEL pressed");
		if (input.length() > 0) {
            input.setLength(input.length() - 1);
            textFieldString = textFieldString.substring(0, textFieldString.length() -1);
            textField.deleteText(textField.getLength() - 1, textField.getLength());
        }
	}

	@FXML
	public void multiply() {
		mainCalculatable.addLink(new Decimal(input.toString()));
		mainCalculatable.addOperator(Operator.MULTIPLY);
		
		input.setLength(0);
		
		textFieldString = textFieldString + "*";
		textField.clear();
		textField.appendText(textFieldString);
		System.out.println("MULTIPLY pressed");
	}

	@FXML
	public void divide() {
		mainCalculatable.addLink(new Decimal(input.toString()));
		mainCalculatable.addOperator(Operator.DEVIDE);
		input.setLength(0);
		
		textFieldString = textFieldString + "/";
		textField.clear();
		textField.appendText(textFieldString);
		System.out.println("DIVIDE pressed");
	}
		
	@FXML
	public void add() {
		mainCalculatable.addLink(new Decimal(input.toString()));
		mainCalculatable.addOperator(Operator.PLUS);
		
		input.setLength(0);
		
		textFieldString = textFieldString + "+";
		textField.clear();
		textField.appendText(textFieldString);
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
		
		resultLabel.setText(textFieldString);
		textField.setText(result);
		input.append(result);
		System.out.println("EQUALS pressed");
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

	@FXML
	public void power_e() {
		System.out.println("POWER_E pressed");
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
		Trigonometric.Sin sinus = new Trigonometric.Sin(new Decimal(input.toString()));
		textFieldString = textFieldString.replace(input.toString(), sinus.toString());
		
		textField.clear();
		textField.appendText(textFieldString);
		input.setLength(0);
		input.append(sinus.getValue().toString());
		System.out.println(textFieldString);
	}

	@FXML
	public void cos() {
		Trigonometric.Cos cosinus = new Trigonometric.Cos(new Decimal(input.toString()));
		textFieldString = textFieldString.replace(input.toString(), cosinus.toString());
		

		textField.clear();
		textField.appendText(textFieldString);
		input.setLength(0);
		input.append(cosinus.getValue().toString());
	}
	
	@FXML
	public void tan() {
		Trigonometric.Tan tangens = new Trigonometric.Tan(new Decimal(input.toString()));
		textFieldString = textFieldString.replace(input.toString(), tangens.toString());
		
		textField.clear();
		textField.appendText(textFieldString);
		input.setLength(0);
		input.append(tangens.getValue().toString());
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
	
	@FXML
	public void deg() {
	}
	
	@FXML
	public void rad() {
	}
}
