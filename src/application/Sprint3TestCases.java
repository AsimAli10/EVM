package application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

public class Sprint3TestCases {
	
	ElectronicVotingMachine evm=new ElectronicVotingMachine();
	@Test
	void castVoteTest() throws IOException {
		boolean check = evm.castVote("125429955","563151682");
		assertEquals(false, check);
	}
	@Test
	void checkWinnerTest() throws IOException {
		Candidate can=evm.checkWinner();
		assertEquals("563151682",can.getId());
	}
	@Test
	void checkNonWinnerTest() throws IOException {
		Candidate can=evm.checkWinner();
		assertNotEquals("382092160",can.getId());
	}
	

}
