
import java.util.*;

public class ArenaOfHeroes {
    private Scanner scanner;
    private Team playerTeam;
    private Team enemyTeam;
    private Random random;
    private int round;
    private boolean gameRunning;

    public ArenaOfHeroes() {
        this.scanner = new Scanner(System.in);
        this.random = new Random();
        this.round = 1;
        this.gameRunning = true;
    }

    public void start() {
        showTitle();
        showMenu();
    }

    private void showTitle() {
        System.out.println("=========================================");
        System.out.println("    ARENA OF HEROES - DAU TRUONG HUYEN THOAI");
        System.out.println("=========================================");
        System.out.println();
    }

    private void showMenu() {
        while (true) {
            System.out.println("1. Bat dau tro choi moi");
            System.out.println("2. Huong dan choi");
            System.out.println("3. Thoat");
            System.out.print("\nChon (1-3): ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    setupGame();
                    runGame();
                    break;
                case "2":
                    showInstructions();
                    break;
                case "3":
                    System.out.println("Tam biet! Hen gap lai!");
                    return;
                default:
                    System.out.println("Lua chon khong hop le. Vui long chon lai.");
            }
        }
    }

    private void showInstructions() {
        System.out.println("\n=== HUONG DAN CHOI ===");
        System.out.println("1. MUC TIEU: Tieu diet toan bo quai vat.");
        System.out.println("2. LUOT CHOI:");
        System.out.println("   - Nguoi choi chon 1 tuong de tan cong.");
        System.out.println("   - Sau do tat ca quai vat con song se tan cong lai.");
        System.out.println("3. CO CHE 'DEN':");
        System.out.println("   - Quai vat se chon muc tieu ngau nhien.");
        System.out.println("   - Co the 3 quai cung danh 1 tuong -> tuong 'den'.");
        System.out.println("4. KHI GIET QUAI:");
        System.out.println("   - Nhan vang theo cap quai.");
        System.out.println("   - Tang 5% sat thuong vinh vien.");
        System.out.println("5. CHIEU CUOI (ULTIMATE):");
        System.out.println("   - Chien binh: Bao Tap (sat thuong gap doi, tu mat 10% HP).");
        System.out.println("   - Phap su: Trung phat thien loi (sat thuong gap ba, ton 50 mana).");
        System.out.println("   - Xa thu: Mua dan bac (ban 3 phat lien tiep).");
        System.out.println("6. COOLDOWN:");
        System.out.println("   - Sau khi dung chieu cuoi, phai doi 3 luot moi dung lai.");
        System.out.println("   - Hien thi thoi gian hoi ben canh ten tuong.");
        System.out.println("\nNhan Enter de tiep tuc...");
        scanner.nextLine();
    }

    private void setupGame() {
        System.out.println("\n=== KHOI TAO TRO CHOI ===");

        // Tao doi nguoi choi
        playerTeam = new Team("Anh Sang", "DOI ANH SANG");

        // Tao tuong mac dinh
        playerTeam.addMember(new Warrior("Yasuo", 450, 50, 20));
        playerTeam.addMember(new Mage("Veigar", 300, 50, 10, 200));
        playerTeam.addMember(new Archer("Bright", 350, 55, 12, 20));

        // Tao doi quai vat
        enemyTeam = new Team("Bong Toi", "DOI BONG TOI");

        // Tao quai vat mac dinh
        enemyTeam.addMember(new Monster("Goblin 1", 1));
        enemyTeam.addMember(new Monster("Ork 1", 2));
        enemyTeam.addMember(new Monster("Vampire 1", 3));

        System.out.println("Da khoi tao " + GameCharacter.totalCharacters + " nhan vat!");
        System.out.println("DOI ANH SANG: 3 tuong");
        System.out.println("DOI BONG TOI: 3 quai vat");
        System.out.println("\nNhan Enter de bat dau tran dau...");
        scanner.nextLine();
    }

    private void runGame() {
        while (gameRunning) {
            showBattleStatus();

            // Luot nguoi choi
            playerTurn();

            // Kiem tra dieu kien thang
            if (enemyTeam.isAllDead()) {
                gameVictory();
                break;
            }

            if (playerTeam.isAllDead()) {
                gameDefeat();
                break;
            }

            // Luot quai vat
            enemyTurn();

            // Kiem tra dieu kien thua
            if (playerTeam.isAllDead()) {
                gameDefeat();
                break;
            }

            // Giam cooldown cho tat ca tuong
            reduceAllCooldowns();

            // Hoi mana cho phap su
            regenManaForMages();

            round++;

            System.out.println("\nNhan Enter de tiep tuc...");
            scanner.nextLine();
        }
    }

    private void showBattleStatus() {
        System.out.println("\n=========================================");
        System.out.println("VONG " + round);
        System.out.println("=========================================");

        playerTeam.displayTeamInfo();
        enemyTeam.displayTeamInfo();
        System.out.println();
    }

