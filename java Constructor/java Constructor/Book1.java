class Book {
    public String ISBN;
    protected String title;
    private String author;

    Book(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }
}

class EBook extends Book {
    EBook(String ISBN, String title, String author) {
        super(ISBN, title, author);
    }

    void show() {
        System.out.println(ISBN + " " + title);
    }

    public static void main(String[] args) {
        EBook e = new EBook("123", "Java", "James");
        e.show();
        System.out.println(e.getAuthor());
    }
}
