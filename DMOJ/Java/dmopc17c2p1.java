import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();
        long total = 0;
        for (int i = 0; i < n; i++){
            int c = sc.nextInt(), v = sc.nextInt();
            if (v > 0){
                total += c;
            }
        }
        System.out.println(total);
    }
}
