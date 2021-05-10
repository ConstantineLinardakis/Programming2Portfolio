/**
*    This program Converts a positive integer into the Roman number system going from 1-3999...
*    Project 5.10 On BIG JAVA CHP 5
*    @author ConstantineLinardakis
*    @since 2020-11-2
*/

public class RomanNumbers {

  /**
  *    Strings and integers of the available Roman Numbers/Letters.
  */

  public static final int[] numbers = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
  public static final String[] letters = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};

  /**
  *    Default Constructor
  *    This method is used to get the roman number value.
  *    @param numb  is used for the main value of the RomanNumbers.
  */

  public static String numbToRoman(int numb) {
    System.out.println("Please pick a number between 1-3999.");
    String roman = "";

    if (numb < 1 || numb > 3999) {
      System.out.println("Invalid Number Value, please pick between 1-3999.");
    }

    while (numb > 0) {
      int maxFound = 0;
      for (int i=0; i < numbers.length; i++){
        if (numb >= numbers[i]) {
          maxFound = i;
        }
      }

      roman += letters[maxFound];
      numb -= numbers[maxFound];

    }

    /**
    *   @return the current roman numberial value.
    */

    return roman;

  }
}



/*

// Other way of approaching it?
// Either way should work.

// NOT MY SOURCE CODE :

class GFG
{
    // Function to calculate roman equivalent
    static String intToRoman(int num)
    {
        // storing roman values of digits from 0-9
        // when placed at different places
        String m[] = {"", "M", "MM", "MMM"};
        String c[] = {"", "C", "CC", "CCC", "CD", "D",
                            "DC", "DCC", "DCCC", "CM"};
        String x[] = {"", "X", "XX", "XXX", "XL", "L",
                            "LX", "LXX", "LXXX", "XC"};
        String i[] = {"", "I", "II", "III", "IV", "V",
                            "VI", "VII", "VIII", "IX"};

        // Converting to roman
        String thousands = m[num/1000];
        String hundereds = c[(num%1000)/100];
        String tens = x[(num%100)/10];
        String ones = i[num%10];

        String ans = thousands + hundereds + tens + ones;

        return ans;
    }

    // Driver program to test above function
    public static void main(String []args)
    {
        int number = 3549;
        System.out.println(intToRoman(number));

    }

}

*/
