import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int logn = 64;
	static int[][][] exponents;
	static int n;
	public static void main(String[] args) throws IOException {
		n = readInt();
		long k = readLong();
		exponents = new int[logn][n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				exponents[0][i][j] = readInt();
			}
		}
		for (int i = 1; i < logn; i++) {
			exponents[i] = multiply(exponents[i-1],exponents[i-1]);
		}
		//matrix multiplication
		//if row = col, length increases (4 -> 3, 1 -> 4, can make 1 -> 4 -> 3)
		int[][] ans = binaryExponentiation(k-1);
		int total = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				total = (total + ans[i][j]);
			}
		}
		System.out.println(total);
	}
	static int[][] multiply(int[][] a, int[][] b){
		int[][] ret = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					ret[i][j] = (ret[i][j] + (a[i][k]*b[k][j]));
				}
			}
		}
		return ret;
	}
	static int[][] binaryExponentiation(long k){
		int[][] ret = exponents[0];
		for (int i = logn-1; i >= 0; i--) {
			if (((k >> i) & 1) == 1) {
				ret = multiply(ret,exponents[i]);
			}
		} 
		return ret;
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
