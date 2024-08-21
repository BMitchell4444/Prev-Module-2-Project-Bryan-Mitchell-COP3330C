
public class BusinessLoan extends Loan {

	public BusinessLoan(int loanNum, String name, double amount, int term, double interest) {
		super(loanNum, name, amount, term, interest);
		super.interestRate = super.interestRate + 0.032;
	}
	
	
}