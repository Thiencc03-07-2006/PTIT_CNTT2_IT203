
public class Archer extends GameCharacter {
    private int criticalRate;

    public Archer(String name, int hp, int attackPower, int armor, int criticalRate) {
        super(name, "Xa thu", hp, attackPower, armor);
        this.criticalRate = criticalRate;
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
        boolean isCritical = (int)(Math.random() * 100) < criticalRate;

        if (isCritical) {
            damage *= 2;
            System.out.println(name + " ban CHI MANG vao " + target.getName() + "!");
        } else {
            System.out.println(name + " ban ten vao " + target.getName() + "!");
        }

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

        System.out.println(name + " dung MUA DAN BAC len " + target.getName() + "!");

        for (int i = 1; i <= 3; i++) {
            if (!target.isAlive()) {
                System.out.println("   -> Muc tieu da chet sau phat thu " + i);
                break;
            }

            int damage = (int)(attackPower * 1.5 * damageMultiplier);
            System.out.print("   Phat " + i + ": ");
            target.takeDamage(damage);
        }

        // Đặt cooldown sau khi dùng ultimate
        setUltimateCooldown();
    }
}