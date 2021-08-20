import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] a = {{0,1,1,1,0},{0,2,1,2,0},{0,0,2,0,0},{0,0,0,0,0},{0,0,0,0,0}};
	public static void main(String[] args) throws IOException {
		int t = readInt();
		for (int z = 0; z < t; z++) {
			int m = readInt(), x = readInt(), y = readInt();
			System.out.println(solve(m,x,y) ? "crystal" : "empty");
		}
	}
	static boolean solve(int m, int x, int y) {
		int tempx = (int) (x / Math.pow(5, m-1)), tempy = (int) (y / Math.pow(5, m-1));
		if (a[tempy][tempx] == 1) {
			return true;
		} else if (a[tempy][tempx] == 0 || (a[tempy][tempx] == 2 && m == 1)) {
			return false;
		} else {
			return solve(m-1,(int)(x%Math.pow(5, m-1)),(int)(y%Math.pow(5, m-1)));
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
