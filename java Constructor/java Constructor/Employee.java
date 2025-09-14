class Employee {
    public int employeeID;
    protected String department;
    private double salary;

    Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }
}

class Manager extends Employee {
    Manager(int id, String dept, double sal) {
        super(id, dept, sal);
    }

    void show() {
        System.out.println(employeeID + " " + department);
    }

    public static void main(String[] args) {
        Manager m = new Manager(1, "IT", 60000);
        m.show();
        m.setSalary(70000);
        System.out.println(m.getSalary());
    }
}
