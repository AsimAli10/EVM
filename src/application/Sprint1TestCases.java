

package application;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

class Sprint1TestCases {
	
	ElectronicVotingMachine evm=new ElectronicVotingMachine();
	@Test
	void adminLogintest() throws IOException {
		int check = evm.authenticateUser("Admin","admin");
		assertEquals(1, check);
	}
	
	@Test
	void RegisteredVoterLogintest() throws IOException {
		int check = evm.authenticateUser("727842791","dniwhdi");
		assertEquals(2, check);
	}
	@Test
	void VoterLoginnotRegisteredtest() throws IOException {
		int check = evm.authenticateUser("455662593","dniwhdi");
		assertEquals(0, check);
	}
	@Test
	void VoterRegistrationTest() throws IOException {
		int check = evm.RegisterNewUser("Adeen","132263824","123456");
		assertEquals(1, check);
	}
	@Test
	void InvalidRegistrationTest() throws IOException {
		int check = evm.RegisterNewUser("Adeen","0987612","123456");
		assertEquals(0, check);
	}

}