package bai5;

import java.util.Comparator;
import java.util.TreeSet;

public class TriageSystem {
    public static void main(String[] args) {
        Comparator<Patient> triageComparator = (p1, p2) -> {
            if (p1.severity != p2.severity) {
                return Integer.compare(p1.severity, p2.severity);
            }
            if (p1.arrivalTime != p2.arrivalTime) {
                return Integer.compare(p1.arrivalTime, p2.arrivalTime);
            }
            return p1.name.compareTo(p2.name);
        };
        TreeSet<Patient> emergencyQueue = new TreeSet<>(triageComparator);
        emergencyQueue.add(new Patient("Bệnh nhân A", 3, 480)); // 8:00
        emergencyQueue.add(new Patient("Bệnh nhân B", 1, 495)); // 8:15
        emergencyQueue.add(new Patient("Bệnh nhân C", 1, 485)); // 8:05
        System.out.println("Thứ tự xử lý cấp cứu:");
        for (Patient p : emergencyQueue) {
            System.out.println(p);
        }
    }
}