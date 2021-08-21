import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), h = readInt();
		int c = h, o = h;
		int[][] array = new int[2][n];
		int[][] array2 = new int[2][n];
		for (int i = 0; i < n; i++) {
			array[0][i] = readCharacter();
			array[1][i] = readInt();
		}
		for (int i = 0; i < n; i++) {
			array2[0][i] = readCharacter();
			array2[1][i] = readInt();
		}
		for (int i = 0; i < n; i++) {
			if (array[0][i] == 'A') {
				o -= array[1][i];
			} else {
				if (array2[0][i] == 'A') {
					array2[1][i] = 0;
				} else {
					c -= array[1][i];
				}
			}
			if (c <= 0) {
				System.out.println("DEFEAT");
				return;
			} else if (o <= 0) {
				System.out.println("VICTORY");
				return;
			}
			if (array2[0][i] == 'A') {
				c -= array2[1][i];
			} else {
				if (i + 1 < n && array[0][i+1] == 'A') {
					array[1][i+1] = 0;
				} else {
					o -= array2[1][i];
				}
			}
			if (c <= 0) {
				System.out.println("DEFEAT");
				return;
			} else if (o <= 0) {
				System.out.println("VICTORY");
				return;
			}
		}
		System.out.println("TIE");
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
