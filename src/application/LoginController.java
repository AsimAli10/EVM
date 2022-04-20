
package application;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

//Class name
//
//--------
public class LoginController {
//login file elements
	ElectronicVotingMachine EVM=new ElectronicVotingMachine();
	@FXML
    private TextField EnteredUsername;
    @FXML
    private TextField EnteredPassword;
    @FXML
    private Label invalidCredentials;
    @FXML
    private Button login;
    @FXML
    private Button Signup;
    
//Register file elements    
    @FXML
    private TextField Username;

    @FXML
    private Button Register;

    @FXML
    private TextField Password;

    @FXML
    private Button Back;

    @FXML
    private TextField CNIC;

    @FXML
    private Label Exception;
    @FXML
    private TextField Password1;
    
    @FXML
    private TextField candidateUsername;
    @FXML
    private TextField candidategroup;
    @FXML
    private TextField candidateCNIC;
    @FXML
    private Label candidateException;
    
    //function to login
    @FXML
    void LoginToSystem(ActionEvent event) throws IOException {
    	int response=EVM.authenticateUser(EnteredUsername.getText(),EnteredPassword.getText());//function call
    	System.out.println(response);
    	if(response==1)//for admin
    	{
    		try 
			{
				Parent root = FXMLLoader.load(getClass().getResource("AdminDashboard.fxml"));
				Stage primaryStage = new Stage();
				primaryStage.setTitle("Admin Operations");
				primaryStage.setScene(new Scene(root));
				primaryStage.show();
				((Node)(event.getSource())).getScene().getWindow().hide();
				
			} catch(Exception e) {
				e.printStackTrace();
			}
    	}
    	else if(response==2)//for user
    	{
    		try 
			{
				Parent root = FXMLLoader.load(getClass().getResource("UserDashboard.fxml"));
				Stage primaryStage = new Stage();
				primaryStage.setTitle("User Dashboard");
				primaryStage.setScene(new Scene(root));
				primaryStage.show();
				((Node)(event.getSource())).getScene().getWindow().hide();
				
			} catch(Exception e) {
				e.printStackTrace();
			}
    	}
    	else
    	{
    		EnteredUsername.setText("");
			EnteredPassword.setText("");
			invalidCredentials.setText("Invalid credentials. Please try again.");
    	}
    }

