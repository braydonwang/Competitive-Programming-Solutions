import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
		int n = sc.nextInt();
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum+= sc.nextInt();
		}
		int x = sc.nextInt();
		for (int i = 0; i < x; i++) {
			sum+= sc.nextInt();
			double a = Math.round((sum/(n+i+1.0))*1000.0)/1000.0;
			System.out.println(a);
		}
    }
}
