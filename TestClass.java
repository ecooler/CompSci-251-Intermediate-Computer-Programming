import junit.framework.TestCase;

public class TestClass extends TestCase{
	
	Person defaultsPerson;
	Person fivesPerson;
	Person negAgePerson;
	Person negHeightPerson;
	Person negTicketsPerson;
	Person lowAgePerson;
	Person lowHeightPerson;
	Person lowTicketsPerson;

	Ride defaultsRide;
	Ride fivesRide;
	Ride negAgeRide;
	Ride negHeightRide;
	Ride negTicketsRide;

	Park defaultsPark;
	Park threesPark;
	Park negAgePark;
	Park negHeightPark;
	Park negTicketsPark;
	Park highAgePark;
	Park highHeightPark;
	Park highTicketsPark;
	
	
	public void setUp() {
		//create a bunch of objects to use for testing later
		
		defaultsPerson = new Person();
		fivesPerson = new Person(); fivesPerson.age = 5; fivesPerson.height = 5.0; fivesPerson.tickets = 5;
		negAgePerson = new Person(); negAgePerson.age = -1; negAgePerson.height = 5.0; negAgePerson.tickets = 5;
		negHeightPerson = new Person(); negHeightPerson.age = 5; negHeightPerson.height = -1.0; negHeightPerson.tickets = 5;
		negTicketsPerson = new Person(); negTicketsPerson.age = 5; negTicketsPerson.height = 5.0; negTicketsPerson.tickets = -1;
		lowAgePerson = new Person(); lowAgePerson.age = 2; lowAgePerson.height = 5.0; lowAgePerson.tickets = 5;
		lowHeightPerson = new Person(); lowHeightPerson.age = 5; lowHeightPerson.height = 2.0; lowHeightPerson.tickets = 5;
		lowTicketsPerson = new Person(); lowTicketsPerson.age = 5; lowTicketsPerson.height = 5.0; lowTicketsPerson.tickets = 2;

		defaultsRide = new Ride();
		fivesRide = new Ride(); fivesRide.ageReq = 5; fivesRide.heightReq = 5.0; fivesRide.ticketReq = 5;
		negAgeRide = new Ride(); negAgeRide.ageReq = -1; negAgeRide.heightReq = 5.0; negAgeRide.ticketReq = 5;
		negHeightRide = new Ride(); negHeightRide.ageReq = 5; negHeightRide.heightReq = -1.0; negHeightRide.ticketReq = 5;
		negTicketsRide = new Ride(); negTicketsRide.ageReq = 5; negTicketsRide.heightReq = 5.0; negTicketsRide.ticketReq = -1;

		defaultsPark = new Park();
		threesPark = new Park(); threesPark.minimumAge = 3; threesPark.minimumHeight = 3.0; threesPark.minimumTickets = 3;
		negAgePark = new Park(); negAgePark.minimumAge = -1; negAgePark.minimumHeight = 3.0; negAgePark.minimumTickets = 3;
		negHeightPark = new Park(); negHeightPark.minimumAge = 3; negHeightPark.minimumHeight = -1.0; negHeightPark.minimumTickets = 3;
		negTicketsPark = new Park(); negTicketsPark.minimumAge = 3; negTicketsPark.minimumHeight = 3.0; negTicketsPark.minimumTickets = -1;
		highAgePark = new Park(); highAgePark.minimumAge = 10; highAgePark.minimumHeight = 3.0; highAgePark.minimumTickets = 3;
		highHeightPark = new Park(); highHeightPark.minimumAge = 3; highHeightPark.minimumHeight = 10.0; highHeightPark.minimumTickets = 3;
		highTicketsPark = new Park(); highTicketsPark.minimumAge = 3; highTicketsPark.minimumHeight = 3.0; highTicketsPark.minimumTickets = 10;
	}
	
	
	//test default values (for primitive numeric variables these are generally 0 values)
	public void test00() {
		assertTrue(defaultsPark.ride(defaultsPerson, defaultsRide));
		assertEquals(0, defaultsPerson.tickets);
		assertTrue(defaultsPark.ride(defaultsPerson, defaultsRide));
	}
	
