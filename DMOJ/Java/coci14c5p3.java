import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt(), k = sc.nextInt();
		int[] col = new int[100001];
		int[] row = new int[100001];
		int[] left = new int[100001*2-1];
		int[] right = new int[100001*2-1];
		int count = 0;
		for (int i = 0; i < n; i++) {
			count++;
			int a = sc.nextInt(), b = sc.nextInt();
			col[a]++; row[b]++; left[a+b]++; right[(100001-1-a)+b]++;
			if (col[a] == k || row[b] == k || left[a+b] == k || right[(100001-1-a)+b] == k) {
				System.out.println(count);
				return;
			}
		}
		System.out.println(-1);
    }
}
