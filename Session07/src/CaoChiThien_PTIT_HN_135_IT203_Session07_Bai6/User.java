package CaoChiThien_PTIT_HN_135_IT203_Session07_Bai6;

public class User {

    public final int id;
    public String username;
    public String password;

    public User(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User[id=" + id + ", name=" + username + "]";
    }
}

