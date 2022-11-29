public class User {
	//This is my comment hehe 
	protected String name;
	protected long mobileNumber;
	protected long SOScontactNumber;

	User() {
		name = "";
	}
	
	User(String name, long mobileNumber, long SOScontactNumber) {
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.SOScontactNumber = SOScontactNumber;
	}
	//Setters and getters
	public String getName() {
		return this.name;
	}
	
	public long getMobileNumber() {
		return this.mobileNumber;
	}
	
	public long getSOScontactNumber() {
		return this.SOScontactNumber;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public void setSOScontactNumber(long SOScontactNumber) {
		this.SOScontactNumber = SOScontactNumber;
	}
}