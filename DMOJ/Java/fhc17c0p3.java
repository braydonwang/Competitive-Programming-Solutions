import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int t = readInt();
		for (int q = 1; q <= t; q++) {
			int h = readInt(), s = readInt();
			double ans = 0;
			for (int i = 0; i < s; i++) {
				String str = next();
				int x = 0, y = 0, z = 0;
				if (str.indexOf("+") != -1) {
					x = Integer.parseInt(str.substring(0,str.indexOf("d")));
					y = Integer.parseInt(str.substring(str.indexOf("d")+1,str.indexOf("+")));
					z = Integer.parseInt(str.substring(str.indexOf("+")+1));
				} else if (str.indexOf("-") != -1) {
					x = Integer.parseInt(str.substring(0,str.indexOf("d")));
					y = Integer.parseInt(str.substring(str.indexOf("d")+1,str.indexOf("-")));
					z = -Integer.parseInt(str.substring(str.indexOf("-")+1));
				} else {
					x = Integer.parseInt(str.substring(0,str.indexOf("d")));
					y = Integer.parseInt(str.substring(str.indexOf("d")+1));
				}
				ans = Math.max(ans,solve(x,y,z,h));
			}
			System.out.println("Case #" + q + ": " + ans);
		}
	}
	static double solve(int x, int y, int z, int h) {
		if (z >= h) {
			return 1.0;
		} else if (y*x + z < h) {
			return 0.0;
		}
		double[][] dp = new double[x+1][h-z+1];
		dp[0][0] = 1.0;
		for (int i = 1; i <= x; i++) {
			for (int j = 0; j <= h-z; j++) {
				for (int k = 1; k <= y; k++) {
					dp[i][Math.min(h-z, j+k)] += dp[i-1][j] * 1.0/y;
				}
			}
		}
		return dp[x][h-z];
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
