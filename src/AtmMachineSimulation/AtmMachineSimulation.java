package AtmMachineSimulation;

import java.util.*;

class Balance
{
	private double balance ;
	
	 public void setter(double balance)
	 {
		 this.balance=balance;
	 } 
	 public double getter()
	 {
		 return balance;
	 } 
}

public class AtmMachineSimulation {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int option=0;
		Balance user1=new Balance();
		do {
			System.out.print("\n\n1.View Balance\n2.Withdraw Amount\n3.Deposit amount\n4.Exit\nChoose your option:");
			option=scan.nextInt();
			if(option==2) {
				System.out.println("Enter amount to withdraw:");
				double withdrawAmount = scan.nextDouble();
				try {
					if(withdrawAmount > user1.getter()) {
						throw new InsufficientFundsException("The balance is not enough");
					}
					else {
						user1.setter(user1.getter()-withdrawAmount);
						System.out.println("Your Balance is "+user1.getter());
					}
					if(withdrawAmount<=0) {
						throw new InValidAmountException("The amount is invalid;");
					}
				}
				catch(InValidAmountException inValidAmountException) {
					System.out.print(inValidAmountException);	
				}
				catch(InsufficientFundsException insufficientFundsException) {
					System.out.print(insufficientFundsException);	
				}
			}
			else if(option==1) {
				System.out.println("Your Balance is "+user1.getter());
			}
			else if(option==3) {
				System.out.println("Enter amount to deposit:");
				double deposit = scan.nextDouble();
				user1.setter(user1.getter()+deposit);
				System.out.println("Your Balance is "+user1.getter());
			}
			else if(option==4) {break;}
			else{ System.out.println("Choose a valid option");}
		}while(option!=4);
		System.out.println("Thank you for using this ATM");
	}	

}
class InsufficientFundsException extends Exception{
	public InsufficientFundsException(String errorMsg) {
		super(errorMsg);
	}
}
class InValidAmountException extends Exception{
	public InValidAmountException(String errorMsg) {
		super(errorMsg);
	}
}


