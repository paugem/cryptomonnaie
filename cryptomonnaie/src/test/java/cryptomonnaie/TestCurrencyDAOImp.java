package cryptomonnaie;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cda.jee.dao.CurrencyDAOImp;
import com.cda.jee.model.Currency;

class TestCurrencyDAOImp {
	CurrencyDAOImp curDaoImp = new CurrencyDAOImp();

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
	void testGetAll() {
		fail("Not yet implemented");
	}

	@Test
	void testAdd() {
		float var = 30;
		Currency cur1 = new Currency(11,"Test","TST",var);
		Currency cur2 = new Currency("Test","TST",var);
		Currency cur3 = curDaoImp.add(cur2);
		assertEquals(cur1,cur3);
	}

	@Test
	void testGetById() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateById() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteById() {
		fail("Not yet implemented");
	}

}
