package app.studnicki.passgen;

import java.text.ParseException;

public class Main {
    public static void main(String[] args){
        PasswordGenerator passwordGenerator;
        if(args.length > 0){
            try{
                int length = Integer.parseInt(args[0]);
                if(args.length > 1){
                    if(args[1].equals("A")){
                        passwordGenerator = new PasswordGenerator(length, true);
                    } else{
                        passwordGenerator = new PasswordGenerator(length);
                    }
                } else{
                    passwordGenerator = new PasswordGenerator(length);
                }
            } catch(NumberFormatException ex){
                System.err.println("You passed non valid number as a length parameter!");
                return;
            } catch(IllegalArgumentException ex){
                System.err.println("Value must greater than 0!");
                return;
            }
        } else{
            passwordGenerator = new PasswordGenerator();
        }
        Password password = passwordGenerator.generate();
        System.out.println(password);
    }
}
