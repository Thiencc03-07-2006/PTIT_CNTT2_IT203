import java.util.Scanner;

public class CaoChiThien_PTIT_HN_135_IT203_Session03_Bai5 {
    public static int deleteBook(int[] arr, int n, int bookId) {
        int index = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] == bookId) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("Không tìm thấy mã sách");
            return n;
        }
        for (int i = index; i < n - 1; i++) {
            arr[i] = arr[i + 1];
        }
        System.out.println("Đã xóa sách mã: " + bookId);
        return n - 1;
    }

    public static void displayBooks(int[] arr, int n) {
        System.out.printf("Kho sách hiện tại (%d cuốn): [ ", n);
        for (int i = 0; i < n; i++) {
            System.out.printf("%d ", arr[i]);
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] books = {101, 102, 103, 104, 105};
        int n = books.length;
        while (n > 0) {
            displayBooks(books, n);
            System.out.print("Nhập mã sách cần xóa (0 để thoát): ");
            int bookId = sc.nextInt();
            if (bookId == 0) {
                break;
            }
            n = deleteBook(books, n, bookId);
        }
    }
}
