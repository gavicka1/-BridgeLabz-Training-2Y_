class Student {
    public int rollNumber;
    protected String name;
    private double cgpa;

    Student(int rollNumber, String name, double cgpa) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.cgpa = cgpa;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }
}

class PostgraduateStudent extends Student {
    PostgraduateStudent(int roll, String name, double cgpa) {
        super(roll, name, cgpa);
    }

    void show() {
        System.out.println(rollNumber + " " + name);
    }

    public static void main(String[] args) {
        PostgraduateStudent p = new PostgraduateStudent(1, "Shiva", 8.5);
        p.show();
        System.out.println(p.getCgpa());
    }
}
