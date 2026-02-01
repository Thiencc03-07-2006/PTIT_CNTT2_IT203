package CaoChiThien_PTIT_HN_135_IT203_Session01_Bai4;

public class Employee {
    private String employeeId;
    private String fullName;
    private double salary;

    public Employee() {
        this.employeeId = "UNKNOWN";
        this.fullName = "Chưa có tên";
        this.salary = 0;
    }

    public Employee(String employeeId, String fullName) {
        this.employeeId = employeeId;
        this.fullName = fullName;
        this.salary = 0;
    }

    public Employee(String employeeId, String fullName, double salary) {
        this.employeeId = employeeId;
        this.fullName = fullName;
        this.salary = salary;
    }

    public void showInfo() {
        System.out.println("Mã NV: " + employeeId);
        System.out.println("Họ tên: " + fullName);
        System.out.println("Lương: " + salary);
    }

}
