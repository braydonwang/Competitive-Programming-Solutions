import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int w = readInt(), h = readInt(), n = readInt();
		int[][] pre = new int[h+1][w+1];
		for (int i = 1; i <= h; i++) {
			for (int j = 1; j <= w; j++) {
				pre[i][j] = pre[i-1][j] + pre[i][j-1] + readInt() - pre[i-1][j-1];
			}
		}
		int max = 0;
		for (int i = 1; i <= h; i++) {
			int j = Math.min(n / i,w);
			if (j != 0) {
				for (int y = 1; y <= h; y++) {
					for (int x = 1; x <= w; x++) {
						if (x + j - 1 <= w && y + i - 1 <= h) {
							max = Math.max(max, pre[y+i-1][x+j-1] - pre[y-1][x+j-1] - pre[y+i-1][x-1] + pre[y-1][x-1]);
						}
					}
				}
			}
		}
		System.out.println(max);
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
