package CaoChiThien_PTIT_HN_135_IT203_Session01_Bai5;

public class Book {
    private String bookId;
    private String title;
    private String author;
    private double price;

    public Book(String bookId, String title, String author, double price) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public void showInfo() {
        System.out.println("Mã sách: " + this.bookId);
        System.out.println("Tên sách: " + this.title);
        System.out.println("Tác giả: " + this.author);
        System.out.println("Giá: " + this.price);
        System.out.println("---------------------------");
    }
}

