import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
		int n = sc.nextInt();
		long sum = 0;
		long[] array = new long[n];
		for (int i = 0; i < n; i++) {
			array[i] = sc.nextLong();
			sum+= array[i];
		}
		if (sum % n == 0) {
			long count = 0;
			for (int i = 0; i < n; i++) {
				count+= Math.abs(sum/n - array[i]);
			}
			System.out.println(count/2);
		}
		else {
			System.out.println("Impossible");
		}
    }
}
