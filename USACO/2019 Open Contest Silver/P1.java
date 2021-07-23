import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static boolean[][] a;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		a = new boolean[n+1][n+1];
		for (int i = 1; i <= n; i++) {
			String str = next();
			for (int j = 1; j <= n; j++) {
				char ch = str.charAt(j-1);
				if (ch == 'R') {
					a[i][j] = true;
				} else {
					a[i][j] = false;
				}
			}
		}
		for (int j = 1; j <= n; j++) {
			if (a[1][j]) {
				for (int i = 1; i <= n; i++) {
					a[i][j] ^= true;
				}
			}
		}
		for (int i = 1; i <= n; i++) {
			if (a[i][1]) {
				for (int j = 1; j <= n; j++) {
					a[i][j] ^= true;
				}
			}
		}
		int temp = sum(2,n,2,n);
		if (temp == 1) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (a[i][j] == true) {
						System.out.println(i + " " + j);
						return;
					}
				}
			}
		} else if (temp == (n-1)*(n-1)) {
			System.out.println(1 + " " + 1);
			return;
		} else if (temp == n-1) {
			for (int i = 1; i <= n; i++) {
				if (sum(i,i,1,n) == n-1) {
					System.out.println(i + " " + 1);
					return;
				}
				if (sum(1,n,i,i) == n-1) {
					System.out.println(1 + " " + i);
					return;
				}
			}
		} else {
		    System.out.println(-1);
		}
	}
	static int sum(int e, int b, int c, int d) {
		int total = 0;
		for (int i = e; i <= b; i++) {
			for (int j = c; j <= d; j++) {
				if (a[i][j]) {
					total++;
				}
			}
		}
		return total;
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
