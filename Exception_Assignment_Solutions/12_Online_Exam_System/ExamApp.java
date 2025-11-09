import exc.InvalidStudentException;
import java.io.IOException;
public class ExamApp {
    public static void validateStudent(String id) throws InvalidStudentException {
        if (!"S1".equals(id)) throw new InvalidStudentException("Student invalid");
    }
    public static void submitExam(String id) throws InvalidStudentException, IOException {
        validateStudent(id);
        if ("IO".equals(id)) throw new IOException("IO error during submission");
        System.out.println("Exam submitted for " + id);
    }
    public static void main(String[] args) {
        try {
            submitExam("X");
        } catch (InvalidStudentException e) {
            System.out.println("Validation error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO error: " + e.getMessage());
        } finally {
            System.out.println("Exam submission process completed.");
        }
    }
}
