import java.time.LocalDate;

public class RentalAgreement {

	private Tool tool;
	private LocalDate checkOutDate;
	private int rentalDays;
	private LocalDate dueDate;
	private double dailyRentalCharge;
	private int chargeableDays;
	private double preDiscountTotal;
	private int percentDiscount;
	private double discountAmount;
	private double finalCharge;
	
	public RentalAgreement(Tool tool, LocalDate checkOutDate, int rentalDays, LocalDate dueDate, double dailyRentalCharge,
			int chargeableDays, double preDiscountTotal, int percentDiscount, double discountAmount, double finalCharge) {
		this.tool = tool;
		this.checkOutDate = checkOutDate;
		this.rentalDays = rentalDays;
		this.dueDate = dueDate;
		this.dailyRentalCharge = dailyRentalCharge;
		this.chargeableDays = chargeableDays;
		this.preDiscountTotal = preDiscountTotal;
		this.percentDiscount = percentDiscount;
		this.discountAmount = discountAmount;
		this.finalCharge = finalCharge;
	}

	public Tool getTool() {
		return tool;
	}
	public LocalDate getCheckOutDate() {
		return checkOutDate;
	}	
	public int getRentalDays() {
		return rentalDays;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}	
	public double getDailyRentalCharge() {
		return dailyRentalCharge;
	}
	public int getChargeableDays() {
		return chargeableDays;
	}	
	public double getPreDiscountTotal() {
		return preDiscountTotal;
	}
	public int getPercentDiscount() {
		return percentDiscount;
	}
	public double getDiscountAmount() {
		return discountAmount;
	}
	public double getFinalCharge() {
		return finalCharge;
	}
	
	public void print() {
		System.out.println("Rental Agreement");
		System.out.println("------------------");
		System.out.println("Tool Code: " + tool.getToolCode());
		System.out.println("Tool Type: " + tool.getToolType());
		System.out.println("Tool Brand: " + tool.getToolBrand());
		System.out.println("Check-Out Date: " + checkOutDate);
		System.out.println("Rental Days: " + rentalDays);
		System.out.println("Due Date: " + dueDate);
		System.out.println("Daily Rental Charge: $" + dailyRentalCharge);
		System.out.println("Chargeable Days: " + chargeableDays);
		System.out.println("Pre-Discount Total: $" + String.format("%.2f", preDiscountTotal));
		System.out.println("% Discount: " + percentDiscount + "%");
		System.out.println("Discount Amount: $" + String.format("%.2f", discountAmount));
		System.out.println("Final Charge: $" + String.format("%.2f", finalCharge));
	}	
}