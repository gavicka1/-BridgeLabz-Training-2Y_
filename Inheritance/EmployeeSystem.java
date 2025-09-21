class Employee {
    String name;
    int id;
    double salary;
    Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }
    void displayDetails() {
        System.out.println("Name: " + name + " Id: " + id + " Salary: " + salary);
    }
}

class Manager extends Employee {
    int teamSize;
    Manager(String name, int id, double salary, int teamSize) {
        super(name, id, salary);
        this.teamSize = teamSize;
    }
    void displayDetails() {
        super.displayDetails();
        System.out.println("Team Size: " + teamSize);
    }
}

class Developer extends Employee {
    String programmingLanguage;
    Developer(String name, int id, double salary, String programmingLanguage) {
        super(name, id, salary);
        this.programmingLanguage = programmingLanguage;
    }
    void displayDetails() {
        super.displayDetails();
        System.out.println("Language: " + programmingLanguage);
    }
}

class Intern extends Employee {
    int duration;
    Intern(String name, int id, double salary, int duration) {
        super(name, id, salary);
        this.duration = duration;
    }
    void displayDetails() {
        super.displayDetails();
        System.out.println("Duration: " + duration + " months");
    }
}

public class EmployeeSystem {
    public static void main(String[] args) {
        Employee e1 = new Manager("Rahul", 101, 50000, 10);
        Employee e2 = new Developer("Shiva", 102, 40000, "Java");
        Employee e3 = new Intern("Aman", 103, 10000, 6);
        e1.displayDetails();
        e2.displayDetails();
        e3.displayDetails();
    }
}
