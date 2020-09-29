//import necessary classes
import java.io*;
import java.util.Scanner;

/**
 * Class StringStuff
 */
public class StringStuff {
  
  /**
   * Creating the blowup() function
  */
  public static String blowup(String userInput)  {
    
    //String charAti = "";
    //String charAfteri = "";
    String output = "";
    boolean endOfArray = false;
    
    //putting string into array
    char charArray[] = userInput.toCharArray();
    
    //looping through each char
    for (int i = 0; i < charArray.length ; i++)  {
      
      //getting the char at index i to check
      String charAti = Character.toString(charArray[i]);
      
      //check to see if char at index i is a digit
      boolean isDigit = isdigit(charAti);
      
      if (isDigit != true) {
        //if not a digit, output to the console
        output += charAti;
      } else  {
        //check to see if char at index i is the last char
        endOfArray = endofarray(charArray, i);
        
        if (endOfArray != true) {
          //get the numeric value of char at i
          int intAti = Integer.parseInt(charAti);
          String charAfteri = Character.toString(charArray[i + 1]);
          for (int repeater = 0; repeater < intAti; repeater++)  {
            output += charAfteri;
          }
        } else  {
          //if true. do nothing
        }
      }
    }
    
    return output;
  }
  
  /**
   * Testing if char at index i is a digit.
  */
  public static boolean isdigit(String charAti) {
    try {
      Integer.parseInt(charAti);
      return true;
    } catch(NumberFormatException e) {
      return false;
    }
  }
  
  /**
   * Testing if char at index i is the last char.
  */
  public static boolean endofarray(char charArray[], int i) {
    try {
      //checking each i
      String charAfteri = Character.toString(charArray[i + 1]);
      return false;
    } catch(ArrayIndexOutOfBoundsException e) {
      return true;
    }
  }
  
  public static void main(String[] args) {
    
    //declare variables
    String output = "";
    //String userInput = "";
    
    //ask the user for an input
    System.out.println("Smash something against the keyboard");
    
    //get the input from the user
    Scanner input = new Scanner(System.in);
    String userInput = input.next();
    
    String testVal = blowup(userInput);
    
    System.out.println(testVal);
  }
}