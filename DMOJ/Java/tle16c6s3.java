import java.util.*;
import java.io.*;
public class Template {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		Pair[] array = new Pair[n+1];
		long[] pre = new long[n+1];
		for (int i = 1; i <= n; i++) {
			int x = readInt(), d = readInt();
			array[i] = new Pair(x,d);
		}
		array[0] = new Pair(Integer.MIN_VALUE,0);
		long[][][] dp = new long[n+1][n+1][2];
		Arrays.sort(array);
		long max = 0;
		for (int i = 1; i <= n; i++) {
		    pre[i] = pre[i-1] + array[i].d;
			if (array[i].x == 0) {
				dp[i][i][0] = dp[i][i][1] = array[i].d;
				max = array[i].d;
			}
		}
		for (int l = n; l >= 1; l--) {
			for (int r = l+1; r <= n; r++) {
				boolean good = false;
				if (dp[l+1][r][0] >= array[l+1].x - array[l].x) {
					dp[l][r][0] = Math.max(dp[l][r][0], dp[l+1][r][0] - (array[l+1].x - array[l].x) + array[l].d);
					good = true;
				}
				if (dp[l+1][r][1] >= array[r].x - array[l].x) {
					dp[l][r][0] = Math.max(dp[l][r][0], dp[l+1][r][1] - (array[r].x - array[l].x) + array[l].d);
					good = true;
				}
				if (dp[l][r-1][0] >= array[r].x - array[l].x) {
					dp[l][r][1] = Math.max(dp[l][r][1], dp[l][r-1][0] - (array[r].x - array[l].x) + array[r].d);
					good = true;
				}
				if (dp[l][r-1][1] >= array[r].x - array[r-1].x) {
					dp[l][r][1] = Math.max(dp[l][r][1], dp[l][r-1][1] - (array[r].x - array[r-1].x) + array[r].d);
					good = true;
				}
				if (good) {
					max = Math.max(max, pre[r] - pre[l-1]);
				}
			}
		}
		System.out.println(max);
	}
	static class Pair implements Comparable<Pair>{
		int x,d;
		Pair(int x, int d){
			this.x = x;
			this.d = d;
		}
		public int compareTo(Pair p) {
			return Integer.compare(this.x, p.x);
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
