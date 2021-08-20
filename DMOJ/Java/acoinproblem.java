import java.util.*;
import java.io.*;
public class Template {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), v = readInt();
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = readInt();
		}
		Store[] stores = new Store[v];
		int maxc = 0, maxl = 0;
		for (int i = 0; i < v; i++) {
			int c = readInt(), l = readInt();
			stores[i] = new Store(c,l,i);
			maxc = Math.max(maxc, c);
			maxl = Math.max(maxl,l);
		}
		Arrays.sort(stores);
		int[] dp = new int[maxc+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		int ind = 0;
		int[] ans = new int[v];
		for (int i = 0; i < maxl; i++) {
			for (int j = array[i]; j <= maxc; j++) {
				if (dp[j-array[i]] != Integer.MAX_VALUE) {
					dp[j] = Math.min(dp[j], dp[j-array[i]]+1);
				}
			}
			while (ind < v && stores[ind].l == i+1) {
				ans[stores[ind].i] = dp[stores[ind].c] == Integer.MAX_VALUE ? -1 : dp[stores[ind].c];
				ind++;
			}
		}
		for (int num: ans) {
			System.out.println(num);
		}
	}
	static class Store implements Comparable<Store>{
		int c, l, i;
		Store(int c, int l, int i){
			this.c = c;
			this.l = l;
			this.i = i;
		}
		public int compareTo(Store s) {
			return this.l - s.l;
		}
	}
	static String next () throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}
	static long readLong () throws IOException {
		return Long.parseLong(next());
	}
	static int readInt () throws IOException {
		return Integer.parseInt(next());
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
