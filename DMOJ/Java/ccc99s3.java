import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int d = readInt();
		for (int i = 0; i < d; i++) {
			int n = readInt(), b = readInt(), t = readInt(), l = readInt(), r = readInt();
			int[][] array = new int[(int) Math.pow(3, n)][(int) Math.pow(3, n)];
			int[][] arr = new int[(int) Math.pow(3, n)][(int) Math.pow(3, n)];
			arr = fractal(n,n,array);
			for (int j = (int) ((Math.pow(3, n))-t); j <= (Math.pow(3, n))-t + (t-b); j++) {
				for (int k = l-1; k <= r-1; k++) {
					if (array[j][k] == 1) {
						System.out.print("  ");
					}
					else {
						System.out.print("* ");
					}
				}
				System.out.println();
			}
			System.out.println();
		}
	}
	static int[][] fractal(int n, int count, int[][] array){
		if (count == 0) {
			return array;
		}
		int num = (int) (Math.pow(3, count));
		int temp = (int)(Math.pow(3,(n-count)*2));
		int x = (int) (Math.pow(3, count-1));
		int y = (int) (Math.pow(3, count-1));
		int z = (int) (Math.pow(3, count-1));
		for (int a = 1; a <= temp; a++) {
			for (int i = x; i < x+z; i++) {
				for (int j = y; j < y+z; j++) {
					array[i][j] = 1;
				} 
			}
			if (a % Math.pow(3, n-count) == 0) {
				x += num;
				y = z;
			}
			else {
				y += num;
			}
		}
		return fractal(n,count-1,array);
	}
	static boolean isValid(String str) {
		str.replaceAll(",", "");
		if (str.length() == 8 && str.charAt(0) >= 48 && str.charAt(0) <= 57) {
			return true;
		}
		else {
			return false;
		}
	}
	static boolean isNumber(char ch) {
		if (ch >= 48 && ch <= 57) {
			return true;
		}
		return false;
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
