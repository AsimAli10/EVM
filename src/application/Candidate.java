package application;

import java.io.IOException;

public class Candidate {

    String name;
    String id;
    String group;
    int votes;
    public Candidate(String n, String Id, String grp){
        name=n;
        id=Id;
        group=grp;
        
        
    }
    public int getVotes()
    {
    	return votes;
    }
    public void setVotes(int v)
    {
    	this.votes=v;
    }
    public Candidate() {
		// TODO Auto-generated constructor stub
	}
	public int registerCandidate(Candidate candidate) throws IOException
    {
        if(this.checkNotAllowedCandidate(candidate))
        {
            if(this.checkExistingCandidate(candidate))
            {
            	dataBase db=new dataBase();
            	if(db.registerCandidate(candidate))
                return 2;
            }
            else
            return 1;
        }
        else
        return 0;
        return 0;
    }
    private boolean checkNotAllowedCandidate(Candidate candidate) throws IOException {
    	dataBase db=new dataBase();
    	return db.checkNotAllowedCandidate(candidate);
		
	}
	private boolean checkExistingCandidate(Candidate candidate) throws IOException {
    	
		dataBase db=new dataBase();
    	return db.checkExistingCandidate(candidate);
	}
	

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getGroup() {
        return group;
    }




}