import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int MM = (int)1e5+4;
        int N = readInt(), M = readInt(), K = readInt();
        String s = next();
        int dis[][] = new int [26][26], psa[][] = new int [MM][26], dp[] = new int [MM], best[][] = new int [MM][26];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                dis[i][j] = readInt();
            }
        }
        for (int k = 0; k < M; k++) {
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < M; j++) {
                    dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[k][j]);
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < M; j++) {
                psa[i][j] = psa[i-1][j] + dis[s.charAt(i-1) - 'a'][j];
            }
        }
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = K; i <= N; i++) {
            for (int p = 0; p < M; p++) {
                dp[i] = Math.min(dp[i], best[i-K][p] + psa[i][p]);
            }
            for (int p = 0; p < M; p++) {
                best[i][p] = Math.min(best[i-1][p], dp[i] - psa[i][p]);
            }
        }
        System.out.println(dp[N]);
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
