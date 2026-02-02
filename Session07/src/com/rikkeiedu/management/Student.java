package com.rikkeiedu.management;
/*
Đề bài: Xây dựng chương trình Quản lý Học sinh
Yêu cầu kiến thức:
    Package: Tổ chức code trong package có tên com.rikkeiedu.management.
    Static: Sử dụng biến static để tạo cơ chế ID tự tăng (auto-increment) cho mỗi học sinh mới và tính toán thống kê.
    Final: Sử dụng từ khóa final để đảm bảo ID của học sinh không thể bị thay đổi sau khi khởi tạo, và định nghĩa tên trường học là hằng số.
Yêu cầu chức năng: Tạo class Student với các thuộc tính:
    id: Số nguyên, tự động tăng (ví dụ: học sinh 1 là ID 1, học sinh 2 là ID 2...), không được phép thay đổi.
    fullName: Họ tên.
    score: Điểm số.
    className: Tên lớp.
Viết chương trình Menu thực hiện:
    Thêm mới học sinh: Nhập thông tin và lưu vào danh sách.
    Hiển thị danh sách: In ra thông tin tất cả học sinh (bao gồm cả ID tự tăng).
    Tính điểm trung bình: Tính và hiển thị điểm trung bình của toàn bộ học sinh trong danh sách.
 */
public class Student {
    final int id;
    String fullName;
    double score;
    String className;
    static int currId =1;

    public Student(String fullName, double score, String className) {
        this.id = currId++;
        this.fullName = fullName;
        this.score = score;
        this.className = className;
    }

    public double getScore() {
        return score;
    }

    public void display() {
        System.out.printf("ID: %-3d | Name: %-20s | Score: %-3.2f | Class: %-20s\n",id,fullName,score,className);
    }
}
