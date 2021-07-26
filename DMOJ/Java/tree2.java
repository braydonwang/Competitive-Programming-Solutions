import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int r = readInt(), c = readInt();
		int sx = 0, sy = 0, max = 0, ex = 0, ey = 0;
		double d = Double.MAX_VALUE;
		ArrayList<Integer> list = new ArrayList<Integer>();
		int[][] array = new int[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				char ch = next().charAt(0);
				if (ch == 'X') {
					sx = j; sy = i;
				} else if (ch != '.') {
					array[i][j] = ch - '0';
				}
				if (array[i][j] > max) {
					max = array[i][j];
					list.clear();
					list.add(i); list.add(j);
				} else if (array[i][j] == max) {
					list.add(i); list.add(j);
				}
			}
		}
		for (int i = 0; i < list.size(); i += 2) {
			int a = list.get(i), b = list.get(i+1);
			double temp = Math.sqrt((b-sx)*(b-sx) + (a-sy)*(a-sy));
			if (temp < d) {
				d = temp;
				ex = b; ey = a;
			}
		}
		Queue<Integer> q = new LinkedList();
		Pair[][] dis = new Pair[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				dis[i][j] = new Pair(Integer.MAX_VALUE,Integer.MAX_VALUE);
			}
		}
		int[][] direction = {{0,1},{0,-1},{1,0},{-1,0}};
		q.add(sx); q.add(sy); dis[sy][sx] = new Pair(0,0);
		while (!q.isEmpty()) {
			int x = q.poll(), y = q.poll();
			for (int i = 0; i < 4; i++) {
				int newx = x + direction[i][0], newy = y + direction[i][1];
				if (newx >= 0 && newx < c && newy >= 0 && newy < r) {
					if (dis[y][x].h + array[newy][newx] < dis[newy][newx].h) {
						dis[newy][newx].h = dis[y][x].h + array[newy][newx];
						if (array[newy][newx] > 0) {
							dis[newy][newx].t = dis[y][x].t + 1;
						} else {
							dis[newy][newx].t = dis[y][x].t;
						}
						q.add(newx); q.add(newy);
					} else if (dis[y][x].h + array[newy][newx] == dis[newy][newx].h) {
						int temp = 0;
						if (array[newy][newx] > 0) {
							temp = dis[y][x].t + 1;
						} else {
							temp = dis[y][x].t;
						}
						if (temp < dis[newy][newx].t) {
							dis[newy][newx].t = temp;
							q.add(newx); q.add(newy);
						}
					}
				}
			}
		}
		System.out.println(dis[ey][ex].t-1);
	}
	static class Pair{
		int h, t;
		Pair(int h, int t){
			this.h = h;
			this.t = t;
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
