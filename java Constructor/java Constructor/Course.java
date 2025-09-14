class Course {
    String courseName;
    int duration;
    double fee;
    static String instituteName = "GLA";

    Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    void displayCourseDetails() {
        System.out.println(courseName + " " + duration + " " + fee + " " + instituteName);
    }

    static void updateInstituteName(String name) {
        instituteName = name;
    }

    public static void main(String[] args) {
        Course c1 = new Course("Java", 3, 5000);
        c1.displayCourseDetails();
        Course.updateInstituteName("IIT");
        c1.displayCourseDetails();
    }
}
