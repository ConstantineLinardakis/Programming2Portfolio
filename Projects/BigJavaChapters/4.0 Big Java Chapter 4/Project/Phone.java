import java.util.Scanner;

/*
*  Project 4.8 (Big Java Chapter 4)
*  Constantine Linardakis
*  Gets the user's Phone Number and format's it in correct order.
*/

public class Phone {

  public static void main(String[] args){

    long n = 10;
    int a[]= new int[10];
    Scanner sc = new Scanner(System.in);

    System.out.println("Enter your phone number : ");

    for(int i=0;i<n;i++) {

      a[i]=sc.nextInt();
      if(a[i]<0 || a[i]>9){
        System.out.println("Wrong Input!");
        return;
      }
      System.out.println("");
    }

    System.out.println("Phone Number Format : ");

    for(int i=0;i<n;i++){
      if(i==0)
      System.out.print("\"(");

      if(i==3)
      System.out.print(") ");

      if(i==6)
      System.out.print("-");
      System.out.print(a[i]);

      if(i==9)
    }

  }

}
