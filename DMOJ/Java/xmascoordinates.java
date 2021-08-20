import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt();
		int sr = 0, sc = 0;
		char[][] array = new char[n][m];
		for (int i = 0; i < n; i++) {
			String str = next();
			for (int j = 0; j < m; j++) {
				array[i][j] = str.charAt(j);
				if (array[i][j] == 'O') {
					sr = i; sc = j;
				}
			}
		}
		int pr = -1, pc = -1;
		int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
		boolean[][] vis = new boolean[n][m];
		int[][] dis = new int[n][m];
		int ans = 0;
		Queue<Integer> q = new LinkedList();
		q.add(sr); q.add(sc); vis[sr][sc] = true;
		while (!q.isEmpty()) {
			int row = q.poll(), col = q.poll();
			for (int k = 0; k < 4; k++) {
				int newr = row + dir[k][0], newc = col + dir[k][1];
				if (newr >= 0 && newr < n && newc >= 0 && newc < m && !vis[newr][newc] && array[newr][newc] != '#') {
					q.add(newr); q.add(newc); vis[newr][newc] = true; dis[newr][newc] = dis[row][col] + 1;
					if (array[newr][newc] == 'P') {
						ans += dis[newr][newc];
						pr = newr; pc = newc;
						break;
					}
				}
			}
			if (ans != 0) {
				break;
			}
		}
		vis = new boolean[n][m];
		dis = new int[n][m];
		q = new LinkedList();
		q.add(pr); q.add(pc); vis[pr][pc] = true;
		while (!q.isEmpty()) {
			int row = q.poll(), col = q.poll();
			for (int k = 0; k < 4; k++) {
				int newr = row + dir[k][0], newc = col + dir[k][1];
				if (newr >= 0 && newr < n && newc >= 0 && newc < m && !vis[newr][newc] && array[newr][newc] != '#') {
					q.add(newr); q.add(newc); vis[newr][newc] = true; dis[newr][newc] = dis[row][col] + 1;
					if (array[newr][newc] == 'X') {
						ans += dis[newr][newc];
						System.out.println(ans);
						return;
					}
				}
			}
		}
		System.out.println(-1);
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
