import java.util.Scanner;

public class CaoChiThien_PTIT_HN_135_IT203_Session02_Bai4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int id;
        do {
            System.out.print("Nhập mã ID sách: ");
            id = sc.nextInt();
            if (id <= 0) {
                System.out.println("Mã không hợp lệ, hãy nhập lại");
            }
        } while (id <= 0);
        System.out.println("Lưu mã sách thành công");
        sc.close();
    }
}
