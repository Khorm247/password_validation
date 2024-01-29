package neuefische.de;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        hasLowercaseLetters("asdflkjasdf");
        sayHelloWorld();
    }

    public static void sayHelloWorld() {
        StringBuilder sb = new StringBuilder();
        sb.append("Hello world!\n");
        System.out.println(sb);
    }

    public static Boolean hasAtLeast8Characters(String pw) {
        return pw.length() > 7;
    }

    public static Boolean hasLowercaseLetters(String pw) {
        char[] allowedCharacters = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        for(char c : allowedCharacters){
            if (pw.contains("" + c)) return true;
        }
        return false;
    }

    public static Boolean hasUppercaseLetters(String pw) {
        char[] allowedCharacters = "abcdefghijklmnopqrstuvwxyz".toUpperCase().toCharArray();
        for(char c : allowedCharacters){
            if (pw.contains("" + c)) return true;
        }
        return false;
    }

    public static Boolean containsDigits(String pw) {
        char[] allowedCharacters = "0123456789".toCharArray();
        for(char c : allowedCharacters){
            if (pw.contains("" + c)) return true;
        }
        return false;
    }

    public static Boolean containsSpecialCharacters(String pw) {
        char[] allowedCharacters = "<([{\\^-=$!|]})?*+.>".toCharArray();
        for(char c : allowedCharacters){
            if (pw.contains("" + c)) return true;
        }
        return false;
    }

    // https://github.com/danielmiessler/SecLists/blob/master/Passwords/Common-Credentials/10k-most-common.txt
    public static Boolean isCommonlyUsedPassword(String pw) throws FileNotFoundException {

        File file = new File("src/main/resources/10k-most-common.txt");

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                final String lineFromFile = scanner.nextLine();
                if (lineFromFile.contains(pw)) {
                    // found a weak password
                    System.out.println("Found your committed password:");
                    System.out.println(lineFromFile);
                    return true;
                }
            }
        }
        return false;
    }

    public static String generateRandomPassword() {
        return "";
    }


    // considering that these are the bonus tasks REGEX is now allowed :D
    // https://www.geeksforgeeks.org/how-to-validate-a-password-using-regular-expressions-in-java/

    public static Boolean passesAllSafePasswordTests(String pw) {

        // Regex to check valid password.
        String regex = "^(?=.*\\d)"                     // min 1 digits
                + "(?=.*[a-z])(?=.*[A-Z])"              // min 1 lowercase and 1 uppercase letter
                + "(?=.*[<([{^\\-=$!|]})?*+.>])"        // min 1 special character
                + "(?=\\S+$).{8,64}$";                  // no whitespaces + length between 8 & 64

        // Compile the ReGex
        Pattern p = Pattern.compile(regex);

        // If the password is empty
        // return false
        if (pw == null) {
            return false;
        }

        // Pattern class contains matcher() method
        // to find matching between given password
        // and regular expression.
        Matcher m = p.matcher(pw);

        // Return if the password
        // matched the ReGex
        return m.matches();
    }
}