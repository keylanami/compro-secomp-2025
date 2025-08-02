// INI SOAL E

import java.util.Scanner;

public class Jiwa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int v1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();
        int v2 = sc.nextInt();
        int x3 = sc.nextInt();
        int y3 = sc.nextInt();
        
        double dManusia = Math.hypot(x3 - x1, y3 - y1);
        double dJiwa    = Math.hypot(x3 - x2, y3 - y2);
        
        double tManusia = dManusia / v1;
        double tJiwa    = dJiwa    / v2;
        
        double eps = 1e-9;
        if (Math.abs(tManusia - tJiwa) < eps) {
            System.out.println("Bersamaan");
        } else if (tManusia < tJiwa) {
            System.out.println("Manusia");
        } else {
            System.out.println("Jiwa");
        }
        
        sc.close();
    }
}