    @FXML
    void MoveToRegisterPage(ActionEvent event) {
    	try 
		{
    		EnteredUsername.setText("");
			EnteredPassword.setText("");
			Parent root = FXMLLoader.load(getClass().getResource("Register.fxml"));
			Stage primaryStage = new Stage();
			primaryStage.setTitle("Register User");
			primaryStage.setScene(new Scene(root));
			primaryStage.show();
			((Node)(event.getSource())).getScene().getWindow().hide();
			
		} catch(Exception e) {
			e.printStackTrace();
		}

    }
    @FXML
    void BackToLoginPage(ActionEvent event) { 
    	try 
		{
			Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
			Stage primaryStage = new Stage();
			primaryStage.setTitle("Login");
			primaryStage.setScene(new Scene(root));
			primaryStage.show();
			((Node)(event.getSource())).getScene().getWindow().hide();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void RegisterNewUser(ActionEvent event) throws IOException {
    	int response=0;
    		if(Password.getText().equals(Password1.getText()))
    		{
    			response=0;//EVM.RegisterNewUser(Username.getText(),CNIC.getText(),Password.getText());//function call
	    		if(response!=2)
	    		{
	    			Username.setText("");
	    			CNIC.setText("");
	    			Password.setText("");
	    			Password1.setText("");
	    			if(response==0)
	    			{
	    				Exception.setText("CNIC is invalid!");
	    			}
	    			if(response==1)
	    			{
	    				Exception.setText("User has already registered!");
	    			}
	    		}
	    		else
	    		{
	    			try 
	    			{
	    				Parent root = FXMLLoader.load(getClass().getResource("UserDashboard.fxml"));
	    				Stage primaryStage = new Stage();
	    				primaryStage.setTitle("User Dashboard");
	    				primaryStage.setScene(new Scene(root));
	    				primaryStage.show();
	    				((Node)(event.getSource())).getScene().getWindow().hide();
	    				
	    			} catch(Exception e) {
	    				e.printStackTrace();
	    			}
	    		}
    		}
	    	else
	    	{
	    		Password1.setText("");
	    		Exception.setText("Please re-confirms the password!");
	    	}	
    }
    @FXML
    void MoveToRegisterACandidate(ActionEvent event) {
    	try 
		{
			Parent root = FXMLLoader.load(getClass().getResource("RegisterCandidate.fxml"));
			Stage primaryStage = new Stage();
			primaryStage.setTitle("Admin Dashboard");
			primaryStage.setScene(new Scene(root));
			primaryStage.show();
			((Node)(event.getSource())).getScene().getWindow().hide();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
    @FXML
    void BackToAdminPage(ActionEvent event) {
    	try 
		{
			Parent root = FXMLLoader.load(getClass().getResource("AdminDashboard.fxml"));
			Stage primaryStage = new Stage();
			primaryStage.setTitle("Admin Dashboard");
			primaryStage.setScene(new Scene(root));
			primaryStage.show();
			((Node)(event.getSource())).getScene().getWindow().hide();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void RegisterACandidate(ActionEvent event) throws IOException {
    	Candidate C=new Candidate(candidateUsername.getText(),candidateCNIC.getText(),candidategroup.getText());
    	int response=EVM.registerCandidate(C);
    	if(response==0)
    	{
    		candidateException.setText("You are banned!");
    		candidateUsername.setText("");
    		candidateCNIC.setText("");
    		candidategroup.setText("");
    	}
    	else if(response==1)
    	{
    		candidateException.setText("Candidate Already exist!");
    		candidateUsername.setText("");
    		candidateCNIC.setText("");
    		candidategroup.setText("");
    	}
    	else
    	{
    		try 
    		{
    			Parent root = FXMLLoader.load(getClass().getResource("AdminDashboard.fxml"));
    			Stage primaryStage = new Stage();
    			primaryStage.setTitle("Admin Dashboard");
    			primaryStage.setScene(new Scene(root));
    			primaryStage.show();
    			((Node)(event.getSource())).getScene().getWindow().hide();
    			
    		} catch(Exception e) {
    			e.printStackTrace();
    		}
    	}
    }
    @FXML
    private Label VotingStatusLabel;
    @FXML
    private TextField CNICToBeChecked;
    @FXML
    void CheckVotingStatus(ActionEvent event) throws IOException {
    	try 
		{
			Parent root = FXMLLoader.load(getClass().getResource("VotingStatus.fxml"));
			Stage primaryStage = new Stage();
			primaryStage.setTitle("User Dashboard");
			primaryStage.setScene(new Scene(root));
			primaryStage.show();
			((Node)(event.getSource())).getScene().getWindow().hide();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
    @FXML
    void CheckStatus(ActionEvent event) throws IOException {
    	boolean status=EVM.checkVotingStatus(CNICToBeChecked.getText());
    	if(status==true)
    	{
    		VotingStatusLabel.setText("You are eligible to vote!");
    	}
    	else
    	{
    		VotingStatusLabel.setText("You are not eligible to vote");
    	}
    }
    @FXML
    void MoveToUserDashboard(ActionEvent event) {
    	try 
		{
			Parent root = FXMLLoader.load(getClass().getResource("UserDashboard.fxml"));
			Stage primaryStage = new Stage();
			primaryStage.setTitle("User Dashboard");
			primaryStage.setScene(new Scene(root));
			primaryStage.show();
			((Node)(event.getSource())).getScene().getWindow().hide();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
}