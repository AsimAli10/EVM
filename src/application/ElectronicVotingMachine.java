//
package application;

import java.io.IOException;

public class ElectronicVotingMachine {
	
	VotersList voterslist=new VotersList();
	CandidatesList candidateslist = new CandidatesList();
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
    public int registerCandidate(Candidate candidate) throws IOException {
    	return candidateslist.registerCandidate(candidate); // 0 for baned candidate
    														// 1 for existing candidate
    														// 2 for successful registration
    }

	public int RegisterNewUser(String Username, String CNIC, String Password) throws IOException {
        return voterslist.RegisterNewUser(Username,CNIC,Password);
    }
	/*public static void main(String[] args) throws IOException{
		Candidate c=new Candidate("Alvin Beidler","174867274","GroupC");
		System.out.println(c.registerCandidate(c));
	}*/
}

