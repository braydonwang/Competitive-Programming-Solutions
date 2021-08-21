import java.util.*;
import java.io.*;
public class Template {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int k = readInt(), p = readInt(), x = readInt();
		int count = 1;
		double num = 0, pre = Integer.MAX_VALUE;
		while (true) {
			num = count * x + (k*p)/(count*1.0);
			if (num > pre) {
				String ans = Double.toString(Math.round(pre*1000.0) / 1000.0);
				int temp = ans.substring(ans.indexOf('.')).length();
				for (int i = temp; i <= 3; i++) {
					ans += "0";
				}
				System.out.println(ans);
				return;
			} else {
				pre = num;
			}
			count++;
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
