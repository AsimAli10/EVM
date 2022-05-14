package application;

import java.io.IOException;
import java.util.List;

public class CandidatesList {
    static List<Voter> candidatelist;

	public int registerCandidate(Candidate candidate) throws IOException {
		return candidate.registerCandidate(candidate);
	}

	public String getCandidates() throws IOException {
		dataBase db = new dataBase();
		return db.getCandidates();
	}

	public Candidate checkWinner() throws IOException {
		dataBase db = new dataBase();
		return db.checkWinner();
	}
}