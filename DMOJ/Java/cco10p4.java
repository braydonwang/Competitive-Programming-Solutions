import java.util.*;
import java.io.*;
public class Template {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int T = readInt(), n = readInt();
		Item[] item = new Item[n];
		for (int i = 0; i < n; i++) {
			item[i] = new Item(readInt(), readInt(), readInt());
		}
		Arrays.sort(item);
		int b = readInt();
		int[][] dp = new int[T+1][b+1];
		for (int i = 0; i < n; i++) {
			for (int j = b; j >= item[i].c; j--) {
				dp[item[i].t][j] = Math.max(dp[item[i].t][j], dp[item[i].t-1][j-item[i].c] + item[i].v); 
			}
		}
		System.out.println(dp[T][b]);
	}
	static class Item implements Comparable<Item>{
		int c, v, t;
		Item(int c, int v, int t){
			this.c = c;
			this.v = v;
			this.t = t;
		}
		public int compareTo(Item i) {
			return this.t - i.t;
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
