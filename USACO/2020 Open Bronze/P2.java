import java.util.*;
import java.io.*;
public class Template {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		Cow[] cow = new Cow[n];
		for (int i = 0; i < n; i++) {
			cow[i] = new Cow(readInt(),readInt());
		}
		Arrays.sort(cow);
		boolean healthy = false;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			if (cow[i].s == 0) {
				healthy = true;
				if (i > 0 && cow[i-1].s == 1) {
					min = Math.min(min, cow[i].x - cow[i-1].x);
				}
				if (i < n-1 && cow[i+1].s == 1) {
					min = Math.min(min, cow[i+1].x - cow[i].x);
				}
			}
		}
		min--;
		if (!healthy) {
			System.out.println(1);
			return;
		}
		int pos = 0, count = 0;
		for (int i = 0; i < n; i++) {
			if (cow[i].s == 1) {
				if (pos == 0) {
					pos = cow[i].x;
					count++;
				} else {
					if (cow[i].x > pos + min) {
						count++;
					}
					pos = cow[i].x;
				}
			}
		}
		System.out.println(count);
	}
	static class Cow implements Comparable<Cow>{
		int x, s;
		Cow(int x, int s){
			this.x = x;
			this.s =s;
		}
		public int compareTo(Cow c) {
			return this.x - c.x;
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
