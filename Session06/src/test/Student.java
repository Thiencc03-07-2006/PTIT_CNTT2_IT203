package test;

import java.time.LocalDateTime;

public class Student {
    String studentId;
    String fullName;
    LocalDateTime createAt;
    String email;
    String phoneNumber;

    public Student(String studentId, String fullName, LocalDateTime createAt, String email, String phoneNumber) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.createAt = createAt;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public void showInfo() {
        System.out.printf("%s %s %s %s %s\n",studentId,fullName, createAt,email,phoneNumber);
    }
}
