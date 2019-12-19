/* Author: Yaman Malik
https://github.com/yamanmalik
*/


public class Bank {
    private Account[] accounts;
    private int size;
    private int capacity;
    
    private static final int SAVINGS = 0;
    private static final int CHECKING = 1;    
    private static final int SENIOR = 0;
    private static final int ADULT = 1;    
    private static final int STUDENT = 2;
    private static final int INIT_CAPACITY = 100;
    
    /** Creates a new instance of Bank */
    public Bank(){
    	accounts = new Account[100];

    }
    //creates bank (new accounts array of size 100)


    
    /********************************************************************
     * Creates a new account.
     * pre: customer information must be not null and types must be valid
     * post: New account added to bank
     * @param customerName String Account owner's name
     * @param customerAddress String Owner's address
     * @param customerAge int Owner's age (in years)
     * @param customerPhoneNumber String Owner's phone number
     * @param customerType int Owner's type of customer within bank
     * @param typeAccount int Account type (savings or checking)
     * @return String New account number
     */



 
public String addAccount(String customerName, int customerAge, int customerType, boolean vIP, int choice) {
	String[] split = customerName.split(" ");
	reallocate();

    	if(customerType == SENIOR && vIP){
    		Senior senior = new Senior(vIP);
    		Senior.setFirstName(split[0]);
    		Senior.setLastName(split[1]);
        	Senior.setAge(customerAge);
        	
        	
        	
        	if(choice == SAVINGS){
        		SavingsAccount savings_account = new SavingsAccount();
        		savings_account.setCustomer(senior);
        		accounts[savings_account.tracker] = savings_account;
        		return Integer.toString(accounts[savings_account.tracker].getAccountNumber());
        	}
        	else if(choice == CHECKING){
        		CheckingAccount checking_account = new CheckingAccount();
        		checking_account.setCustomer(senior);
        		accounts[checking_account.tracker] = checking_account;
        		return Integer.toString(accounts[checking_account.tracker].getAccountNumber());
        	}
    	}
    	if(customerType == SENIOR && vIP==false){
    		Senior senior = new Senior(vIP);
    		Senior.setFirstName(split[0]);
    		Senior.setLastName(split[1]);
        	Senior.setAge(customerAge);
        	
        	
        	
        	if(choice == SAVINGS){
        		SavingsAccount savings_account = new SavingsAccount();
        		savings_account.setCustomer(senior);
        		accounts[savings_account.tracker] = savings_account;
        		return Integer.toString(accounts[savings_account.tracker].getAccountNumber());
        	}
        	else if(choice == CHECKING){
        		CheckingAccount checking_account = new CheckingAccount();
        		checking_account.setCustomer(senior);
        		accounts[checking_account.tracker] = checking_account;
        		return Integer.toString(accounts[checking_account.tracker].getAccountNumber());
        	}
    	}
    	
    	if(customerType == ADULT){
    		Adult adult = new Adult();
    		Adult.setFirstName(split[0]);
    		Adult.setLastName(split[1]);
    		Adult.setAge(customerAge);
    		
        	
        	if(choice == SAVINGS){
        		SavingsAccount savings_account = new SavingsAccount();
        		savings_account.setCustomer(adult);
        		accounts[savings_account.tracker] = savings_account;
        		return Integer.toString(accounts[savings_account.tracker].getAccountNumber());
        	}
        	else if(choice == CHECKING){
        		CheckingAccount checking_account = new CheckingAccount();
        		checking_account.setCustomer(adult);
        		accounts[checking_account.tracker] = checking_account;
        		return Integer.toString(accounts[checking_account.tracker].getAccountNumber());
        	}
    		
    	}
    	
    	if(customerType == STUDENT){
    		Student student = new Student();
        	Student.setFirstName(split[0]);
    		Student.setLastName(split[1]);
        	Student.setAge(customerAge);
        	
        	
        	if(choice ==SAVINGS){
        		SavingsAccount savings_account = new SavingsAccount();
        		savings_account.setCustomer(student);
        		accounts[savings_account.tracker] = savings_account;
        		return Integer.toString(accounts[savings_account.tracker].getAccountNumber());
        	}
        	else if(choice == CHECKING){
        		CheckingAccount checking_account = new CheckingAccount();
        		checking_account.setCustomer(student);
        		accounts[checking_account.tracker] = checking_account;
        		return Integer.toString(accounts[checking_account.tracker].getAccountNumber());
        	}
        	
    	}

    	
    	
    	


    	

    	return "ERROR";

    }
    //adds account to bank
    
