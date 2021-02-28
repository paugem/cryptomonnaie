package cryptomonnaie;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cda.jee.model.Holding;
import com.cda.jee.services.HoldingsServicesImp;

class TestHoldingServicesImp {
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
		String sDate1="2020-08-23";
		float f1 = 238;
		float f2 = 240;
		float delta = f2-f1;
		Date date1;
		try {
			date1 = new SimpleDateFormat("yyyy-MM-dd").parse(sDate1);
			ArrayList<Holding> liste1 = holdServiceImp.index();
			holdServiceImp.create(new Holding("Test2",200,f1,new java.sql.Date(date1.getTime()),f2,delta));
			ArrayList<Holding> liste2 = holdServiceImp.index();
			assertTrue(liste1.size()<liste2.size());
		}
		catch (ParseException e) {
			e.printStackTrace();
		}
	}

	@Test
	void testCreate() {
		String sDate1="2020-08-23";
		float f1 = 238;
		float f2 = 240;
		float delta = f2-f1;
		Date date1;
		try {
			date1 = new SimpleDateFormat("yyyy-MM-dd").parse(sDate1);
			Holding hold1 = new Holding(11,"Test",200,f1,new java.sql.Date(date1.getTime()),f2,delta);
			Holding hold2 = new Holding("Test",200,f1,new java.sql.Date(date1.getTime()),f2,delta);
			Holding hold3 = holdServiceImp.create(hold2);
			assertEquals(hold1,hold3);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	@Test
	void testRead() {
		String sDate1="2020-08-23";
		float f1 = 238;
		float f2 = 240;
		float delta = f2-f1;
		Date date1;
		try {
			date1 = new SimpleDateFormat("yyyy-MM-dd").parse(sDate1);
			Holding hold1 = new Holding(11,"Test",200,f1,new java.sql.Date(date1.getTime()),f2,delta);
			Holding hold2 = holdServiceImp.read(11);
			assertEquals(hold1,hold2);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	@Test
	void testUpdate() {
		String sDate1="2020-08-23";
		float f1 = 238;
		float f2 = 240;
		float delta = f2-f1;
		Date date1;
		try {
			date1 = new SimpleDateFormat("yyyy-MM-dd").parse(sDate1);
			Holding hold1 = holdServiceImp.read(11);
			Holding hold2 = new Holding(5,"Test",600,f1,new java.sql.Date(date1.getTime()),f2,delta);
			holdServiceImp.update(hold2);
			Holding hold3 = holdServiceImp.read(11);
			assertNotEquals(hold1,hold3);
			assertEquals(hold2, hold3);
		}
		catch(ParseException e) {
			e.printStackTrace();			
		}
	}

	@Test
	void testDelete() {
	ArrayList<Holding> liste1 = holdServiceImp.index();
	holdServiceImp.delete(11);
	ArrayList<Holding> liste2 = holdServiceImp.index();
	assertTrue(liste1.size()>liste2.size());
	}

}
