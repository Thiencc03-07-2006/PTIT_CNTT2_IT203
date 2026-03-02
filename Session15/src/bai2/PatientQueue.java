package bai2;

import java.util.LinkedList;
import java.util.Queue;

public class PatientQueue {

    private Queue<Patient> queue;

    public PatientQueue() {
        queue = new LinkedList<>();
    }

    public void addPatient(Patient p) {
        queue.offer(p);
        System.out.println("Đã thêm bệnh nhân: " + p.getName());
    }

    public Patient callNextPatient() {
        if (queue.isEmpty()) {
            System.out.println("Không có bệnh nhân nào trong hàng đợi.");
            return null;
        }
        Patient p = queue.poll();
        System.out.println("Đang khám bệnh nhân: " + p.getName());
        return p;
    }

    public Patient peekNextPatient() {
        if (queue.isEmpty()) {
            System.out.println("Hàng đợi trống.");
            return null;
        }
        return queue.peek();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public void displayQueue() {
        if (queue.isEmpty()) {
            System.out.println("Không có bệnh nhân đang chờ.");
            return;
        }
        System.out.println("Danh sách bệnh nhân đang chờ:");
        for (Patient p : queue) {
            System.out.println(p);
        }
    }
}