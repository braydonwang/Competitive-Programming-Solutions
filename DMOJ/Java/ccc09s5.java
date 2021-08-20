import java.util.*;
import java.io.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int m = readInt(), n = readInt(), k = readInt();
		int[][] array = new int[m][n+1];
		for (int i = 0; i < k; i++) {
			int x = readInt(), y = readInt(), r = readInt(), b = readInt();
			x--; y--;
			for (int j = Math.max(0, y-r); j <= Math.min(m-1, y+r); j++) {
				int left = Math.max(0,(int) Math.ceil(((-1*Math.sqrt(r*r - ((j-y) * (j-y)))) + x)));
				int right = Math.min(n-1,(int) (Math.sqrt(r*r - ((j-y) * (j-y))) + x));
				array[j][left] += b;
				array[j][right+1] -= b;
			}
		}
		int[][] ans = new int[m][n];
		int max = 0, count = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (j == 0) {
					ans[i][j] = array[i][j];
				} else {
					ans[i][j] = ans[i][j-1] + array[i][j];
				}
				if (ans[i][j] == max) {
					count++;
				} else if (ans[i][j] > max) {
					max = ans[i][j];
					count = 1;
				}
			}
		}
		System.out.println(max);
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
