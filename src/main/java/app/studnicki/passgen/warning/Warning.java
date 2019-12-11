package app.studnicki.passgen.warning;

public class Warning {
    public static void showMessage(WarningType type){
        System.out.println(type.of());
    }
}
