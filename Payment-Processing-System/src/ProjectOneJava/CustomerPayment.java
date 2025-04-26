/*Name Joud Thaher 
 * ID 1221381 
 * lab section 11*/
package ProjectOneJava;
public abstract  class CustomerPayment implements Comparable<CustomerPayment>{
	//data fields, #protected 
	protected String customerName;
	protected int customerId;
	protected double amount;
	//no argument constructor
	public CustomerPayment() {
	}
	//all argument constructor 
	public CustomerPayment(String customerName, int customerId, double amount) {
		super();
		this.customerName = customerName;
		this.customerId = customerId;
		this.amount = amount;
	}
	//setters and getters 
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	//the abstract method shown in the UML #
	abstract protected double calculatePayment();
	//another method shown in the UML.. default modifier
	void printPaymentInfo() {
		System.out.println(toString()+"Payment is :"+calculatePayment());
	}
	//the toString method...the override is from object class
	@Override
	public abstract String toString(); //will print the info using the print info method
	@Override //writing the implementation we want for comparable 
	public int compareTo(CustomerPayment p) {
		if(calculatePayment() > p.calculatePayment()) //changing > to < to print descending in driver (> asc and <des)
			return 1;
		else if(calculatePayment() < p.calculatePayment())
			return -1;
		else 
		    return 0;
	}
	
	

}
