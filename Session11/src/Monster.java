
import java.util.Random;

public class Monster extends GameCharacter {
    private int level;
    private String monsterType;
    private int goldValue;
    private Random random;

    public Monster(String name, int level) {
        super(name, "Quai vat", 0, 0, 0);
        this.level = level;
        this.random = new Random();
        initMonsterByLevel();
    }

    private void initMonsterByLevel() {
        switch(level) {
            case 1: // Goblin
                this.monsterType = "Goblin";
                this.maxHp = 100;
                this.hp = 100;
                this.attackPower = 10;
                this.armor = 0;
                this.goldValue = 50;
                // Goblin ultimate hồi 2 lượt
                this.ultimateCooldown = 2;
                break;
            case 2: // Ork
                this.monsterType = "Ork";
                this.maxHp = 500;
                this.hp = 500;
                this.attackPower = 25;
                this.armor = 30;
                this.goldValue = 100;
                // Ork ultimate hồi 3 lượt
                this.ultimateCooldown = 3;
                break;
            case 3: // Vampire
                this.monsterType = "Vampire";
                this.maxHp = 800;
                this.hp = 800;
                this.attackPower = 40;
                this.armor = 20;
                this.goldValue = 200;
                // Vampire ultimate hồi 4 lượt
                this.ultimateCooldown = 4;
                break;
            case 4: // Goblin King (Mini Boss)
                this.monsterType = "Goblin Vua";
                this.maxHp = 1500;
                this.hp = 1500;
                this.attackPower = 50;
                this.armor = 40;
                this.goldValue = 500;
                this.ultimateCooldown = 3;
                break;
            case 5: // Fire Dragon (Boss)
                this.monsterType = "Rong Lua";
                this.maxHp = 3000;
                this.hp = 3000;
                this.attackPower = 100;
                this.armor = 100;
                this.goldValue = 1000;
                this.ultimateCooldown = 2;
                break;
        }
    }

    public int getLevel() {
        return level;
    }

    public String getMonsterType() {
        return monsterType;
    }

    public int getGoldValue() {
        return goldValue;
    }

    @Override
    public void attack(GameCharacter target) {
        if (!isAlive) {
            return;
        }

        if (!target.isAlive()) {
            return;
        }

        // Thỉnh thoảng quái dùng ultimate nếu có thể
        if (canUseUltimate() && random.nextInt(100) < 30) { // 30% tỷ lệ dùng ulti
            useUltimate(target);
            return;
        }

        String[] attacks = {"can xe", "vo lay", "quat duoi", "phun axit", "hat tung"};
        String attackName = attacks[random.nextInt(attacks.length)];

        System.out.println(monsterType + " " + name + " " + attackName + " " + target.getName() + "!");

        if (monsterType.equals("Vampire")) {
            int damage = attackPower;
            target.takeDamage(damage);
            int healAmount = damage * 20 / 100;
            this.hp += healAmount;
            if (this.hp > maxHp) {
                this.hp = maxHp;
            }
            System.out.println("   -> Vampire hut " + healAmount + " mau. HP hien tai: " + hp + "/" + maxHp);
        } else {
            target.takeDamage(attackPower);
        }

        if (monsterType.equals("Goblin") && target.isAlive()) {
            int stealGold = 5;
            if (target.gold >= stealGold) {
                target.addGold(-stealGold);
                this.gold += stealGold;
                System.out.println("   -> Goblin an cap 5 vang cua " + target.getName() + "!");
            }
        }
    }

    @Override
    public void useUltimate(GameCharacter target) {
        if (!canUseUltimate()) return;

        System.out.println(monsterType + " " + name + " dung ULTIMATE!");

        if (monsterType.equals("Goblin")) {
            System.out.println("   -> Goblin dao tham! Gay 30 sat thuong va an cap 10 vang!");
            target.takeDamage(30);
            if (target.isAlive() && target.gold >= 10) {
                target.addGold(-10);
                this.gold += 10;
            }
        } else if (monsterType.equals("Ork")) {
            System.out.println("   -> Ork cuong no! Gay 50 sat thuong va tu mat 20 HP!");
            target.takeDamage(50);
            this.hp -= 20;
            if (this.hp < 0) this.hp = 0;
            System.out.println("   -> Ork mat 20 HP. HP con: " + hp + "/" + maxHp);
        } else if (monsterType.equals("Vampire")) {
            System.out.println("   -> Vampire hoa than doi! Gay 60 sat thuong va hut 30 mau!");
            target.takeDamage(60);
            this.hp += 30;
            if (this.hp > maxHp) this.hp = maxHp;
            System.out.println("   -> Vampire hoi 30 HP. HP con: " + hp + "/" + maxHp);
        } else {
            attack(target);
        }

        setUltimateCooldown();
    }

    @Override
    public void takeDamage(int amount) {
        super.takeDamage(amount);

        if (monsterType.equals("Goblin Vua") && isAlive && (hp <= maxHp / 2)) {
            System.out.println("   -> Goblin Vua trieu hoi Goblin con!");
        }
    }

    @Override
    public void displayInfo() {
        String status = isAlive ? "Dang song" : "Da chet";
        String cooldownStatus = (currentCooldown > 0) ? ("Con " + currentCooldown + " luot hoi") : "San sang";
        System.out.println(name + " [" + monsterType + " cap " + level + "] - HP: " + hp + "/" + maxHp + " | Sat thuong: " + attackPower + " | Giap: " + armor + " | Ulti: " + cooldownStatus + " | Trang thai: " + status + " | Vang: " + goldValue);
    }

    @Override
    public void displayShortInfo() {
        String cooldownMark = (currentCooldown > 0) ? (" (Ulti con " + currentCooldown + " luot)") : "";
        System.out.println("  " + name + " [" + monsterType + " cap " + level + "] - HP: " + hp + "/" + maxHp + cooldownMark);
    }
}