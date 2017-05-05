package base;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import domain.PersonDomainModel;

public class Person_Test {
	
	static PersonDomainModel person = new PersonDomainModel();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		person.setFirstName("Kirstie");
		person.setLastName("Niessen");
		person.setCity("Kennett Square PA");
		person.setBirthday(LocalDate.now());
		person.setPostalCode(19348);
		person.setStreet("136 West Thomas Court");
		PersonDAL.addPerson(person);
		PersonDomainModel person_2 = PersonDAL.getPerson(person.getPersonID());
		
		assertNotNull(person_2);
	}
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		
		PersonDAL.deletePerson(person.getPersonID());
	}

	@Test
	public void AddPerson() {
		PersonDAL.addPerson(person);
		PersonDomainModel person_2 = PersonDAL.getPerson(person.getPersonID());
		
		assertNotNull(person_2);
		
	}
	
	@Test
	public void UpdateDelete(){
		
		PersonDomainModel person_2 = PersonDAL.getPerson(person.getPersonID());
		assertEquals(person.getPersonID(), person_2.getPersonID());
		person_2.setLastName("Marsh");
		PersonDAL.updatePerson(person_2);
		PersonDomainModel person_3 = PersonDAL.getPerson(person_2.getPersonID());
		assertEquals(person_2.getLastName(), person_3.getLastName());
		assertNotEquals(person.getLastName(), person_3.getLastName());	
		PersonDAL.deletePerson(person.getPersonID());
		PersonDomainModel person_4 = PersonDAL.getPerson(person.getPersonID());
		assertNull(person_4);
		
		
	}

		
	}

