import java.util.Date;

public class Booking {
	
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
	
	protected boolean isCompleted() {
		return completed;
	}
	
	protected void markAsCompleted() {
		this.completed = true;
	}
	
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