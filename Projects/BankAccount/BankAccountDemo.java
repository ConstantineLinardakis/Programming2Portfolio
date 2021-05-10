import java.util.Scanner;

public class BankAccountDemo
{
   public static void main(String[] args)
   {

     /**
     *   This is the main method.
     *   @param args Unused.
     *   @return Nothing.
     *   @exception IOException.
     *   @see IOException.
     */

     /**
     *   This is the first BankAccount (MomSavings).
     *   User should be able to input there own fee.
     */


      BankAccount momsSavings = new BankAccount();
      Scanner scan = new Scanner(System.in);

      System.out.println("Please enter a custom fee below 1 : ");
      double fee = scan.nextDouble();
      momsSavings.setFee(fee);

      System.out.println("Moms 1st Deposit : " + momsSavings.deposit(500));

      System.out.println("Mom's 1st Withdrawal : " + momsSavings.withdraw(200) + " , total left in savings : "+ momsSavings.getAmount());

      momsSavings.monthlyFee();

      System.out.println("You had a monthly rent fee of 25$ now you remain with : " + momsSavings.getAmount());

      momsSavings.deposit(1000);

      System.out.println("You later deposited 1,000$ into the account you remain with : " + momsSavings.getAmount());

      momsSavings.deductMonthlyCharge();

      System.out.println("You paid a mothly rent fee of 25$ but it was cancelled because you already payed it awhile back, so they gave you your money back. You new balance is : " + momsSavings.getAmount());

   }
}
