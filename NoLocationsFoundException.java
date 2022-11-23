public class NoLocationsFoundException extends Exception {
	public NoLocationsFoundException() {
		super("No locations found for your search string.");
	}
}
