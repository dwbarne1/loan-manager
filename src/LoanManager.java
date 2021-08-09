import java.util.Scanner;
public class LoanManager 
{

	private Scanner scan = new Scanner(System.in);
	private Loan[] loans = new Loan[10];
	private int loanCounter = 0;
	// field variables
	
	public static void main(String[] args)
	{
		LoanManager lm = new LoanManager();
		lm.startLoanManager();
	} // end main method
	
	public void startLoanManager() // invokes the other three loan methods of the class
	{
		loanInformation();
		loansInSystem();
		totalPaymentOfAllLoans();
	} // end startLoanManager method
	
	public void loanInformation() // asks for loan amount, number of years, and then stores the information in a new array object
	{
		System.out.println("\t\tFirst National Loans\n\n");
		
		for(int i = 0; i < 10; i++)
		{
			
			System.out.print("Enter loan amount: ");
			double loanAmount = Double.parseDouble(scan.nextLine());
			
			System.out.print("Enter number of years: ");
			int years = Integer.parseInt(scan.nextLine());
			
			Loan loanObject = new Loan();
			
			loanObject.setLoanAmount(loanAmount);
			loanObject.setNumOfYears(years);
			
			loans[i] = loanObject;
			
			System.out.printf("The total payment on this loan will be $%.2f", loanObject.totalPayment());
			
			loanCounter++;
			
			if(!(i == 9))
			{
				System.out.print("\n\nDo you want to apply for another loan? (Y/N): ");
				String input = scan.nextLine();
				if(input.equalsIgnoreCase("n"))
				{
					break;
				}
				System.out.println();
			}
			
			
		}
		
	} // end loanInformation method
	
	public void loansInSystem() // lists the contents of the Loan objects in the loans array
	{
		System.out.println("\nFollowing are the loans in the system.");
		System.out.println("    Amount Total Payment");
		
		for(int i = 0; i < loanCounter; i++)
		{
			System.out.printf("  %.2f     %.2f\n", loans[i].getLoanAmount(), loans[i].totalPayment());
		}
	} // end loansInSystem method
	
	public void totalPaymentOfAllLoans() // adds the total payments of all Loan objects
	{
		double totalPayment = 0;
		
		for(int i = 0; i < loanCounter; i++)
		{
			totalPayment += loans[i].totalPayment();
		}
		
		System.out.printf("\nThe total payment of all loans is $%.2f", totalPayment);
		
		System.out.print("\nPress Enter to exit...");
		scan.nextLine();
	} // end totalPaymentOfAllLoans
	
} // end LoanManager class