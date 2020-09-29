//import necessary classes
import java.io.*;
import java.util.Scanner;

/**
* This application takes an input from a txt file.
* Applies changes to it
* And then outputs it to a txt file
*
* @author  Ben Falsetto
* @version 1.0
* @since   2020-09-29
*/
public class StringStuff {
  
  /**
   * Creating the blowup() function.
  */
  public static String blowup(String userInput)  {
    
    //String charAti = "";
    //String charAfteri = "";
    String output = "";
    boolean endOfArray = false;
    
    //putting string into array
    char[] charArray = userInput.toCharArray();
    
    //looping through each char
    for (int i = 0; i < charArray.length; i++)  {
      
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
    } catch (NumberFormatException e) {
      return false;
    }
  }
  
  /**
   * Testing if char at index i is the last char.
  */
  public static boolean endofarray(char[] charArray, int i) {
    try {
      //checking each i
      String charAfteri = Character.toString(charArray[i + 1]);
      return false;
    } catch (ArrayIndexOutOfBoundsException e) {
      return true;
    }
  }
  
  /**
    * Data is collected here and is sent off for processing.
    * The data is then returned and is written here
  */
  public static void main(String[] args) {
    
    //declare variables
    String userInput = "";
    
    //the name of the file
    String inputFileName = "input.txt";
    String outputFileName = "output.txt";
    
    //string to reference one at a time
    String line = null;
    
    //attempting to write the .txt file to the string variable
    try {
      FileReader fileReader = new FileReader(inputFileName);
      BufferedReader bufferedReader = new BufferedReader(fileReader);
      while ((line = bufferedReader.readLine()) != null)  {
        System.out.println(line);
        userInput = line;
      }
      bufferedReader.close();
      
      //catching file not opening and file reading errors
    } catch (FileNotFoundException ex) {
      System.out.println("Unable to open file '" + inputFileName + "'");
    } catch (IOException ex) {
      System.out.println("Error reading file '" + inputFileName + "'");
    }
    
    //ask the user for an input
    //System.out.println("Smash something against the keyboard");
    
    //get the input from the user
    //Scanner input = new Scanner(System.in);
    //userInput = input.next();
    
    String output = blowup(userInput);
    
    System.out.println(output);
    
    try {
      //writing the text to an output file
      FileWriter fileWriter = new FileWriter(outputFileName);
      
      BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
      
      bufferedWriter.write(output);
      
      bufferedWriter.close();
      
      //if things go wrong, don't break the program
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }
}