import java.util.Scanner;
public class CaoChiThien_PTIT_HN_135_IT203_Session01_Bai1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("--- NHẬP THÔNG TIN SÁCH ---");
        System.out.print("Nhập mã sách: ");
        String bookID = input.nextLine();
        System.out.print("Nhập tên sách: ");
        String bookName = input.nextLine();
        System.out.print("Nhập năm xuất bản: ");
        int publishYear = input.nextInt();
        System.out.print("Nhập giá bìa: ");
        double price = input.nextDouble();
        System.out.print("Sách còn trong kho (true/false): ");
        boolean isAvailable = input.nextBoolean();
        int bookAge = 2026 - publishYear;
        System.out.println("\n--- PHIẾU THÔNG TIN SÁCH ---");
        System.out.println("Mã số: " + bookID);
        System.out.println("Tên sách: " + bookName.toUpperCase());
        System.out.println("Mã số: " + bookID+" | Tuổi thọ: " + bookAge + " năm");
        System.out.printf("Giá bán: %.2f VNĐ\n", price);
        System.out.println("Tình trạng: " + (isAvailable ? "Còn sách" : "Đã mượn"));
        input.close();
    }
}
