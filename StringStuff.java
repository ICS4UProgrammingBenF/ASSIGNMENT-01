//import necessary classes
import java.util.Scanner;

/**
 * Class StringStuff
 */
public class StringStuff {
  
  /**
   * Required Javadoc.
  */
  
  /**
   * Creating the convertchar() function
  */
  
  public static String blowup(String userInput)  {
    char[] charArray = userInput.toCharArray();
    return userInput;
  }
  
  public static void main(String[] args) {
    
    //declare variables
    String output = "";
    //String userInput = "";
    
    //get the input from the user
    Scanner input = new Scanner(System.in);
    String userInput = input.next();
    
    String testVal = blowup(userInput);
    
    System.out.println(userInput);
    System.out.println(testVal);
  }
}