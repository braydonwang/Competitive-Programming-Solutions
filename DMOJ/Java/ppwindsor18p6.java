import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int col = readInt(), row = readInt();
		char[][] array = new char[row][col];
		int sx = 0, sy = 0;
		for (int i = 0; i < row; i++) {
			String str = next();
			for (int j = 0; j < col; j++) {
				array[i][j] = str.charAt(j);
				if (array[i][j] == '1') {
					sx = j; sy = i;
				}
			}
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		int[][] direction = {{1,0},{-1,0},{0,1},{0,-1}};
		Queue<Integer> q = new LinkedList();
		boolean[][] vis = new boolean[row][col];
		q.add(sx); q.add(sy); vis[sy][sx] = true;
		while (!q.isEmpty()) {
			int x = q.poll(), y = q.poll();
			for (int i = 0; i < 4; i++) {
				int newx = x + direction[i][0];
				int newy = y + direction[i][1];
				if (newx >= 0 && newx < col && newy >= 0 && newy < row && array[newy][newx] != '#' && !vis[newy][newx]) {
					q.add(newx); q.add(newy); vis[newy][newx] = true;
					if (array[newy][newx] >= '1' && array[newy][newx] <= '9') {
						list.add(array[newy][newx] - '0');
					}
				}
			}
		}
		Collections.sort(list);
		System.out.print(1 + " ");
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
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
