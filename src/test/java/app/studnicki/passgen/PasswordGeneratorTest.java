package app.studnicki.passgen;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

@Test
public class PasswordGeneratorTest {

    public void youWillGet10AsAPasswordLengthAfterUsageOfDefaultConstructor() {
        PasswordGenerator passwordGenerator = new PasswordGenerator();

        assertEquals(10, passwordGenerator.length);
    }

    public void ifNotSpecifiedThenNewGeneratorContainsSpecialCharacters() {
        PasswordGenerator passwordGenerator = new PasswordGenerator();
        PasswordGenerator anotherPasswordGenerator = new PasswordGenerator(20);

        assertFalse(passwordGenerator.isAlpha);
        assertFalse(anotherPasswordGenerator.isAlpha);
    }

    public void ifSpecifiedThenNewGeneratorWillOperatingOnlyOnAlphanumericalCharacters(){
        PasswordGenerator passwordGenerator = new PasswordGenerator(true);
        PasswordGenerator anotherPasswordGenerator = new PasswordGenerator(20, true);

        assertTrue(passwordGenerator.isAlpha);
        assertTrue(anotherPasswordGenerator.isAlpha);
    }

    public void passwordCharactersAreAlphanumerical(){
        PasswordGenerator passwordGenerator = new PasswordGenerator(true);

        Password password = passwordGenerator.generate();

        for(char c : password.value){
            assertTrue(Character.isLetterOrDigit(c));
        }
    }

    public void passwordCharactersAreNonWhitespaces(){
        PasswordGenerator passwordGenerator = new PasswordGenerator(1000);

        Password password = passwordGenerator.generate();

        for(char c : password.value){
            assertFalse(Character.isWhitespace(c));
        }
    }

    @Test (expectedExceptions = IllegalArgumentException.class)
    public void valueLesserOrEquals0ShouldThrowsException(){
        PasswordGenerator passwordGenerator = new PasswordGenerator(-1);
    }

    @Test (expectedExceptions = IllegalArgumentException.class)
    public void valueLesserOrEquals0ShouldThrowsExceptionInTwoArgumentalConstructor(){
        PasswordGenerator passwordGenerator = new PasswordGenerator(0, true);
    }
}
