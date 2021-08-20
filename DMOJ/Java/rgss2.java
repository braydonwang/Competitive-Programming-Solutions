import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
		int n = sc.nextInt();
		int[] x = new int[n];
		int[] y = new int[n];
		for (int i = 0; i < n; i++) {
			x[i] = sc.nextInt();
			y[i] = sc.nextInt();
		}
		Arrays.sort(x);
		Arrays.sort(y);
		
		int a = x[x.length-1] - x[0];
		int b = y[y.length-1] - y[0];
		System.out.println(a*b);
    }
}
