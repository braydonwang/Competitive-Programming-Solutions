import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt(), p = readInt(), q = readInt();
		long total = 0, ans = 0;
		ArrayList<Edge> list = new ArrayList<Edge>();
		int[] r = new int[n+1], c = new int[m+1];
		int row = n, col = m;
		for (int i = 0; i < p; i++) {
			int u = readInt(), v = readInt(), w = readInt();
			list.add(new Edge(u,v,w,0));
			total += (long)n*w;
		}
		for (int i = 0; i < q; i++) {
			int u = readInt(), v = readInt(), w = readInt();
			list.add(new Edge(u,v,w,1));
			total += (long)m*w;
		}
		Collections.sort(list);
		for (int i = 1; i <= n; i++) {
			r[i] = i;
		}
		for (int i = 1; i <= m; i++) {
			c[i] = i;
		}
		for (Edge x: list) {
			if (x.f == 1) {
				if (row == 1) {
					continue;
				}
				int fu = find(x.u, r), fv = find(x.v, r);
				if (fu != fv) {
					r[fu] = fv;
					row--;
					ans += (long)x.w * col;
				}
			} else {
				if (col == 1) {
					continue;
				}
				int fu = find(x.u, c), fv = find(x.v,c);
				if (fu != fv) {
					c[fu] = fv;
					col--;
					ans += (long)x.w * row;
				}
			}
			if (row == 1 && col == 1) {
				break;
			}
		}
		System.out.println(total - ans);
	}
	static int find(int d, int[] p) {
		if (d != p[d]) {
			p[d] = find(p[d],p);
		}
		return p[d];
	}
	static class Edge implements Comparable<Edge>{
		int u, v, w, f;
		Edge(int u, int v, int w, int f){
			this.u = u;
			this.v = v;
			this.w = w;
			this.f = f;
		}
		public int compareTo(Edge e) {
			return this.w - e.w;
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
