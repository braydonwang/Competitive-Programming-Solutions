import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		long[][] pre = new long[652][652];
		long[][] temp = new long[652][652];
		int[] a = new int[n], b = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = readInt()+1; b[i] = readInt()+1;
			temp[a[i]][b[i]]++;
		}
		for (int i = 1; i <= 651; i++) {
			for (int j = 1; j <= 651; j++) {
				pre[i][j] = temp[i][j] + pre[i-1][j] + pre[i][j-1] - pre[i-1][j-1];
			}
		}
		for (int i = 0; i < n; i++) {
			System.out.print(pre[651][651] - pre[a[i]][651] - pre[651][b[i]] + pre[a[i]][b[i]] + 1);
			long num = n - pre[a[i]-1][b[i]-1];
			if (a[i] == 651) {
				num -= temp[1][b[i]];
			}
			if (b[i] == 651) {
				num -= temp[a[i]][1];
			}
			System.out.println(" " + num);
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
