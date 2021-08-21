import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int r = readInt(), c = readInt();
		char[][] array = new char[r][c];
		for (int i = 0; i < r; i++) {
			String temp = next();
			for (int j = 0; j < c; j++) {
				array[i][j] = temp.charAt(j);
			}
		}
		String ans = "zzzzzzzzzzzzzz";
		for (int i = 0; i < r; i++) {
			int ind = 0;
			String str = "";
			while (ind < c) {
				if (array[i][ind] == '#') {
					break;
				}
				str += array[i][ind];
				ind++;
			}
			if (str.length() > 1 && str.compareTo(ans) < 0) {
				ans = str;
			}
		}
		for (int i = 0; i < c; i++) {
			int ind = 0;
			String str = "";
			while (ind < r) {
				if (array[ind][i] == '#') {
					break;
				}
				str += array[ind][i];
				ind++;
			}
			if (str.length() > 1 && str.compareTo(ans) < 0) {
				ans = str;
			}
		}
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (array[i][j] == '#') {
					int ind = i+1;
					String str = "";
					while (ind < r) {
						if (array[ind][j] == '#') {
							break;
						}
						str += array[ind][j];
						ind++;
					}
					if (str.length() > 1 && str.compareTo(ans) < 0) {
						ans = str;
					}
					ind = j+1;
					str = "";
					while (ind < c) {
						if (array[i][ind] == '#') {
							break;
						}
						str += array[i][ind];
						ind++;
					}
					if (str.length() > 1 && str.compareTo(ans) < 0) {
						ans = str;
					}
				}
			}
		}
		System.out.println(ans);
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
