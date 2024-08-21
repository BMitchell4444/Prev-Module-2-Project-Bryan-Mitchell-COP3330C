import java.util.Scanner;

public class CreateLoans {


	public static void main(String[] args) {
		int loanNum;
		String name;
		double amount;
		int term;
		double interest;
		int loanType;
		double personalLoanAmount = 0;
		double businessLoanAmount = 0;
		int i;
		int j;
		int sameLoans = 0;
		
		Loan userLoans[] = new Loan[5];
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter prime interest rate: ");
		interest = scan.nextDouble();
		
		for(i = 0; i < 5; i++) {
			System.out.print("What type of loan is this loan? Enter 1 for Business, 2 for Personal: ");
			loanType = scan.nextInt();
			
			System.out.print("What is the loan number?: ");
			loanNum = scan.nextInt();
			
			System.out.print("What is the last name of the loanee?: ");
			name = scan.next();
			
			System.out.print("What is the loan amount?: ");
			amount = scan.nextDouble();
			
			if(amount > userLoans[i].maxAmount) {
				while(amount > 50000) {
				System.out.print("Error: loans cannot be more than $50,000. Please enter a new amount: ");
				amount = scan.nextDouble();
				}
			}
			
			if(amount < 0) {
				while(amount < 0) {
					System.out.print("Error: loans cannot be less than $0. Please enter a new amount: ");
					amount = scan.nextDouble();
					}
			}
			
			System.out.print("How long is the loan term? Enter 3 for short term, 7 for medium term, and 15 for long term. "
					+ "\nAll other inputs will default to the short term: ");
			term = scan.nextInt();
			System.out.print("\n");
			
			
			if(loanType == 1) {
				userLoans[i] = new BusinessLoan(loanNum, name, amount, term, interest);
				businessLoanAmount = businessLoanAmount + amount;
			}
			
			if(loanType == 2) {
				userLoans[i] = new PersonalLoan(loanNum, name, amount, term, interest);
				personalLoanAmount = personalLoanAmount + amount;
			}
			
			

		}
		
		System.out.print("\n" + Loan.companyName + ": \n");
		System.out.print("\nDisplaying loan list: \n");
		
		for(i = 0; i < 5; i++) {
			System.out.print((i + 1) + ". ");
			userLoans[i].toString();
			System.out.print("\n");
		}
		
		System.out.printf("Total amount of business loans: $%.2f\n", businessLoanAmount);
		System.out.printf("Total amount of personal loans: $%.2f\n", personalLoanAmount);
		System.out.printf("Total amount of money loaned: $%.2f\n", (businessLoanAmount + personalLoanAmount));
		
		for(i = 0; i < 4; i++) {
			for(j = i + 1; j < 5; j++) {
				if(userLoans[i].equals(userLoans[j])) {
					System.out.print("Loan " + (i + 1) + " loan " + (j + 1) + " are the same.\n");
					sameLoans = sameLoans + 1;
				}
			}
		}
		
		if(sameLoans == 0) {
			System.out.print("\n\nThere are no loans that are the same.\n");
		}
		
	}

}
