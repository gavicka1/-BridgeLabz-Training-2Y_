class Employee {
    static String companyName = "TechCorp";
    static int totalEmployees = 0;
    final int id;
    String name;
    String designation;

    Employee(String name, int id, String designation) {
        this.name = name;
        this.id = id;
        this.designation = designation;
        totalEmployees++;
    }

    static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }

    void displayDetails() {
        if (this instanceof Employee) {
            System.out.println("Company: " + companyName);
            System.out.println("Name: " + name);
            System.out.println("ID: " + id);
            System.out.println("Designation: " + designation);
        }
    }

    public static void main(String[] args) {
        Employee e = new Employee("Shiva", 1, "Developer");
        e.displayDetails();
        Employee.displayTotalEmployees();
    }
}
