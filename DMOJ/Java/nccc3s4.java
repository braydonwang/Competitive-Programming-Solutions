import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt(); int[] array = new int[n]; long sum = 0; int max = 0;
		for (int i = 0; i < n; i++) {
			array[i] = sc.nextInt();
			sum+= array[i];
			max = Math.max(max, array[i]);
		}
		if (sum % 2 == 0 && max <= sum - max) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
    }
}
