import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++){
            long x = sc.nextLong();
            if ((x & (x-1)) == 0){
                System.out.println("T");
            } else {
                System.out.println("F");
            }
        }
    }
}
