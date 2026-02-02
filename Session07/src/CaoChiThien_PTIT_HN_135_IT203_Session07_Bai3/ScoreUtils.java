package CaoChiThien_PTIT_HN_135_IT203_Session07_Bai3;

public class ScoreUtils {
    public static boolean checkPoint(double point) {
        return point >= 5;
    }

    public static double avgPoint(double... points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        double totalPoint = 0;
        for (int i = 0; i < points.length; i++) {
            totalPoint += points[i];
        }
        return totalPoint / points.length;
    }
}
