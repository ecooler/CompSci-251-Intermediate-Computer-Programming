
public class Park {
	public int minimumAge;
	public double minimumHeight;
	public int minimumTickets;
	
	/**
	 * This method should have semantics very similar to the attemptToRide method in the homework
	 * However, this time, since the Ride fields are public, we have to check them against 
	 * the Park object's minimums.
	 * Determine the requirements as follows: for of the three requirements, if the Ride object has a requirement
	 * that is at least the Park object's minimum, use that. Otherwise, use the Park's minimum.
	 * (Don't change the Ride object's fields)
	 * If the Person is old enough, tall enough, and has enough tickets, 
	 * subtract that number of tickets from the Person and return true
	 * If the Ride is null, or the Person is null, return false without changing anything.
	 * If any of this Park's, or the Person's or Ride's fields are negative, this should return false
	 * without changing anything.
	 * @param guest who is attempting to ride
	 * @param ride to be ridden
	 * @return true if they were able to ride, false otherwise.
	 * return false if ride is null or invalid values are detected.
	 */
	public boolean ride(Person guest, Ride ride) {
		return true;
	}
}
