import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        if (str.indexOf("CCC") != -1){
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }
}
