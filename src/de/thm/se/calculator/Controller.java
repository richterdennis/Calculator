package de.thm.se.calculator;

import de.thm.se.calculator.calc.Chain;
import de.thm.se.calculator.calc.Decimal;
import de.thm.se.calculator.calc.Fracture;
import de.thm.se.calculator.calc.Ln;
import de.thm.se.calculator.calc.Log;
import de.thm.se.calculator.calc.Operator;
import de.thm.se.calculator.calc.Power;
import de.thm.se.calculator.calc.Root;
import de.thm.se.calculator.calc.Sqrt;
import de.thm.se.calculator.calc.Trigonometric;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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
	
	@FXML
	Label errorLabel;
	
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
		if (input.length() == 0 ) {
			
			input.append(Math.PI);
			textField.appendText("π");
			}
			else {
				mainCalculatable.addLink(new Decimal(input.toString()));
				mainCalculatable.addOperator(Operator.MULTIPLY);
				textField.appendText("*π");
				input.setLength(0);
				input.append(Math.PI);
			}
			System.out.println("pi pressed");
	}
	
	@FXML
	public void e() {
	if (input.length() == 0 ) {
		
		input.append(Math.E);
		textField.appendText("e");
		input.setLength(0);
		}
		else {
			mainCalculatable.addLink(new Decimal(input.toString()));
			mainCalculatable.addOperator(Operator.MULTIPLY);
			textField.appendText("*e");
			input.setLength(0);
			input.append(Math.E);
		}
		System.out.println("e pressed");
		
	}

	@FXML
	public void power_e() {
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
		 DialogCreator test = new DialogCreator("Bruch", "Bitte Zähler und Nenner eingeben", "Zähler", "Nenner");
		 Fracture fra = new Fracture(new Decimal(test.getOne()), new Decimal(test.getTwo()));
		 System.out.println(fra.toString());
		 System.out.println(fra.getValue().toString());
		 input.append(fra.getValue().toString());
		 textField.appendText(fra.toString());   
	}

	@FXML
	public void sin() {
		TextDialogCreator dialog = new TextDialogCreator("Sinus", "Bitte Wert eingeben", "sin");
		Trigonometric.Sin sin = new Trigonometric.Sin(new Decimal(dialog.getValue()));
	    System.out.println(sin.getValue().toString());
	    System.out.println(sin.toString());
	    input.append(sin.getValue().toString());
	    textField.appendText(sin.toString());
	}

	@FXML
	public void cos() {
		TextDialogCreator dialog = new TextDialogCreator("Cosinus", "Bitte Wert eingeben", "cos");
		Trigonometric.Cos cos = new Trigonometric.Cos(new Decimal(dialog.getValue()));
	    System.out.println(cos.getValue().toString());
	    System.out.println(cos.toString());
	    input.append(cos.getValue().toString());
	    textField.appendText(cos.toString());
		    
	}
	
	@FXML
	public void tan() {
		TextDialogCreator dialog = new TextDialogCreator("Tangens", "Bitte Wert eingeben", "tan");
		Trigonometric.Tan tan = new Trigonometric.Tan(new Decimal(dialog.getValue()));
	    System.out.println(tan.getValue().toString());
	    System.out.println(tan.toString());
	    input.append(tan.getValue().toString());
	    textField.appendText(tan.toString());
	}
	
	@FXML
	public void arcsin() {
		TextDialogCreator dialog = new TextDialogCreator("Arkussinus", "Bitte Wert eingeben", "arcsin");
		Trigonometric.Arcsin arcsin = new Trigonometric.Arcsin(new Decimal(dialog.getValue()));
	    System.out.println(arcsin.getValue().toString());
	    System.out.println(arcsin.toString());
	    input.append(arcsin.getValue().toString());
	    textField.appendText(arcsin.toString());
	}
	
	@FXML
	public void arccos() {
		TextDialogCreator dialog = new TextDialogCreator("Arkuscosinus", "Bitte Wert eingeben", "arccos");
		Trigonometric.Arccos arccos = new Trigonometric.Arccos(new Decimal(dialog.getValue()));
	    System.out.println(arccos.getValue().toString());
	    System.out.println(arccos.toString());
	    input.append(arccos.getValue().toString());
	    textField.appendText(arccos.toString());
	}
	
	@FXML
	public void arctan() {
		TextDialogCreator dialog = new TextDialogCreator("Arkustangens", "Bitte Wert eingeben", "arctan");
		Trigonometric.Arctan arctan = new Trigonometric.Arctan(new Decimal(dialog.getValue()));
	    System.out.println(arctan.getValue().toString());
	    System.out.println(arctan.toString());
	    input.append(arctan.getValue().toString());
	    textField.appendText(arctan.toString());	
	}
	
	

	@FXML
	public void power() {
		    DialogCreator test = new DialogCreator("Exponential", "Bitte Exponent und Basis eingeben", "Basis", "Exponent");
		    Power pow = new Power(new Decimal(test.getOne()), new Decimal(test.getTwo()));
		    System.out.println(pow.toString());
		    System.out.println(pow.getValue().toString());
		    input.append(pow.getValue().toString());
		    textField.appendText(pow.toString());
		    
		
	}

	@FXML
	public void power_2() {
		if (input.length() == 0 ) {
			//errorLabel.setText("ZUNÄCHST BASIS EINGEBEN");
			}
			else {
				Power pow = new Power(new Decimal(input.toString()), new Decimal(2));
				textField.appendText("²");
				input.setLength(0);
				input.append(pow.getValue());
			}
			System.out.println("power2 pressed");
			
	}
	
	@FXML
	public void root() {
		 DialogCreator test = new DialogCreator("Wurzel", "Bitte Wurzelexponent und Radikant eingeben", "Wurzelexponent", "Radikant");
		 Root roo = new Root(new Decimal(test.getOne()), new Decimal(test.getTwo()));
		 System.out.println(roo.toString());
		 System.out.println(roo.getValue().toString());
		 input.append(roo.getValue().toString());
		 textField.appendText(roo.toString());   
	}

	@FXML
	public void sroot() {
		TextDialogCreator dialog = new TextDialogCreator("Quadratwurzel", "Bitte Radikant eingeben", "Radikant");
		Root sqr = new Root(new Decimal(dialog.getValue()));
	    System.out.println(sqr.getValue().toString());
	    System.out.println(sqr.toString());
	    input.append(sqr.getValue().toString());
	    textField.appendText(sqr.toString());
	}

	@FXML
	public void log() {
		DialogCreator test = new DialogCreator("Logarithmus", "Bitte Basis und Numerus eingeben", "Basis", "Numerus");
	    Log log = new Log(new Decimal(test.getOne()), new Decimal(test.getTwo()));
	    System.out.println(log.toString());
	    System.out.println(log.getValue().toString());
	    input.append(log.getValue().toString());
	    textField.appendText(log.toString());
	}

	@FXML
	public void ln() {
		TextDialogCreator dialog = new TextDialogCreator("Limes", "Bitte Wert eingeben", "ln");
		Ln ln = new Ln(new Decimal(dialog.getValue()));
	    System.out.println(ln.getValue().toString());
	    System.out.println(ln.toString());
	    input.append(ln.getValue().toString());
	    textField.appendText(ln.toString());
	}
	
	@FXML
	public void deg() {
	}
	
	@FXML
	public void rad() {
	}
}