package app.studnicki.passgen;

import app.studnicki.passgen.charactersRange.CharactersRange;
import app.studnicki.passgen.warning.Warning;
import app.studnicki.passgen.warning.WarningType;

import java.util.Random;

public class PasswordGenerator {

    final int length;
    boolean isAlpha;

    final int DEFAULT_LENGTH = 10;
    final int MINIMAL_SAFE_LENGTH = 8;

    public PasswordGenerator() {
        this.length = DEFAULT_LENGTH;
    }

    public PasswordGenerator(int length) {
        if(length <= 0){
            throw new IllegalArgumentException("Not a valid length value! Must be greater than 0!");
        }
        this.length = length;
        if (this.length < MINIMAL_SAFE_LENGTH) {
            Warning.showMessage(WarningType.PASSWORD_WILL_NOT_BE_SAFE);
        }
    }

    public PasswordGenerator(boolean isAlpha) {
        this();
        this.isAlpha = true;
    }

    public PasswordGenerator(int length, boolean isAlpha) {
        this(length);
        this.isAlpha = true;
    }

    public Password generate() {
        char[] characters;

        if (isAlpha) {
            characters = CharactersRange.getAlphanumericals();
        } else {
            characters = CharactersRange.getNonWhitespaces();
        }

        char[] password = new char[length];
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length);
            password[i] = characters[randomIndex];
        }

        return new Password(password);
    }
}
