public class Driver extends User {
	
	public int totalNumberOfBookings;
	
	Driver()	// No-Arg Constructor 
	{		
		// body of the constructor
	}
	
	Driver(String name, long mobileNumber) // Constructor with two parameters
	{
		super();
	}
	
	public boolean equals(Driver d2) {	// Boolean Method to determine if the mobile numbers are equal
		if (this.name.equals(d2.name)) {
			if (this.mobileNumber == d2.mobileNumber) {
				return true;
			}
		}
		return false;
	}
	
	public String toString() {		// String toString() Method to returns the string itself
		return "[Driver] " + name + ", " + mobileNumber;
	}
	
}