	//test nulls
	//why didn't we test null.ride(...)?
	public void test01() {
		assertFalse(defaultsPark.ride(null, null));
		assertFalse(defaultsPark.ride(fivesPerson, null));
		assertFalse(defaultsPark.ride(null, fivesRide));
		assertEquals(5, fivesPerson.tickets);
		assertEquals(5, fivesRide.ticketReq);
	}
	
	//test negative values
	public void test02() {
		assertFalse(negAgePark.ride(fivesPerson, fivesRide));
		assertFalse(negHeightPark.ride(fivesPerson, fivesRide));
		assertFalse(negTicketsPark.ride(fivesPerson, fivesRide));
		assertFalse(threesPark.ride(negAgePerson, fivesRide));
		assertFalse(threesPark.ride(negHeightPerson, fivesRide));
		assertFalse(threesPark.ride(negTicketsPerson, fivesRide));
		assertFalse(threesPark.ride(fivesPerson, negAgeRide));
		assertFalse(threesPark.ride(fivesPerson, negHeightRide));
		assertFalse(threesPark.ride(fivesPerson, negTicketsRide));
	}
	
	//test ride-set requirements
	public void test03() {
		assertTrue(threesPark.ride(fivesPerson, fivesRide));
		assertEquals(0, fivesPerson.tickets);
		assertFalse(threesPark.ride(fivesPerson, fivesRide));
		assertFalse(threesPark.ride(defaultsPerson, fivesRide));
		assertFalse(threesPark.ride(lowAgePerson, fivesRide));
		assertFalse(threesPark.ride(lowHeightPerson, fivesRide));
		assertFalse(threesPark.ride(lowTicketsPerson, fivesRide));
		assertEquals(2, lowTicketsPerson.tickets);
		
		assertEquals(3, threesPark.minimumAge);
		assertEquals(3.0, threesPark.minimumHeight);
		assertEquals(3, threesPark.minimumTickets);
	}
	
	//test park-set requirements
	public void test04() {
		assertTrue(threesPark.ride(fivesPerson, defaultsRide));
		assertEquals(2, fivesPerson.tickets);
		assertFalse(threesPark.ride(fivesPerson, defaultsRide));
		
		fivesPerson.tickets = 5;
		assertFalse(highAgePark.ride(fivesPerson, fivesRide));
		assertFalse(highHeightPark.ride(fivesPerson, fivesRide));
		assertFalse(highTicketsPark.ride(fivesPerson, fivesRide));
		assertEquals(5, fivesPerson.tickets);
		
		assertEquals(5, fivesRide.ageReq);
		assertEquals(5.0, fivesRide.heightReq);
		assertEquals(5, fivesRide.ticketReq);
	}
	
	//test other combinations
	public void test05() {
		Person testPerson = new Person(); testPerson.age = 12; testPerson.height = 4.0; testPerson.tickets = 8;
		assertFalse(highAgePark.ride(testPerson, fivesRide));
		testPerson = new Person(); testPerson.age = 12; testPerson.height = 8.0; testPerson.tickets = 4;
		assertFalse(highAgePark.ride(testPerson, fivesRide));
		testPerson = new Person(); testPerson.age = 8; testPerson.height = 12.0; testPerson.tickets = 4;
		assertFalse(highHeightPark.ride(testPerson, fivesRide));
		testPerson = new Person(); testPerson.age = 4; testPerson.height = 12.0; testPerson.tickets = 8;
		assertFalse(highHeightPark.ride(testPerson, fivesRide));
		testPerson = new Person(); testPerson.age = 4; testPerson.height = 8.0; testPerson.tickets = 12;
		assertFalse(highTicketsPark.ride(testPerson, fivesRide));
		testPerson = new Person(); testPerson.age = 8; testPerson.height = 4.0; testPerson.tickets = 12;
		assertFalse(highTicketsPark.ride(testPerson, fivesRide));
		
		assertEquals(5, fivesRide.ageReq);
		assertEquals(5.0, fivesRide.heightReq);
		assertEquals(5, fivesRide.ticketReq);
	}
	
}
