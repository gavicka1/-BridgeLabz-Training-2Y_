class PalindromeChecker {
    String text;

    PalindromeChecker(String text) {
        this.text = text;
    }

    boolean isPalindrome() {
        String reversed = new StringBuilder(text).reverse().toString();
        return text.equalsIgnoreCase(reversed);
    }

    void displayResult() {
        System.out.println(text + " is palindrome? " + isPalindrome());
    }

    public static void main(String[] args) {
        PalindromeChecker p = new PalindromeChecker("madam");
        p.displayResult();
    }
}
