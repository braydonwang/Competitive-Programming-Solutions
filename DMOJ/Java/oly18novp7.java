import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt();
		Queue<Integer> q = new LinkedList();
		boolean[] vis = new boolean[1000000];
		long[] dis = new long[1000000];
		q.add(n); vis[n] = true; dis[n] = 0;
		while (!q.isEmpty()) {
			int x = q.poll();
			if (x + 1 < 1000000 && !vis[x+1]) {
				q.add(x+1); vis[x+1] = true; dis[x+1] = dis[x] + 1;
			}
			if (x - 1 >= 0 && !vis[x-1]) {
				q.add(x-1); vis[x-1] = true; dis[x-1] = dis[x] + 1;
			}
			if (x * 2 < 1000000 && !vis[x*2]) {
				q.add(x*2); vis[x*2] = true; dis[x*2] = dis[x] + 1;
			}
			if (vis[m]) {
				break;
			}
		}
		System.out.println(dis[m]);
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
