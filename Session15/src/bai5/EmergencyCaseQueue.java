package bai5;

import java.util.LinkedList;
import java.util.Queue;

public class EmergencyCaseQueue {

    private Queue<EmergencyCase> cases;

    public EmergencyCaseQueue() {
        cases = new LinkedList<>();
    }

    public void addCase(EmergencyCase c) {
        cases.offer(c);
        System.out.println("Tiếp nhận bệnh nhân: " + c.getPatient().getName());
    }

    public EmergencyCase getNextCase() {
        if (cases.isEmpty()) {
            System.out.println("Không còn ca cấp cứu.");
            return null;
        }
        EmergencyCase c = cases.poll();
        System.out.println("Đang xử lý: " + c.getPatient().getName());
        return c;
    }
}