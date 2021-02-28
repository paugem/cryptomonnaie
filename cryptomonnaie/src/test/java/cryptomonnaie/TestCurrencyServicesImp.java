package cryptomonnaie;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cda.jee.model.Currency;
import com.cda.jee.services.CurrencyServicesImp;

class TestCurrencyServicesImp {
	CurrencyServicesImp curServicesImp = new CurrencyServicesImp();

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
		ArrayList<Currency> liste1 = curServicesImp.index();
		curServicesImp.create(new Currency());
		ArrayList<Currency> liste2 = curServicesImp.index();
		assertTrue(liste1.size()<liste2.size());
	}

	@Test
	void testCreate() {
		float var = 30;
		Currency cur1 = new Currency(11,"Test","TST",var);
		Currency cur2 = new Currency("Test","TST",var);
		Currency cur3 = curServicesImp.create(cur2);
		assertEquals(cur1,cur3);
	}

	@Test
	void testRead() {
		float var =	30;	
		Currency cur1 = new Currency(1,"Bitcoin","BTC",var);
		Currency cur2 = curServicesImp.read(1);
		assertEquals(cur1,cur2);		
	}

	@Test
	void testUpdate() {
		float var = 40;
		Currency cur1 = curServicesImp.read(1);
		Currency cur2 = new Currency(1,"Bitcoin","BTC",var);
		curServicesImp.update(cur2);
		Currency cur3 = curServicesImp.read(1);
		assertEquals(cur2, cur3);
		assertNotEquals(cur1, cur3);
	}

	@Test
	void testDelete() {
		ArrayList<Currency> liste1 = curServicesImp.index();
		curServicesImp.delete(14);
		ArrayList<Currency> liste2 = curServicesImp.index();
		assertTrue(liste1.size()>liste2.size());
	}

}
