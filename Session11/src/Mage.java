
public class Mage extends GameCharacter {
    private int mana;
    private int maxMana;

    public Mage(String name, int hp, int attackPower, int armor, int mana) {
        super(name, "Phap su", hp, attackPower, armor);
        this.mana = mana;
        this.maxMana = mana;
    }

    public int getMana() {
        return mana;
    }

    public void regenMana() {
        mana += 10;
        if (mana > maxMana) {
            mana = maxMana;
        }
        System.out.println("   [+] " + name + " hoi 10 mana. Mana: " + mana + "/" + maxMana);
    }

    @Override
    public void attack(GameCharacter target) {
        if (!isAlive) {
            System.out.println(name + " da chet, khong the tan cong!");
            return;
        }

        if (!target.isAlive()) {
            System.out.println("Muc tieu " + target.getName() + " da chet, khong the tan cong!");
            return;
        }

        if (mana >= 10) {
            int damage = (int)(attackPower * damageMultiplier);
            System.out.println(name + " ban tia set vao " + target.getName() + "!");
            target.takeDamage(damage);
            mana -= 10;
            System.out.println("   -> " + name + " ton 10 mana. Mana con: " + mana + "/" + maxMana);
        } else {
            int damage = (int)((attackPower / 2) * damageMultiplier);
            System.out.println(name + " het mana, danh thuong yeu ot vao " + target.getName() + "!");
            target.takeDamage(damage);
        }
    }

    @Override
    public void useUltimate(GameCharacter target) {
        if (!isAlive) {
            System.out.println(name + " da chet, khong the dung chieu cuoi!");
            return;
        }

        if (!target.isAlive()) {
            System.out.println("Muc tieu " + target.getName() + " da chet, khong the dung chieu cuoi!");
            return;
        }

        // Kiểm tra cooldown
        if (!canUseUltimate()) {
            System.out.println(name + " chua the dung chieu cuoi! Can doi " + currentCooldown + " luot nua.");
            return;
        }

        if (mana >= 50) {
            System.out.println(name + " dung TRUNG PHAT THIEN LOI len " + target.getName() + "!");
            int damage = (int)(attackPower * 3 * damageMultiplier);
            target.takeDamage(damage);
            mana -= 50;
            System.out.println("   -> " + name + " ton 50 mana. Mana con: " + mana + "/" + maxMana);

            // Đặt cooldown sau khi dùng ultimate
            setUltimateCooldown();
        } else {
            System.out.println(name + " khong du mana de dung chieu cuoi! Can 50, co " + mana);
        }
    }

    @Override
    public void displayInfo() {
        String status = isAlive ? "Dang song" : "Da chet";
        String cooldownStatus = (currentCooldown > 0) ? ("Con " + currentCooldown + " luot hoi") : "San sang";
        System.out.println(name + " [" + role + "] - HP: " + hp + "/" + maxHp + " | Sat thuong: " + attackPower + " | Giap: " + armor + " | Mana: " + mana + "/" + maxMana + " | Ulti: " + cooldownStatus + " | Trang thai: " + status + " | Vang: " + gold + " | He so: " + (int)(damageMultiplier * 100) + "%");
    }

    @Override
    public void displayShortInfo() {
        String cooldownMark = (currentCooldown > 0) ? (" (Ulti con " + currentCooldown + " luot)") : "";
        System.out.println("  " + name + " [" + role + "] - HP: " + hp + "/" + maxHp + " | Mana: " + mana + "/" + maxMana + cooldownMark);
    }
}