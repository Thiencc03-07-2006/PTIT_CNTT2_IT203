import java.time.LocalDateTime;

public class CaoChiThien_PTIT_HN_135_IT203_Session04_Bai3 {
    public static void main(String[] args) {
        String[] transactions = {"BK001-20/01", "BK005-21/01", "BK099-22/01"};
        StringBuilder log = new StringBuilder();

        log.append("Báo cáo\n");
        log.append("Ngày tạo: ")
                .append(LocalDateTime.now())
                .append("\n");
        for (String t : transactions) {
            log.append("Giao dịch: ").append(t).append("\n");
        }
        System.out.println(log.toString());
    }
}
