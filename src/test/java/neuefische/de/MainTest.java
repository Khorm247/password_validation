package neuefische.de;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    /* template
    // GIVEN
    // WHEN
    // THEN
     */

    @Test
    void sayHelloWorld() {
        // GIVEN

        // WHEN
        Main.sayHelloWorld();
        // THEN
        assertTrue(true);
    }

    @Test
    void hasAtLeast8Characters_WhenMoreThan7_returnTrue(){
        // GIVEN
        String pw = "12345678Ab!";
        // WHEN
        Boolean actual = Main.hasAtLeast8Characters(pw);
        // THEN
        assertTrue(actual);
    }

    @Test
    void hasAtLeast8Characters_WhenLessThan8_returnFalse(){
        // GIVEN
        String pw = "12345";
        // WHEN
        Boolean actual = Main.hasAtLeast8Characters(pw);
        // THEN
        assertFalse(actual);
    }

    @Test
    void containsDigits_WhenPasswordHasDigits_ThenReturnTrue(){
        // GIVEN
        String pw = "12345678Ab!";
        // WHEN
        Boolean actual = Main.containsDigits(pw);
        // THEN
        assertTrue(actual);
    }

    @Test
    void containsDigits_WhenPasswordHasNoDigits_ThenReturnFalse(){
        // GIVEN
        String pw = "asjlgkjalksjgAbs";
        // WHEN
        Boolean actual = Main.containsDigits(pw);
        // THEN
        assertFalse(actual);
    }

    @Test
    void hasLowercaseLetters_WhenLowercaseIncluded_ThenReturnTrue(){
        // GIVEN
        String pw = "12345678Ab!";
        // WHEN
        Boolean actual = Main.hasLowercaseLetters(pw);
        // THEN
        assertTrue(actual);
    }

    @Test
    void hasLowercaseLetters_WhenLowercaseMissing_ThenReturnFalse(){
        // GIVEN
        String pw = "12345678A123322ASDASD!";
        // WHEN
        Boolean actual = Main.hasLowercaseLetters(pw);
        // THEN
        assertFalse(actual);
    }

    @Test
    void hasUppercaseLetters(){
        // GIVEN
        String pw = "12345678Ab!";
        // WHEN
        Boolean actual = Main.hasUppercaseLetters(pw);
        // THEN
        assertTrue(actual);
    }

    @Test
    void containsSpecialCharacters(){
        // GIVEN
        String pw = "12345678Ab!";
        // WHEN
        Boolean actual = Main.containsSpecialCharacters(pw);
        // THEN
        assertTrue(actual);
    }

    @Test
    void isCommonlyUsedPassword_When12345678AbX_returnFalse() throws FileNotFoundException {
        // GIVEN
        String pw = "12345678Ab!";
        // WHEN
        Boolean actual = Main.isCommonlyUsedPassword(pw);
        // THEN
        assertFalse(actual);
    }

    @Test
    void isCommonlyUsedPassword_WhenPassword_returnTrue() throws FileNotFoundException {
        // GIVEN
        String pw = "password";
        // WHEN
        Boolean actual = Main.isCommonlyUsedPassword(pw);
        // THEN
        assertTrue(actual);
    }

    @Test
    void generateRandomPassword(){
        // GIVEN
        String pw = Main.generateRandomPassword(16);
        // WHEN
        Boolean actual = Main.passesAllSafePasswordTests(pw);
        // THEN
        assertTrue(actual);
    }
}