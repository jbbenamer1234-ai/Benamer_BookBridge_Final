

public class LibraryBook {

    private String isbn;
    private String title;
    private boolean available;

    public LibraryBook(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
        this.available = true;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return available;
    }

    public void reserve() {
        available = false;
    }

    public void markReturned() {
        available = true;
    }
}