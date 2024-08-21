
public class PersonalLoan extends Loan {

	public PersonalLoan(int loanNum, String name, double amount, int term, double interest) {
		super(loanNum, name, amount, term, interest);
		super.interestRate = super.interestRate + 0.027;
	}

	

}
