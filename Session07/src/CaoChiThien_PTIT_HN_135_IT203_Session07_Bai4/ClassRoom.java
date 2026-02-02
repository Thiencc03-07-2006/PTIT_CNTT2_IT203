package CaoChiThien_PTIT_HN_135_IT203_Session07_Bai4;

public class ClassRoom {
    static double classFund = 0;
    String studentName;

    public ClassRoom(String studentName) {
        this.studentName = studentName;
    }

    public void contribute(double amount) {
        if (amount > 0) {
            classFund += amount;
            System.out.println(studentName + " đã đóng: " + amount);
        } else {
            System.out.println("Số tiền không hợp lệ!");
        }
    }

    public static void showClassFund() {
        System.out.println("Tổng quỹ lớp hiện tại: " + classFund);
    }
}
