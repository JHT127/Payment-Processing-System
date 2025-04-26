/*Name Joud Thaher 
 * ID 1221381 
 * lab section 11*/
package ProjectOneJava;
//importing the date package for type Date in the class
import java.util.*;
public  class CreditCard extends CustomerPayment implements Payable{ 
	//private data fields shown in the UML
	private double chargingFee;
	private Date expiryDate;
	Date currentDate=new Date(); //to compare current date in the authorized method 
	//no argument constructor 
	public CreditCard() {
	}
	//all argument constructor 
	public CreditCard(String customerName, int customerId, double amount,double chargingFee, Date expiryDate) {
		super(customerName,customerId,amount); //this will initialize the others
		this.chargingFee = chargingFee;
		this.expiryDate = expiryDate;
	}
	//setters and getters
	public double getChargingFee() {
		return chargingFee;
	}
	public void setChargingFee(double chargingFee) {
		this.chargingFee = chargingFee;
	}
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	
	//payment is the amount plus the charging fee
	@Override
	protected double calculatePayment() {
		return super.amount + this.chargingFee; //amount is inherited from super class
	}
	@Override
	public boolean isAuthorized() {
		if(this.expiryDate.compareTo(currentDate)>=0)
			return true;
		else 
		    return false;
	}
	
	//the toString method 
	@Override
	public String toString() {
		return "CreditCard [chargingFee=" + chargingFee + ", expiryDate=" + expiryDate + ", customerName="
				+ customerName + ", customerId=" + customerId + ", amount=" + amount + "]";
	}
	
		
	

}
