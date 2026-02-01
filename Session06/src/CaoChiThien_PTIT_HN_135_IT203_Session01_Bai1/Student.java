package CaoChiThien_PTIT_HN_135_IT203_Session01_Bai1;

public class Student {
    String studentId;
    String fullName;
    int yearOfBirth;
    double avgPoint;

    public Student(String studentId, String fullName, int yearOfBirth, double avgPoint) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.yearOfBirth = yearOfBirth;
        this.avgPoint = avgPoint;
    }

    public void showInfo() {
        System.out.println("MSSV: " + studentId);
        System.out.println("Họ tên: " + fullName);
        System.out.println("Ngày sinh: " + yearOfBirth);
        System.out.println("Điểm TB: " + avgPoint);
    }

}
