import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		for (int z = 0; z < 5; z++) {
			int n = readInt(), m = readInt();
			int[][] a = new int[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					a[i][j] = readInt();
				}
			}
			int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
			int ans = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					for (int k = a[i][j]+1; k <= 50; k++) {
						Queue<Integer> q = new LinkedList();
						boolean[][] vis = new boolean[n][m];
						q.add(i); q.add(j); vis[i][j] = true;
						boolean good = true;
						while (!q.isEmpty()) {
							int r = q.poll(), c = q.poll();
							if (a[r][c] >= k) {
								continue;
							}
							if (r == 0 || c == 0 || r == n-1 || c == m-1) {
								good = false;
								break;
							}
							for (int l = 0; l < 4; l++) {
								int newr = r + dir[l][0], newc = c + dir[l][1];
								if (!vis[newr][newc]) {
									q.add(newr); q.add(newc); vis[newr][newc] = true;
								}
							}
						}
						if (good) {
							ans++;
						} else {
							break;
						}
					}
				}
			}
			System.out.println(ans);
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
