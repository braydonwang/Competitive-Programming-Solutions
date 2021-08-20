import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int count = 0;
	static int[][] a;
	static int n;
	static boolean[] vis;
	public static void main(String[] args) throws IOException {
		n = readInt();
		a = new int[n][n];
		vis = new boolean[n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				a[i][j] = readInt();
			}
		}
		for (int i = 0; i < n; i++) {
			dfs(i,i);
		}
		System.out.println(count);
	}
	static void dfs(int v, int st) {
		vis[v] = true;
		for (int i = 0; i < n; i++) {
			if (a[v][i] == 1) {
				if (i == st) {
					count++;
				} else if (i > st && !vis[i]) {
					dfs(i,st);
				}
			}
		}
		vis[v] = false;
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
