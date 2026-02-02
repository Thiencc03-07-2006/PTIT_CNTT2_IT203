import CaoChiThien_PTIT_HN_135_IT203_Session07_Bai1.Student;
import CaoChiThien_PTIT_HN_135_IT203_Session07_Bai3.ScoreUtils;
import CaoChiThien_PTIT_HN_135_IT203_Session07_Bai4.ClassRoom;
import CaoChiThien_PTIT_HN_135_IT203_Session07_Bai5.Config;
import CaoChiThien_PTIT_HN_135_IT203_Session07_Bai6.User;
import CaoChiThien_PTIT_HN_135_IT203_Session07_Bai6.UserManager;

public class Main {
    public static void main(String[] args) {
        //Bai1
        System.out.println("Bai1");
        Student.nowTotalStudents();
        Student stu1 = new Student("SV1", "Nguyen Van A");
        stu1.studentInfo();
        Student.nowTotalStudents();
        Student stu2 = new Student("SV2", "Nguyen Van B");
        stu2.nowTotalStudents();
        //Bai2
        System.out.println("Bai2");
        int a = 10;
        int b = a; //sao chep gia tri
        b = 20;
        System.out.println("Gia tri a:" + a);
        System.out.println("Gia tri b:" + b);
        Student stu3 = stu1; //sao chep dia chi
        stu3.setStudentName("Nguyen Van C");
        Student.nowTotalStudents();
        stu1.studentInfo();
        //Bai3
        System.out.println("Bai3");
        double point1 = 8;
        double point2 = 4;
        double point3 = 6;
        System.out.println("Diem 1: " + (ScoreUtils.checkPoint(point1) ? "Dat" : "Khong dat"));
        System.out.println("Diem 2: " + (ScoreUtils.checkPoint(point2) ? "Dat" : "Khong dat"));
        System.out.println("Diem trung binh: " + ScoreUtils.avgPoint(point1, point2, point3));
        //Bai4
        System.out.println("Bai4");
        ClassRoom s1 = new ClassRoom("An");
        ClassRoom s2 = new ClassRoom("Binh");
        s1.contribute(100_000);
        ClassRoom.showClassFund();
        s2.contribute(200_000);
        ClassRoom.showClassFund();
        //Bai5
        System.out.println("Bai5");
        int score1 = 8;
        checkScore(score1);
        int score2 = -1;
        checkScore(score2);
//        Config.MAX_SCORE = 20;
        //Bai6
        System.out.println("Bai6");
        User u1 = new User(1, "dev_a", "123456");
        User u2 = new User(2, "dev_b", "abcdef");
        User u3 = new User(3, "dev_c", "999999");
        UserManager.addUser(u1);
        UserManager.addUser(u2);
        UserManager.addUser(u3);
        UserManager.showUsers();
        System.out.println("Login (\"dev_a\", \"123456\"): " + (UserManager.checkLogin("dev_a", "123456") ? "Thành công!" : "Thất bại!"));
        System.out.println("Login (\"dev_b\", \"sai_pass\"): " +(UserManager.checkLogin("dev_b", "sai_pass") ? "Thành công!" : "Thất bại!"));
    }

    private static void checkScore(int score) {
        if (score >= Config.MIN_SCORE && score <= Config.MAX_SCORE) {
            System.out.println("Điểm hợp lệ");
        } else {
            System.out.println("Điểm không hợp lệ");
        }
    }
}