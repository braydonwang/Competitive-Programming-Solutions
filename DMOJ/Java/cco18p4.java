import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static HashMap<Long,Integer> map = new HashMap<Long,Integer>();
	static int base = 131;
	public static void main(String[] args) throws IOException {
		int r = readInt(), c = readInt(), k = readInt();
		int r1 = 1, r2 = r, c1 = 1, c2 = c;
		while (r1 < r2 || c1 < c2) {
			int rm = (r1 + r2) / 2, cm = (c1 + c2) / 2;
			if (r1 < r2) {
				int cen = query(rm,cm), below = query(rm+1,cm);
				if (cen < below) {
					r2 = rm;
				} else {
					r1 = rm + 1;
				}
			}
			if (c1 < c2) {
				int cen = query(rm,cm), rit = query(rm,cm+1);
				if (cen < rit) {
					c2 = cm;
				} else {
					c1 = cm + 1;
				}
			}
		}
		System.out.println("!" + query(r1,c1));
	}
	static int query(int r, int c) throws IOException{
		long key = r * base + c;
		if (map.containsKey(key)) {
			return map.get(key);
		}
		System.out.println("?" + r + " " + c);
		System.out.flush();
		int x = readInt();
		map.put(key, x);
		return x;
	}
	static class Pair{
		int a, b;
		Pair(int a, int b){
			this.a = a;
			this.b = b;
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
