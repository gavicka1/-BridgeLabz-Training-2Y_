import java.util.*;

public class LongestWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] words = sc.nextLine().split(" ");
        String longest = "";
        for (String w : words) if (w.length() > longest.length()) longest = w;
        System.out.println(longest);
        sc.close(); 
    }
}
