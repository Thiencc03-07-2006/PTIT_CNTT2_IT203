package CaoChiThien_PTIT_HN_135_IT203_Session07_Bai6;

import java.util.ArrayList;

public class UserManager {

    public static ArrayList<User> users = new ArrayList<>();

    public static void addUser(User u) {
        users.add(u);
    }

    public static boolean checkLogin(String username, String password) {
        for (User u : users) {
            if (u.username.equals(username) &&
                    u.password.equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static void showUsers() {
        System.out.println("Danh sách hiện tại:");
        for (int i = 0; i < users.size(); i++) {
            System.out.println((i + 1) + ". " + users.get(i));
        }
    }
}
