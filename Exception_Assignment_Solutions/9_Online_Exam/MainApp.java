import exam.ExamSystem;
import exam.LateSubmissionException;
import exam.InvalidFileFormatException;
import java.time.LocalDateTime;
public class MainApp {
    public static void main(String[] args) {
        ExamSystem e = new ExamSystem();
        try {
            e.submitExam("answers.doc", LocalDateTime.now());
        } catch (InvalidFileFormatException ex) {
            System.out.println("Submission failed: invalid file format");
        } catch (LateSubmissionException ex) {
            System.out.println("Submission failed: late submission");
        }
    }
}
