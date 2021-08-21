import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int l = readInt(), d = readInt();
		int[][] array = new int[d][l];
		for (int i = 0; i < d; i++) {
			for (int j = 0; j < l; j++) {
				array[i][j] = readInt();
			}
		}
		int[][] direction = {{1,0},{-1,0},{0,1}};
		Queue<Integer> q = new LinkedList();
		int[][] dis = new int[d][l];
		for (int i = 0; i < d; i++) {
			Arrays.fill(dis[i],(int)1e9);
		}
		dis[0][0] = array[0][0]; q.add(0); q.add(0);
		while (!q.isEmpty()) {
			int x = q.poll(), y = q.poll();
			for (int k = 0; k < 3; k++) {
				int newx = x + direction[k][0], newy = y + direction[k][1];
				if (newx >= 0 && newx < l && newy >= 0 && newy < d) {
					if (dis[y][x] + array[newy][newx] < dis[newy][newx]) {
						dis[newy][newx] = dis[y][x] + array[newy][newx];
						q.add(newx); q.add(newy);
					}
				}
			}
		}
		int a = readInt(), b = readInt();
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
