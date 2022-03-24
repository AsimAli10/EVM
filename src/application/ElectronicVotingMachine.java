package application;

import java.io.IOException;

public class ElectronicVotingMachine {
	
	VotersList voterslist=new VotersList();
    public int authenticateUser(String Username, String Password) throws IOException {
    	if(this.authenticatAdmin(Username,Password)==1)
    		return 1;
		return voterslist.authenticateUser( Username,  Password);
    }

    public int authenticatAdmin(String username, String password) {
		if(username.equals("Admin")&&password.equals("admin"))
			return 1;
		else return 0;
		
	}

	public int RegisterNewUser(String Username, String CNIC, String Password) throws IOException {
        return voterslist.RegisterNewUser(Username,CNIC,Password);
    }
}
