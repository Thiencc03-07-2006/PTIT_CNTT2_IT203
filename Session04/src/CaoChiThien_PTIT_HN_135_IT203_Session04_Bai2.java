public class CaoChiThien_PTIT_HN_135_IT203_Session04_Bai2 {
    public static void main(String[] args) {
        String description = "Sách giáo khoa Toán lớp 12, Kệ: A1-102, tình trạng mới";
        int start = description.indexOf("Kệ:") + 4;
        int end = description.indexOf(",", start);
        String position = description.substring(start, end).trim();
        System.out.printf("Vị trí tìm thấy: %s\n", position);
        description = description.replace("Kệ:", "Vị trí lưu trữ:");
        System.out.printf("Mô tả mới: %s", description);
    }
}
