package bank.account;

public class BankAccountTest {

	public static void main(String[] args) {
		BankAccount ac1 = new BankAccount();
		ac1.deposit(200, true);
		ac1.deposit(100, false);
		System.out.println("\n");
		System.out.println(ac1.getBalance(true));
		System.out.println(ac1.getBalance(false));
		ac1.withdraw(150, false);
		ac1.withdraw(150, true);
		System.out.println("\n");
		System.out.println(ac1.getBalance(true));
		System.out.println(ac1.getBalance(false));
		System.out.format("Account number: %.0f",ac1.getAccountNumber());
	}

}
