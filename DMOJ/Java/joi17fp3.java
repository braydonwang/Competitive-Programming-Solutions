import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt();
		char[][] array = new char[3003][3003];
		for (int i = 1; i <= n; i++) {
			String str = next();
			for (int j = 1; j <= m; j++) {
				array[i][j] = str.charAt(j-1);
			}
		}
		int[][] dp = new int[6006][3];
		int ans = 0;
		for (int i = 1; i <= n+m-1; i++){
		    int s = 1;
		    for (int r = Math.min(i,n), c = Math.max(1,i-n+1); r > 0 && c <= m; r--, c++, s++){
		        dp[s][0] = Math.max(dp[s-1][0], Math.max(dp[s-1][1], dp[s-1][2]));
		        dp[s][1] = dp[s][2] = 0;
		        if (array[r-1][c] == 'R' && array[r][c] == 'G' && array[r+1][c] == 'W') {
					dp[s][1] = Math.max(dp[s-1][0],dp[s-1][1])+1;
				}
				if (array[r][c-1] == 'R' && array[r][c] == 'G' && array[r][c+1] == 'W') {
					dp[s][2] = Math.max(dp[s-1][0],dp[s-1][2])+1;
				}
		    }
		    ans += Math.max(dp[s-1][0],Math.max(dp[s-1][1],dp[s-1][2]));
		}
		
		System.out.println(ans);
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
