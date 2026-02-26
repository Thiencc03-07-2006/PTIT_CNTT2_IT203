package bai4;

import java.util.LinkedList;

public class EmergencyRoom {

    private LinkedList<String> queue = new LinkedList<>();

    public void patientCheckIn(String name) {
        queue.addLast(name);
        System.out.println(name + " đã check-in (thường).");
    }

    public void emergencyCheckIn(String name) {
        queue.addFirst(name);
        System.out.println(name + " vào cấp cứu khẩn cấp!");
    }

    public void treatPatient() {
        if (queue.isEmpty()) {
            System.out.println("Không còn bệnh nhân.");
            return;
        }
        String name = queue.removeFirst();
        System.out.println("Đang khám: " + name);
    }

    public static void main(String[] args) {
        EmergencyRoom er = new EmergencyRoom();
        er.patientCheckIn("A");
        er.patientCheckIn("B");
        er.emergencyCheckIn("C");
        System.out.println("\n--- Bắt đầu điều trị ---");
        System.out.println("Đang cấp cứu: " + er.queue.removeFirst());
        er.treatPatient();
        er.treatPatient();
    }
}