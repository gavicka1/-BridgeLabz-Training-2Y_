class LibraryBook {
    String title;
    String author;
    double price;
    boolean available = true;

    LibraryBook(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    void borrowBook() {
        if (available) {
            available = false;
            System.out.println(title + " borrowed");
        } else {
            System.out.println(title + " not available");
        }
    }

    public static void main(String[] args) {
        LibraryBook b = new LibraryBook("Java", "Gosling", 300);
        b.borrowBook();
        b.borrowBook();
    }
}
