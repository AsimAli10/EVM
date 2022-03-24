package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VotersList {
	 static List<Voter> voterlist;

	public  int authenticateUser(String Username, String Password) throws IOException {
			voterlist=new ArrayList<Voter>();
			Voter v=new Voter();
			return v.authenticateUser( Username,  Password);
		
	}

	public int RegisterNewUser(String username, String cNIC, String password) throws IOException {
		voterlist=new ArrayList<Voter>();
		Voter v=new Voter();
		return v.RegisterNewUser(username,cNIC,password);
	}

}
