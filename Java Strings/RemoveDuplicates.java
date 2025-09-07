import java.util.*;

public class RemoveDuplicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String res = "";
        for (char ch : str.toCharArray()) if (res.indexOf(ch) == -1) res += ch;
        System.out.println(res);
        sc.close();
    }
}
