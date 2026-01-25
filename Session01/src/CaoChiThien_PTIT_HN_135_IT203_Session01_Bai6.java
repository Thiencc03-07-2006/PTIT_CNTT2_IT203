import java.util.Scanner;
public class CaoChiThien_PTIT_HN_135_IT203_Session01_Bai6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập số thứ tự của cuốn sách trong hệ thống: ");
        int stt = input.nextInt();
        int keSo = (stt - 1) / 25 + 1;
        int viTri = (stt - 1) % 25 + 1;
        String khuVuc = (keSo <= 10) ? "Khu Cận" : "Khu Viễn";
        System.out.println("--- THÔNG TIN ĐỊNH VỊ ---" + khuVuc);
        System.out.println("Địa chỉ: Kệ " + keSo + " - Vị trí " + viTri);
        System.out.println("Phân khu: " + khuVuc);
        input.close();
    }
}
