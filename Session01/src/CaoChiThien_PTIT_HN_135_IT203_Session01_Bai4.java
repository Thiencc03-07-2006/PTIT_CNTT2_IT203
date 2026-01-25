import java.util.Scanner;
public class CaoChiThien_PTIT_HN_135_IT203_Session01_Bai4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập giá sách (USD): ");
        double bookPriceUSD = input.nextDouble();
        System.out.print("Nhập tỷ giá USD -> VND: ");
        float exchangeRate = input.nextFloat();
        double totalVND = bookPriceUSD * exchangeRate;
        long roundedVND = (long) totalVND;
        System.out.println("Giá chính xác: " + totalVND + " VND");
        System.out.println("Giá làm tròn để thanh toán: " + roundedVND + " VND");
        input.close();
    }
}
