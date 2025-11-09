import com.school.data.*;
import com.school.util.*;
public class MainApp {
    public static void main(String[] args) {
        Student s = new Student("Shiva", 80, 90, 70);
        Analyzer a = new Analyzer();
        double avg = a.average(s);
        System.out.println(s);
        System.out.println("Average: " + avg);
        System.out.println("Grade: " + a.grade(avg));
    }
}