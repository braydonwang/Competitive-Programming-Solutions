import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		for (int i = 0; i < 5; i++) {
			int n = readInt(), m = readInt();
			List<Integer> adj[] = new ArrayList[n+1];
			int count = 0;
			int[] array = new int[m*2];
			for (int j = 0; j <= n; j++) {
				adj[j] = new ArrayList();
			}
			for (int j = 0; j < m*2; j+=2) {
				int a = readInt(), b = readInt();
				adj[a].add(b); adj[b].add(a);
				array[j] = a; array[j+1] = b;
			}
			for (int j = 0; j < m*2; j+=2) {
				Queue<Integer> q = new LinkedList();
				boolean[] vis = new boolean[n+1];
				adj[array[j]].remove(adj[array[j]].indexOf(array[j+1]));
				adj[array[j+1]].remove(adj[array[j+1]].indexOf(array[j]));
				q.add(1); vis[1] = true;
				while (!q.isEmpty()) {
					int cur = q.poll();
					for (int nxt: adj[cur]) {
						if (!vis[nxt]) {
							q.add(nxt);
							vis[nxt] = true;
						}
					}
				}
				boolean connect = true;
				for (int k = 1; k <= n; k++) {
					if (!vis[k]) {
						connect = false;
						break;
					}
				}
				if (!connect) {
					count++;
				}
				adj[array[j]].add(array[j+1]);
				adj[array[j+1]].add(array[j]);
			}
			System.out.println(count);
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
