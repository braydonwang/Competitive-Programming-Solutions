import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, mod = (int)1e9+7;
	static Point[] p;
	static long ans = 0;
	public static void main(String[] args) throws IOException {
		n = readInt();
		p = new Point[n];
		for (int i = 0; i < n; i++) {
			p[i] = new Point(readInt(),readInt());
		}
		for (int i = 0; i < 4; i++) {
			fun(); rotate();
		}
		System.out.println(ans);
	}
	static void rotate() {
		for (int i = 0; i < n; i++) {
			p[i] = new Point(-p[i].y,p[i].x);
		}
	}
	static void fun() {
		Arrays.sort(p);
		int max = (int)1e4+2;
		long[] cx = new long[2*max], cy = new long[2*max], sx = new long[2*max], sy = new long[2*max], lx = new long[2*max], ly = new long[2*max];
		for (int i = 0; i < n; i++) {
			int x = p[i].x + max - 2, y = p[i].y + max - 2;
			sx[x] = (sx[x] + ((y - lx[x]) * cx[x]) % mod) % mod;
			sy[y] = (sy[y] + ((x - ly[y]) * cy[y]) % mod) % mod;
			cx[x]++; cy[y]++; lx[x] = y; ly[y] = x;
			ans = (ans + (sx[x] * sy[y]) % mod) % mod;
		}
	}
	static class Point implements Comparable<Point>{
		int x, y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
		public int compareTo(Point p) {
			if (this.x == p.x) {
				return this.y - p.y;
			}
			return this.x - p.x;
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
