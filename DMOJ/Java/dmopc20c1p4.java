import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int max = 105;
	static int mod = (int)1e9+7;
	static int t;
	public static void main(String[] args) throws IOException {
		long n = readLong();
		int k = readInt();
		t = readInt();
		int c = readInt();
		Matrix x = new Matrix();
		x.d[t][t] = 1; x.d[0][t] = k;
		for (int i = 1; i <= t; i++) {
			x.d[i][i-1] = 1;
		}
		x = quickPower(x,n-1);
		long ans = 2*c*x.d[t][t] % mod;
		for(int i = 0; i < t; i++) {
			ans = (ans + c*x.d[i][t] % mod) % mod;
		}
		System.out.println(ans);
	}
	static Matrix quickPower(Matrix x, long exp) {
		Matrix ans = new Matrix();
		//identity matrix
		for (int i = 0; i <= t; i++) {
			ans.d[i][i] = 1;
		}
		while (exp > 0) {
			if (exp % 2 != 0) {
				ans = multiply(ans,x);
			}
			x = multiply(x,x); exp /= 2;
		}
		return ans;
	}
	static Matrix multiply(Matrix a, Matrix b) {
		Matrix ans = new Matrix();
		for (int i = 0; i <= t; i++) {
			for (int k = 0; k <= t; k++) {
				for (int j = 0; j <= t; j++) {
					ans.d[i][j] = (ans.d[i][j] + a.d[i][k] * b.d[k][j]) % mod;
				}
			}
		}
		return ans;
	}
	static class Matrix{
		long[][] d;
		Matrix(){
			d = new long[max][max];
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
