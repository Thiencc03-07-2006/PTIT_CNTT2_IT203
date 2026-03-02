package bai2;

public class Main {
    public static void main(String[] args) {
        PatientQueue patientQueue = new PatientQueue();
        patientQueue.addPatient(new Patient("P01", "Nguyen Van A", 30));
        patientQueue.addPatient(new Patient("P02", "Tran Thi B", 25));
        patientQueue.addPatient(new Patient("P03", "Le Van C", 40));
        System.out.println();
        patientQueue.displayQueue();
        System.out.println();
        System.out.println("Bệnh nhân sắp được khám: " + patientQueue.peekNextPatient());
        System.out.println();
        patientQueue.callNextPatient();
        System.out.println();
        patientQueue.displayQueue();
    }
}