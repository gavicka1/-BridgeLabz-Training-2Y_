import com.company.hr.*;
import com.company.payroll.*;
public class MainApp {
    public static void main(String[] args) {
        Employee e = new Employee(1, "Shiva", 50000);
        Payroll p = new Payroll();
        p.addBonus(e);
        System.out.println(e.getName() + " Final Salary: " + e.getSalary());
    }
}