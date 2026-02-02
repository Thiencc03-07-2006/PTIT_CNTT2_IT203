package CaoChiThien_PTIT_HN_135_IT203_Session07_Bai1;

public class Student {
    String studentId;
    String studentName;
    static int totalStudent = 0;

    public Student(String studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
        totalStudent++;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void studentInfo() {
        System.out.println("MSV: " + this.studentId);
        System.out.println("Tên sinh viên: " + this.studentName);
    }

    public static void nowTotalStudents() {
        System.out.println("Tổng số sinh viên đã tạo: " + totalStudent);
    }
}
