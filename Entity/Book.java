package entity;
import states.*;

public class Book {
    String title;
    String category;
    String author;
    String publishedDate;
    BookStateInterface state;
    public Book(String title, String category, String author, String publishedDate) {
        this.title = title;
        this.category = category;
        this.author = author;
        this.publishedDate = publishedDate;
        this.state = new AvailableState(); //default state is available when book is created
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
    public void setState(BookStateInterface state) {
        this.state = state;
    }

    //check jika buku tersedia, dipinjam, dipesan, atau hilang/rusak
    public String getState() {
        return state.getState();
    }

    //methods
    public boolean borrow() {
        return state.borrow(this);
    }

    public boolean returnBook() {
        return state.returnBook(this);
    }

    public boolean reserve() {
        return state.reserve(this);
    }

    public boolean cancelReservation() {
        return state.cancelReservation(this);
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        result = prime * result + ((category == null) ? 0 : category.hashCode());
        result = prime * result + ((author == null) ? 0 : author.hashCode());
        result = prime * result + ((publishedDate == null) ? 0 : publishedDate.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Book other = (Book) obj;
        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        if (category == null) {
            if (other.category != null)
                return false;
        } else if (!category.equals(other.category))
            return false;
        if (author == null) {
            if (other.author != null)
                return false;
        } else if (!author.equals(other.author))
            return false;
        if (publishedDate == null) {
            if (other.publishedDate != null)
                return false;
        } else if (!publishedDate.equals(other.publishedDate))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return title + ",\n" +
            category + ",\n" +
            author + ",\n" +
            "published on " + publishedDate + ",\n" + 
            "Status: " + state.getState();
    }

    
}
