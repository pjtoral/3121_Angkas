public class Driver extends User {
	
	public int totalNumberOfBookings;
	
	Driver() {		
	}
	
	Driver(String name, long mobileNumber) {
		super(name, mobileNumber);
	}
	
	public boolean equals(Driver d2) {
		if (this.name.equals(d2.name)) {
			if (this.mobileNumber == d2.mobileNumber) {
				return true;
			}
		}
		return false;
	}
	
	public String toString() {
		return "[Driver] " + name + ", " + mobileNumber;
	}
	
}