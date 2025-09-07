import java.util.*;

public class ToggleCase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        for (char ch : str.toCharArray()) {
            if (Character.isUpperCase(ch)) sb.append(Character.toLowerCase(ch));
            else if (Character.isLowerCase(ch)) sb.append(Character.toUpperCase(ch));
            else sb.append(ch);
        }
        System.out.println(sb.toString());
        sc.close();
    }
}
