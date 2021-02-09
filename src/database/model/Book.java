package database.model;

public class Book {
  private String bookId;
  private String name;
  private int price;
  private boolean available;
  private String author;

  public Book(String bookId, String name, int price, boolean available, String author) {
    this.bookId = bookId;
    this.name = name;
    this.price = price;
    this.available = available;
    this.author = author;
  }

  public String getBookId() {
    return bookId;
  }

  public String getName() {
    return name;
  }

  public int getPrice() {
    return price;
  }

  public boolean isAvailable() {
    return available;
  }

  public String getAuthor() {
    return author;
  }

  @Override
  public String toString() {
    return "Book{" +
            "bookId='" + bookId + '\'' +
            ", name='" + name + '\'' +
            ", price=" + price +
            ", available=" + available +
            ", author='" + author + '\'' +
            '}';
  }

  public void setBookId(String bookId) {
    this.bookId = bookId;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public void setAvailable(boolean available) {
    this.available = available;
  }

  public void setAuthor(String author) {
    this.author = author;
  }
}
