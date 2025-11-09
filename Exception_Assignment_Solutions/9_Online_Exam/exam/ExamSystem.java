package exam;
import java.time.LocalDateTime;
public class ExamSystem {
    private static final LocalDateTime DEADLINE = LocalDateTime.of(2025, 11, 1, 23, 59);
    public void submitExam(String fileName, LocalDateTime submissionTime) throws LateSubmissionException, InvalidFileFormatException {
        if (!fileName.toLowerCase().endsWith(".pdf")) throw new InvalidFileFormatException("Invalid format");
        if (submissionTime.isAfter(DEADLINE)) throw new LateSubmissionException("Late submission");
        System.out.println("Submission accepted: " + fileName);
    }
}
