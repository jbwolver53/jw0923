import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class DriverTest {

	@Test
	void Test1DiscountExceedsRange() {
		Tool tool = new Tool("JAKR","Jackhammer","Ridgid");
		// Y/M/D
		LocalDate checkOutDate = LocalDate.of(2015, 9, 3);
		int rentalDays = 5;
		int percentDiscount = 101;
		Checkout checkout = new Checkout(tool, checkOutDate, rentalDays, percentDiscount);
        RentalAgreement rentalAgreement = checkout.calculate();
        
        // Check final result class
        assertEquals("JAKR", rentalAgreement.getTool().getToolCode());
        assertEquals("Jackhammer", rentalAgreement.getTool().getToolType());
        assertEquals("Ridgid", rentalAgreement.getTool().getToolBrand());
        assertEquals(checkOutDate, rentalAgreement.getCheckOutDate());
        assertEquals(rentalDays, rentalAgreement.getRentalDays());
        assertEquals("2015-09-08", rentalAgreement.getDueDate().toString());
        assertEquals(2.99, rentalAgreement.getDailyRentalCharge());
        assertEquals(2, rentalAgreement.getChargeableDays());
        assertEquals(5.98, rentalAgreement.getPreDiscountTotal());
        assertEquals(0, rentalAgreement.getPercentDiscount());
        assertEquals(0.0, rentalAgreement.getDiscountAmount());
        assertEquals(5.98, rentalAgreement.getFinalCharge());
	}
	
	@Test
	void Test2() {
		Tool tool = new Tool("LADW","Ladder","Werner");
		// Y/M/D
		LocalDate checkOutDate = LocalDate.of(2020, 7, 2);
		int rentalDays = 3;
		int percentDiscount = 10;
		Checkout checkout = new Checkout(tool, checkOutDate, rentalDays, percentDiscount);
        RentalAgreement rentalAgreement = checkout.calculate();
        
        // Check final result class
        assertEquals("LADW", rentalAgreement.getTool().getToolCode());
        assertEquals("Ladder", rentalAgreement.getTool().getToolType());
        assertEquals("Werner", rentalAgreement.getTool().getToolBrand());
        assertEquals(checkOutDate, rentalAgreement.getCheckOutDate());
        assertEquals(rentalDays, rentalAgreement.getRentalDays());
        assertEquals("2020-07-05", rentalAgreement.getDueDate().toString());
        assertEquals(1.99, rentalAgreement.getDailyRentalCharge());
        assertEquals(2, rentalAgreement.getChargeableDays());
        assertEquals(3.98, rentalAgreement.getPreDiscountTotal());
        assertEquals(percentDiscount, rentalAgreement.getPercentDiscount());
        assertEquals(0.398, rentalAgreement.getDiscountAmount());
        assertEquals(3.582, rentalAgreement.getFinalCharge());
	}
	
	@Test
	void Test3() {
		Tool tool = new Tool("CHNS","Chainsaw","Stihl");
		// Y/M/D
		LocalDate checkOutDate = LocalDate.of(2015, 7, 2);
		int rentalDays = 5;
		int percentDiscount = 25;
		Checkout checkout = new Checkout(tool, checkOutDate, rentalDays, percentDiscount);
        RentalAgreement rentalAgreement = checkout.calculate();
        
        // Check final result class
        assertEquals("CHNS", rentalAgreement.getTool().getToolCode());
        assertEquals("Chainsaw", rentalAgreement.getTool().getToolType());
        assertEquals("Stihl", rentalAgreement.getTool().getToolBrand());
        assertEquals(checkOutDate, rentalAgreement.getCheckOutDate());
        assertEquals(rentalDays, rentalAgreement.getRentalDays());
        assertEquals("2015-07-07", rentalAgreement.getDueDate().toString());
        assertEquals(1.49, rentalAgreement.getDailyRentalCharge());
        assertEquals(3, rentalAgreement.getChargeableDays());
        assertEquals(4.47, rentalAgreement.getPreDiscountTotal());
        assertEquals(percentDiscount,rentalAgreement.getPercentDiscount());
        assertEquals(1.1175, rentalAgreement.getDiscountAmount());
        assertEquals(3.3525, rentalAgreement.getFinalCharge());
	}
	
	@Test
	void Test4NoDiscount() {
		Tool tool = new Tool("JAKD","Jackhammer","DeWalt");
		// Y/M/D
		LocalDate checkOutDate = LocalDate.of(2015, 9, 3);
		int rentalDays = 6;
		int percentDiscount = 0;
		Checkout checkout = new Checkout(tool, checkOutDate, rentalDays, percentDiscount);
        RentalAgreement rentalAgreement = checkout.calculate();
        
        // Check final result class
        assertEquals("JAKD", rentalAgreement.getTool().getToolCode());
        assertEquals("Jackhammer", rentalAgreement.getTool().getToolType());
        assertEquals("DeWalt", rentalAgreement.getTool().getToolBrand());
        assertEquals(checkOutDate, rentalAgreement.getCheckOutDate());
        assertEquals(rentalDays, rentalAgreement.getRentalDays());
        assertEquals("2015-09-09", rentalAgreement.getDueDate().toString());
        assertEquals(2.99, rentalAgreement.getDailyRentalCharge());
        assertEquals(3, rentalAgreement.getChargeableDays());
        assertEquals(8.97, rentalAgreement.getPreDiscountTotal());
        assertEquals(percentDiscount, rentalAgreement.getPercentDiscount());
        assertEquals(0.0, rentalAgreement.getDiscountAmount());
        assertEquals(8.97, rentalAgreement.getFinalCharge());
	}
	
	@Test
	void Test5() {
		Tool tool = new Tool("JAKR","Jackhammer","Ridgid");
		// Y/M/D
		LocalDate checkOutDate = LocalDate.of(2015, 7, 2);
		int rentalDays = 6;
		int percentDiscount = 0;
		Checkout checkout = new Checkout(tool, checkOutDate, rentalDays, percentDiscount);
        RentalAgreement rentalAgreement = checkout.calculate();
        
        // Check final result class
        assertEquals("JAKR", rentalAgreement.getTool().getToolCode());
        assertEquals("Jackhammer", rentalAgreement.getTool().getToolType());
        assertEquals("Ridgid", rentalAgreement.getTool().getToolBrand());
        assertEquals(checkOutDate, rentalAgreement.getCheckOutDate());
        assertEquals(rentalDays, rentalAgreement.getRentalDays());
        assertEquals("2015-07-08", rentalAgreement.getDueDate().toString());
        assertEquals(2.99, rentalAgreement.getDailyRentalCharge());
        assertEquals(3, rentalAgreement.getChargeableDays());
        assertEquals(8.97, rentalAgreement.getPreDiscountTotal());
        assertEquals(percentDiscount, rentalAgreement.getPercentDiscount());
        assertEquals(0.0, rentalAgreement.getDiscountAmount());
        assertEquals(8.97, rentalAgreement.getFinalCharge());
	}
	
	@Test
	void Test6() {
		Tool tool = new Tool("JAKR","Jackhammer","Ridgid");
		// Y/M/D
		LocalDate checkOutDate = LocalDate.of(2020, 7, 2);
		int rentalDays = 4;
		int percentDiscount = 50;
		Checkout checkout = new Checkout(tool, checkOutDate, rentalDays, percentDiscount);
        RentalAgreement rentalAgreement = checkout.calculate();
        
        // Check final result class
        assertEquals("JAKR", rentalAgreement.getTool().getToolCode());
        assertEquals("Jackhammer", rentalAgreement.getTool().getToolType());
        assertEquals("Ridgid", rentalAgreement.getTool().getToolBrand());
        assertEquals(checkOutDate, rentalAgreement.getCheckOutDate());
        assertEquals(rentalDays, rentalAgreement.getRentalDays());
        assertEquals("2020-07-06", rentalAgreement.getDueDate().toString());
        assertEquals(2.99, rentalAgreement.getDailyRentalCharge());
        assertEquals(1, rentalAgreement.getChargeableDays());
        assertEquals(2.99, rentalAgreement.getPreDiscountTotal());
        assertEquals(percentDiscount, rentalAgreement.getPercentDiscount());
        assertEquals(1.495, rentalAgreement.getDiscountAmount());
        assertEquals(1.495, rentalAgreement.getFinalCharge());
	}
}
