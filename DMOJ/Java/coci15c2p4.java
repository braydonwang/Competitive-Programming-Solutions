import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), base = 131, ans = 0;
		HashMap<Long,Integer> map = new HashMap<Long,Integer>();
		for (int i = 0; i < n; i++) {
			String s = next();
			int best = 0;
			long pre = 0, suf = 0, pw = 1;
			for (int j = 0; j < s.length(); j++) {
				pre = pre*base + s.charAt(j);
				suf = s.charAt(s.length()-j-1)*pw + suf;
				pw*= base;
				if (pre == suf) {
					best = Math.max(best, map.getOrDefault(pre, 0));
				}
			}
			ans = Math.max(ans, best+1); map.put(pre,best+1);
		}
		System.out.println(ans);
		
	}
	static String next () throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}
	static int readInt () throws IOException {
		return Integer.parseInt(next());
	}
}
