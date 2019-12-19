
/* Author: Yaman Malik
https://github.com/yamanmalik
*/

public abstract class Customer{
	
	private static String firstName, lastName;
	private static int age;
	private static int customerNumber;
	private static String address;
	private static int lastCustomerNumber = 9999;

	public Customer(){
		customerNumber = lastCustomerNumber;
		lastCustomerNumber+=1;
	}
	//this constructor increases the customer number by one everytime a new customer is created, default value is 9999 (first customer)

	public static String getFirstName(){
		return firstName;
	}

	public static String getLastName(){
		return lastName;
	}

	public static int getAge(){
		return age;
	}

	public static int getCustomerNumber(){
		return customerNumber;
	}

	public static String getAddress(){
		return address;
	}

	public static void setFirstName(String f){
		firstName = f;
	}

	public static void setLastName(String l){
		lastName = l;
	}

	public static void setAge(int a){
		age = a;
	}

	public static void setCustomerNumber(int number){
		customerNumber = number;
	}

	public static void setAddress(String add){
		address = add;
	}

	//getters and setters

	public abstract double getSavingsInterest();

	public abstract double getCheckInterest();

	public abstract double getCheckCharge();

	// abstract methods that are to be implemented in other classes (as assignment instructs)

	public static boolean equals(Customer other){
		if((other.getFirstName() == firstName) && (other.getAge() == age)&&(other.getLastName() == lastName)){
			return true;
		}
		else{
			return false;
		}
	}
	//equals method 

}