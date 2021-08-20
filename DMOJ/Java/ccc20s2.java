import java.util.*;
import java.io.*;
public class Template {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int m = readInt(), n = readInt();
		boolean[][] vis = new boolean[m+1][n+1];
		boolean[] num = new boolean[1000005];
		int[][] array = new int[m+1][n+1];
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				array[i][j] = readInt();
			}
		}
		Queue<Integer> q = new LinkedList();
		q.add(1); q.add(1); vis[1][1] = true; num[array[1][1]] = true;
		while (!q.isEmpty()) {
			int x = q.poll(), y = q.poll();
			int a = array[y][x];
			num[a] = true;
			for (int i = 1; i <= Math.sqrt(a); i++) {
				if (a % i == 0) {
					int temp = a / i;
					if (i <= m && temp <= n && !vis[i][temp]) {
						vis[i][temp] = true;
						if (!num[array[i][temp]]) {
							q.add(temp); q.add(i);
						}
					}
					if (i <= n && temp <= m && !vis[temp][i]) {
						vis[temp][i] = true;
						if (!num[array[temp][i]]) {
							q.add(i); q.add(temp);
						}
					}
				}
			}
			if (vis[m][n]) {
				break;
			}
		}
		if (vis[m][n]) {
			System.out.println("yes");
		} else {
			System.out.println("no");
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
