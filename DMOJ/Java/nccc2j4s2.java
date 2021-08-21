import java.util.*;
import java.io.*;
public class Template {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int[][] array = new int[3][2];
		int area = 0;
		for (int i = 0; i < 3; i++) {
			int x = readInt(), y = readInt();
			array[i][0] = x; array[i][1] = y;
		}
		int x1 = 0, x2 = 0, y1 = 0, y2 = 0;
		if (Math.sqrt(area) == (int)(Math.sqrt(area))) {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 2; j++) {
					int s = array[i][j];
					int a = array[i][(j+1)%2];
					
					int x = s;
					int y = s-a;
					
					x1 = 0; y1 = 0; x2 = 0; y2 = 0;
					for (int k = 0; k < 3; k++) {
						if (i != k) {
							if (x1 == 0) {
								x1 = array[k][0];
								y1 = array[k][1];
							} else if (x2 == 0) {
								x2 = array[k][0];
								y2 = array[k][1];
							}
						}
					}
					
					for (int l = 0; l < 2; l++) {
						if (x1 == x2 && x2 == x && (y2 == y - y1 || y1 == y - y2)) {
							System.out.println("YES");
							return;
						}
						if (x1 == x2 && x2 == y && (y2 == x - y1 || y1 == x - y2)) {
							System.out.println("YES");
							return;
						}
						if (y2 == y1 && y2 == y && (x2 == x - x1 || x1 == x - x2)) {
							System.out.println("YES");
							return;
						}
						if (y2 == y1 && y2 == x && (x2 == y - x1 || x1 == y - x2)) {
							System.out.println("YES");
							return;
						}
						int temp = x1;
						x1 = y1;
						y1 = temp;
					}
				}
			}
		}
		System.out.println("NO");
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
