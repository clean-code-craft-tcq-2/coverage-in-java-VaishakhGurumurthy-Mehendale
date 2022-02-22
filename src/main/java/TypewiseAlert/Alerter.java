package TypewiseAlert;

public class Alerter {

    public static boolean sendToController(BreachType breachType) {

        boolean isControllerAlerted_STUD = false;
        int header = 0xfeed;
        System.out.printf("%n : %s%n\n", header, breachType);

        // Dummy assumption -> Controller alerted without any network error
        isControllerAlerted_STUD = true;
        return isControllerAlerted_STUD;

    }

    public static boolean sendToEmail(BreachType breachType) {
        String recepient = "a.b@c.com";
        boolean isEmailSent_STUD = false;
        if(breachType == BreachType.TOO_LOW) {
            System.out.printf("To: %s\n", recepient);
            System.out.printf("Hi, the temperature is %s", breachType.toString());
        }else{
            System.out.printf("To: %s\n", recepient);
            System.out.printf("Hi, the temperature is %s", breachType.toString());
        }

        // Dummy assumption - > Email logic executed without any network errors
        isEmailSent_STUD = true;
        return isEmailSent_STUD;

    }

}
