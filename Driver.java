import java.time.LocalDate;

public class Driver {
	public static void main(String[] args) {
		
		// Initialize values
		Tool tool1 = new Tool("CHNS","Chainsaw","Stihl");
		// DEBUG statements
//		Tool tool2 = new Tool("LADW","Ladder","Werner");
//		Tool tool3 = new Tool("JAKD","Jackhammer","DeWalt");
//		Tool tool4 = new Tool("JAKR","Jackhammer","Ridgid");
		LocalDate checkOutDate = LocalDate.of(2023, 1, 2);
		int rentalDays = 9;
		int percentDiscount = 40;
		
        Checkout checkout = new Checkout(tool1, checkOutDate, rentalDays, percentDiscount);
        checkout.calculate();
	}
}