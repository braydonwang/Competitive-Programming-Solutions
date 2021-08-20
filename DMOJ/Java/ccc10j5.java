import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt(), a = readInt(), b = readInt();
		boolean[][] vis = new boolean[9][9];
		int[][] dis = new int[9][9];
		Queue<Integer> q = new LinkedList();
		q.add(n); q.add(m); vis[m][n] = true; dis[m][n] = 0;
		while (!q.isEmpty()) {
			int x = q.poll();
			int y = q.poll();
			if (x + 2 <= 8 && y + 1 <= 8 && !vis[y+1][x+2]) {
				q.add(x+2); q.add(y+1); vis[y+1][x+2] = true; dis[y+1][x+2] = dis[y][x] + 1;
			}
			if (x + 2 <= 8 && y - 1 >= 1 && !vis[y-1][x+2]) {
				q.add(x+2); q.add(y-1); vis[y-1][x+2] = true; dis[y-1][x+2] = dis[y][x] + 1;
			}
			if (x + 1 <= 8 && y + 2 <= 8 && !vis[y+2][x+1]) {
				q.add(x+1); q.add(y+2); vis[y+2][x+1] = true; dis[y+2][x+1] = dis[y][x] + 1;
			}
			if (x + 1 <= 8 && y - 2 >= 1 && !vis[y-2][x+1]) {
				q.add(x+1); q.add(y-2); vis[y-2][x+1] = true; dis[y-2][x+1] = dis[y][x] + 1;
			}
			if (x - 1 >= 1 && y + 2 <= 8 && !vis[y+2][x-1]) {
				q.add(x-1); q.add(y+2); vis[y+2][x-1] = true; dis[y+2][x-1] = dis[y][x]+1;
			}
			if (x - 1 >= 1 && y - 2 >= 1 && !vis[y-2][x-1]) {
				q.add(x-1); q.add(y-2); vis[y-2][x-1] = true; dis[y-2][x-1] = dis[y][x]+1;
			}
			if (x - 2 >= 1 && y + 1 <= 8 && !vis[y+1][x-2]) {
				q.add(x-2); q.add(y+1); vis[y+1][x-2] = true; dis[y+1][x-2] = dis[y][x] + 1;
			}
			if (x - 2 >= 1 && y - 1 >= 1 && !vis[y-1][x-2]) {
				q.add(x-2); q.add(y-1); vis[y-1][x-2] = true; dis[y-1][x-2] = dis[y][x] + 1;
			}
			if (vis[b][a]) {
				break;
			}
		}
		System.out.println(dis[b][a]);
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
