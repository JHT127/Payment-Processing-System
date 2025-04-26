/*Name Joud Thaher 
 * ID 1221381 
 * lab section 11*/
package ProjectOneJava;
public class Cash extends CustomerPayment {
	
	//private (-)data fields indicated in the UML
	private double discountRate;
	
	//no argument constructor to avoid confusion and errors ...
	public Cash() {
	}
	//all argument constructor 
	public Cash(String customerName, int customerId, double amount,double discountRate) {
		super(customerName,customerId,amount);
		this.discountRate = discountRate;
	}
	//setters and getters 
	public double getDiscountRate() {
		return discountRate;
	}
	public void setDiscountRate(double discountRate) {
		this.discountRate = discountRate;
	}
	
	//payment is amount minus discount rate percentage..example a=200,d=11..200-0.11*200=178
	@Override
	protected double calculatePayment() {
		return super.amount-(this.discountRate/100)*super.amount; //amount is inherited 
	}
	
	//the toString method 
	@Override
	public String toString() {
		return "Cash [discountRate=" + discountRate + ", customerName=" + customerName + ", customerId=" + customerId
				+ ", amount=" + amount + "]";
	}
	
	
		
}
