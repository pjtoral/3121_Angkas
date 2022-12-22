//Alfonso Miguelle Branzuela

import java.util.Date;
//Class for booking appointments
public class Booking {

	/**
	 *Private Repositories
	 */

	private Customer customer;
	private Driver driver;
	private Date bookingDate;
	private Location pickup;
	private Location dropoff;
	private boolean completed;
	
	Booking(Customer customer, Driver driver, Date bookingDate, Location pickup, Location dropoff) {

		this.customer = customer;
		this.driver = driver;
		this.bookingDate = bookingDate;
		this.pickup = pickup;
		this.dropoff = dropoff;		
	}
	
	/**
	 * @return true if booking is completed
	 */
	protected boolean isCompleted() {
		return completed;
	}
	
	/**
	 * This method will mark a booking as completed.
	 */
	protected void markAsCompleted() {
		this.completed = true;
	}
	
	
	/**
	 * Override the toString() method of the Object class
	 */
	public String toString() {
		String result = "\n[Booking]";
		result += "\nCustomer: " + customer.getName();
		result += "\nDriver  : " + driver.getName();
		result += "\nDate    : " + bookingDate;
		result += "\nPickup  : " + pickup.getAddress();
		result += "\nDropoff : " + dropoff.getAddress();
		result += "\nComplete: " + completed; 
		return result;
	}
	
}