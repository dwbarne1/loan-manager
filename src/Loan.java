public class Loan 
{

	private double loanAmount;
	private int numOfYears;
	private double annualInterestRate;
	// field variables
	
	public Loan() // Loan constructor sets the annual interest rate for the loan at 5%
	{
		annualInterestRate = 5.0;
	} // end Loan constructor
	
	// getters and setters for loanAmount and numOfYears
	public double getLoanAmount() 
	{
		return loanAmount;
	}

	public void setLoanAmount(double loanAmount) 
	{
		this.loanAmount = loanAmount;
	}

	public int getNumOfYears() 
	{
		return numOfYears;
	}

	public void setNumOfYears(int numOfYears) 
	{
		this.numOfYears = numOfYears;
	}
	// end getters and setters for loanAmount and numOfYears
	
	public double monthlyPayment() // calculates the monthly payment of a loan using annual interest rate and two new variables in the monthly payment formula
	{
		double monthlyInterestRate = annualInterestRate / 1200;
		double monthlyPayment = loanAmount * monthlyInterestRate / (1 - (Math.pow(1 / (1 + monthlyInterestRate), numOfYears * 12)));
		return monthlyPayment;
	} // end monthlyPayment method
	
	public double totalPayment() // calculates the total loan payment
	{
		double totalPayment = monthlyPayment() * 12 * numOfYears;
		return totalPayment;
	} // end totalPayment method
}
