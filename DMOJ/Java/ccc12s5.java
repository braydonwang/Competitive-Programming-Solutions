import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int r = readInt(), c = readInt(), k = readInt();
		int[][] dis = new int[r+1][c+1];
		boolean[][] vis = new boolean[r+1][c+1];
		for (int i = 0; i < k; i++) {
			int y = readInt(), x = readInt();
			vis[y][x] = true;
		}
		for (int i = 1; i <= r; i++) {
			if (!vis[i][1]) {
				dis[i][1] = 1;
			} else {
				break;
			}
		}
		for (int i = 1; i <= c; i++) {
			if (!vis[1][i]) {
				dis[1][i] = 1;
			} else {
				break;
			}
		}
		for (int i = 2; i <= r; i++) {
			for (int j = 2; j <= c; j++) {
				if (!vis[i][j]) {
					dis[i][j] = dis[i-1][j] + dis[i][j-1];
				}
			}
		}
		System.out.println(dis[r][c]);
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
