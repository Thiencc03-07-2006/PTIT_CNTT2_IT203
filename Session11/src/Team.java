
import java.util.ArrayList;
import java.util.List;

public class Team {
    private String teamName;
    private String teamType;
    private List<GameCharacter> members;
    private int totalGold;

    public Team(String teamName, String teamType) {
        this.teamName = teamName;
        this.teamType = teamType;
        this.members = new ArrayList<>();
        this.totalGold = 0;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getTeamType() {
        return teamType;
    }

    public List<GameCharacter> getMembers() {
        return members;
    }

    public List<GameCharacter> getAliveMembers() {
        List<GameCharacter> alive = new ArrayList<>();
        for (GameCharacter c : members) {
            if (c.isAlive()) {
                alive.add(c);
            }
        }
        return alive;
    }

    public void addMember(GameCharacter character) {
        members.add(character);
    }

    public void removeDeadMembers() {
        members.removeIf(c -> !c.isAlive());
    }

    public boolean isAllDead() {
        return getAliveMembers().isEmpty();
    }

    public int getAliveCount() {
        return getAliveMembers().size();
    }

    public void addTeamGold(int amount) {
        this.totalGold += amount;
    }

    public int getTotalGold() {
        return totalGold;
    }

    public void distributeGold(int amount) {
        int aliveCount = getAliveCount();
        if (aliveCount == 0) return;

        int eachShare = amount / aliveCount;
        for (GameCharacter c : getAliveMembers()) {
            c.addGold(eachShare);
        }
        System.out.println("   [Team] Nhan " + amount + " vang, chia " + eachShare + " vang cho moi thanh vien.");
    }

    public void displayTeamInfo() {
        System.out.println("\n=== " + teamType + " - " + teamName + " ===");
        System.out.println("So luong: " + getAliveCount() + "/" + members.size() + " | Tong vang: " + totalGold);
        for (int i = 0; i < members.size(); i++) {
            System.out.print((i+1) + ". ");
            members.get(i).displayShortInfo();
        }
    }
}