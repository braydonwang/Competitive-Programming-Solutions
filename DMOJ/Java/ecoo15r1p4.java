import java.util.*;
import java.io.*;
public class Template {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		String[] array = {"ook","ookook","oog","ooga","ug","mook","mookmook","oogam","oogum","ugug"};
		for (int a = 0; a < 10; a++) {
			String str = next();
			int[] dp = new int[str.length()+1];
			dp[0] = 1;
			for (int i = 2; i <= str.length(); i++) {
				for (int j = 0; j < 10; j++) {
					if (i - array[j].length() >= 0 && str.substring(i-array[j].length(),i).equals(array[j])) {
						dp[i] += dp[i-array[j].length()];
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
