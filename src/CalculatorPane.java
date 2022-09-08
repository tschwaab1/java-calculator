import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.*;
import javafx.event.EventHandler; 
import java.text.SimpleDateFormat;
import java.util.Date;




class CalculatorPane extends SplitPane{

	AnchorPane upperPane;
	//Pane's
    private AnchorPane lowerPane;
//    static int count=0;
    //Label's
    private Label num1,num2,num3,funclabel,controllabel,CalcCapt,resultLabel,label6;
    
    //Function ComboBox
    private ComboBox<String> comboBox;
    
    // Inputfields
    public TextField number1,number2,number3,number4;

    
    //Buttons
    private Button computeButton,resetButton,newWindow;
   
    // Textarea
    private TextArea resultArea;

    //Alert test
	private Alert alert;
	
	 String log="";

	public CalculatorPane() {
		

		
        setDividerPositions(0.35);
        setOrientation(javafx.geometry.Orientation.VERTICAL);
        
		upperPane = new AnchorPane();

        num1 = new Label();
        num1.setLayoutX(30.0);
        num1.setLayoutY(25.0);
        num1.setText("Number1");

        num2 = new Label();
        num2.setLayoutX(30.0);
        num2.setLayoutY(60.0);
        num2.setText("Number2");

        num3 = new Label();
        num3.setLayoutX(30.0);
        num3.setLayoutY(95.0);
        num3.setText("Number3");

        
        label6 = new Label();
        label6.setLayoutX(30.0);
        label6.setLayoutY(130.0);
        label6.setText("Number4");
        
        number1 = new TextField();
        number1.setLayoutX(109.0);
        number1.setLayoutY(25.0);


        number2 = new TextField();
        number2.setLayoutX(109.0);
        number2.setLayoutY(60.0);

        number3 = new TextField();
        number3.setLayoutX(109.0);
        number3.setLayoutY(95.0);
        
        number4 = new TextField();
        number4.setLayoutX(109.0);
        number4.setLayoutY(130.0);

        comboBox = new ComboBox<String>();
        
        comboBox.setLayoutX(325.0);
        comboBox.setLayoutY(25.0);
        comboBox.getItems().addAll(
        		"Please choose!",
        		"R8 (Eratosthenes)",
        		"R9 (Euclid)",
        		"R10 (Prime)",
        		"R11 (Euler's totient)",
        		"R12 (Prime factorization)",
        		"R13 (Sigma)",
        		"R14 (Lin. cong. gen.)",
        		"R15 (Partition)"
        		);
  
        
        comboBox.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	String Itm= comboBox.getValue();
            	 
            	switch(Itm) {
            	
            	case "Please choose!":
            		resultLabel.setText("Please choose a function!");
            		break;
            	case "R8 (Eratosthenes)":
        			
        			resultLabel.setText("Sieve of Eratosthenes: Input an Integer n>1 in Number1 field.");	

            		break;
            	case "R9 (Euclid)":
        			resultLabel.setText("Euclid algorithm: Input two numbers (n>0,m>0) into Number1 and Number2 field.");

            		break;
            	case "R10 (Prime)":
        			resultLabel.setText("Prime numbers smaller than n: Input n>0 in Number1 field.");

            		break;
            	case "R11 (Euler's totient)":

        			resultLabel.setText("Euler's totient: Input n>0 in Number 1 field.");

            		
            		
            		break;
            	case "R12 (Prime factorization)":
            		
        			resultLabel.setText("Prime factorization: Input n>1 in Number1 field.");

            		break;
            	case "R13 (Sigma)":
        			resultLabel.setText("Sigma function: Input n>1 (Number1) and x>=0 (Number2).");
            		break;
            	case "R14 (Lin. cong. gen.)":
            		resultLabel.setText("Linear congruential generator: Input a(Number1),b (Number2),m (Number 3),n (Number4) >0");
            		break;
            	case "R15 (Partition)":
            		resultLabel.setText("Partition function: Input n>0 (Number1 - field).");
            		break;
            	
            	
            	}
            	
            	

            }
        });
       
        /*********************************************
         * Y-axis values:
         * 
         * 30
         * 60
         * 90/95
         * 130
         * 
         */
        
        funclabel = new Label();
        funclabel.setLayoutX(270.0);
        funclabel.setLayoutY(30.0);
        funclabel.setText("Function:");

        controllabel = new Label();
        controllabel.setLayoutX(513.0);
        controllabel.setLayoutY(30.0);
        controllabel.setText("Controls:");

        computeButton = new Button();
        computeButton.setLayoutX(586.0);
        computeButton.setLayoutY(30.0);
        computeButton.setText("Compute");
        computeButton.setOnAction(this::pressCompute);

        resetButton = new Button();
        resetButton.setLayoutX(586.0);
        resetButton.setLayoutY(60.0);
        resetButton.setText("Reset");
        resetButton.setOnAction(this::ResetAll);

        newWindow = new Button();
        newWindow.setLayoutX(586.0);
        newWindow.setLayoutY(95.0);
        newWindow.setText("History");
        newWindow.setOnAction(this::openNewWindow);
       
        lowerPane = new AnchorPane();

        resultArea = new TextArea();
        resultArea.setLayoutX(14.0);
        resultArea.setLayoutY(96.0);
        resultArea.setPrefWidth(667.0);

        CalcCapt = new Label();
        CalcCapt.setLayoutX(14.0);
        CalcCapt.setLayoutY(69.0);
        CalcCapt.setText("Calculation:");
        CalcCapt.setAlignment(Pos.CENTER);

        resultLabel = new Label();
        resultLabel.setLayoutX(13.0);
        resultLabel.setLayoutY(14.0);
        resultLabel.setText("Select a function to see the inputs needed.");


        
        //  Upper Pane
        upperPane.getChildren().add(num1);
        upperPane.getChildren().add(num2);
        upperPane.getChildren().add(num3);
        upperPane.getChildren().add(number1);
        upperPane.getChildren().add(number2);
        upperPane.getChildren().add(number3);
        upperPane.getChildren().add(number4);
        upperPane.getChildren().add(comboBox);
        upperPane.getChildren().add(funclabel);
        upperPane.getChildren().add(controllabel);
        upperPane.getChildren().add(label6);
        upperPane.getChildren().add(computeButton);
        upperPane.getChildren().add(resetButton);
        upperPane.getChildren().add(newWindow);

        getItems().add(upperPane);
        
        
        // Lower Pane
        lowerPane.getChildren().add(resultArea);
        lowerPane.getChildren().add(CalcCapt);
        lowerPane.getChildren().add(resultLabel);
        getItems().add(lowerPane);
        
        alert = new Alert(AlertType.ERROR);

	}
			
	
		
	private void pressCompute(ActionEvent event) {
				
		String comBox;
		comBox = (String) comboBox.getValue();
		
		switch (comBox) {
		
		case "Please choose!":
		
			// open Error Dialog for no function chosen!
			
			AlertDialog("No function","No function has been chosen!","Please choose a function in the Menu");
			
		break;
		case "R8 (Eratosthenes)":
			
			//Input hints
			
			
			// Debug AddToTA("Function 8 has been choosen!");
						
				if (checkIn1() == false) {
					
					AlertDialog("Error","There is an Error in Number1 - field", "Please look down to the Log for futher Informations.");
				}
				else {
				int n1 = Integer.parseInt(number1.getText());
					
				// Check if input is reaklly n>1
					
					if (n1>1) {
						//R8(n1);
					AddToTA("F: Sieve of Eratosthenes, Input: n = "+n1+" , Result: "+functions.R8(n1));
					}
					else {
						AddToTA("Please enter only a Number n>1");
					}
				
					//R8();
				}
			
			
			//AddToTA("True or false: ?"+checkIn1());
			
		break;
		case "R9 (Euclid)":
		/// Denbug Infos	AddToTA("Function 9 has been choosen!");
			
			
				if(checkIn1() == false || checkIn2() == false) {
					AlertDialog("Error","There is an Error in Number1 or Number2 - field", "Please look down to the Log for futher Informations.");
				}
				else {
					int n1 = Integer.parseInt(number1.getText());
					int n2 = Integer.parseInt(number2.getText());
					
					
					// n1 and n2 have to be greater than 0
					
					if(n1 >0 && n2 >0) {
						
						AddToTA("F: Euclid algorithm, Input: n = "+n1+", m = "+n2+", Result: "+functions.R9(n1,n2));
						
					}
					else {
						AddToTA("Number1 or Number 2 is not greater than 0");
					}
					

				}
		//	CheckR9req();
		break;
		case "R10 (Prime)":
			//AddToTA("Function 10 has been choosen!");
						
			if (checkIn1() == false) {
				AlertDialog("Error","There is an Error in Number1 - field", "Please look down to the Log for futher Informations.");
			}else {
				int n1 = Integer.parseInt(number1.getText());
				
				//n1 > 0 -> check it
				
				if(n1>0) {
					
					AddToTA("F: Prime numbers smaller than n, Input: n = "+n1+", Result: "+functions.R10(n1));					
				}else {
					AddToTA("Number 1 has to be > 0!");
				}
				

			}
		break;
		case "R11 (Euler's totient)":
		//	AddToTA("Function 11 has been choosen!");

			
			if (checkIn1() == false) {
				AlertDialog("Error","There is an Error in Number1 - field", "Please look down to the Log for futher Informations.");
			}else{
				int n1 = Integer.parseInt(number1.getText());
				
					if(n1 > 0) {
						AddToTA("F: Euler's totient, Input: n = "+n1+", Result: "+functions.R11(n1));
					}
					else {
						AddToTA("Number 1 has to be > 0 (positive integer)");
					}
				
				//R11(n1);
			}
			
		break;
		case "R12 (Prime factorization)":	
		//	AddToTA("Function 12 has been choosen!");
			

			
			if(checkIn1() == false) {
				AlertDialog("Error", "There is an Error in Number1 - field", "Please look down to the Log for futher Informations");
			}else {
				int n1 = Integer.parseInt(number1.getText());				
					if(n1>1) {
						AddToTA("F: Prime factorization, Input: n = "+n1+", Results: "+functions.R12(n1));
					}
					else {
						AddToTA("Number 1 has to be >1");
					}
				
			}
		break;
		case "R13 (Sigma)":
			//AddToTA("Function 13 has been choosen!");
			

			
			if(checkIn1() == false || checkIn2() == false) {	
			AlertDialog("Error", "There is an Error in Number1 or Number2 - field", "Please look down to the Log for futher Informations");
			}
			else {
				int n1 = Integer.parseInt(number1.getText());
				int n2 = Integer.parseInt(number2.getText());
				
				
				if (n1>=0 && n2 >1) {
					
					// Run R13 function
					AddToTA("F: Sigma function, Input: n = "+n1+", x = "+n2+" Result: "+functions.R13(n1,n2));
				}
				else {
					AddToTA("Number1 has to be >= 0 and Number 2 >1, please correct the input.");
				}
				
				
			}
			
			
			
		break;
		case "R14 (Lin. cong. gen.)":
			//AddToTA("Function 14 has been choosen!");
			
			if(checkIn1() == false || checkIn2() == false || checkIn3() == false || checkIn4() == false) {
				AlertDialog("Error", "There is an Error in Number1 to Number4 - field", "Please look down to the Log for futher Informations");
			}
			else {
				
				// No check required??? a,b,m,n only have to be Int -> already check with isInteger Function
				int n1 = Integer.parseInt(number1.getText());
				int n2 = Integer.parseInt(number2.getText());
				int n3 = Integer.parseInt(number3.getText());
				int n4 = Integer.parseInt(number4.getText());
				
				//R14_calc(n1, n2, n3, n4);
			//	AddToTA("Function 14 (lcg) numbers: "+R14_next(n1,n2,n3,n4));
			AddToTA("F: Linear congruential generator, Input: a = "+n1+", b = "+n2+", m = "+n3+", n = "+n4+" Results: "+functions.R14(n1, n2, n3, n4));
				
			}
			
			
		break;
		case "R15 (Partition)":
			//AddToTA("Function 15 has been choosen!");
			
			if (checkIn1() == false) {
				AlertDialog("Error", "There is an Error in Number1 to Number4 - field", "Please look down to the Log for futher Informations");
			}
			else {
				int n1 = Integer.parseInt(number1.getText());	
				
				if (n1 > 0) {
					// Run the stupid R15 function
					AddToTA("F: Partition function, Input: n = "+n1+" Result: "+functions.getPartys(n1));
				}
				else {
					AddToTA("Number1 has to be a non-negative integer. Please correct you input!");
				}
				
				functions.setCountZero();
				
			}
			
			
		break;	
		
		}
		
			
		}
	
	// New Window function
	
	private void openNewWindow(ActionEvent event) {
		

		TextArea resultArea2 = new TextArea();
		resultArea2.setPrefHeight(700);

		
		VBox vBox = new VBox(resultArea2);
		Scene scene = new Scene(vBox, 700, 700);

		Stage stage = new Stage();
		stage.setTitle("History of past Calculations");
		stage.setScene(scene);
		stage.show();
	
		resultArea2.setText(log);
		
	}
	
