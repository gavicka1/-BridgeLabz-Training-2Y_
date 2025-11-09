public class PropagateApp {
    public static void methodB() {
        try {
            Integer.parseInt("12a");
        } catch (NumberFormatException e) {
            System.out.println("Handled in methodB: NumberFormatException");
        }
        String s = null;
        System.out.println(s.length());
    }
    public static void methodA() {
        try {
            methodB();
        } catch (Exception e) {
            System.out.println("Caught in methodA: " + e.getClass().getSimpleName());
        }
    }
    public static void main(String[] args) {
        methodA();
    }
}
