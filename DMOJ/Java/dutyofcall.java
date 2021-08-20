import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), r = readInt();
		int[] in = new int[n+1];
		ArrayList<Integer> adj[] = new ArrayList[n+1];
		for (int i = 0; i <= n; i++) {
			adj[i] = new ArrayList();
		}
		for (int i = 1; i <= n; i++) {
			int m = readInt();
			for (int j = 0; j < m; j++) {
				int x = readInt();
				in[x]++;
				adj[i].add(x);
				adj[x].add(i);
			}
		}
		Queue<Integer> q = new LinkedList();
		boolean[] vis = new boolean[n+1];
		int[] dis = new int[n+1];
		q.add(r);
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int nxt: adj[cur]) {
				if (!vis[nxt]) {
					q.add(nxt);
					vis[nxt] = true;
					dis[nxt] = dis[cur] + 1;
				}
			}
		}
		int soupCount = 0, bruceCount = 0;
		for (int i = 1; i <= n; i++){
		    if (in[i] == 0){
		        if (dis[i] % 2 == 0){
		            soupCount++;
		        } else{
		            bruceCount++;
		        }
		    }
		}
		System.out.println(soupCount + " " + bruceCount);
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
