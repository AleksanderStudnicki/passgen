package app.studnicki.passgen.warning;

public enum WarningType {
    PASSWORD_WILL_NOT_BE_SAFE;

    String of(){
        switch(this){
            case PASSWORD_WILL_NOT_BE_SAFE:
                return "Length of password is too short. Password will not be safe!";
            default:
                return "Unrecognized warning type!";
        }
    }
}
