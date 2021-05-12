/**
*    Prints a bank accounts money withdrawal's, deposit's, and fee's...
*    Project 3.13 On BIG JAVA CHP 3
*    @author ConstantineLinardakis
*    @since 2020-10-6
*/

public class BankAccount {

  private double balance;
  private int monthlyCharge = 25;
  private double fee = 0;

  /**
  *    Default Constructor
  */

  public BankAccount(){
    this.balance = 0;
  }

  /**
  *    2nd Constructor
  *    This method is used to get the balance.
  *    @param initValue  is used for the main value of the balance.
  */

  public BankAccount(double initValue){
    this.balance = initValue;
  }

  /**
  *    This method is used to get the value of balance.
  *    @return the current balance.
  */

  public double getAmount() {
    return balance;
  }

  /**
  *    Deposits the balance.
  */

  public double deposit(double amount){
    this.balance = this.balance + (amount + transactionFee(amount));
    return amount = amount - transactionFee(amount);
  }

  /**
  *   Withdraw the balance.
  */

  public double withdraw(double amount){
    this.balance = this.balance - (amount + transactionFee(amount));
    return amount = amount - transactionFee(amount);
  }

  /**
  *   Making a fee that affects the balance.
  *   @return the fee.
  */

  public double transactionFee(double transFee){
    transFee = transFee * this.fee;
    return transFee;
  }

  /**
  *   Monthly Fee charge.
  *   Should deduct 25$ from remaining balance using an Integer.
  */

  public void monthlyFee(){
    this.balance = this.balance - monthlyCharge;
  }

  /**
  *   Monthly Fee charge deduction.
  *   Should add 25$ to remaining balance using an Integer.
  */

  public void deductMonthlyCharge(){
    this.balance = this.balance + monthlyCharge;
  }

  /**
  *   Setting the user's input as the fee.
  *   Using there fee as the new fee for transactionFee.
  */

  public void setFee(double newFee){
    this.fee = newFee;
  }


}
