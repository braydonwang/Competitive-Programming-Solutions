import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int h = readInt(), v = readInt();
		long ans = (long)(h*(h-1))/2 * (v*(v-1))/2;
		for (int y = 1; y <= h; y++) {
			for (int x = 1; x <= v; x++) {
				int g = gcd(x,y), dy = y/g, dx = x/g;
				for (int r = y + dx, c = x + dy; r <= h && c <= v; r += dx, c += dy) {
					ans += (h-r) * (v-c);
				}
			}
		}
		System.out.println(ans);
	}
	static int gcd(int x, int y) {
		if (y == 0) {
			return x;
		}
		return gcd(y,x%y);
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
