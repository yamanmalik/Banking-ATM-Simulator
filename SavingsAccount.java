/* Author: Yaman Malik
https://github.com/yamanmalik
*/
public class SavingsAccount extends Account {
	
	
	
	public SavingsAccount() {
		tracker++;
	}
	public void deposit(double depositAmount) {
		// this method takes in a double, depositAmount, from the user and allows the user to deposit money into their account.
		// it then stores the transaction information in the transaction array
		reallocate();
		Transaction trans = new Transaction();
		transactions[y] = trans;
	
		
		balance +=depositAmount; // updates new balance.
		// where the components of the transaction array is updated.
		transactions[y].transaction = 0;
		transactions[y].amount = depositAmount;
		transactions[y].fees = 0;
		transactions[y].description = "Transanction type: Deposit" +"\n" +"Transaction amount: "+transactions[y].amount+"\n"+" Transaction date: "+transactions[y].date+"\n"+" Transaction fees: " +transactions[y].fees;
		y+=1; // increments y by one to move on to next cell in the transaction array
		
	}

	//desposits into account
	
	public void withdraw(double withdrawAmount) {
		// This method allows the user to withdraw money from their account
		// it  checks if the user is a student, adult, or senior. And processes the transaction accordingly.
		reallocate();
		Transaction trans = new Transaction();
		transactions[y] = trans;
		
		transactions[y].transaction = 1; // sets transaction type.
			
			if(getCustomer().getCheckCharge() == 0.03) { // checks if person is an adult.
				if(withdrawAmount>balance) { // charges customer accordingly for being an adult
					transactions[y].fees = Adult.OVERDRAFT_PENTALTY + Adult.CHECK_CHARGE;
				}
				else {
					transactions[y].fees = Adult.CHECK_CHARGE;
				}
			}
			if(getCustomer().getCheckCharge() == 0.01) { // checks if customer is a senior.
				if(withdrawAmount>balance) { // charges customer accordingly for being  senior.
					transactions[y].fees = Senior.OVERDRAFT_PENTALTY + Senior.CHECK_CHARGE;
				}
				else {
					transactions[y].fees = Senior.CHECK_CHARGE;
				}
			}
			if(getCustomer().getCheckCharge() == 0) { // checks if customer is a vip senior.
				if(withdrawAmount>balance) { // charges customer accordingly for being  senior.
					if(withdrawAmount <=100) {
						Senior.OVERDRAFT_PENTALTY =0;
					}
					transactions[y].fees = Senior.OVERDRAFT_PENTALTY + Senior.CHECK_CHARGE;
				}
				else {
					transactions[y].fees = Senior.CHECK_CHARGE;
				}
			}
			
		
		
		if(getCustomer().getCheckCharge() == 0.02) { // checks if customer is a student.
			
			transactions[y].fees = Student.CHECK_CHARGE;
		}
		balance -= withdrawAmount; // updates balance.
		//transaction information is stored
		transactions[y].amount = withdrawAmount;
		transactions[y].description = "Transanction type: Withdrawal" +"\n" +"Transaction amount: -"+transactions[y].amount+"\n"+" Transaction date: "+transactions[y].date+"\n"+" Transaction fees: " +transactions[y].fees;

		
		y+=1; // incremented by 1 to move on to next cell in transaction array
	}

	// withdraws from account 

	public void addInterest() {
		//method to apply correct interest.
		reallocate();
		Transaction trans = new Transaction();
		transactions[y] = trans;
		
		double interest =0;
		// if statements to check if customer is an adult, senior, or student. and adjust fees accordingly.
		if(getCustomer().getCheckCharge() == 0.03) {
			interest = Adult.SAVINGS_INTEREST*balance;
		}
		if(getCustomer().getCheckCharge() == 0.01 || getCustomer().getCheckCharge() == 0) {
			interest = Senior.SAVINGS_INTEREST*balance;
		}
		if(getCustomer().getCheckCharge() == 0.02) {
			interest = Student.SAVINGS_INTEREST*balance;
		}
		//updates balance and stores transaction information.
		balance+=interest;
		transactions[y].transaction = 2;
		transactions[y].amount = interest;
		transactions[y].description = "Transanction type: Added Interest" +"\n" +"Transaction amount: "+transactions[y].amount+"\n"+" Transaction date: "+transactions[y].date+"\n"+" Transaction fees: " +transactions[y].fees;

		y+=1; // increments y by one to move on to next cell in transaction array.
	}
	// adds interest to account
}
