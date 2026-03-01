package bai5;

class Patient {
    String name;
    int severity;
    int arrivalTime;   // phút tính từ 00:00

    public Patient(String name, int severity, int arrivalTime) {
        this.name = name;
        this.severity = severity;
        this.arrivalTime = arrivalTime;
    }

    @Override
    public String toString() {
        return name + " (Mức " + severity + ", đến lúc " + formatTime(arrivalTime) + ")";
    }

    private String formatTime(int minutes) {
        int hour = minutes / 60;
        int min = minutes % 60;
        return String.format("%02d:%02d", hour, min);
    }
}