    /***********************************************************************
     * Make a deposit into account.
     * pre: amount must be a positive integer
     * post: Account's balance increases
     * @param accountNumber String Account's number
     * @param amount double Amount to deposit
     * @return double New balance
     */
    public String makeDeposit(String accountNumber, double amount){
    	if(find(accountNumber) == -1){
    		String s = "That account does not exist!";
    		return s;
    	}

    	int a = Integer.parseInt(accountNumber) - 9999;
    	accounts[a].balance+= amount;
    	accounts[a].y++;
    	return Double.toString(accounts[a].getBalance());
    }

    //makes deposit
    
    /***********************************************************************
     * Make a withdrawal from account.
     * pre: amount must be a positive integer
     * post: Account's balance decreases
     * @param accountNumber String Account's number
     * @param amount double Amount to withdraw
     * @return double New balance
     */    
    public String makeWithdrawal(String accountNumber, double amount){
    	if(find(accountNumber) == -1){
    		String s = "That account does not exist!";
    		return s;
    	}
    	
    	int a = Integer.parseInt(accountNumber) -9999;
    	if((accounts[a].getCustomer().getCheckCharge() == 0.01 || accounts[a].getCustomer().getCheckCharge() == 0.03  || accounts[a].getCustomer().getCheckCharge() == 0)&&(accounts[a].balance +500)<amount) {
    		String s = "You can withdraw a maximum of $500 more than the amount you have. Try again!";
    		return s;
    	}
    	if((accounts[a].getCustomer().getCheckCharge()==0.02)&&(accounts[a].balance)<amount) {
    		String s = "You cannot withdraw more than the amount you have. Try again!";
    		return s;
    	}
        accounts[a].withdraw(amount);
        accounts[a].y++;
        return Double.toString(accounts[a].getBalance());       
    }

    //makes withdrawal
    
    public String addInterest(String accountNumber){
    	if(find(accountNumber) == -1){
    		String s = "That account does not exist!";
    		return s;
    	}

    	int a = Integer.parseInt(accountNumber) -9999;
        accounts[a].addInterest();
        accounts[a].y++;
        return Double.toString(accounts[a].getBalance());       
    }

    //adds interest 

    /***********************************************************************
     * Returns account information as a string so it can be displayed
     * @param accountNumber String Account's number
     * @return String Account information as a String object
     */    
    public String getAccount(String accountNumber){
    	if(find(accountNumber) == -1){
    		String s = "That account does not exist!";
    		return s;
    	}
    	int a = Integer.parseInt(accountNumber) - 9999;
    	return accounts[a].toString();
    	
    }
    //looks for account in bank (searches accounts array) and returns it

    
    /***********************************************************************
     * Given an account number tells if the account exists or not
     * @param accountNumber String Account's number
     * @return int TRUE if accountNumber exists in accounts[]. Otherwise, -1.
     */    
    private int find(String accountNumber){
    	int a = Integer.parseInt(accountNumber);
    	for(int i = 0; i<accounts.length; i++){
    		if(accounts[i] == null){
    			return -1;
    		}
    		else if(accounts[i].getAccountNumber() == a){
    			return i;
    		}
    	}
    	return -1;
    }
    // looks for account in bank (accounts array)

 /***********************************************************************


    /** You need to create private method : Allocate to allocate a new array to hold the transactions. */
    private void reallocate() {
    	boolean full = true;
    	Account[] temp = new Account[accounts.length];
    	for(int i = 0; i<accounts.length; i++){
    		if(accounts[i] ==  null){
    			full = false;
    		}
    	}
    	if(full){
    		for(int j = 0; j<temp.length; j++){
    			temp[j] = accounts[j];
    			accounts[j] = null;
    		}
    	}
    	accounts = new Account[accounts.length*2];
    	for(int k = 0; k<temp.length; k++){
    		accounts[k] = temp[k];
    	}
    }
    //doubles accounts array if full

    	
}

