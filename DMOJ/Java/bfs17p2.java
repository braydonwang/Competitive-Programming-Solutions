import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
		int n = sc.nextInt();
		sc.nextLine();
		String str = sc.nextLine();
		String[] a = str.split(" ");
		int max = 0;
		Map<String, Integer> map = new HashMap();
		for (int i = 0; i < n; i++) {
			map.put(a[i], map.getOrDefault(a[i], 0)+1);
			max = Math.max(max, map.get(a[i]));
		}
		int other = n - max;
		if (max > other + 1) {
			System.out.println(other + other + 1);
		}
		else {
			System.out.println(n);
		}
    }
}
