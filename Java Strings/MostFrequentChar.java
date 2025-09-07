import java.util.*;

public class MostFrequentChar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int max = 0; char ans = ' ';
        for (char ch : str.toCharArray()) {
            int freq = 0;
            for (char d : str.toCharArray()) if (ch == d) freq++;
            if (freq > max) { max = freq; ans = ch; }
        }
        System.out.println(ans);
        sc.close();
    }
}
