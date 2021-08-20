import java.util.*;
import java.io.*;
public class Template {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		String[] array = new String[n];
		for (int i = 0; i < n; i++) {
			array[i] = next();
		}
		for (int a = 0; a < 10; a++) {
			String str = next();
			ArrayList<String> list = new ArrayList<String>();
			for (int i = 0; i < n; i++) {
				if (str.indexOf(array[i]) != -1) {
					list.add(array[i]);
				}
			}
			int[] dp = new int[str.length()+1];
			Arrays.fill(dp, Integer.MAX_VALUE);
			dp[0] = -1;
			for (int i = 1; i <= str.length(); i++) {
				for (int j = 0; j < list.size(); j++) {
					if (i-list.get(j).length() >= 0 && str.substring(i-list.get(j).length(),i).equals(list.get(j))) {
						if (dp[i-list.get(j).length()] != Integer.MAX_VALUE) {
							dp[i] = Math.min(dp[i], dp[i-list.get(j).length()] + 1);
						}
					}
				}
			}
			System.out.println(dp[str.length()]);
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
