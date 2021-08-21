import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int b = readInt(), t = readInt();
		ArrayList<Integer> adj[] = new ArrayList[b+1];
		for (int i = 0; i <= b; i++) {
			adj[i] = new ArrayList();
		}
		int[] x = new int[b], y = new int[b], r = new int[b];
		for (int i = 0; i < b; i++) {
			x[i] = readInt(); y[i] = readInt(); r[i] = readInt();
		}
		for (int i = 0; i < b-1; i++) {
			for (int j = i+1; j < b; j++) {
				if ((x[i] - x[j])*(x[i] - x[j]) + (y[i] - y[j]) * (y[i] - y[j]) <= r[j]*r[j]) {
					adj[j+1].add(i+1);
				}
				if ((x[j] - x[i])*(x[j] - x[i]) + (y[j] - y[i]) * (y[j] - y[i]) <= r[i]*r[i]) {
					adj[i+1].add(j+1);
				}
			}
		}
		for (int i = 0; i < t; i++) {
			int a = readInt(), c = readInt();
			boolean[] vis = new boolean[b+1];
			boolean can = false;
			Queue<Integer> q = new LinkedList();
			q.add(a); vis[a] = true;
			while (!q.isEmpty()) {
				int cur = q.poll();
				if (cur == c) {
					can = true;
					break;
				}
				for (int nxt: adj[cur]) {
					if (!vis[nxt]) {
						q.add(nxt); vis[nxt] = true;
					}
				}
			}
			if (can) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
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
