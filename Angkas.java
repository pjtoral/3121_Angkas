import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Angkas {
	
	private static final int arraySize = 10000;
	
	private static Location[] locations = new Location[arraySize];
	private static Driver[] drivers = new Driver[arraySize];
	private static Customer[] customers = new Customer[arraySize];
	private static Booking[] bookings = new Booking[arraySize];
	private static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		createLocations();
		
		do {
			
			int choice = displayMenu();
			
			switch(choice) {
				case 0: System.exit(0);
				case 1: addDriver(); break;
				case 2: deleteDriver(); break;
				case 3: displayDrivers(); break;
				case 4: addCustomer(); break;
				case 5: deleteCustomer(); break;
				case 6: displayCustomers(); break;
				case 7: displayLocations(); break;
				case 8: 
					try {
						searchLocation();
					} catch (NoLocationsFoundException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 9: addBooking(); break;
				case 10: completeBooking(); break;
				case 11: displayActiveBookings(); break;
				case 12: save(); break;
				case 13: load(); break;
				default: break;
			}
			
		} while(true);
		
		
	}
	
	private static int displayMenu() {
		
		System.out.println("1. Add Driver");
		System.out.println("2. Delete Driver");
		System.out.println("3. Display Drivers");
		
		System.out.println("4. Add Customer");
		System.out.println("5. Delete Customer");
		System.out.println("6. Display Customers");
		
		System.out.println("7. Display Locations");
		System.out.println("8. Search Locations");
		
		System.out.println("9. Make a Booking");
		System.out.println("10. Complete a Booking");
		System.out.println("11. Display Active Bookings");
		
		System.out.println("0. Exit");
		System.out.println("12. Save all data to file");
		System.out.println("13. Load all data from file");
		
		
		int choice = -1;
		
		do {
			try {
				System.out.print("Enter a choice: ");
				choice = input.nextInt();
			} catch(InputMismatchException ime) {
				System.out.println("Incorrect selection.");
				input.next();
			} finally {
				//statements here are executed regardless of whether an exception happened or not
			}
		} while(choice == -1);
		
		return choice;
	}
	
	private static void addDriver() {
		
		Driver d = new Driver();
		
		System.out.print("Enter Driver Name: ");
		input.nextLine(); //delete later
		d.setName(input.nextLine());
		
		System.out.print("Enter Mobile Number: ");
		d.setMobileNumber(input.nextLong());
		
		boolean added = false;
		for (int i = 0; i < drivers.length; i++) {
			if (drivers[i] == null) {
				drivers[i] = d;
				added = true;
				break;
			}
		}
		
		if (!added) {
			System.out.println("Error: Driver database is full.");
		}
		
	}
	
	private static void addCustomer() {
		
		Customer c = new Customer();
		
		System.out.print("Enter Customer Name: ");
		input.nextLine(); //delete later
		c.setName(input.nextLine());
		
		System.out.print("Enter Mobile Number: ");
		try {
			c.setMobileNumber(input.nextLong());
		} catch (InputMismatchException ime) {
			System.out.println("Incorrect format for mobile number.");
		}
		
		boolean added = false;
		for (int i = 0; i < customers.length; i++) {
			if (customers[i] == null) {
				customers[i] = c;
				added = true;
				break;
			}
		}
		
		if (!added) {
			System.out.println("Error: Customer database is full.");
		}
		
	}
	
	private static void addBooking() {
		
		if (countDrivers() == 0 || countCustomers() == 0) {
			System.out.println("No Drivers or Customers in the database yet.");
			return;
		}
		
		displayCustomers();
		System.out.print("Enter the number of the customer: ");
		Customer c = customers[input.nextInt()];
		
		displayDrivers();
		System.out.print("Enter the number of the driver: ");
		Driver d = drivers[input.nextInt()];
		
		Location pickup = null;
		
		do {
			try {
				searchLocation();
				System.out.print("Enter the number of the pickup location: ");
				pickup = locations[input.nextInt()];
			} catch(NoLocationsFoundException e) {
				System.out.println(e.getMessage());
			}	
		} while(pickup == null);
		
		
		Location dropoff = null;
		
		do {
			try {
				searchLocation();
				System.out.print("Enter the number of the dropoff location: ");
				dropoff = locations[input.nextInt()];
			} catch(NoLocationsFoundException e) {
				System.out.println(e.getMessage());
			}
		} while (dropoff == null);		
		
		Date now = new Date();
		
		Booking b = new Booking(c, d, now, pickup, dropoff);		
		
		boolean added = false;
		for (int i = 0; i < bookings.length; i++) {
			if (bookings[i] == null) {
				bookings[i] = b;
				added = true;
				break;
			}
		}
		
		if (!added) {
			System.out.println("Error: Booking database is full.");
		} else {
			System.out.println("Successfully booked " + c.getName() + " with " + d.getName() + " from " + pickup.getAddress() + " to " + dropoff.getAddress() + " at " + now);
		}
		
	}
	
	private static void deleteDriver() {
		
		displayDrivers();
		
		System.out.print("Enter the number of the Driver to delete: ");
		int indexToDelete = input.nextInt();
		
		drivers[indexToDelete] = null;
		
	}
	
	private static void deleteCustomer() {
		
		displayCustomers();
		
		System.out.print("Enter the number of the Customer to delete: ");
		int indexToDelete = input.nextInt();
		
		customers[indexToDelete] = null;
		
	}
	
	private static void completeBooking() {
		
		displayActiveBookings();
		
		System.out.print("Enter the number of the Booking to complete: ");
		int indexToComplete = input.nextInt();
		
		bookings[indexToComplete].markAsCompleted();

	}
	
	
	private static void displayDrivers() {
		for (int i = 0; i < drivers.length; i++) {
			if (drivers[i] != null) {
				System.out.println(i + ": " + drivers[i]);
			}
		}
	}
	
	private static void displayCustomers() {
		for (int i = 0; i < customers.length; i++) {
			if (customers[i] != null) {
				System.out.println(i + ": " + customers[i]);
			}
		}
	}
	
	private static void displayLocations() {
		for (int i = 0; i < locations.length; i++) {
			if (locations[i] != null) {
				System.out.println(i + ": " + locations[i]);
			}
		}
	}
	
	private static void displayActiveBookings() {
		for (int i = 0; i < bookings.length; i++) {
			if (bookings[i] != null) {
				if (bookings[i].isCompleted() == false) {
					System.out.println(i + ": " + bookings[i]);
				}
			}
		}
	}
	
	private static int countDrivers() {
		int count = 0;
		for (Driver d : drivers) {
			if (d != null) {
				count++;
			}
		}
		return count;
	}
	
	private static int countCustomers() {
		int count = 0;
		for (Customer c : customers) {
			if (c != null) {
				count++;
			}
		}
		return count;
	}
	
	private static void createLocations() {
		locations[0] = new Location("USC Talamban", 10.353009856805054, 123.91346193389556);
		locations[1] = new Location("USC Main", 10.300309319529106, 123.89835760785145);
		locations[2] = new Location("Mactan Airport", 10.312506927208169, 123.98017971732706);
		locations[3] = new Location("SM City Cebu Mall", 10.312418573918931, 123.91787593882432);
		locations[4] = new Location("SM Seaside Mall", 10.282366809626353, 123.88046710157114);
		locations[5] = new Location("Taboan", 10.296518315656636, 123.89127994957185);
		locations[6] = new Location("Carbon", 10.292551435724878, 123.89913937507386);
		locations[7] = new Location("Pier 1", 10.292501221780078, 123.90909124510753);
		locations[8] = new Location("Cebu City Hall", 10.29307360788318, 123.90172715911378);
		locations[9] = new Location("Cebu Provincial Capitol", 10.316808447131276, 123.89070225950223);
		locations[10] = new Location("Ayala Center Cebu Mall", 10.319063296773708, 123.90454134561374);
		locations[11] = new Location("Robinsons Galleria Mall", 10.304521295600214, 123.91119042893347);
		locations[12] = new Location("Vicente Sotto Hospital", 10.30902881879025, 123.89167382871386);
		locations[13] = new Location("UC Medical Center Hospital", 10.321017039722578, 123.93085662955787);
		locations[14] = new Location("Chong Hua Hospital Mandaue", 10.323456034416841, 123.93157557371848);	
	}
	
	private static void searchLocation() throws NoLocationsFoundException {
		input.nextLine(); //delete later
		System.out.print("Enter text to search locations: ");
		String search = input.nextLine();
		int numberOfSearchResults = 0;
		for (int i = 0; i < locations.length; i++) {
			if (locations[i] != null) {
				if (locations[i].getAddress().toUpperCase().indexOf(search.toUpperCase()) > -1) {
					System.out.println(i + ": " + locations[i]);
					numberOfSearchResults++;
				}
			}
		}
		if (numberOfSearchResults == 0) {
			throw new NoLocationsFoundException();
		}	
	}
	
	private static void save() {
		File driversFile = new File("C:\\Users\\Paul Ouano\\eclipse-workspace\\Angkas\\src\\data\\drivers.txt");
		PrintWriter driversPrintWriter;
		try {
			driversPrintWriter = new PrintWriter(driversFile);
		} catch(FileNotFoundException fnfe) {
			System.out.println(fnfe.getMessage());
			return;
		}
		
		for (Driver d: drivers) {
			if (d != null) {
				driversPrintWriter.println(d.getName() + ";" + d.mobileNumber);
			}
		}		
		
		driversPrintWriter.close();		
	}
	
	private static void load() {
		File driversFile = new File("C:\\Users\\Paul Ouano\\eclipse-workspace\\Angkas\\src\\data\\drivers.txt");
		Scanner driversScanner;
		try {
			driversScanner = new Scanner(driversFile);
		} catch (FileNotFoundException fnfe) {
			System.out.println(fnfe.getMessage());
			return;
		}
		while (driversScanner.hasNext()) {
			String driver = driversScanner.nextLine();
			String[] driverDetails = driver.split(";");
			long driverMobileNumber = Long.parseLong(driverDetails[1]);
			Driver d = new Driver(driverDetails[0], driverMobileNumber);
			drivers[countDrivers()] = d;
		}		
		driversScanner.close();
	
	}

}