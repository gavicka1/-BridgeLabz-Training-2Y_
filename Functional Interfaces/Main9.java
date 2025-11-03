import java.text.SimpleDateFormat;
import java.util.Date;

interface DateUtils {
    static String formatDate(Date d, String pattern) {
        return new SimpleDateFormat(pattern).format(d);
    }
}

public class Main9 {
    public static void main(String[] args) {
        System.out.println(DateUtils.formatDate(new Date(), "dd/MM/yyyy"));
    }
}
