import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int r = readInt(), c = readInt();
		int sr = readInt(), sc = readInt();
		int or = readInt(), oc = readInt();
		char[][] array = new char[r][c];
		for (int i = 0; i < r; i++) {
			String str = next();
			for (int j = 0; j < c; j++) {
				array[i][j] = str.charAt(j);
			}
		}
		int a = readInt();
		int[] devicer = new int[a];
		int[] devicec = new int[a];
		for (int i = 0; i < a; i++) {
			devicer[i] = readInt(); devicec[i] = readInt();
		}
		Queue<Integer> q = new LinkedList();
		boolean[][] vis = new boolean[r][c];
		int[][] dis = new int[r][c];
		q.add(sc); q.add(sr); vis[sr][sc] = true; dis[sr][sc] = 0;
		while (!q.isEmpty()) {
			int x = q.poll();
			int y = q.poll();
			if (x + 1 <= c-1 && array[y][x+1] != 'X' && !vis[y][x+1]) {
				q.add(x+1); q.add(y); vis[y][x+1] = true; dis[y][x+1] = dis[y][x]+1;
			}
			if (y + 1 <= r-1 && array[y+1][x] != 'X' && !vis[y+1][x]) {
				q.add(x); q.add(y+1); vis[y+1][x] = true; dis[y+1][x] = dis[y][x]+1;
			}
			if (x - 1 >= 0 && array[y][x-1] != 'X' && !vis[y][x-1]) {
				q.add(x-1); q.add(y); vis[y][x-1] = true; dis[y][x-1] = dis[y][x]+1;
			}
			if (y - 1 >= 0 && array[y-1][x] != 'X' && !vis[y-1][x]) {
				q.add(x); q.add(y-1); vis[y-1][x] = true; dis[y-1][x] = dis[y][x]+1;
			}
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < a; i++) {
			if (vis[devicer[i]][devicec[i]]) {
				min = Math.min(dis[devicer[i]][devicec[i]], min);
			}
		}
		if (dis[or][oc] < min){
		    System.out.println(0);
		} else{
		    System.out.println(dis[or][oc] - min);
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
