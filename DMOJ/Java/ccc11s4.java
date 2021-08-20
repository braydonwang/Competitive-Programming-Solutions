import java.io.*;
import java.util.*;

public class Main {
    static int[] blood;
    static int[] patients;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        blood = new int [8];
        patients = new int [8];
        for (int k = 0; k < 8; k++) {
            blood[k] = sc.nextInt();
        }
        for (int k = 0; k < 8; k++) {
            patients[k] = sc.nextInt();
        }
        int total = 0;
        total += dec(0,0);
        total += dec(1,1) + dec(0,1);
        total += dec(2,2) + dec(0,2);
        total += dec(4,4) + dec(0,4);
        total += dec(3,3) + dec(2,3);
        total += dec(5,5) + dec(4,5);
        total += dec(1,3) + dec(0,3);
        total += dec(1,5) + dec(0,5);
        total += dec(6,6) + dec(4,6) + dec(2,6) + dec(0,6);
        total += dec(7,7) + dec(6,7) + dec(5,7) + dec(4,7) + dec(3,7) + dec(2,7) + dec(1,7) + dec(0,7);

        System.out.println(total);
    }
    static int dec(int n,int m) {
        int min = Math.min(blood[n], patients[m]);
        blood[n] -= min;
        patients[m] -= min;
        return min;
    }
}
