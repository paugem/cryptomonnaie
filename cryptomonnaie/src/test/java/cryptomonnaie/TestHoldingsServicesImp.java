package cryptomonnaie;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cda.jee.model.Holdings;
import com.cda.jee.services.HoldingsServicesImp;

class TestHoldingsServicesImp {
	HoldingsServicesImp holdServiceImp = new HoldingsServicesImp();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testIndex() {
		ArrayList<Holdings> liste1 = holdServiceImp.index();
		holdServiceImp.create(new Holdings());
		ArrayList<Holdings> liste2 = holdServiceImp.index();
		assertTrue(liste1.size()<liste2.size());
	}

	@Test
	void testCreate() {
		fail("Not yet implemented");
	}

	@Test
	void testRead() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	void testDelete() {
		fail("Not yet implemented");
	}

}
