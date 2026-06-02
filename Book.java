public class Book {
    String title;
    String category;
    String author;
    String publishedDate;
    public Book(String title, String category, String author, String publishedDate) {
        this.title = title;
        this.category = category;
        this.author = author;
        this.publishedDate = publishedDate;
    }
    
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getPublishedDate() {
        return publishedDate;
    }
    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    
}
