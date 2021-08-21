import java.util.*;
import java.io.*;
public class Template {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), rs = readInt(), cs = readInt(), re = readInt(), ce = readInt();
		int r1 = readInt(), c1 = readInt(), r2 = readInt(), c2 = readInt();
		Queue<Integer> q = new LinkedList();
		int[][][][] dis = new int[n+1][n+1][n+1][n+1];
		boolean[][][][] vis = new boolean[n+1][n+1][n+1][n+1];
		if (r1 == rs && c1 == cs) {
			q.add(r1); q.add(c1); q.add(r2); q.add(c2); vis[r1][c1][r2][c2] = true; dis[r1][c1][r2][c2] = 0;
		} else {
			q.add(r2); q.add(c2); q.add(r1); q.add(c1); vis[r2][c2][r1][c1] = true; dis[r2][c2][r1][c1] = 0;
		}
		int[][] direction = {{1,0},{-1,0},{0,1},{0,-1}};
		while (!q.isEmpty()) {
			int r = q.poll(), c = q.poll(), er = q.poll(), ec = q.poll();
			int distance = dis[r][c][er][ec];
			if (r == re && c == ce) {
				System.out.println(distance);
				return;
			}
			for (int i = 0; i < 4; i++) {
				if (r + direction[i][0] == er && c + direction[i][1] == ec && !vis[er][ec][r][c]) {
					q.add(er); q.add(ec); q.add(r); q.add(c); vis[er][ec][r][c] = true; dis[er][ec][r][c] = distance + 1;
				}
				int newer = er + direction[i][0], newec = ec + direction[i][1];
				if (newer >= 1 && newer <= n && newec >= 1 & newec <= n && (newer != r || newec != c) && !vis[r][c][newer][newec]) {
					q.add(r); q.add(c); q.add(newer); q.add(newec); vis[r][c][newer][newec] = true; dis[r][c][newer][newec] = distance + 1;
				}
			}
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
