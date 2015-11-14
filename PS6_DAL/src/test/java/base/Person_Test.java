package base;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import domain.PersonDomainModel;

public class Person_Test {

	private static PersonDomainModel per1;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		Date dDate = null;
		try {
			dDate = new SimpleDateFormat("yyyy-MM-dd").parse("1994-06-06");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		per1 = new PersonDomainModel();
		per1.setFirstName("Joshua");
		per1.setLastName("Johnson");
		per1.setBirthday(dDate);
		per1.setCity("Dover");
		per1.setPostalCode(19010);
		per1.setStreet("20 tam o shanter ct");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		PersonDomainModel per;	
		PersonDAL.deletePerson(per1.getPerID());
		per = PersonDAL.getPerson(per1.getPerID());
		assertNull("The Person is not in the database",per);		
	}
	
	@Test
	public void AddPersonTest()
	{		
		PersonDomainModel per;		
		per = PersonDAL.getPerson(per1.getPerID());		
		assertNull("The Person is not the database",per);		
		PersonDAL.addPerson(per1);	
		
		per = PersonDAL.getPerson(per1.getPerID());
		System.out.println(per1.getPerID() +  per1.getFirstName());
		assertNotNull("The Person is in the database",per1);
	}
	
	@Test
	public void UpdatePersonTest()
	{		
		PersonDomainModel per;
		final String Other_LASTNAME = "Jones";
		
		per = PersonDAL.getPerson(per1.getPerID());		
		assertNull("The Person is not in the database",per);		
		PersonDAL.addPerson(per1);	
		
		per1.setLastName(Other_LASTNAME);
		PersonDAL.updatePerson(per1);
		
		per = PersonDAL.getPerson(per1.getPerID());

		assertTrue("Name Didn't Change",per1.getLastName() == Other_LASTNAME);
	}

	@Test
	public void DeletePersonTest()
	{		
		PersonDomainModel per;		
		per = PersonDAL.getPerson(per1.getPerID());		
		assertNull("The Person is not in the database",per);	
		
		PersonDAL.addPerson(per1);			
		per = PersonDAL.getPerson(per1.getPerID());
		System.out.println(per1.getPerID() + per1.getFirstName());
		//assertNotNull("The Person should have been added to the database",per);
		
		PersonDAL.deletePerson(per1.getPerID());
		per = PersonDAL.getPerson(per1.getPerID());		
		assertNull("The Person is not the database",per);	
		
	}
	
}