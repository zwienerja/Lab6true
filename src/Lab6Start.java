import javax.swing.*;

/***********************************************************************************************************
 @author jaredzwiener , Jared Zwiener
 Date: 2/23/18
 Worker with: Hunter Smith

 *  CSIT 150 Lab 6 Spring 2018
 *
 * Imagine that you are developing a software package that requires users to enter their own
 passwords. Your software requires that user passwords meet the following criteria:

  The password should be at least six characters long.
  The password should contain at least one uppercase and at least one lowercase letter.
  The password should have at least one digit and one special character.
 (A special character is not alphabetic and is not a digit).
  The password should not be in the array of not allowed passwords.
 In general, this array may include several words, or be null.
 For testing purposes, do not allow passwords to be one of  the following strings: "Password1","Mypassw0rd".
 Ask for the user name and password.
 Keep asking for a password until the user enters a password that meets the criteria above.
 Output the username and the password. Then, output the user and the hidden password â€œ******â€.

 Add JavaDoc comments to this program.

 ********************************************************************************************************/

public class Lab6Start {

    private static String[] notAllowed = {"Password1", "Mypassw0rd"};

    /**
     * Makes sure the password entered is not a 'banned' password for the array
     * @param passWord
     * @param notAllowed
     * @return allowed - boolean
     */
    public static boolean isAllowed(String passWord, String[] notAllowed) {
        for(int g = 0; g < notAllowed.length; g++){
            if (passWord == notAllowed[g])
                return false;
        }
        return true;
    }

    /**
     * Makes sure the password entered has a number in it
     * @param passWord
     * @return digit - boolean
     */
    public static boolean digitValidate(String passWord){
        boolean digit = false;
        char [] digits = {'1','2','3','4','5','6','7','8','9'};
        //validate digit presence
        for (int h = 0; h < passWord.length(); h++){
            for (int j = 0; j < digits.length; j++){
                if(passWord.charAt(h) == digits[j]){
                    digit = true;
                }
            }
        }
        return digit;
    }

    /**
     * Makes sure the password entered has a symbol in it
     * @param passWord
     * @return symbol - boolean
     */
    public static boolean symbolValidate(String passWord){
        boolean symbol = false;
        String symbols = ("`~!@#$%^&*()-_=+[{]}|';:/?.>,<");
        //validate symbol presence
        for (int b = 0; b < passWord.length(); b++){
            for (int c = 0; c < symbols.length(); c++){
                if(passWord.charAt(b) == symbols.charAt(c)){
                    return true;
                }
            }
        }
        return symbol;
    }

    /**
     * Makes sure the password entered has a capital letter in it
     * @param passWord
     * @return upperCase - boolean
     */
    public static boolean upperCaseValidate(String passWord){
        boolean upperCase = false;
        //validate upper case presence
        for (int a = 0; a < passWord.length(); a++){
            if(Character.isUpperCase(passWord.charAt(a))){
                upperCase = true;
            }
        }
        return upperCase;
    }

    /**
     * Makes sure the password entered has a lower case letter in it
     * @param passWord
     * @return lowerCase - boolean
     */
    public static boolean lowerCaseValidate(String passWord){
        boolean lowerCase = false;
        //validate lower case presence
        for (int i = 0; i < passWord.length(); i++){
            if(Character.isLowerCase(passWord.charAt(i))){
                lowerCase = true;
            }
        }
        return lowerCase;
    }

    /**
     * Makes sure the password entered is at least 6 characters long
     * @param passWord
     * @return length - boolean
     */
    public static boolean lengthValidate(String passWord){
        boolean length = false;
        //validate length
        if (passWord.length() >= 6) {
            length = true;
        }
        return length;
    }

    /**
     * Returns true if the entered password is 6 characters long and encases a symbol, number digit,
     * upper case letter, and lower case letter.  Returns false if the password doesn't satisfy these
     * requirements
     * @param passWord
     * @return boolean
     */
    public static boolean isValidPassword(String passWord) {
        if (digitValidate(passWord) && symbolValidate(passWord) && lengthValidate(passWord) &&
                upperCaseValidate(passWord) && lowerCaseValidate(passWord) && isAllowed(passWord, notAllowed)){
            return true;
        }
        return false;
    }

    /**
     * Takes in a password and turns it into a row of astrix's '*'
     * @param passWord
     * @return hiddenPassword - "******"
     */
    public static StringBuffer hidePassword(String passWord) {
        StringBuffer hiddenPassword = new StringBuffer(passWord);
        //hiddenPassword = hiddenPassword.replace(0, passWord.length(), "*");
        for (int i = 0; i < passWord.length(); i++)
            hiddenPassword.replace(i, passWord.length(),"*");
        return hiddenPassword;
    }

    /**
     * Main method
     * asks user for input: username , password
     * validates that password satisfies password requirements
     * outputs user's username and password
     * then outputs user's username and hidden password
     * @param args
     */
    public static void main(String[] args) {

        boolean valid = true;
        String userName = "";
        String passWord = "";
        userName = JOptionPane.showInputDialog(null, "Enter your username: ");
        passWord = JOptionPane.showInputDialog(null, "Enter your password: ");
        valid = isValidPassword(passWord);
        while (!valid) {
            passWord = JOptionPane.showInputDialog(null, "Invalid password. Enter a new password: ");
            valid = isValidPassword(passWord);
        }
        StringBuffer hiddenPassword = hidePassword(passWord);
        System.out.println("The username: " + userName + " has password: " + passWord);
        System.out.println("The username: " + userName + " with hidden password: " + hiddenPassword);
    }
}