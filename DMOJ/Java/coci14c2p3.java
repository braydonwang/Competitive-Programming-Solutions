import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] a1, a2;
	public static void main(String[] args) throws IOException {
		int n = readInt(), k = readInt();
		Pair[] array = new Pair[n];
		int[] pos = new int[n];
		int[] end = new int[n+1];
		//find longest non decreasing subsequence
		for (int i = 0; i < n; i++) {
			array[i] = new Pair(readInt(),i);
		}
		Arrays.sort(array);
		int cnt = 1;
		for (int i = 0; i < n; i++) {
			pos[array[i].ind] = cnt;
			if ((i+1) % k == 0) {
				cnt++;
			}
		}
		int[] dp = new int[n];
		int max = 0;
		for (int i = 0; i < n; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (pos[i] >= pos[j]) {
					dp[i] = Math.max(dp[i],dp[j]+1);
				}
			}
			max = Math.max(max, dp[i]);
		}
		System.out.println(n-max);
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
