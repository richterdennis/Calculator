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
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;

public class Controller implements Initializable{
	
	// Parse TextField
	@FXML 
	TextField textField;
	
	// Toggle Button for deg/rad
	@FXML
	ToggleButton degradButton;

	// Label for result of the calculation
	@FXML
	Label resultLabel;
	
	// Buffer for result
	String result;
	
	// Collect the user input and create a calculatable later
	StringBuilder input = new StringBuilder();
	
	// This is the main calculatable
	Chain mainCalculatable = new Chain();
	
	@FXML
	Button answer;
	
	// Set Answer as primary Button (Onlick --> Enter)
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
		
		textField.appendText("-");
		System.out.println("SUBTRACT pressed");
	}

	@FXML
	public void equals() {
		mainCalculatable.addLink(new Decimal(input.toString()));
		
		String calc = mainCalculatable.toString();
		result = mainCalculatable.getValue().toString();
		
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
	}

	@FXML
	public void pi() {
		if (input.length() == 0 ) {
			
			input.append(Math.PI);
			textField.appendText("p");
			}
			else {
				mainCalculatable.addLink(new Decimal(input.toString()));
				mainCalculatable.addOperator(Operator.MULTIPLY);
				textField.appendText("*p");
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
	public void factorial() {
		if (input.length() != 0 ) {
				Factorial fac = new Factorial(new Decimal(input.toString()));
				textField.appendText("!");
				input.setLength(0);
				input.append(fac.getValue());
			}
	}
	
	@FXML
	public void pleft() {
		input.append("(");
		textField.appendText("(");
		System.out.println("PLEFT pressed");
	}

	@FXML
	public void pright() {
		input.append(")");
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
		if (input.length() == 0) {		    
		    input.append(sin.getValue().toString());
			}
		    else { multiply();
		    input.append(sin.getValue().toString());
		    }
		    textField.appendText(sin.toString());
	    }

	@FXML
	public void cos() {
		TextDialogCreator dialog = new TextDialogCreator("Cosinus", "Bitte Wert eingeben", "cos");
		Trigonometric.Cos cos = new Trigonometric.Cos(new Decimal(dialog.getValue()));
	    
		if (input.length() == 0) {		    
		    input.append(cos.getValue().toString());}
		    else { multiply();
		    input.append(cos.getValue().toString());
		    }
		    textField.appendText(cos.toString());
		    
	}
	
	@FXML
	public void tan() {
		TextDialogCreator dialog = new TextDialogCreator("Tangens", "Bitte Wert eingeben", "tan");
		Trigonometric.Tan tan = new Trigonometric.Tan(new Decimal(dialog.getValue()));
	    
		if (input.length() == 0) {		    
		    input.append(tan.getValue().toString());}
		    else { multiply();
		    input.append(tan.getValue().toString());
		    }
		    textField.appendText(tan.toString());
	}
	
	@FXML
	public void arcsin() {
		TextDialogCreator dialog = new TextDialogCreator("Arkussinus", "Bitte Wert eingeben", "arcsin");
		Trigonometric.Arcsin arcsin = new Trigonometric.Arcsin(new Decimal(dialog.getValue()));
	    
		if (input.length() == 0) {		    
		    input.append(arcsin.getValue().toString());}
		    else { multiply();
		    input.append(arcsin.getValue().toString());
		    }
		    textField.appendText(arcsin.toString());
	}
	
	@FXML
	public void arccos() {
		TextDialogCreator dialog = new TextDialogCreator("Arkuscosinus", "Bitte Wert eingeben", "arccos");
		Trigonometric.Arccos arccos = new Trigonometric.Arccos(new Decimal(dialog.getValue()));

		if (input.length() == 0) {		    
		    input.append(arccos.getValue().toString());}
		    else { multiply();
		    input.append(arccos.getValue().toString());
		    }
		    textField.appendText(arccos.toString());
	}

	
	@FXML
	public void arctan() {
		TextDialogCreator dialog = new TextDialogCreator("Arkustangens", "Bitte Wert eingeben", "arctan");
		Trigonometric.Arctan arctan = new Trigonometric.Arctan(new Decimal(dialog.getValue()));
	   
		if (input.length() == 0) {		    
		    input.append(arctan.getValue().toString());}
		    else { multiply();
		    input.append(arctan.getValue().toString());
		    }
		    textField.appendText(arctan.toString());
	}
	
	

	@FXML
	public void power() {
		    DialogCreator test = new DialogCreator("Exponential", "Bitte Exponent und Basis eingeben", "Basis", "Exponent");
		    Power pow = new Power(new Decimal(test.getOne()), new Decimal(test.getTwo()));
		    
		    if (input.length() == 0) {		    
		    input.append(pow.getValue().toString());}
		    else { multiply();
		    input.append(pow.getValue().toString());
		    }
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
		 Root roo = new Root(new Decimal(test.getTwo()), new Decimal(test.getOne()));
		 
		 if (input.length() == 0) {		    
			    input.append(roo.getValue().toString());}
			    else { multiply();
			    input.append(roo.getValue().toString());
			    }
			    textField.appendText(roo.toString());
	}

	@FXML
	public void sroot() {
		TextDialogCreator dialog = new TextDialogCreator("Quadratwurzel", "Bitte Radikant eingeben", "Radikant");
		Root sqr = new Root(new Decimal(dialog.getValue()));
	   
		if (input.length() == 0) {		    
		    input.append(sqr.getValue().toString());}
		    else { multiply();
		    input.append(sqr.getValue().toString());
		    }
		    textField.appendText(sqr.toString());
	}

	@FXML
	public void log() {
		DialogCreator test = new DialogCreator("Logarithmus", "Bitte Basis und Numerus eingeben", "Basis", "Numerus");
	    Log log = new Log(new Decimal(test.getOne()), new Decimal(test.getTwo()));
	    
	    if (input.length() == 0) {		    
		    input.append(log.getValue().toString());}
		    else { multiply();
		    input.append(log.getValue().toString());
		    }
		    textField.appendText(log.toString());
	}

	@FXML
	public void ln() {
		TextDialogCreator dialog = new TextDialogCreator("Limes", "Bitte Wert eingeben", "ln");
		Ln ln = new Ln(new Decimal(dialog.getValue()));
	    
		if (input.length() == 0) {		    
		    input.append(ln.getValue().toString());}
		    else { multiply();
		    input.append(ln.getValue().toString());
		    }
		    textField.appendText(ln.toString());
	}
	
	@FXML
	public void degrading() {
		if (degradButton.isSelected() == true) {
			degradButton.setText("RAD");
		}
		else {
			degradButton.setText("DEG");}
		}

	@FXML
	public void ans() {
		textField.appendText(result);
		input.append(result);
	}
	}
