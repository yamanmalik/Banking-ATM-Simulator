/* Author: Yaman Malik
https://github.com/yamanmalik
*/


public class Adult extends Customer {
public static final double SAVINGS_INTEREST = 0.03;
public static final double CHECK_INTEREST = 0.01;
public static final double CHECK_CHARGE = 0.03;
public static final double OVERDRAFT_PENTALTY= 25.0;

	public double getSavingsInterest() {
		
		return SAVINGS_INTEREST;
	}

	public double getCheckInterest() {
		
		return CHECK_INTEREST;
	}

	public double getCheckCharge() {
		
		return CHECK_CHARGE;
	}
	
	public double getOverdraftPenalty() {
		return OVERDRAFT_PENTALTY;
	}
	
	// getter methods for variables

}
