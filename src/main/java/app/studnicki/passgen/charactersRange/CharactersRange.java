package app.studnicki.passgen.charactersRange;

public class CharactersRange {
    public static char[] getNonWhitespaces(){
        StringBuilder sb = new StringBuilder();
        appendNonWhitespaces(sb);
        String charactersString = sb.toString();
        return charactersString.toCharArray();
    }

    public static char[] getAlphanumericals(){
        StringBuilder sb = new StringBuilder();
        appendLowerCaseLetters(sb);
        appendUpperCaseLetters(sb);
        appendNumbers(sb);
        String charactersString = sb.toString();
        return charactersString.toCharArray();
    }

    private static void appendNumbers(StringBuilder sb) {
        appendCharsFromRange(sb, '0', '9');
    }

    private static void appendUpperCaseLetters(StringBuilder sb) {
        appendCharsFromRange(sb, 'A', 'Z');
    }

    private static void appendLowerCaseLetters(StringBuilder sb) {
        appendCharsFromRange(sb, 'a', 'z');
    }

    private static void appendNonWhitespaces(StringBuilder sb) {
        appendCharsFromRange(sb, (char)33, '~');
    }

    private static void appendCharsFromRange(StringBuilder sb, char startChar, char endChar) {
        for (int i = startChar; i <= endChar; i++) {
            sb.append((char) i);
        }
    }


}
