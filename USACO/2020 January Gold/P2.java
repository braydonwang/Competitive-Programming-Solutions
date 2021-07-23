import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), q = readInt();
		int mv = (int) (1e6 + 3);
		long[][] pre = new long[n+1][n+1];
		int[] count = new int[2*mv];
		int[] array = new int[n+1];
		for (int i = 1; i <= n; i++) {
			array[i] = readInt();
		}
		for (int i = n-1; i >= 1; i--) {
			for (int k = i+1; k <= n; k++) {
				int val = mv -(array[i] + array[k]);
				if (val >= 0 && val < 2*mv) {
					pre[i][k] = count[val];
				}
				count[array[k]+mv]++;
			}
			for (int k = i+1; k <= n; k++) {
				count[array[k]+mv]--;
			}
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				pre[i][j] += pre[i-1][j] + pre[i][j-1] - pre[i-1][j-1];
			}
		}
		for (int i = 0; i < q; i++) {
			int a = readInt(), b = readInt();
			System.out.println(pre[b][b] - pre[a-1][b] - pre[b][a-1] + pre[a-1][a-1]);
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
