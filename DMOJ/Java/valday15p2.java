import java.util.*;
import java.io.*;
public class CCC {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), w = readInt();
		int[] value = new int[n+1];
		int[] weight = new int[n+1];
		for (int i = 1; i <= n; i++) {
			int v = readInt(), k = readInt();
			value[i] = v;
			weight[i] = k;
		}
		int[] dp = new int[w+1];
		for (int i = 1; i <= n; i++) {
    		for(int j = w; j >= weight[i]; j--) {
    			dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
    		}
    	}
		System.out.println(dp[w]);
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
