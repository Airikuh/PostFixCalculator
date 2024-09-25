//Erika Valle-Baird 
//CIS 296
//Project 3
//11/19/2021


package PostFixCalculator;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.Stack;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class PostFixCalculatorFXMLController implements Initializable {
    //Need this, appending to field ran into errors with calculate without this variable
private String equation = "";
   
    @FXML
    private TextField displayInput;
    @FXML
    private Button one;
    @FXML
    private Button two;
    @FXML
    private Button three;
    @FXML
    private Button plus;
    @FXML
    private Button divide;
    @FXML
    private Button multiply;
    @FXML
    private Button minus;
    @FXML
    private Button six;
    @FXML
    private Button five;
    @FXML
    private Button four;
    @FXML
    private Button nine;
    @FXML
    private Button eight;
    @FXML
    private Button seven;
    @FXML
    private Button clear;
    @FXML
    private Button zero;
    @FXML
    private Button space;
    @FXML
    private Button calculate;
    


 

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    



    @FXML
    private void handleClick(ActionEvent event) {
        if(event.getSource() == one){
            equation += "1";
            viewer();
            //displayInput.appendText("1");
        }
        else if(event.getSource() == two){
                        equation += "2";
            viewer();

            //displayInput.appendText("2");
        }
         else if(event.getSource() == three){
                         equation += "3";
            viewer();

            //displayInput.appendText("3");
         }
         else if(event.getSource() == four){
                         equation += "4";
            viewer();

            //displayInput.appendText("4");
         }
         else if(event.getSource() == five){
                         equation += "5";
            viewer();

            //displayInput.appendText("5");
         }
         else if(event.getSource() == six){
                         equation += "6";
            viewer();

            //displayInput.appendText("6");
         }
         else if(event.getSource() == seven){
                         equation += "7";
            viewer();

            //displayInput.appendText("7");
         }
         else if(event.getSource() == eight){
                         equation += "8";
            viewer();

            //displayInput.appendText("8");
         }
         else if(event.getSource() == nine){
                         equation += "9";
            viewer();

            //displayInput.appendText("9");
         } 
         else if(event.getSource() == zero){
                         equation += "0";
            viewer();

            //displayInput.appendText("0");
         }
        else if(event.getSource() == space){
                        equation += " ";
            viewer();

            //displayInput.setText(displayInput.getText() + " ");
        }
         else if(event.getSource() == plus){
                         equation += "+";
            viewer();

           //displayInput.setText(displayInput.getText() + "+");

        }
         else if(event.getSource() == minus){
                         equation += "-";
            viewer();

            //displayInput.setText(displayInput.getText() + "-");
            
        }
         else if(event.getSource() == multiply){
                         equation += "*";
            viewer();

            //displayInput.setText(displayInput.getText() + "*");
            
        }
         else if(event.getSource() == divide){
                         equation += "/";
            viewer();

            //displayInput.setText(displayInput.getText() + "/");
            
        }

         else if(event.getSource() == clear){
                         equation = "";
            viewer();

            //displayInput.setText(displayInput.getText() + "");
        }
        else if(event.getSource() == calculate){
            String inputEq = equation;
           //If Call to Postfix Notation to Determine if Input is Valid Returns True
            if(postfixNotation(equation)){
                equation = "";
                //If Null is Returned Division by Zero was Attempted
                if(calculate(inputEq)==null){
                  equation += "INVALID DIVISION BY ZERO";
                  viewer();
                }
                //Else Get and Display Result
                else{
                  int answer = (int)Math.round(calculate(inputEq));
                  equation += Integer.toString(answer);
                  viewer(); 
                 }
           }
            //If Call to Postfix Evaluation Returns False, Input was Invalid
            else{
             equation = "";
             equation += "INVALID INPUT";
             viewer();
            }

        }
   
    }

    //Method To Calculate the Expression
public Double calculate(String equation){
    String[] eq = equation.split(" ");
Stack operands = new Stack();
double answer = 0;
for(int i = 0; i < eq.length;i++){
    String nextCharacter = eq[i];

    //Switch Statement for Different Possible Operators
switch(nextCharacter){

//Addition Case
case("+"):{
double operand2 = (double)operands.pop();
double operand1 = (double)operands.pop();
answer = operand1 + operand2;
operands.push(answer);
break;}

//Subtraction Case
case("-"):{
double operand2 = (double)operands.pop();
double operand1 = (double)operands.pop();
answer = operand1-operand2;
operands.push(answer);
break;}

//Multiplication Case
case("*"):{

    double operand2 = (double)operands.pop();
double operand1 = (double)operands.pop();
answer = operand1*operand2;
operands.push(answer);
break;}

//Division Case
case("/"):{

    double operand2 = (double)operands.pop();
double operand1 = (double)operands.pop();
//Error For Specific Divide by Zero Case, Does NOT Catch it Without this
if(operand2 == 0){
        return null;
}
else{
answer = operand1/operand2;
operands.push(answer);
break;
}
}
//Default Case the Character Encountered is an Operand
default:
operands.push(Double.parseDouble(nextCharacter));
break;
}

}

return answer;
}
  
//Method to Display Answer, Invalid Messages, and Clear.
//If Just Use Append Calculate Did not Work
   public void viewer(){
       if(equation.length() != 0){
          displayInput.setText(equation);
       }
       else{
           displayInput.setText(" ");
       }
   } 
   
   //Check If User Input Was in Valid Postfix Notation
   //Return True if it is
   //Return False Otherwise
   public boolean postfixNotation(String equation){
       //Our Boolean Variable to Check Conditions
       boolean check = false;
       //A Counter to Keep Track of Number of Operands
       int counter = 0;       
       //To Parse Through our String
       char eq;
       
       //Empty Expression, nothing to calculate. Avoid the loops 
       if(equation.equals("")){
           return false;
       }
       //Loop Through Each Character in the String and Determine if 
       //Calculations can be Done or Not
       for(int i = 0; i < equation.length(); i++){
           eq = equation.charAt(i);
           //If Our Checker is True and we Have More to Encounter
           if((check == true) && (eq == ' ')){
           check = true;
           
       }
           //If Our Checker is False and we Only have Whitespace
           else if((check == false) && (eq == ' ')){
               return false;
           }
           //If an Operator
           else if(isOperator(eq) ){
               //But Don't Have Enough Operands to Do Anything With
               if(counter < 2 || (check == false)){
                   return false;
                   
               }
               //Or we DO Have Enough Operands to Do Calculations
               counter--;
               check = true;
           }
           //Left with One Operator
           else if(!Character.isDigit(eq)){
               return false;
           }
           //Changing Check to True if Conditions met
           else if((Character.isDigit(eq)) || ((Character.isDigit(eq)) && (eq == ' '))){
               counter++;
               check = true;
               
           }
           
     
       }
       //Return Check Condition
       return (check);
       
   }
   
   
   
   public boolean isOperator(char operator){
       return((operator == '+')|| (operator == '-')|| (operator == '*')|| (operator == '/'));
   }

   
}

