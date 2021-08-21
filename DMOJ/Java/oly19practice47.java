import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int N = readInt(), L = readInt();
		int[] p = new int[N+1];
	    for(int i=1; i<=N; i++){
	       p[i] = readInt();
	    }
	    p[0] = L; N++; Arrays.sort(p);
	    int st = 0;
	    for (int i = 0; i <= N; i++) {
	    	if (p[i] == L) {
	    		st = i;
	    		break;
	    	}
	    }
	    long[][][] dp = new long[N+1][N+1][2];
	    for (int i = 0; i <= N; i++) {
	    	for (int j = 0; j <= N; j++) {
	    		Arrays.fill(dp[i][j], (long)1e12);
	    	}
	    }
	    dp[st][st][0]=dp[st][st][1]=0;
	    for(int len=1; len<=N; len++){
	        for(int l=0; l+len<N; l++){
	            int r = l + len;
	            dp[l][r][0] = Math.min(dp[l][r][0], dp[l+1][r][0]+1L*(N-len)*(p[l+1]-p[l]));
	            dp[l][r][0] = Math.min(dp[l][r][0], dp[l+1][r][1]+1L*(N-len)*(p[r]-p[l]));
	            dp[l][r][1] = Math.min(dp[l][r][1], dp[l][r-1][0]+1L*(N-len)*(p[r]-p[l]));
	            dp[l][r][1] = Math.min(dp[l][r][1], dp[l][r-1][1]+1L*(N-len)*(p[r]-p[r-1]));
	            //System.out.println(dp[l][r][0] + " " + dp[l][r][1] + " " + l + " " + r);
	        }
	    }
	    System.out.println(Math.min(dp[0][N-1][0], dp[0][N-1][1]));
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
