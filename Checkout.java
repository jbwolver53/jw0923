import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class Checkout {
	
	private Tool tool;
	private LocalDate checkOutDate;
	private int rentalDays;
	private int percentDiscount;
	
	public Checkout(Tool tool, LocalDate checkOutDate, int rentalDays, int percentDiscount) {
		this.tool = tool;
		this.checkOutDate = checkOutDate;
		this.rentalDays = rentalDays;
		this.percentDiscount = percentDiscount;
		
		// Sanity checks
		if (rentalDays < 1) {
			System.out.println("Rental day count is not 1 or greater, defaulting to 1.");
			this.rentalDays = 1;
		}
		if (percentDiscount < 0 || percentDiscount > 100) {
			System.out.println("Discount percent is not in the range 0-100. Defaulting to 0.");
			this.percentDiscount = 0;
		}
	}
	
	public RentalAgreement calculate() {
		double preDiscountTotal = 0.0;
		double dailyRentalCharge = 0;
		boolean weekendCharge = false;
		boolean holidayCharge = false;
		
		// Check for the tool type and set the appropriate charges
		// (Weekday charge is being excluded since it is always true)
		if (tool.getToolCode().substring(0, 3).equals("LAD")) {
			dailyRentalCharge = 1.99;
			weekendCharge = true;
		}
		else if (tool.getToolCode().substring(0, 3).equals("CHN")) {
			dailyRentalCharge = 1.49;
			holidayCharge = true;
		}
		// Jackhammer is the fallback case
		else {
			dailyRentalCharge = 2.99;
		}
		
		int chargeableDays = chargeableDays(weekendCharge, holidayCharge);
		preDiscountTotal = dailyRentalCharge * chargeableDays;
		LocalDate dueDate = checkOutDate.plusDays(rentalDays);
		double discountAmount = preDiscountTotal * ((double)percentDiscount / 100);
		double finalCharge = preDiscountTotal - discountAmount;
		
		RentalAgreement rentalAgreement = new RentalAgreement(tool, checkOutDate, rentalDays, dueDate, 
				dailyRentalCharge, chargeableDays, preDiscountTotal, percentDiscount, discountAmount, finalCharge);
		rentalAgreement.print();
		return rentalAgreement;
	}
	
	public int chargeableDays(boolean weekendCharge, boolean holidayCharge) {
		int chargeableDays = 0;
		LocalDate currentDate = checkOutDate;
		
		// Create and then find independence day
		LocalDate independenceDay = checkOutDate;
		independenceDay = independenceDay.withMonth(7);
		independenceDay = independenceDay.withDayOfMonth(4);
		
		if (independenceDay.getDayOfWeek().toString().contentEquals("SATURDAY")) {
			independenceDay = independenceDay.minusDays(1);
		}
		else if (independenceDay.getDayOfWeek().toString().contentEquals("SUNDAY")) {
			independenceDay = independenceDay.plusDays(1);
		}
		// Create and then find labor day
		LocalDate laborDay = checkOutDate;
		laborDay = laborDay.withMonth(9);
		laborDay = laborDay.withDayOfMonth(1);
		laborDay = laborDay.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));		
		
		System.out.println("Labor Day: " + laborDay);
		System.out.println("Independence Day: " + independenceDay);
		
		// Start at the given date and walk forward
		for (int count = 0; count < rentalDays; count++) {	

			// DEBUG statements
//			System.out.println(currentDate.getDayOfWeek());
//			System.out.println(currentDate);
			
			// If it is a weekday, add the chargeable day
			if (!currentDate.getDayOfWeek().toString().equals("SATURDAY") &&
					!currentDate.getDayOfWeek().toString().equals("SUNDAY")) {
				chargeableDays++;
			}			
			// If we are charging weekends and it is a weekend, we can add the day
			if (weekendCharge == true && currentDate.getDayOfWeek().toString().equals("SATURDAY") || 
			weekendCharge == true && currentDate.getDayOfWeek().toString().equals("SUNDAY")) {
				chargeableDays++;
			}

			// Check if it is a holiday and if we are charging
			if (holidayCharge == false && currentDate.equals(independenceDay)) {
				chargeableDays--;
			}
			
			else if (holidayCharge == false && currentDate.equals(laborDay)) {
				chargeableDays--;
			}
			
			// Increment localDate object by 1 day
	        currentDate = currentDate.plusDays(1);
		}
		return chargeableDays;
	}
}