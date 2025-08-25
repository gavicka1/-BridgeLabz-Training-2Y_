public class ques7 {
    public static void main(String[] args) {
        int month = Integer.parseInt(args[0]);
        int day = Integer.parseInt(args[1]);

        boolean isSpring = false;

        if (month == 3 && day >= 20 && day <= 31) {
            isSpring = true;
        } else if (month > 3 && month < 6) {
            isSpring = true;
        } else if (month == 6 && day >= 1 && day <= 20) {
            isSpring = true;
        }

        if (isSpring) {
            System.out.println("Its a Spring Season");
        } else {
            System.out.println("Not a Spring Season");
        }
    }
}
