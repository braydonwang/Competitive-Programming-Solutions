import java.util.*;
import java.io.*;
public class Template {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static long[] pre;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		pre = new long[n+1];
		for (int i = 1; i <= n; i++) {
			pre[i] = pre[i-1] + readInt();
		}
		boolean[][] dp = new boolean[n+1][n+1];
		long max = 0;
		for (int l = n; l >= 1; l--) {
			for (int r = l; r <= n; r++) {
				if (l == r) {
					dp[l][r] = true;
				} else if (r - l <= 2) {
					if (dp[l][l] && dp[r][r] && sum(l,l) == sum(r,r)) {
						dp[l][r] = true;
					}
				}
				HashMap<Long,Integer> map = new HashMap<Long,Integer>();
				for (int i = l; i <= r - 2; i++) {
					if (dp[l][i]) {
						map.put(sum(l,i), i);
					}
				}
				for (int i = r; i >= l + 2; i--) {
					if (dp[i][r] && map.containsKey(sum(i,r))) {
						if (dp[map.get(sum(i,r))+1][i-1]) {
							dp[l][r] = true;
							break;
						}
					}
				}
				for (int i = l; i < r; i++) {
					if (dp[l][i] && dp[i+1][r] && sum(l,i) == sum(i+1,r)) {
						dp[l][r] = true;
						break;
					}
				}
				if (dp[l][r]) {
					max = Math.max(max, sum(l,r));
				}
			}
		}
		System.out.println(max);
	}
	static long sum(int l, int r) {
		return pre[r] - pre[l-1];
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
