import java.util.*;
import java.io.*;
public class Template {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		String str = next();
		ArrayList<Integer> gap = new ArrayList<Integer>();
		int first = str.indexOf('1'), last = str.lastIndexOf('1');
		int count = 1;
		for (int i = first+1; i <= last; i++) {
			if (str.charAt(i) == '1') {
				gap.add(count);
				count = 1;
			} else {
				count++;
			}
		}
		Collections.sort(gap);
		if (first == -1) {
			System.out.println(n-1);
			return;
		}
		if (first == last) {
			int dis = Math.max(n-first-1, first);
			System.out.println(Math.max(dis/2, Math.min(first, n-first-1)));
			return;
		}
		int temp = Math.min(gap.get(gap.size()-1)/2, Math.max(first, n-last-1));
		temp = Math.max(temp,Math.max(first/2, (n-last-1)/2));
		temp = Math.max(temp, gap.get(gap.size()-1)/3);
		if (gap.size() >= 2) {
			temp = Math.max(temp, Math.min(gap.get(gap.size()-1)/2, gap.get(gap.size()-2)/2));
		}
		System.out.println(Math.min(gap.get(0), temp));
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
