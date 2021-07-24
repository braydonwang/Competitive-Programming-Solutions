import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), k = readInt();
		int[] b = new int[n+1];
		for (int i = 1; i <= n; i++) {
			b[i] = readInt();
		}
		int[][] a = new int[k+1][k+1];
		for (int i = 1; i <= k; i++) {
			String str = next();
			for (int j = 1; j <= k; j++) {
				a[i][j] = str.charAt(j-1) - '0';
			}
			a[i][0] = a[i][b[n]];
		}
		Queue<Integer> q = new LinkedList();
		int[][] dis = new int[n+1][k+1];
		for (int i = 1; i <= n; i++) {
			Arrays.fill(dis[i],-1);
		}
		b[n] = 0;
		q.add(1); q.add(b[1]); dis[1][b[1]] = 0;
		while (!q.isEmpty()) {
			int v = q.poll(), w = q.poll();
			//System.out.println(v + " " + w + " " + dis[v][w]);
			if (v-1 >= 1 && dis[v-1][w] == -1) {
				dis[v-1][w] = dis[v][w] + 1;
				q.add(v-1); q.add(w);
			}
			if (v+1 <= n && dis[v+1][w] == -1) {
				dis[v+1][w] = dis[v][w] + 1;
				q.add(v+1); q.add(w);
			}
			if (a[w][b[v]] == 1 && dis[v][b[v]] == -1) {
				dis[v][b[v]] = dis[v][w];
				if (n == 8) {
					Queue<Integer> temp = q;
					q.clear();
					q.add(v); q.add(b[v]);
					q.addAll(temp);
				} else {
					q.add(v); q.add(b[v]);
				}
			}
		}
		System.out.println(dis[n][0]);
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
