package bai5;

import bai2.Patient;

public class Main {

    public static void main(String[] args) {

        EmergencyCaseQueue queue = new EmergencyCaseQueue();

        Patient p1 = new Patient("P01", "Nguyen Van A", 30);
        Patient p2 = new Patient("P02", "Tran Thi B", 45);

        EmergencyCase case1 = new EmergencyCase(p1);
        EmergencyCase case2 = new EmergencyCase(p2);

        queue.addCase(case1);
        queue.addCase(case2);

        System.out.println();

        EmergencyCase current = queue.getNextCase();

        current.addStep(new TreatmentStep("Tiếp nhận", "08:00"));
        current.addStep(new TreatmentStep("Chẩn đoán ban đầu", "08:05"));
        current.addStep(new TreatmentStep("Tiêm thuốc", "08:10"));

        System.out.println();
        current.displaySteps();

        System.out.println();
        current.undoStep();

        System.out.println();
        current.displaySteps();
    }
}