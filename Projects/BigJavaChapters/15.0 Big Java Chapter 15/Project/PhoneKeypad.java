import java.util.*;
import java.util.Scanner;

/**
* A program that prompts the user to enter a phone number as a string. Project 15.1
* @author Constantine Linardakis
* @since April / 29 / 2021
*/

public class PhoneKeypad {
  public static int getNumber(char uppercaseLetter) {
    int number = 0;
    switch(uppercaseLetter){
      case 'A':
      case 'B':
      case 'C':
      number = 2;
      break;
      case 'D':
      case 'E':
      case 'F':
      number = 3;
      break;
      case 'G':
      case 'H':
      case 'I':
      number = 4;
      break;
      case 'J':
      case 'K':
      case 'L':
      number = 5;
      break;
      case 'M':
      case 'N':
      case 'O':
      number = 6;
      break;
      case 'P':
      case 'Q':
      case 'R':
      case 'S':
      number = 7;
      break;
      case 'T':
      case 'U':
      case 'V':
      number = 8;
      break;
      case 'W':
      case 'X':
      case 'Y':
      case 'Z':
      number = 9;
      break;
    }
    /*
    * @return the number here for the main method.
    */
    return number;
  }

  /*
  * Main method for getting the user input as a phone number.
  */

  public static void main(String[]args){
    System.out.print("Please Enter A Phone Number (Please Enter the Letters in Capital): ");
    Scanner keyboard = new Scanner(System.in);

    String phone = keyboard.nextLine();
    keyboard.close();
    int phoneLength = phone.length();

    for (int i=0; i<phoneLength; i++) {
      char currChar = phone.charAt(i);
      if (Character.isLetter(currChar)) {
        currChar = Character.toUpperCase(currChar);
        int number = getNumber(currChar);
        System.out.print(number);
      }
      else {
        System.out.print(currChar);
      }
    }
    System.out.println();
  }
}
