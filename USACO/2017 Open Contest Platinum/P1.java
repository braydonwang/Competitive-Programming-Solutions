import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int[][] a = new int[n+1][n+1];
		int[][] c = new int[n*n+1][4];
		int[][] pre = new int[n+2][n+2];
		boolean[] vis = new boolean[n*n+1];
		boolean[] bad = new boolean[n*n+1];
		for (int i = 1; i <= n*n; i++) {
			c[i][0] = c[i][1] = Integer.MAX_VALUE;
		}
		int temp = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				a[i][j] = readInt();
				c[a[i][j]][0] = Math.min(c[a[i][j]][0], j);
				c[a[i][j]][1] = Math.min(c[a[i][j]][1], i);
				c[a[i][j]][2] = Math.max(c[a[i][j]][2], j);
				c[a[i][j]][3] = Math.max(c[a[i][j]][3], i);
				if (!vis[a[i][j]] && a[i][j] != 0){
				    temp++;
				}
				vis[a[i][j]] = true;
			}
		}
		if (temp == 1){
		    System.out.println(n*n-1);
		    return;
		}
		for (int i = 1; i <= n*n; i++) {
			if (vis[i]) {
				int l = c[i][0], u = c[i][1], r = c[i][2], d = c[i][3];
				pre[u][l]++; pre[u][r+1]--; pre[d+1][l]--; pre[d+1][r+1]++;
			}
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				pre[i][j] += pre[i-1][j] + pre[i][j-1] - pre[i-1][j-1];
				//System.out.print(pre[i][j] + " ");
				if (pre[i][j] >= 2) {
					bad[a[i][j]] = true;
				}
			}
			//System.out.println();
		}
		int count = 0;
		for (int i = 1; i <= n*n; i++) {
			if (!bad[i] || !vis[i]) {
				count++;
			}
		}
		System.out.println(count);
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
