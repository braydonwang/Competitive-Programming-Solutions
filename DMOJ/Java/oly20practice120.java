import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt(), k = readInt();
		boolean[][] pool = new boolean[n+1][m+1];
		for (int i = 0; i < k; i++) {
			int r = readInt(), c = readInt();
			pool[r][c] = true;
		}
		int ans = 0;
		boolean[][] vis = new boolean[n+1][m+1];
		int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (pool[i][j] && !vis[i][j]) {
					ans++;
					Queue<Integer> q = new LinkedList();
					q.add(i); q.add(j); vis[i][j] = true;
					while (!q.isEmpty()) {
						int row = q.poll(), col = q.poll();
						for (int t = 0; t < 4; t++) {
							int newr = row + dir[t][0], newc = col + dir[t][1];
							if (newr >= 1 && newr <= n && newc >= 1 && newc <= m && pool[newr][newc] && !vis[newr][newc]) {
								q.add(newr); q.add(newc); vis[newr][newc] = true;
							}
						}
					}
				}
			}
		}
		System.out.println(ans);
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
