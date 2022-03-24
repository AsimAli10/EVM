package application;

import java.io.IOException;

public class Voter {

	public int authenticateUser(String username, String password) throws IOException {
		dataBase db=new dataBase();
		return db.checkLogin(username,password);
		
	}

	public int RegisterNewUser(String username, String cNIC, String password) throws IOException {
		dataBase db=new dataBase();
		
		return db.RegisterNewUser(username,cNIC,password);
	}
	
	

}
