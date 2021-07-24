import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), t = readInt();
		long[][] a = new long[2*n+2][2*n+2];
		TreeMap<Integer,Integer> x = new TreeMap<Integer,Integer>(), y = new TreeMap<Integer,Integer>();
		long[] xhelp = new long[2*n+1], yhelp = new long[2*n+1];
		Pair[] p = new Pair[n];
		for (int i = 0; i < n; i++) {
			p[i] = new Pair(readInt(),readInt(),readInt(),readInt(),readInt());
			if (!x.containsKey(p[i].x1)) {
				x.put(p[i].x1, 0);
			}
			if (!x.containsKey(p[i].x2)) {
				x.put(p[i].x2, 0);
			}
			if (!y.containsKey(p[i].y1)) {
				y.put(p[i].y1, 0);
			}
			if (!y.containsKey(p[i].y2)) {
				y.put(p[i].y2, 0);
			}
		}
		int count = 1;
		for (int num: x.keySet()) {
			x.put(num, count);
			xhelp[count] = num;
			count++;
		}
		count = 1;
		for (int num: y.keySet()) {
			y.put(num,count);
			yhelp[count] = num;
			count++;
		}
		for (int i = 0; i < n; i++) {
			int x1 = p[i].x1, y1 = p[i].y1, x2 = p[i].x2, y2 = p[i].y2;
			p[i] = new Pair(x.get(x1),y.get(y1),x.get(x2),y.get(y2),p[i].t);
			for (int j = p[i].y1; j < p[i].y2; j++) {
				a[j][p[i].x1] += p[i].t; a[j][p[i].x2] -= p[i].t;
			}
		}
		long ans = 0;
		for (int i = 1; i <= 2*n; i++) {
			for (int j = 1; j <= 2*n; j++) {
				a[i][j] += a[i][j-1];
				//System.out.print(a[i][j] + " ");
			}
			//System.out.println();
		}
		for (int i = 1; i <= 2*n; i++) {
			for (int j = 1; j <= 2*n; j++) {
				if (a[i][j] >= t) {
					ans += (xhelp[j+1] - xhelp[j]) * (yhelp[i+1] - yhelp[i]);
				}
			}
		}
		System.out.println(ans);
	}
	static class Pair{
		int x1, y1, x2, y2, t;
		Pair(int x1, int y1, int x2, int y2, int t){
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
			this.t = t;
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
