import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), t = readInt();
		char[][] array = new char[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				array[i][j] = next().charAt(0);
			}
		}
		int[][] direction = {{0,1},{0,-1},{1,0},{-1,0},{-1,-1},{-1,1},{1,-1},{1,1}};
		for (int i = 0; i < t; i++) {
			String str = next();
			boolean good = false;
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					if (array[j][k] == str.charAt(0)) {
						Queue<Integer> q = new LinkedList();
						boolean[][] vis = new boolean[n][n];
						int[][] dis = new int[n][n];
						q.add(k); q.add(j); vis[j][k] = true;
						while (!q.isEmpty()) {
							int x = q.poll(), y = q.poll();
							vis[y][x] = true;
							if (dis[y][x] == str.length()-1) {
								good = true;
								break;
							}
							for (int l = 0; l < 8; l++) {
								int newx = x + direction[l][0], newy = y + direction[l][1];
								if (newx >= 0 && newx < n && newy >= 0 && newy < n && !vis[newy][newx] && array[newy][newx] == str.charAt(dis[y][x]+1)) {
									q.add(newx); q.add(newy); dis[newy][newx] = dis[y][x] + 1;
								}
							}
						}
					}
					if (good) {
						break;
					}
				}
				if (good) {
					break;
				}
			}
			if (good) {
				System.out.println("good puzzle!");
			} else {
				System.out.println("bad puzzle!");
			}
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
