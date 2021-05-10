import java.util.Scanner;

/**
* @author Constantine Linardakis
* @since 3/5/2021 
* Project 13.2 Phone numbers and PIN codes can be easier to remember when you find words that spell out the number on a standard phone pad.
For example, instead of remembering the combination 5282, you can just think of JAVA.
Write a recursive method that, given a number, yields all possible spellings (which may or may not be real words).
*/

public class PinWordEnumerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your pin number: ");
        String num = scanner.nextLine();

        System.out.println();
        System.out.printf("The keypad encodings for %s are:%n", num);
        enumerateWords(num);
    }

    /**
    * Method to return a character array containing all possible keypad
    * Encodings for a digit in a standard phone
    */

    static char[] getKeysForButton(int n) {
    switch (n) {
        case 0:
                return new char[] { ' ' }; //returning only space
        case 1:
                return new char[] { '.' }; //returning only dot
        case 2:
                return new char[] { 'A', 'B', 'C' };  //button 2 contains A, B and C keys
        case 3:
                return new char[] { 'D', 'E', 'F' };
        case 4:
                return new char[] { 'G', 'H', 'I' };
        case 5:
                return new char[] { 'J', 'K', 'L' };
        case 6:
                return new char[] { 'M', 'N', 'O' };
        case 7:
                return new char[] { 'P', 'Q', 'R', 'S' };
        case 8:
                return new char[] { 'T', 'U', 'V' };
        case 9:
                return new char[] { 'W', 'X', 'Y', 'Z' };
        }

        return null;
    
    }

    /**
    * Method to Enumerate words
    * @param num String containing pin numbers assuming it has only numbers
    */

    static void enumerateWords(String num) {

    /**
    *  Calling the recursive method to perform the enumeration
    */
    
    if (num != null)
        enumerateWords(num, "");
    }

    /**
    * Main method that performs the recursion 
    * @param num current number
    * @param text containg converted spellings
    */

    static void enumerateWords(String num, String text) {
         if (num.length() == 0) {
            // Base case, displaying the text
            System.out.println(text);
         } else {
            // Finding the digit at 0th position
            int digit = num.charAt(0) - '0';
            // Finding possible phone keys for this digit
            char letters[] = getKeysForButton(digit);
            if (letters != null) {
                // Looping through all possible keys
                for (int i = 0; i < letters.length; i++) {
                    /**
                    * Appending the current letter to the text and calling the
                    * Recursive method also neglecting the first letter of
                    * Current 'num' string
                    */
                    enumerateWords(num.substring(1), text + letters[i]);
                }
            }
        }
    }
}
