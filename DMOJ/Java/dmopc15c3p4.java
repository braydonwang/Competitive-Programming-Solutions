import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		long[] x = new long[n], y = new long[n];
		long[][] adj = new long[n][n];
		for (int i = 0; i < n; i++) {
			x[i] = readLong(); y[i] = readLong();
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i != j) {
					adj[i][j] = (x[i] - x[j]) * (x[i] - x[j]) + (y[i] - y[j]) * (y[i] - y[j]);
				}
			}
		}
		int source = readInt();
		int q = readInt();
		long[] dis = new long[n]; boolean[] vis = new boolean[n];
		Arrays.fill(dis, Long.MAX_VALUE);
		dis[source-1] = 0;
		for (int i = 0; i < n; i++) {
			long min = Long.MAX_VALUE;
			int id = -1;
			for (int j = 0; j < n; j++) {
				if (dis[j] < min && !vis[j]) {
					min = dis[j];
					id = j;
				}
			}
			if (id == -1) {
				break;
			}
			vis[id] = true;
			for (int j = 0; j < n; j++) {
				dis[j] = Math.min(dis[j], dis[id] + adj[id][j]);
			}
		}
		Arrays.sort(dis);
		for (int i = 0; i < q; i++) {
			long num = readLong();
			int lo = 0, hi = n-1;
			while (lo <= hi) {
				int mid = (lo + hi) / 2;
				if (dis[mid] <= num) {
					lo = mid + 1;
				} else {
					hi = mid - 1;
				}
			}
			System.out.println(lo);
		}
	}
	static class Edge{
		int v;
		long w;
		Edge(int v, long w){
			this.v=v;
			this.w=w;
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
