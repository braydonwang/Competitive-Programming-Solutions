import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int w = sc.nextInt();
        int h = sc.nextInt();
        int s = sc.nextInt();
        int num = (w/s) * (h/s);
        System.out.println(num);
    }
}
