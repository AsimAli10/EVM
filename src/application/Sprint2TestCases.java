package application;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

public class Sprint2TestCases {
	
	ElectronicVotingMachine evm=new ElectronicVotingMachine();
	@Test
	void eligibleVotingStatusTest() throws IOException {
		boolean check = evm.checkVotingStatus("132263824");
		assertEquals(true, check);
	}
	@Test
	void nonEligibleVotingStatusTest() throws IOException {
		boolean check = evm.checkVotingStatus("125429955");
		assertEquals(false, check);
	}
	@Test
	void banedCandidateRegistrationTest() throws IOException {
		Candidate c=new Candidate("Herman Schwoeppe","387150986","groupB");
		int check = evm.registerCandidate(c);
		assertEquals(0, check);
	}
	@Test
	void existingCandidateRegistrationTest() throws IOException {
		Candidate c=new Candidate("Marlin","563151682","groupB");
		int check = evm.registerCandidate(c);
		assertEquals(1, check);
	}
	

}
