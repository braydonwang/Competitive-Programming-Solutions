import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int r = readInt(), c = readInt();
		char[][] array = new char[r][c];
		for (int i = 0; i < r; i++) {
			String str = next();
			for (int j = 0; j < c; j++) {
				array[i][j] = str.charAt(j);
			}
		}
		int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
		boolean[][] vis = new boolean[r][c];
		int count = 0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (!vis[i][j] && array[i][j] == '.') {
					count++;
					Queue<Integer> q = new LinkedList();
					q.add(i); q.add(j); vis[i][j] = true;
					while (!q.isEmpty()) {
						int row = q.poll(), col = q.poll();
						for (int k = 0; k < 4; k++) {
							int newr = row + dir[k][0], newc = col + dir[k][1];
							if (newr >= 0 && newr < r && newc >= 0 && newc < c && !vis[newr][newc] && array[newr][newc] == '.') {
								q.add(newr); q.add(newc); vis[newr][newc] = true;
							}
						}
					}
				}
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
