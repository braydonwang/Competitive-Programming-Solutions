import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int r = readInt(), c = readInt();
		int sr = 0, sc = 0, dr = 0, dc = 0;
		char[][] a = new char[r][c];
		int[][] flood = new int[r][c];
		for (int i = 0; i < r; i++) {
			String str = next();
			for (int j = 0; j < c; j++) {
				a[i][j] = str.charAt(j);
				if (a[i][j] == 'S') {
					sr = i; sc = j;
				} else if (a[i][j] == 'D') {
					dr = i; dc = j;
				} else if (a[i][j] == '*') {
					flood[i][j] = 1;
				}
			}
		}
		int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
		Queue<Integer> q = new LinkedList();
		boolean[][] vis = new boolean[r][c];
		int[][] dis = new int[r][c];
		q.add(sr); q.add(sc); vis[sr][sc] = true;
		int count = 1;
		while (!q.isEmpty()) {
			int cr = q.poll(), cc = q.poll();
			if (dis[cr][cc] == count-1) {
				count++;
				for (int i = 0; i < r; i++) {
					for (int j = 0; j < c; j++) {
						if (a[i][j] == '*' && flood[i][j] < count) {
							for (int k = 0; k < 4; k++) {
								int nr = i + dir[k][0], nc = j + dir[k][1];
								if (nr >= 0 && nr < r && nc >= 0 && nc < c && a[nr][nc] == '.') {
									a[nr][nc] = '*'; flood[nr][nc] = count;
								}
							}
						}
					}
				}
			}
			for (int k = 0; k < 4; k++) {
				int newr = cr + dir[k][0], newc = cc + dir[k][1];
				if (newr >= 0 && newr < r && newc >= 0 && newc < c && a[newr][newc] != '*' && a[newr][newc] != 'X' && !vis[newr][newc]) {
					q.add(newr); q.add(newc); vis[newr][newc] = true; dis[newr][newc] = dis[cr][cc] + 1;
					if (a[newr][newc] == 'D') {
						break;
					}
				}
			}
		}
		if (dis[dr][dc] != 0) {
			System.out.println(dis[dr][dc]);
		} else {
			System.out.println("KAKTUS");
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
