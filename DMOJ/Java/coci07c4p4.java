import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int t = readInt(), n = readInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = readInt();
		}
		Pair[] temp = new Pair[t+1];
		int[] dp = new int[t+1];
		dp[0] = 2;
		int max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = t; j >= a[i]; j--) {
				if (dp[j] != 0) {
					continue;
				}
				if (dp[j-a[i]] != 0) {
					dp[j] = 1;
					temp[j] = new Pair(a[i],i);
					max = Math.max(j, max);
				}
			}
		}
		int[] ans = new int[n];
		Arrays.fill(ans, -1);
		int count = 0;
		while (dp[max] != 2) {
			ans[temp[max].ind] = count;
			count += temp[max].v;
			max -= temp[max].v;
		}
		count = 0;
		for (int i = 0; i < n; i++) {
			if (ans[i] == -1) {
				ans[i] = count;
				count += a[i];
			}
		}
		for (int x: ans) {
			System.out.print(x + " ");
		}
	}
	static class Pair{
		int v, ind;
		Pair(int v, int ind){
			this.v = v;
			this.ind = ind;
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
