/* Author: Yaman Malik
https://github.com/yamanmalik
*/

public class Senior extends Customer {
	static double SAVINGS_INTEREST = 0.08;
	static double CHECK_INTEREST = 0.04;
	static double CHECK_CHARGE = 0.01;
	static boolean VIP;
	static double OVERDRAFT_PENTALTY = 10.0;

	public Senior(boolean VIP) {
		Senior.VIP = VIP;
		if(VIP) {
		OVERDRAFT_PENTALTY = 5;
		SAVINGS_INTEREST = 0.1;
		CHECK_INTEREST = 0.04;
		CHECK_CHARGE = 0;
		}
	}
	// check if senior is vip and applies senior rates if so.

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


