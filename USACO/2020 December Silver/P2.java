import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] pre;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		Point[] p = new Point[n];
		for (int i = 0; i < n; i++) {
			p[i] = new Point(readInt(),readInt(),0,0);
		}
		Arrays.sort(p);
		for (int i = 0; i < n; i++) {
			p[i].a = i+1; p[i].x = p[i].y;
		}
		Arrays.sort(p);
		pre = new int[n+1][n+1];
		for (int i = 0; i < n; i++) {
			p[i].b = i+1; 
			pre[p[i].a][p[i].b]++;
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				pre[i][j] += pre[i-1][j] + pre[i][j-1] - pre[i-1][j-1];
			}
		}
		long ans = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i+1; j < n; j++) {
				int minx = Math.min(p[i].a, p[j].a), maxx = Math.max(p[i].a, p[j].a);
				int miny = Math.min(p[i].b, p[j].b), maxy = Math.max(p[i].b, p[j].b);
				ans += sum(1,minx,maxy,miny) * sum(maxx,n,maxy,miny);
			}
		}
		System.out.println(ans + 1 + n);
	}
	static int sum(int x1, int x2, int y2, int y1) {
		return pre[x2][y2] - pre[x1-1][y2] - pre[x2][y1-1] + pre[x1-1][y1-1];
	}
	static class Point implements Comparable<Point>{
		int x, y, a, b;
		Point(int x, int y, int a, int b){
			this.x = x;
			this.y = y;
			this.a = a;
			this.b = b;
		}
		public int compareTo(Point p) {
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
