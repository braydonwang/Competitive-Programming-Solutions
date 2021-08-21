import java.util.*;
import java.io.*;
public class Template {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		long k = readLong();
		long[] array = new long[n+1];
		for (int i = 1; i <= n; i++) {
			array[i] = readLong();
			if (array[i] >= k && array[i] <= 2*k) {
				System.out.println(1);
				System.out.println(i);
				return;
			}
		}
		ArrayList<Integer> adj[] = new ArrayList[n+1];
		for (int i = 0; i <= n; i++) {
			adj[i] = new ArrayList();
		}
		for (int i = 0; i < n-1; i++) {
			int a = readInt(), b = readInt();
			if (array[a] < k && array[b] < k) {
				adj[a].add(b);
				adj[b].add(a);
			}
		}
		boolean[] vis = new boolean[n+1];
		for (int i = 1; i <= n; i++) {
			if (array[i] < k && !vis[i]) {
				Queue<Integer> q = new LinkedList();
				ArrayList<Integer> ans = new ArrayList<Integer>();
				long total = array[i];
				q.add(i); vis[i] = true; ans.add(i);
				while (!q.isEmpty()) {
					int cur = q.poll();
					for (int nxt: adj[cur]) {
						if (!vis[nxt] && array[nxt] + total <= 2*k) {
							q.add(nxt); vis[nxt] = true;
							ans.add(nxt); total += array[nxt];
						}
					}
				}
				if (total >= k && total <= 2*k){
				    System.out.println(ans.size());
				    for (int a: ans){
				        System.out.print(a + " ");
				    }
				    return;
				}
			}
		}
		System.out.println(-1);
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