    private void playerTurn() {
        System.out.println("\n=== LUOT CUA DOI ANH SANG ===");

        List<GameCharacter> alivePlayer = playerTeam.getAliveMembers();
        if (alivePlayer.isEmpty()) return;

        // Hien thi danh sach tuong con song
        System.out.println("Chon tuong de ra lenh:");
        for (int i = 0; i < alivePlayer.size(); i++) {
            GameCharacter c = alivePlayer.get(i);
            System.out.println((i+1) + ". " + c.getName() + " [" + c.getRole() + "] - HP: " + c.getHp() + "/" + c.getMaxHp());
        }

        // Chon tuong
        int heroChoice = -1;
        while (heroChoice < 1 || heroChoice > alivePlayer.size()) {
            System.out.print("Chon (1-" + alivePlayer.size() + "): ");
            try {
                heroChoice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so!");
            }
        }

        GameCharacter selectedHero = alivePlayer.get(heroChoice - 1);

        // Hien thi hanh dong
        System.out.println("\nChon " + selectedHero.getName() + ":");
        System.out.println("1. Tan cong thuong");

        // Hien thi trang thai ultimate
        if (selectedHero.canUseUltimate()) {
            System.out.println("2. Dung chieu cuoi (Ultimate) - SAN SANG");
        } else {
            System.out.println("2. Dung chieu cuoi (Ultimate) - CON " + selectedHero.getCurrentCooldown() + " LUOT HOI");
        }

        System.out.println("3. Xem thong tin chi tiet");
        System.out.println("4. Chon tuong khac");

        int actionChoice = -1;
        while (actionChoice < 1 || actionChoice > 4) {
            System.out.print("Chon (1-4): ");
            try {
                actionChoice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so!");
            }
        }

        if (actionChoice == 3) {
            selectedHero.displayInfo();
            System.out.println("\nNhan Enter de tiep tuc...");
            scanner.nextLine();
            playerTurn(); // Chon lai
            return;
        } else if (actionChoice == 4) {
            playerTurn(); // Chon lai tuong khac
            return;
        }

        // Neu chon ultimate ma chua san sang
        if (actionChoice == 2 && !selectedHero.canUseUltimate()) {
            System.out.println(selectedHero.getName() + " chua the dung chieu cuoi! Can doi " + selectedHero.getCurrentCooldown() + " luot nua.");
            System.out.println("Ban co the chon tan cong thuong hoac chon tuong khac.");
            playerTurn(); // Cho chon lai
            return;
        }

        // Chon muc tieu (quai vat)
        List<GameCharacter> aliveEnemy = enemyTeam.getAliveMembers();
        if (aliveEnemy.isEmpty()) return;

        System.out.println("\nChon muc tieu:");
        for (int i = 0; i < aliveEnemy.size(); i++) {
            GameCharacter e = aliveEnemy.get(i);
            System.out.println((i+1) + ". " + e.getName() + " [" + ((Monster)e).getMonsterType() + "] - HP: " + e.getHp() + "/" + e.getMaxHp());
        }

        int targetChoice = -1;
        while (targetChoice < 1 || targetChoice > aliveEnemy.size()) {
            System.out.print("Chon (1-" + aliveEnemy.size() + "): ");
            try {
                targetChoice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so!");
            }
        }

        GameCharacter target = aliveEnemy.get(targetChoice - 1);

        // Thuc hien hanh dong
        if (actionChoice == 1) {
            selectedHero.attack(target);
        } else if (actionChoice == 2) {
            selectedHero.useUltimate(target);
        }

        // Kiem tra neu quai chet
        if (!target.isAlive()) {
            handleMonsterDeath(target, selectedHero);
        }
    }

    private void enemyTurn() {
        System.out.println("\n=== LUOT CUA DOI BONG TOI ===");

        List<GameCharacter> aliveEnemy = enemyTeam.getAliveMembers();
        List<GameCharacter> alivePlayer = playerTeam.getAliveMembers();

        if (aliveEnemy.isEmpty() || alivePlayer.isEmpty()) return;

        System.out.println("Quai vat dang chon muc tieu (ngau nhien)...");

        // Moi quai vat chon muc tieu ngau nhien
        for (GameCharacter monster : aliveEnemy) {
            if (!monster.isAlive()) continue;
            if (alivePlayer.isEmpty()) break;

            // Chon ngau nhien 1 tuong con song
            int randomIndex = random.nextInt(alivePlayer.size());
            GameCharacter target = alivePlayer.get(randomIndex);

            System.out.print("> ");
            monster.attack(target);

            // Giam cooldown cho quai sau khi tan cong (moi luot giam 1)
            monster.reduceCooldown();

            // Kiem tra neu tuong chet
            if (!target.isAlive()) {
                System.out.println("   [!] " + target.getName() + " da chet!");
                alivePlayer = playerTeam.getAliveMembers(); // Cap nhat danh sach

                // Quai vat nhan vang khi giet tuong
                monster.addGold(100);
                System.out.println("   -> " + monster.getName() + " nhan 100 vang vi ha duoc tuong!");
            }

            if (alivePlayer.isEmpty()) break;
        }

        // Thong ke luot quai
        System.out.println("\nKet thuc luot quai vat:");
        for (GameCharacter c : playerTeam.getMembers()) {
            if (c.isAlive()) {
                System.out.println("  " + c.getName() + " con " + c.getHp() + "/" + c.getMaxHp() + " HP");
            }
        }
    }

