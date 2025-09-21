import java.util.ArrayList;
import java.util.List;

abstract class Employee {
    private String employeeId;
    private String name;
    private double baseSalary;
    public Employee(String employeeId,String name,double baseSalary){
        setEmployeeId(employeeId);
        setName(name);
        setBaseSalary(baseSalary);
    }
    public String getEmployeeId(){return employeeId;}
    public void setEmployeeId(String id){if(id==null||id.isEmpty()) throw new IllegalArgumentException(); this.employeeId=id;}
    public String getName(){return name;}
    public void setName(String name){if(name==null||name.isEmpty()) throw new IllegalArgumentException(); this.name=name;}
    public double getBaseSalary(){return baseSalary;}
    public void setBaseSalary(double s){if(s<0) throw new IllegalArgumentException(); this.baseSalary=s;}
    public abstract double calculateSalary();
    public void displayDetails(){System.out.println("ID: "+getEmployeeId()+" Name: "+getName()+" Salary: "+calculateSalary());}
}

interface Department{
    void assignDepartment(String dept);
    String getDepartmentDetails();
}

class FullTimeEmployee extends Employee implements Department{
    private String department;
    public FullTimeEmployee(String id,String name,double baseSalary){super(id,name,baseSalary);}
    public double calculateSalary(){return getBaseSalary();}
    public void assignDepartment(String dept){this.department=dept;}
    public String getDepartmentDetails(){return department==null?"Not Assigned":department;}
}

class PartTimeEmployee extends Employee implements Department{
    private String department;
    private int hours;
    private double hourlyRate;
    public PartTimeEmployee(String id,String name,int hours,double hourlyRate){
        super(id,name,hourlyRate*hours);
        setHours(hours);
        setHourlyRate(hourlyRate);
    }
    public void setHours(int h){if(h<0) throw new IllegalArgumentException(); this.hours=h;}
    public void setHourlyRate(double r){if(r<0) throw new IllegalArgumentException(); this.hourlyRate=r;}
    public int getHours(){return hours;}
    public double getHourlyRate(){return hourlyRate;}
    public double calculateSalary(){return hours*hourlyRate;}
    public void assignDepartment(String dept){this.department=dept;}
    public String getDepartmentDetails(){return department==null?"Not Assigned":department;}
}

public class EmployeeManagement{
    public static void main(String[] args){
        List<Employee> list=new ArrayList<>();
        FullTimeEmployee f=new FullTimeEmployee("F001","Asha",50000);
        f.assignDepartment("HR");
        PartTimeEmployee p=new PartTimeEmployee("P001","Ravi",80,250);
        p.assignDepartment("Support");
        list.add(f);
        list.add(p);
        for(Employee e:list) e.displayDetails();
        System.out.println("Dept of P001: "+((Department)p).getDepartmentDetails());
    }
}
