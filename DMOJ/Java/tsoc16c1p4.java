import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int r = readInt(), c = readInt();
		char[][] array = new char[r][c];
		for (int i = 0; i < r; i++) {
			String str = next();
			for (int j = 0; j < c; j++) {
				array[i][j] = str.charAt(j);
			}
		}
		int count = 0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (array[i][j] == 'M') {
					count++;
					Queue<Integer> q = new LinkedList();
					q.add(j); q.add(i);
					while (!q.isEmpty()) {
						int x = q.poll();
						int y = q.poll();
						if (x + 1 <= c-1 && array[y][x+1] != '#') {
							q.add(x+1); q.add(y);
							array[y][x+1] = '#';
						}
						if (y + 1 <= r-1 && array[y+1][x] != '#') {
							q.add(x); q.add(y+1);
							array[y+1][x] = '#';
						}
						if (x - 1 >= 0 && array[y][x-1] != '#') {
							q.add(x-1); q.add(y);
							array[y][x-1] = '#';
						}
						if (y - 1 >= 0 && array[y-1][x] != '#') {
							q.add(x); q.add(y-1);
							array[y-1][x] = '#';
						}
					}
				}
			}
		}
		System.out.println(count);
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
