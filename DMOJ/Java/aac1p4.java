import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), q = readInt();
		int[] a = new int[n+1];
		for (int i = 1; i <= n; i++) {
			a[i] = readInt();
		}
		Query[] qu = new Query[q];
		for (int i = 0; i < q; i++) {
			qu[i] = new Query(readInt(),readInt(),readInt(),i);
		}
		Arrays.sort(qu);
		int[] vis = new int[(int)1e5+5];
		boolean[] ans = new boolean[q];
		int ind = 1;
		for (int i = 0; i < q; i++) {
			int l = qu[i].l, r = qu[i].r, x = qu[i].x, idx = qu[i].ind;
			while (ind <= r) {
				vis[a[ind]] = ind;
				ind++;
			}
			for (int j = 1; j <= Math.sqrt(x); j++) {
				if (x % j == 0 && j != x/j) {
					if (vis[j] >= l && vis[x/j] >= l) {
						ans[idx] = true;
					}
				}
			}
		}
		for (int i = 0; i < q; i++) {
			if (ans[i]) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
	static class Query implements Comparable<Query>{
		int l, r, x, ind;
		Query(int l, int r, int x, int ind){
			this.l = l;
			this.r = r;
			this.x = x;
			this.ind = ind;
		}
		public int compareTo(Query q) {
			return this.r - q.r;
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
