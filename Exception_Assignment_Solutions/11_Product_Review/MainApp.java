import rev.InvalidRatingException;
import rev.EmptyReviewException;
public class MainApp {
    public static void submitReview(int rating, String comment) throws InvalidRatingException, EmptyReviewException {
        if (rating < 1 || rating > 5) throw new InvalidRatingException("Rating out of range");
        if (comment == null || comment.trim().isEmpty()) throw new EmptyReviewException("Empty comment");
        System.out.println("Review accepted: " + rating + " comment: " + comment);
    }
    public static void main(String[] args) {
        try {
            submitReview(6, "");
        } catch (InvalidRatingException e) {
            System.out.println("Rating error: " + e.getMessage());
        } catch (EmptyReviewException e) {
            System.out.println("Comment error: " + e.getMessage());
        }
    }
}
