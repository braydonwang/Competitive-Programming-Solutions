import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int max = Integer.MAX_VALUE;
	static int[][] array;
	public static void main(String[] args) throws IOException {
		array = new int[3][3];
		int cnt = 0, temp = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				String str = next();
				if (str.equals("X")) {
					cnt++;
					array[i][j] = max;
				} else {
					array[i][j] = Integer.parseInt(str);
					temp = array[i][j];
				}
			}
		}
		if (cnt == 9) {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					System.out.print(1 + " " );
				}
				System.out.println();
			}
			return;
		} else if (cnt == 8) {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					System.out.print(temp + " " );
				}
				System.out.println();
			}
			return;
		}
		// a b c
		//2*b = a + c
		//b = (a + c) / 2, a = 2*b - c, c = 2*b - a
		solve();
		if (array[1][1] == max) {
			array[1][1] = 10;
		}
		if (array[0][1] == max && array[2][1] != max) {
			array[0][1] = 2*array[1][1] - array[2][1];
		} else if (array[0][1] != max && array[2][1] == max) {
			array[2][1] = 2*array[1][1] - array[0][1];
		} else if (array[0][1] == max && array[2][1] == max) {
			array[0][1] = 24;
			array[2][1] = 2*array[1][1] - array[0][1];
		}
		solve();
		if (array[1][0] == max && array[1][2] != max) {
			array[1][0] = 2*array[1][1] - array[1][2];
		} else if (array[1][0] != max && array[1][2] == max) {
			array[1][2] = 2*array[1][1] - array[1][0];
		} else if (array[1][0] == max && array[1][2] == max) {
			array[1][0] = 24;
			array[1][2] = 2*array[1][1] - array[1][0];
		}
		solve();
		
		for (int i = 0; i < 3; i+=2) {
			if (array[i][0] != max && array[i][2] == max) {
				array[i][2] = 2*array[i][1] - array[i][0];
			} else if (array[i][0] == max && array[i][2] != max) {
				array[i][0] = 2*array[i][1] - array[i][2];
			} else if (array[i][0] == max && array[i][2] == max) {
				array[i][0] = 32;
				array[i][2] = 2*array[i][1] - array[i][0];
			}
			solve();
		}
		
		for (int i = 0; i < 3; i+=2) {
			if (array[0][i] != max && array[2][i] == max) {
				array[2][i] = 2*array[1][i] - array[0][i];
			} else if (array[0][i] == max && array[2][i] != max) {
				array[0][i] = 2*array[1][i] - array[2][i];
			} else if (array[0][i] == max && array[2][i] == max) {
				array[0][i] = 32;
				array[2][i] = 2*array[1][i] - array[0][i];
			}
			solve();
		}
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	}
	static void solve() {
		for (int j = 0; j < 2; j++) {
			for (int i = 0; i < 3; i++) {
				if (array[i][0] == max && array[i][1] != max && array[i][2] != max) {
					array[i][0] = 2*array[i][1] - array[i][2];
				} else if (array[i][0] != max && array[i][1] == max && array[i][2] != max) {
					array[i][1] = (array[i][0] + array[i][2]) / 2;
				} else if (array[i][0] != max && array[i][1] != max && array[i][2] == max) {
					array[i][2] = 2*array[i][1] - array[i][0];
				}
			}
			for (int i = 0; i < 3; i++) {
				if (array[0][i] == max && array[1][i] != max && array[2][i] != max) {
					array[0][i] = 2*array[1][i] - array[2][i];
				} else if (array[0][i] != max && array[1][i] == max && array[2][i] != max) {
					array[1][i] = (array[0][i] + array[2][i]) / 2;
				} else if (array[0][i] != max && array[1][i] != max && array[2][i] == max) {
					array[2][i] = 2*array[1][i] - array[0][i];
				}
			}
		}
	}
	static int readInt () throws IOException {
		return Integer.parseInt(next());
	}
	static String next () throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}
	static long readLong () throws IOException {
		return Long.parseLong(next());
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
