public class User {
	
	protected String name;
	protected long mobileNumber;
	
	User() {
		name = "";
	}
	
	User(String name, long mobileNumber) {
		this.name = name;
		this.mobileNumber = mobileNumber;
	}
	
	public String getName() {
		return this.name;
	}
	
	public long getMobileNumber() {
		return this.mobileNumber;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
}