import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		long k = readLong();
		int[] a = new int[n+1];
		for (int i = 1; i <= n; i++) {
			a[i] = readInt();
		}
		int[] dis = new int[n+1];
		boolean[] vis = new boolean[n+1];
		int cur = 1; vis[cur] = true; dis[cur] = 0; int pre = -1;
		int cycle = 0, mod = 0, start = 0;
		boolean done = false;
		while (true) {
			pre = cur; cur = a[cur];
			if (dis[pre] + 1 == k) {
				System.out.println(cur);
				done = true;
				break;
			}
			if (vis[cur]) {
				start = cur;
				cycle = dis[pre] + 1 - dis[cur];
				mod = (int) ((k - (dis[pre] + 1)) % cycle);
				break;
			} else {
				vis[cur] = true; dis[cur] = dis[pre] + 1;
			}
		}
		if (done) {
			return;
		}
		for (int i = 0; i < mod; i++) {
			start = a[start];
		}
		System.out.println(start);
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
