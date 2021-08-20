import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int a1, a2, b1, b2;
	public static void main(String[] args) throws IOException {
		int h = readInt(), w = readInt();
		char[][] array = new char[h][w];
		for (int i = 0; i < h; i++) {
			String str = next();
			for (int j = 0; j < w; j++) {
				array[i][j] = str.charAt(j);
			}
		}
		long[][] dis = new long[h][w];
		for (int i = 0; i < h; i++) {
			if (array[i][0] == '.') {
				dis[i][0] = 1;
			} else {
				break;
			}
		}
		for (int i = 0; i < w; i++) {
			if (array[0][i] == '.') {
				dis[0][i] = 1;
			} else {
				break;
			}
		}
		for (int i = 1; i < h; i++) {
			for (int j = 1; j < w; j++) {
				if (array[i][j] == '.') {
					dis[i][j] = (dis[i-1][j] + dis[i][j-1]) % 1000000007;
				}
			}
		}
		System.out.println(dis[h-1][w-1]);
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
