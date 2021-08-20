import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), t = readInt();
		int[][] adj = new int[n+1][n+1];
		for (int i = 0; i < t; i++) {
			int a = readInt(), b = readInt(), c = readInt();
			adj[a][b] = c; adj[b][a] = c;
		}
		int k = readInt();
		int[] city = new int[k];
		int[] price = new int[k];
		for (int i = 0; i < k; i++) {
			city[i] = readInt();
			price[i] = readInt();
		}
		int d = readInt();
		int[] dis = new int[n+1]; boolean[] vis = new boolean[n+1];
		Arrays.fill(dis, Integer.MAX_VALUE);
		dis[d] = 0;
		for (int i = 0; i < n; i++) {
			int min = Integer.MAX_VALUE, id = -1;
			for (int j = 1; j <= n; j++) {
				if (dis[j] < min && !vis[j]) {
					min = dis[j];
					id = j;
				}
			}
			if (id == -1) {
				break;
			}
			vis[id] = true;
			for (int j = 0; j <= n; j++) {
				if (adj[id][j] > 0 && adj[id][j] + dis[id] < dis[j]) {
					dis[j] = dis[id] + adj[id][j];
				}
			}
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < k; i++) {
			if (vis[city[i]]) {
				min = Math.min(dis[city[i]] + price[i], min);
			}
		}
		System.out.println(min);
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
