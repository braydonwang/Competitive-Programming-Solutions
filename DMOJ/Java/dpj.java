import java.util.*;
import java.io.*;
public class Template {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int one = 0, two = 0, three = 0;
		for (int i = 0; i < n; i++) {
			int num = readInt();
			if (num == 1) {
				one++;
			} else if (num == 2) {
				two++;
			} else {
				three++;
			}
		}
		//all threes can turn into twos and all two and threes can turn into ones
		double[][][] dp = new double[one+two+three+1][two+three+1][three+1];
		for (int c = 0; c <= three; c++) {
			//loop for every two and three subtract the number of threes in c
			for (int b = 0; b <= two+three-c; b++) {
				//loop for every one, two and three subtract the number of twos and threes in b
				for (int a = 0; a <= one+two+three-b; a++) {
					if (a == 0 && b == 0 && c == 0) {
						dp[a][b][c] = 0;
					} else {
						double ans = ((n*1.0)/(a+b+c));
						if (a > 0) {
							//you take the expected number of turns where there is one less 1 and 
							//you add the expected number of turns to choose a one, two or three
							//and multiply by the probability of choosing a one from the total number
							//of one, two and threes
							ans += (dp[a-1][b][c]) * ((a*1.0)/(a+b+c));
						}
						if (b > 0) {
							ans += (dp[a+1][b-1][c]) * ((b*1.0)/(a+b+c));
						}
						if (c > 0) {
							ans += (dp[a][b+1][c-1]) * ((c*1.0)/(a+b+c));
						}
						dp[a][b][c] = ans;
					}
				}
			}
		}
		System.out.println(dp[one][two][three]);
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