    private void handleMonsterDeath(GameCharacter monster, GameCharacter killer) {
        Monster deadMonster = (Monster) monster;
        int goldValue = deadMonster.getGoldValue();

        System.out.println("\n=== " + deadMonster.getName() + " BI HA GUC ===");

        // Nguoi giet nhan vang ca nhan
        killer.addGold(goldValue);
        killer.increaseDamageMultiplier();
        System.out.println("  " + killer.getName() + " nhan " + goldValue + " vang ca nhan.");

        // Team nhan them vang
        int teamGold = goldValue * 40 / 100; // 40% gia tri quai
        playerTeam.addTeamGold(teamGold);
        playerTeam.distributeGold(teamGold);

        // Xoa quai khoi team
        enemyTeam.removeDeadMembers();

        System.out.println("  Con " + enemyTeam.getAliveCount() + " quai vat.");
    }

    private void reduceAllCooldowns() {
        for (GameCharacter c : playerTeam.getMembers()) {
            if (c.isAlive()) {
                c.reduceCooldown();
            }
        }

        for (GameCharacter c : enemyTeam.getMembers()) {
            if (c.isAlive()) {
                c.reduceCooldown();
            }
        }
    }

    private void regenManaForMages() {
        for (GameCharacter c : playerTeam.getMembers()) {
            if (c instanceof Mage && c.isAlive()) {
                ((Mage)c).regenMana();
            }
        }
    }

    private void gameVictory() {
        System.out.println("\n=========================================");
        System.out.println("CHIEN THANG! DOI ANH SANG CHIEN THANG!");
        System.out.println("=========================================");

        System.out.println("\nTHONG KE TRAN DAU:");
        System.out.println("- So vong: " + round);
        System.out.println("- Tuong con song: " + playerTeam.getAliveCount() + "/" + playerTeam.getMembers().size());

        int totalKills = 0;
        int totalGold = 0;

        for (GameCharacter c : playerTeam.getMembers()) {
            totalKills += c.getKillCount();
            totalGold += c.getGold();
        }

        System.out.println("- Tong so quai da diet: " + totalKills);
        System.out.println("- Tong vang nhan duoc: " + totalGold);

        System.out.println("\nTHONG SO TUONG CUOI CUNG:");
        for (GameCharacter c : playerTeam.getMembers()) {
            c.displayInfo();
        }

        System.out.println("\n1. Choi lai");
        System.out.println("2. Ve man hinh chinh");
        System.out.println("3. Thoat game");
        System.out.print("Chon: ");

        String choice = scanner.nextLine();
        if (choice.equals("1")) {
            GameCharacter.totalCharacters = 0;
            setupGame();
            runGame();
        } else if (choice.equals("2")) {
            gameRunning = false;
            GameCharacter.totalCharacters = 0;
            showMenu();
        } else {
            System.out.println("Tam biet!");
            System.exit(0);
        }
    }

    private void gameDefeat() {
        System.out.println("\n=========================================");
        System.out.println("THAT BAI! DOI ANH SANG DA BI TIEU DIET!");
        System.out.println("=========================================");

        System.out.println("\nTHONG KE TRAN DAU:");
        System.out.println("- So vong: " + round);

        int totalKills = 0;
        for (GameCharacter c : playerTeam.getMembers()) {
            if (!c.isAlive()) {
                totalKills += c.getKillCount();
            }
        }

        System.out.println("- So quai da diet: " + totalKills);

        System.out.println("\n1. Choi lai");
        System.out.println("2. Ve man hinh chinh");
        System.out.println("3. Thoat game");
        System.out.print("Chon: ");

        String choice = scanner.nextLine();
        if (choice.equals("1")) {
            GameCharacter.totalCharacters = 0;
            setupGame();
            runGame();
        } else if (choice.equals("2")) {
            gameRunning = false;
            GameCharacter.totalCharacters = 0;
            showMenu();
        } else {
            System.out.println("Tam biet!");
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        ArenaOfHeroes game = new ArenaOfHeroes();
        game.start();
    }
}