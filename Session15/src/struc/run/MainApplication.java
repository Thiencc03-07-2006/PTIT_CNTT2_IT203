package struc.run;

import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args) {
        run();
    }

    private static void run(){
        Scanner sc = new Scanner(System.in);
        ProductView.showProductMenu(sc);
        sc.close();
    }
}