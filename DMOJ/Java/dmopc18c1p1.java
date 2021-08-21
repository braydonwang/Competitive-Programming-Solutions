import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt();
        int array [] = new int [n];
        int low = 1;
        for (int k = 0; k < n; k++) {
            array[k] = sc.nextInt();
            if (k > 0 && array[k] == 0 && array[k-1] != 0) low  = Math.max(low, array[k-1]);
        }
        boolean sorted = true;

        for (int i = 0; i <n; i++) {
            if (array[i] == 0) array[i] = low;
            if (i > 0 && array[i] < array[i-1]) {sorted = false; break;}
        }
        System.out.println(sorted? "YES" : "NO");
    }
}
