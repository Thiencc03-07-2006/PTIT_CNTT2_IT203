
public abstract class GameCharacter {
    protected String name;
    protected String role;
    protected int hp;
    protected int maxHp;
    protected int attackPower;
    protected int armor;
    protected boolean isAlive;
    protected int gold;
    protected int killCount;
    protected double damageMultiplier;

    // Thêm biến đếm lượt hồi chiêu cho ultimate
    protected int ultimateCooldown;
    protected int currentCooldown;

    public static int totalCharacters = 0;

    public GameCharacter(String name, String role, int hp, int attackPower, int armor) {
        this.name = name;
        this.role = role;
        this.hp = hp;
        this.maxHp = hp;
        this.attackPower = attackPower;
        this.armor = armor;
        this.isAlive = true;
        this.gold = 0;
        this.killCount = 0;
        this.damageMultiplier = 1.0;

        // Mặc định ultimate hồi 3 lượt
        this.ultimateCooldown = 3;
        this.currentCooldown = 0;

        totalCharacters++;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public int getHp() {
        return hp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public int getGold() {
        return gold;
    }

    public void addGold(int amount) {
        this.gold += amount;
    }

    public int getKillCount() {
        return killCount;
    }

    public double getDamageMultiplier() {
        return damageMultiplier;
    }

    public void increaseDamageMultiplier() {
        this.damageMultiplier += 0.05;
        System.out.println("   [+] " + name + " nhan 5% sat thuong vinh vien! (Tong: " + (int)(damageMultiplier * 100) + "%)");
    }

    // Getter cho cooldown
    public int getCurrentCooldown() {
        return currentCooldown;
    }

    // Kiểm tra có thể dùng ultimate không
    public boolean canUseUltimate() {
        return currentCooldown == 0;
    }

    // Giảm cooldown mỗi lượt
    public void reduceCooldown() {
        if (currentCooldown > 0) {
            currentCooldown--;
        }
    }

    // Đặt cooldown sau khi dùng ultimate
    protected void setUltimateCooldown() {
        this.currentCooldown = this.ultimateCooldown;
        System.out.println("   [Cooldown] " + name + " can doi " + ultimateCooldown + " luot de dung lai chieu cuoi.");
    }

    public abstract void attack(GameCharacter target);

    public abstract void useUltimate(GameCharacter target);

    public void takeDamage(int amount) {
        int actualDamage = amount - armor;
        if (actualDamage < 0) {
            actualDamage = 0;
        }

        this.hp -= actualDamage;
        System.out.println("   -> " + name + " nhan " + actualDamage + " sat thuong. HP: " + hp + "/" + maxHp);

        if (this.hp <= 0) {
            this.hp = 0;
            this.isAlive = false;
            System.out.println("   [!] " + name + " DA BI HA GUC!");
        }
    }

    public void displayInfo() {
        String status = isAlive ? "Dang song" : "Da chet";
        String cooldownStatus = (currentCooldown > 0) ? ("Con " + currentCooldown + " luot hoi") : "San sang";
        System.out.println(name + " [" + role + "] - HP: " + hp + "/" + maxHp + " | Sat thuong: " + attackPower + " | Giap: " + armor + " | Ulti: " + cooldownStatus + " | Trang thai: " + status + " | Vang: " + gold + " | He so: " + (int)(damageMultiplier * 100) + "%");
    }

    public void displayShortInfo() {
        String cooldownMark = (currentCooldown > 0) ? (" (Ulti con " + currentCooldown + " luot)") : "";
        System.out.println("  " + name + " [" + role + "] - HP: " + hp + "/" + maxHp + cooldownMark);
    }
}