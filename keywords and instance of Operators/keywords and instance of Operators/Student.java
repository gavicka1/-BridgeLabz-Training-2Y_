class Student {
    static String universityName = "GLA University";
    static int totalStudents = 0;
    final int rollNumber;
    String name;
    String grade;

    Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        totalStudents++;
    }

    static void displayTotalStudents() {
        System.out.println("Total Students: " + totalStudents);
    }

    void displayDetails() {
        if (this instanceof Student) {
            System.out.println("University: " + universityName);
            System.out.println("Name: " + name);
            System.out.println("Roll Number: " + rollNumber);
            System.out.println("Grade: " + grade);
        }
    }

    public static void main(String[] args) {
        Student s = new Student("Shiva", 1, "A");
        s.displayDetails();
        Student.displayTotalStudents();
    }
}