/// General functions used often	
	
	public void AddToTA(String text) {
		
		String newText;
		
		String timeStamp = new SimpleDateFormat("HH:mm:ss").format(new Date());
		
		String oldt = resultArea.getText();
		
		if(resultArea.getText() == ""){
			
			newText = "["+timeStamp+"] "+text;
			addToLog(newText);
		}
		else {
			
			newText = oldt  +"["+timeStamp+"] "+text+" \n";
			
			addToLog("["+timeStamp+"] "+text);
		}
		
		resultArea.setText(newText);
//		addToLog(newText);
	}
/***
	private void dbMe(String dmsg) {
		
		// DEbug by console
		
		System.out.println(dmsg);
		
		// Debug by TextArea
		
		resultArea.setText(dmsg);
		
	}
**/
	private void AlertDialog(String Titel,String Header,String Content) {
		
		alert.setTitle(Titel);
		alert.setHeaderText(Header);
		alert.setContentText(Content);
		alert.showAndWait();
		
	}

	private void ResetAll(ActionEvent event) {
		
		number1.clear();
		number2.clear();
		number3.clear();
		number4.clear();
		
		//Enable all inputfield if disabeled
	/**	number1.setDisable(false);
		number2.setDisable(false);
		number3.setDisable(false);
		**/
		
		comboBox.setValue("Please choose!");
		resultLabel.setText("");
		//resultArea.clear();
		
		
	//	dbMe("Everything cleared");
		
	}
	
	private boolean checkIn1() {
		
		
		if (number1.getText().isEmpty()) {
			
			AddToTA("Number1 is empty! Please enter positive int Number.");
			return false;
		}
		else if (number1.getText().startsWith(" ")) {
			AddToTA("Number1 starts with a Space! Please enter only positive int Number.");
			return false;
		}
		else {
			//int num1 = Integer.parseInt(number1.getText());
			//AddToTA("Number1 is "+num1);
			
			if (isInteger(number1.getText()) == false) {
			
			AddToTA("Number1 is not an Integer!");
				return false;
				
			} else {
				return true;
			}
			
		}
		
	}
	
	private boolean checkIn2() {
		
		
		if (number2.getText().isEmpty()) {
			
			AddToTA("Number2 is empty! Please enter positive int Number.");
			return false;
		}
		else if (number2.getText().startsWith(" ")) {
			AddToTA("Number2 starts with a Space! Please enter only positive int Number.");
			return false;
		}
		else {
			//int num1 = Integer.parseInt(number1.getText());
			//AddToTA("Number1 is "+num1);
			
			if (isInteger(number2.getText()) == false) {
				
				AddToTA("Number2 is not an Integer!");
				return false;
				
			} else {
				return true;
			}
			
			
			/**
			
			if(num1 <= 0) {
					return false;
			}
			else {
					return true;
			}
		**/
		}
		
	}
	
	private boolean checkIn3() {
		
		
		if (number3.getText().isEmpty()) {
			
			AddToTA("Number3 is empty! Please enter positive int Number.");
			return false;
		}
		else if (number3.getText().startsWith(" ")) {
			AddToTA("Number3 starts with a Space! Please enter only positive int Number.");
			return false;
		}
		else {
			//int num1 = Integer.parseInt(number1.getText());
			//AddToTA("Number1 is "+num1);
			
			if (isInteger(number3.getText()) == false) {
				
				AddToTA("Number3 is not an Integer!");
				return false;
				
			} else {
				return true;
			}
			
			
			/**
			
			if(num1 <= 0) {
					return false;
			}
			else {
					return true;
			}
		**/
		}
		
	}
	
	private boolean checkIn4() {
		
		
		if (number4.getText().isEmpty()) {
			
			AddToTA("Number4 is empty! Please enter positive int Number.");
			return false;
		}
		else if (number4.getText().startsWith(" ")) {
			AddToTA("Number4 starts with a Space! Please enter only positive int Number.");
			return false;
		}
		else {
			//int num1 = Integer.parseInt(number1.getText());
			//AddToTA("Number1 is "+num1);
			
			if (isInteger(number4.getText()) == false) {
				
				AddToTA("Number4 is not an Integer!");
				return false;
				
			} else {
				return true;
			}
			
			
			/**
			
			if(num1 <= 0) {
					return false;
			}
			else {
					return true;
			}
		**/
		}
		
	}

	
	public static boolean isInteger(String n1) {
		try { 
	        Integer.parseInt(n1); 
	    } catch(NumberFormatException e) { 
	        return false; 
	    } catch(NullPointerException e) {
	        return false;
	    }
	    return true;
	}
	
	private void addToLog(String input) {
		
		log = log+"\n"+input;
		
		
	}
}
	

