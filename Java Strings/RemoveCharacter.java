import java.util.*;

public class RemoveCharacter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char rem = sc.nextLine().charAt(0);
        String res = "";
        for (char ch : str.toCharArray()) if (ch != rem) res += ch;
        System.out.println(res);
        sc.close();
    }
}
