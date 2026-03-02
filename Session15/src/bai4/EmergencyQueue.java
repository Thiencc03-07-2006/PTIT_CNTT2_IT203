package bai4;

import java.util.PriorityQueue;
import java.util.Comparator;

public class EmergencyQueue {

    private PriorityQueue<EmergencyPatient> queue;
    private long sequenceNumber = 0; // đánh số thứ tự đến

    public EmergencyQueue() {
        queue = new PriorityQueue<>(new Comparator<EmergencyPatient>() {
            @Override
            public int compare(EmergencyPatient p1, EmergencyPatient p2) {
                if (p1.getPriority() != p2.getPriority()) {
                    return Integer.compare(p1.getPriority(), p2.getPriority());
                }
                return Long.compare(p1.getArrivalOrder(), p2.getArrivalOrder());
            }
        });
    }

    public void addPatient(EmergencyPatient p) {
        p.setArrivalOrder(sequenceNumber++);
        queue.offer(p);
        System.out.println("Đã thêm: " + p.getName());
    }

    public EmergencyPatient callNextPatient() {
        if (queue.isEmpty()) {
            return null;
        }
        EmergencyPatient p = queue.poll();
        return p;
    }

    public void displayQueue() {
        if (queue.isEmpty()) {
            System.out.println("Danh sách trống.");
            return;
        }

        System.out.println("Danh sách bệnh nhân đang chờ:");
        for (EmergencyPatient p : queue) {
            System.out.println(p);
        }
    }
}