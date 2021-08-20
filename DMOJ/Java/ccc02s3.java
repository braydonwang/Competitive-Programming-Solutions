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
		int m = readInt();
		char[] moves = new char[m];
		for (int i = 0; i < m; i++) {
			moves[i] = next().charAt(0);
		}
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (array[i][j] != 'X') {
					for (int d = 0; d < 4; d++) {
						boolean done = true;
						int x = j;
						int y = i;
						int dir = d;
						for (int a = 0; a < m; a++){
							if (moves[a] == 'F') {
								if (dir == 0) {
									y--;
								} else if (dir == 1) {
									x++;
								} else if (dir == 2) {
									y++;
								} else {
									x--;
								}
							} else if (moves[a] == 'R') {
								dir = (dir+1)%4;
							} else {
								dir = (dir+3)%4;
							}
							if (x < 0 || x >= c || y < 0 || y >= r || array[y][x] == 'X') {
								done = false;
								break;
							}
						}
						if (done) {
							array[y][x] = '*';
						}
					}
				}
			}
		}
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print(array[i][j]);
			}
			System.out.println();
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
