import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int h = readInt(), w = readInt();
		int count = 0;
		char[][] array = new char[h][w];
		int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
		boolean[][] vis = new boolean[h][w];
		Queue<Integer> q = new LinkedList();
		Queue<Integer> q2 = new LinkedList();
		Queue<Integer> q3 = new LinkedList();
		for (int i = 0; i < h; i++) {
			String str = next();
			for (int j = 0; j < w; j++) {
				array[i][j] = str.charAt(j);
			}
		}
		q.add(0); q.add(0); vis[0][0] = true;
		while (true) {
			count++;
			while (!q.isEmpty()) {
				int r = q.poll(), c = q.poll();
				for (int k = 0; k < 4; k++) {
					int nr = r + dir[k][0], nc = c + dir[k][1];
					if (nr < 0 || nr >= h || nc < 0 || nc >= w || vis[nr][nc] || array[nr][nc] == '.') {
						continue;
					}
					if (array[nr][nc] == array[r][c]) {
						q.add(nr); q.add(nc); vis[nr][nc] = true;
					} else {
						q2.add(nr); q2.add(nc); vis[nr][nc] = true;
					}
				}
			}
			if (q2.isEmpty()) {
				break;
			}
			q = q2;
			q2 = new LinkedList();
		}
		System.out.println(count);
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
