public class Book {
    String title;
    String category;
    String author;
    String publishedDate;
    BookState state;
    public Book(String title, String category, String author, String publishedDate) {
        this.title = title;
        this.category = category;
        this.author = author;
        this.publishedDate = publishedDate;
    }
    //getters
    public String getTitle() {
        return title;
    }
    public String getCategory() {
        return category;
    }
    public String getAuthor() {
        return author;
    }
    public String getPublishedDate() {
        return publishedDate;
    }

    //Set state buat buku
    public void setState(BookState state) {
        this.state = state;
    }

    //check jika buku tersedia, dipinjam, dipesan, atau hilang/rusak
    public String getState() {
        return state.getState();
    }

    //methods
    public boolean borrow() {
        return state.borrow();
    }

    public boolean returnBook() {
        return state.returnBook();
    }

    public boolean reserve() {
        return state.reserve();
    }

}
