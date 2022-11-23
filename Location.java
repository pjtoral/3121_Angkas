public class Location {
	
	private String address;
	private double latitude;
	private double longitude;
	
	Location() {
		address = "";
	}
	
	Location(String address, double latitude, double longitude) {
		this.address = address;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	public double getLatitude() {
		return this.latitude;
	}
	
	public double getLongitude() {
		return this.longitude;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	public String toString() {
		return "[Location] " + address + ", " + latitude + ", " + longitude;
	}
	
}