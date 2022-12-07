//Vincent Joshua C. Adlaon 19102491

public class Customer extends User {
	
	Customer() {
		
	}
	
	Customer(String name, long mobileNumber) {
		super(name, mobileNumber);
	}
	
	public boolean equals(Customer c2) {
		if (this.mobileNumber == c2.mobileNumber) {
			return true;
		}
		return false;
	}
	
	public String toString() {
		return "[Customer] " + name + ", " + mobileNumber;
	}
	
}