import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static ArrayList<Integer> adj[];
	static boolean[] vis;
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt();
		adj = new ArrayList[n+1];
		vis = new boolean[n+1];
		int[] array = new int[n+1];
		for (int i = 0; i <= n; i++) {
			adj[i] = new ArrayList();
		}
		for (int i = 0; i < m; i++) {
			int x = readInt(), k = readInt();
			for (int j = 0; j < k; j++) {
				int a = readInt();
				adj[x].add(a);
			}
		}
		for (int i = 1; i <= n; i++) {
			array[i] = readInt();
		}
		System.out.println(check(1,0,array));
	}
	static int check(int v, int count, int[] array) {
		count += array[v];
		vis[v] = true;
		int min = Integer.MAX_VALUE;
		for (int nxt: adj[v]) {
			if (!vis[nxt]) {
				min = Math.min(min, check(nxt,0,array));
			}
		}
		if (min != Integer.MAX_VALUE) {
			count += min;
		}
		return count;
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
