import java.util.*;
import java.io.*;
public class Template {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		String str = readLine();
		int n = readInt();
		int[][] array = new int[str.length()+1][26];
		for (int i = 1; i <= str.length(); i++) {
			char ch = str.charAt(i-1);
			for (int j = 0; j < 26; j++) {
				if (ch == (char)(j+'a')) {
					array[i][j] = array[i-1][j] + 1;
				} else {
					array[i][j] = array[i-1][j];
				}
			}
		}
		for (int i = 0; i < n; i++) {
			int a = readInt(), b = readInt(), c = readCharacter()-'a';
			System.out.println(array[b][c] - array[a-1][c]);
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
