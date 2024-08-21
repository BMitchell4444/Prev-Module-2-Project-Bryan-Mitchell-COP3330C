
public abstract class Loan implements LoanConstants {
	
private int loanNumber;
private String lastName;
private double loanAmount;
protected double interestRate;
private int loanTerm;

public Loan(int loanNum, String name, double amount, int term, double interest) {
	loanNumber = loanNum;
	lastName = name;
	loanAmount = amount;
	loanTerm = term;
	interestRate = interest;
}

public String toString() {
	System.out.print("Loan number: " + loanNumber + "\n" + "Last name: " + lastName + "\n");
	System.out.printf("Loan amount %.2f\n", loanAmount);
	
	if(loanTerm == 3) {
		System.out.print("Loan term: " + shortLoan + "\n");
	}
	else if(loanTerm == 7) {
		System.out.print("Loan term: " + medLoan + "\n");
	}
	else if(loanTerm == 15) {
		System.out.print("Loan term: " + longLoan + "\n");
	}
	else {
		System.out.print("The length of this loan term is not offered by us, defaulting to: " + shortLoan + "\n");
		loanTerm = 3;
	}
	
	System.out.printf("Interest accrued: $%.2f\n", ((loanAmount * interestRate) * loanTerm));
	System.out.printf("Total due by end of term: $%.2f\n", (loanAmount + ((loanAmount * interestRate) * loanTerm)));
	
	return null;
	
}

public boolean equals(Loan b) {
	if(loanNumber == b.loanNumber) {
		if(lastName.equals(b.lastName)) {
			if(loanAmount == b.loanAmount) {
				if(loanTerm == b.loanTerm) {
					return true;
				}
				else {
					return false;
				}
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	else {
		return false;
	}
}
}
