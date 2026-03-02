package bai4;

public class Main {
    public static void main(String[] args) {
        EmergencyQueue eq = new EmergencyQueue();
        eq.addPatient(new EmergencyPatient("E01", "Nguyen Van A", 2));
        eq.addPatient(new EmergencyPatient("E02", "Tran Thi B", 1));
        eq.addPatient(new EmergencyPatient("E03", "Le Van C", 2));
        eq.addPatient(new EmergencyPatient("E04", "Pham Thi D", 1));
        System.out.println();
        eq.displayQueue();
        System.out.println("\nThứ tự được khám:");
        while (true) {
            EmergencyPatient p = eq.callNextPatient();
            if (p == null) break;
            System.out.println("Đang khám: " + p.getName());
        }
    }
}