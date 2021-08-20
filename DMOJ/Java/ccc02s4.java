import java.util.*;
import java.io.*;
public class Template {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int mod = (int)(1e9 + 7);
	public static void main(String[] args) throws IOException {
		int m = readInt(), q = readInt();
		String[] name = new String[q+1];
		int[] speed = new int[q+1];
		for (int i = 1; i <= q; i++) {
			name[i] = next();
			speed[i] = readInt();
		}
		int[][] dp = new int[q+1][m+1];
		int[] path = new int[q+1];
		for (int i = 1; i <= q; i++) {
			for (int j = 1; j <= m; j++) {
				if (j == 1) {
					dp[i][j] = dp[i-1][j] + speed[i];
				} else {
					int slowest = speed[i];
					int min = Integer.MAX_VALUE;
					for (int k = 1; k <= j && i-k+1 >= 1; k++) {
						slowest = Math.max(speed[i-k+1], slowest);
						if (min > dp[i-k][j] + slowest) {
							min = dp[i-k][j] + slowest;
							path[i] = k;
						}
					}
					dp[i][j] = min;
				}
			}
		}
		ArrayList<String> list = new ArrayList<String>();
		int n = path[q];
		int person = q;
		while (person > 0) {
			String temp = name[person];
			for (int i = 1; i < n; i++) {
				temp = name[person-i] + " " + temp;
			}
			list.add(temp);
			person = person - n;
			if (person <= 0) {
				continue;
			}
			n = path[person];
		}
		System.out.println("Total Time: " + dp[q][m]);
		for (int i = list.size() - 1; i >= 0; i--) {
			System.out.println(list.get(i));
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
