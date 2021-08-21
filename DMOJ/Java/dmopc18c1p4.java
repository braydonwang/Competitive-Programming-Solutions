import java.util.*;
import java.io.*;
import java.lang.reflect.Array;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		long m = readLong(), k = readLong();
		int x = readInt();
		long[] pre = new long[n+1];
		Pair[] freq = new Pair[n];
		int[] ans = new int[n];
		for (int i = 0; i < n; i++) {
			freq[i] = new Pair(readInt(),i);
		}
		Arrays.sort(freq);
		for (int i = 1; i <= n; i++) {
			pre[i] = pre[i-1] + freq[i-1].val;
		}
		int l = 0, r = n;
		while (l <= n && pre[l] < k) {
			l++;
		}
		while (r >= 1 && pre[n] - pre[r] < k) {
			r--;
		}
		//System.out.println(l + " " + r);
		if (x > l || x < n-r) {
			System.out.println(-1);
			return;
		}
		int count = 0;
		for (int i = x; i <= n; i++) {
			if (pre[i] - pre[i-x] >= k) {
				for (int j = i-x+1; j <= i; j++) {
					ans[freq[j-1].ind] = ++count; 
				}
				for (int j = 0; j < n; j++) {
					if (ans[j] == 0) {
						ans[j] = ++count;
					}
				}
				for (int num: ans) {
					System.out.print(num + " ");
				}
				return;
			}
		}
	}
	static class Pair implements Comparable<Pair>{
		int val, ind;
		Pair(int val, int ind){
			this.val = val;
			this.ind = ind;
		}
		public int compareTo(Pair p) {
			return this.val - p.val;
		}
	}
	static int readInt () throws IOException {
		return Integer.parseInt(next());
	}
	static String next () throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}
	static long readLong () throws IOException {
		return Long.parseLong(next());
	}
	static double readDouble () throws IOException {
		return Double.parseDouble(next());
	}
	static char readCharacter () throws IOException {
		return next().charAt(0);
	}
	static String readLine () throws IOException {
		return br.readLine().trim();
	}
}
