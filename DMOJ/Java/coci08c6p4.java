import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		ArrayList<Integer> adj[] = new ArrayList[3];
		for (int i = 0; i < 3; i++) {
			adj[i] = new ArrayList();
		}
		for (int i = 0; i < n; i++) {
			int x = readInt();
			adj[x%3].add(x);
		}
		int a = adj[0].size(), b = adj[1].size(), c = adj[2].size(), pre = -1;
		int[] ans = new int[n];
		for (int i = 0; i < n; i++) {
			if (pre == -1) {
				if (a >= b && a >= c) {
					pre = 0; a--;
					ans[i] = adj[0].remove(0);
				} else if (b >= a && b >= c) {
					pre = 1; b--;
					ans[i] = adj[1].remove(0);
				} else {
					pre = 2; c--;
					ans[i] = adj[2].remove(0);
				}
			} else if (pre == 0) {
				if (Math.max(b, c) == 0) {
					System.out.println("impossible");
					return;
				}
				if (b > c) {
					pre = 1; b--;
					ans[i] = adj[1].remove(0);
				} else {
					pre = 2; c--;
					ans[i] = adj[2].remove(0);
				}
			} else if (pre == 1) {
				if (Math.max(b, a) == 0) {
					System.out.println("impossible");
					return;
				}
				if (b < a) {
					pre = 0; a--;
					ans[i] = adj[0].remove(0);
				} else {
					pre = 1; b--;
					ans[i] = adj[1].remove(0);
				}
			} else if (pre == 2) {
				if (Math.max(a, c) == 0) {
					System.out.println("impossible");
					return;
				}
				if (a > c) {
					pre = 0; a--;
					ans[i] = adj[0].remove(0);
				} else {
					pre = 2; c--;
					ans[i] = adj[2].remove(0);
				}
			}
		}
		for (int x: ans) {
			System.out.print(x + " ");
		}
		System.out.println();
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
