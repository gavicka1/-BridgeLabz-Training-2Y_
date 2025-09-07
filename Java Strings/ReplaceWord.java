import java.util.*;

public class ReplaceWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String oldW = sc.nextLine();
        String newW = sc.nextLine();
        System.out.println(str.replace(oldW, newW));
        sc.close();
    }
}
