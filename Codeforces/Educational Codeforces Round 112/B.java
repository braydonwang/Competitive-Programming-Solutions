import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int t = readInt();
		for (int i = 0; i < t; i++) {
			int W = readInt(), H = readInt();
			int x1 = readInt(), y1 = readInt(), x2 = readInt(), y2 = readInt();
			int w = readInt(), h = readInt();
			int spv = H - y2 + y1, sph = W - x2 + x1;
			if (spv < h && sph < w) {
				System.out.println(-1);
			} else if (spv < h) {
				System.out.println(Math.max(0, w - Math.max(W-x2, x1)));
			} else if (sph < w) {
				System.out.println(Math.max(0, h - Math.max(H-y2, y1)));
			} else {
				System.out.println(Math.max(0, Math.min(w - Math.max(W-x2, x1), h - Math.max(H-y2, y1))));
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
