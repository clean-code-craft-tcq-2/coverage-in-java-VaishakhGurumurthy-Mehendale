package TypewiseAlert;

public class Alerter {

    public static void sendToController(BreachType breachType) {
        int header = 0xfeed;
        System.out.printf("%n : %s%n\n", header, breachType);
    }

    public static void sendToEmail(BreachType breachType) {
        String recepient = "a.b@c.com";

        if(breachType == BreachType.TOO_LOW) {
            System.out.printf("To: %s\n", recepient);
            System.out.printf("Hi, the temperature is %s", breachType.toString());
        }else{
            System.out.printf("To: %s\n", recepient);
            System.out.printf("Hi, the temperature is %s", breachType.toString());
        }

    }

}
