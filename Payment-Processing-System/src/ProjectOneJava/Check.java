/*Name Joud Thaher 
 * ID 1221381 
 * lab section 11*/
package ProjectOneJava;
//subclass of customerPayment
public class Check extends CustomerPayment implements Payable{
 //private fields as shown in the UML
	private int accountNumber;
	private double accountBalance;
	private int type;
	public static final int CASHIER=1;
	public static final int CERTIFIED=2;
	public static final int PERSONAL=3;
//no argument constructor 
	public Check() {
	}
//all argument constructor 
public Check(String customerName, int customerId, double amount,int accountNumber, double accountBalance, int type) {
	super(customerName,customerId,amount); //this will initialize the others
	this.accountNumber = accountNumber;
	this.accountBalance = accountBalance;
	this.type = type;
}
//setters and getters 
public int getAccountNumber() {
	return accountNumber;
}
public void setAccountNumber(int accountNumber) {
	this.accountNumber = accountNumber;
}
public double getAccountBalance() {
	return accountBalance;
}
public void setAccountBalance(double accountBalance) {
	this.accountBalance = accountBalance;
}
public int getType() {
	return type;
}
public void setType(int type) {
	this.type = type;
}
//public(+) method shown in the UML
public void deductAmountFromBalance() {
	if(this.type == PERSONAL || this.type==CERTIFIED) { //as mentioned in the project cashier wont subtract
		this.accountBalance-= super.amount; //amount is # so we can call it directly
	}
}

//payment=amount..different implementation of the subclass method
@Override  
protected double calculatePayment() {
	return super.amount;   //amount is inherited from super class 
}
@Override
public boolean isAuthorized() { 
	boolean authorized= this.type ==CASHIER || super.amount<=this.accountBalance;
	if(authorized && (this.type==PERSONAL || this.type==CERTIFIED)) {
		deductAmountFromBalance();	
		} //if authorized from types personal and certified it will subtract 
	return authorized;
}   //return true if cashier or amount less or equal to balance 

@Override
public String toString() {
	return "Check [accountNumber=" + accountNumber + ", accountBalance=" + accountBalance + ", type=" + type
			+ ", customerName=" + customerName + ", customerId=" + customerId + ", amount=" + amount + "]";
}

}
