/* Author: Yaman Malik
https://github.com/yamanmalik
*/

public abstract class Account{
	public static final int INITSIZE = 25;	
	Customer customer;
	double balance;
	int accountNumber;
	static int lastAccountNumber = 9999;
	Transaction[] transactions; 
	static int tracker=-1;
	int y = 0; // variable to be incremented in CheckingAccount and SavingsAccount classes each time a new transaction is made.
	public Account() {
		transactions = new Transaction [INITSIZE];
		accountNumber = lastAccountNumber;
		lastAccountNumber+=1;
	}
	public void reallocate(){
		Transaction[] temp = new Transaction[transactions.length];
		boolean full = true;
		
		for(int k=0; k<transactions.length; k++) {
			if(transactions[k] == null) {
				full = false;
			                            }
		                                         }
		
		if(full) {
			for (int i =0; i<temp.length; i++) {
				temp[i] = transactions[i];
				transactions[i] = null;
		                                       }
			
		transactions = new Transaction[transactions.length*2];
		
			for (int j =0; j<temp.length; j++) {
				transactions[j] = temp[j];
		                                       }

		         }
	}
	// doubles transactions array if full
	
	public double getBalance(){
		return balance;
	}

	public int getAccountNumber(){
		return accountNumber;
	}

	public Customer getCustomer(){
		return customer;
	}

	public String toString(){
		return "Customer First Name: "+customer.getFirstName()+", Customer Last Name: "+customer.getLastName()+" Balance: "+balance+" Account Number: "+accountNumber;
	}

	public void setCustomer(Customer c){
		customer = c;
	}

	//getters, setters, and toString method
	
	public abstract void withdraw(double amount);
	public abstract void addInterest();
	

}