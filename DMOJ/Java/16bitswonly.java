import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++){
            long a = sc.nextLong(), b = sc.nextLong(), c = sc.nextLong();
            if (a * b == c){
                System.out.println("POSSIBLE DOUBLE SIGMA");
            } else {
                System.out.println("16 BIT S/W ONLY");
            }
        }
    }
}
