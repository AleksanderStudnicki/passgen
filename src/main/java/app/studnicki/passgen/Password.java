package app.studnicki.passgen;

import java.util.Arrays;

public class Password {

    final char[] value;
    final double entropy;

    public Password(char[] value) {
        this.value = value;
        entropy = calculateEnthropy();
    }

    private double calculateEnthropy(){
        boolean isAlphanumerical = true;

        for(char c : value){
            if(!Character.isLetterOrDigit(c) && !Character.isWhitespace(c)){
                isAlphanumerical = false;
                break;
            }
        }

        int range;

        if(isAlphanumerical){
            range = 62;
        } else{
            range = 95;
        }

        return Math.log(Math.pow(range, value.length)) / Math.log(2);
    }

    @Override
    public String toString() {
        return "Password{" +
                "value=" + Arrays.toString(value).replaceAll(", ", "") +
                ", enthropy=" + entropy +
                '}';
    }
}
