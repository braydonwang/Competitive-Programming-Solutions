import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		for (int i = 0; i < 5; i++) {
			char[][] array = new char[10][10];
			Queue<Integer> q = new LinkedList();
			int[][] dis = new int[10][10];
			for (int j = 0; j < 10; j++) {
				String str = next();
				for (int k = 0; k < 10; k++) {
					array[j][k] = str.charAt(k);
					if (array[j][k] == 'F') {
						q.add(k); q.add(j);
					}
				}
			}
			int time = 0;
			while (!q.isEmpty()) {
				int x = q.poll();
				int y = q.poll();
				if (x - 1 >= 0 && array[y][x-1] == 'T') {
					array[y][x-1] = 'F';
					q.add(x-1);
					q.add(y);
					dis[y][x-1] = dis[y][x]+1;
					time = Math.max(dis[y][x-1], time);
				}
				if (y - 1 >= 0 && array[y-1][x] == 'T') {
					array[y-1][x] = 'F';
					q.add(x);
					q.add(y-1);
					dis[y-1][x] = dis[y][x]+1;
					time = Math.max(dis[y-1][x], time);
				}
				if (y + 1 <= 9 && array[y+1][x] == 'T') {
					array[y+1][x] = 'F';
					q.add(x);
					q.add(y+1);
					dis[y+1][x] = dis[y][x]+1;
					time = Math.max(dis[y+1][x], time);
				}
				if (x + 1 <= 9 && array[y][x+1] == 'T') {
					array[y][x+1] = 'F';
					q.add(x+1);
					q.add(y);
					dis[y][x+1] = dis[y][x]+1;
					time = Math.max(dis[y][x+1], time);
				}
			}
			boolean survive = false;
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k < 10; k++) {
					if (array[j][k] == 'T') {
						System.out.println(-1);
						survive = true;
						break;
					}
				}
				if (survive){
				    break;
				}
			}
			if (!survive) {
				System.out.println(time);
			}
			String str = readLine();
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
