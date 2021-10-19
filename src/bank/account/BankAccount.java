package bank.account;
import java.util.ArrayList;
import java.util.Random;

public class BankAccount {
	private double checking_balance;
	private double savings_balance;
	private static int n_accounts =0;
	private static double total_balance_checking;
	private static double total_balance_savings;
	private double account_number;
	private static ArrayList<Double> acc_num_list = new ArrayList<Double>();
	
	
	public Double getAccNum() {
		Random rand = new Random();
		Double ac_num;
		do {
	//Some sort of trick is necessary due to the requirement of a 10-digit number
		int rand_int1 = Math.abs(rand.nextInt(9999999)) + 1;
		int rand_int2 = Math.abs(rand.nextInt(999)) + 1;
		double rand_num = rand_int1*1000 + rand_int2;
		ac_num = Double.valueOf(rand_num);
		}
		while(acc_num_list !=null & acc_num_list.contains(ac_num));
		
		return ac_num;
		
	}
	
	public BankAccount() {
		n_accounts +=1;
		account_number = (double)getAccNum();
		acc_num_list.add(account_number);
	}
	
	
	public double getAccountNumber() {
		return account_number;
	}
	
	public double getBalance(boolean isChecking) {
		if(isChecking) {
			return checking_balance;
			}
		else {
			return savings_balance;
			}
		
	}
	
	public void deposit(double money, boolean isChecking) {
		if (isChecking) {
			checking_balance += money;
			total_balance_checking += money;
			System.out.format("\nSuccessful deposit. Current balance: %.2f", checking_balance);
			
		} else {
			
			savings_balance += money;
			total_balance_savings += money;
			System.out.format("\nSuccessful deposit. Current balance: %.2f", savings_balance);
		}
		
	}
	
	
	
	
	public void withdraw(double money, boolean isChecking) {
		if (isChecking & checking_balance >= money) {
			checking_balance -= money;
			total_balance_checking -= money;
			System.out.format("\nSuccessful withdraw. Current balance: %.2f", checking_balance);
					
		} else if (isChecking == false & savings_balance >= money) {
			
			savings_balance -= money;
			total_balance_savings -= money;
			System.out.format("\nSuccessful withdraw. Current balance: %.2f", savings_balance);
		}
		
		else {
			
			System.out.println("\nInsufficient funds");
			
		}
		
	}
	
	
	static void printTotals() {
		System.out.format("\nTotal checking accounts: %.2f\nTotal savings accounts: %.2f",
				total_balance_checking,total_balance_savings);
	}
	
	static void printNumAccounts(){
		System.out.format("\nThe total number of accounts is %d", n_accounts);
	}
	
	
}
