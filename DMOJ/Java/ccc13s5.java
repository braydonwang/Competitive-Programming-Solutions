import java.util.*;
import java.io.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), ans = 0;
		while (n > 1) {
			//System.out.println("n = " + n);
			//find the smallest number that divides n
			for (int i = 2; i <= n; i++) {
				if (n % i == 0) {
					//temp is the other factor (n = i * temp)
					int temp = n / i;
					//System.out.println(temp + " " + i);
					//subtract the larger factor (trying to minimize cost)
					n -= temp;
					//System.out.println(n);
					ans += n/temp;
					//System.out.println(ans);
					break;
				}
			}
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
