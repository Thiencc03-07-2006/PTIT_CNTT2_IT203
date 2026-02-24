
public class Warrior extends GameCharacter {

    public Warrior(String name, int hp, int attackPower, int armor) {
        super(name, "Chien binh", hp, attackPower, armor);
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

        int damage = (int)(attackPower * damageMultiplier);
        System.out.println(name + " chem manh vao " + target.getName() + "!");
        target.takeDamage(damage);
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

        System.out.println(name + " dung BÃO TAP len " + target.getName() + "!");
        int damage = (int)(attackPower * 2 * damageMultiplier);
        target.takeDamage(damage);

        int selfDamage = (int)(this.hp * 0.1);
        if (selfDamage <= 0) selfDamage = 1;

        this.hp -= selfDamage;
        System.out.println("   -> " + name + " tu mat " + selfDamage + " HP vi phan chuan. HP con: " + hp + "/" + maxHp);

        // Đặt cooldown sau khi dùng ultimate
        setUltimateCooldown();

        if (this.hp <= 0) {
            this.hp = 0;
            this.isAlive = false;
            System.out.println("   [!] " + name + " DA BI HA GUC DO PHAN CHAN TU ULTIMATE!");
        }
    }
}