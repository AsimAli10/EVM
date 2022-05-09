//
package application;

import java.io.IOException;

public class ElectronicVotingMachine {
	String CurentUser;
	VotersList voterslist=new VotersList();
	CandidatesList candidateslist = new CandidatesList();
    public int authenticateUser(String Username, String Password) throws IOException {
    	if(this.authenticatAdmin(Username,Password)==1)
    		return 1;
		if(voterslist.authenticateUser( Username,  Password)>0)
		{
			CurentUser=Username;
			return voterslist.authenticateUser( Username,  Password);
		}
		else return voterslist.authenticateUser( Username,  Password);
    }

    public int authenticatAdmin(String username, String password) {
		if(username.equals("Admin")&&password.equals("admin"))
			return 1;
		else return 0;
		
	}
    
    public int RegisterNewUser(String Username, String CNIC, String Password) throws IOException {
        return voterslist.RegisterNewUser(Username,CNIC,Password);
    }
    
    public int registerCandidate(Candidate candidate) throws IOException {
    	return candidateslist.registerCandidate(candidate); // 0 for baned candidate
    														// 1 for existing candidate
    														// 2 for successful registration
    }

	
	public boolean checkVotingStatus(String votercnic) throws IOException { // true if eligible
																			// false if already vote done
		return voterslist.checkVotingStatus(votercnic);
		
	}
	public boolean castVote(String voterid,String candidateid)throws IOException {
		
		return voterslist.castVote(voterid,candidateid);
		
	}
	public static void main(String[] args) throws IOException{
		ElectronicVotingMachine c=new ElectronicVotingMachine();
		
		System.out.println(c.authenticateUser("132263824", "1234"));
	}
}

