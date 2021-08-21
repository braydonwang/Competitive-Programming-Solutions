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
				if (array[i][j] == '.') {
					int dot = 0, snake = 0;
					if (i - 1 >= 0 && array[i-1][j] == '.') {
						dot++;
					}
					else if (i - 1 >= 0 && array[i-1][j] == 'S'){
						snake++;
					}
					if (i + 1 < r && array[i+1][j] == '.') {
						dot++;
					}
					else if (i + 1 < r && array[i+1][j] == 'S'){
						snake++;
					}
					if (j - 1 >= 0 && array[i][j-1] == '.') {
						dot++;
					}
					else if (j - 1 >= 0 && array[i][j-1] == 'S'){
						snake++;
					}
					if (j + 1 < c && array[i][j+1] == '.') {
						dot++;
					}
					else if (j + 1 < c && array[i][j+1] == 'S'){
						snake++;
					}
					if (j - 1 >= 0 && i - 1 >= 0 && array[i-1][j-1] == '.') {
						dot++;
					}
					else if (j - 1 >= 0 && i - 1 >= 0 && array[i-1][j-1] == 'S'){
						snake++;
					}
					if (j - 1 >= 0 && i + 1 < r && array[i+1][j-1] == '.') {
						dot++;
					}
					else if (j - 1 >= 0 && i + 1 < r && array[i+1][j-1] == 'S'){
						snake++;
					}
					if (j + 1 < c && i - 1 >= 0 && array[i-1][j+1] == '.') {
						dot++;
					}
					else if (j + 1 < c && i - 1 >= 0 && array[i-1][j+1] == 'S'){
						snake++;
					}
					if (j + 1 < c && i + 1 < r && array[i+1][j+1] == '.') {
						dot++;
					}
					else if (j + 1 < c && i + 1 < r && array[i+1][j+1] == 'S'){
						snake++;
					}
					if (dot > snake) {
						count++;
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
