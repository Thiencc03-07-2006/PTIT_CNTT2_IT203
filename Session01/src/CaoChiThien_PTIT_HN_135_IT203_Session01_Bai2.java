import java.util.Scanner;
public class CaoChiThien_PTIT_HN_135_IT203_Session01_Bai2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập số ngày chậm trễ: ");
        int n = input.nextInt();
        System.out.print("Nhập số lượng sách mượn: ");
        int m = input.nextInt();
        double total = n * m * 5000;
        System.out.println("Tiền phạt gốc: " + total + " VND");
        if (n > 7 && m >= 3) {
            total = total * 1.2;
        }
        System.out.println("Tiền phạt sau điều chỉnh: " + total + " VND");
        System.out.println("Yêu cầu khóa thẻ: " + (total > 50000));
        input.close();
    }
}
