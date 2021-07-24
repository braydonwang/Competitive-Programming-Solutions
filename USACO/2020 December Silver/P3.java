import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int t = readInt();
		char[] ch = new char[t];
		int[] x = new int[t], y = new int[t];
		int ce = 0, cn = 0;
		for (int i = 0; i < t; i++) {
			ch[i] = readCharacter(); x[i] = readInt(); y[i] = readInt();
			if (ch[i] == 'E') {
				ce++;
			} else {
				cn++;
			}
		}
		East[] e = new East[ce];
		North[] n = new North[cn];
		int ind1 = 0, ind2 = 0;
		for (int i = 0; i < t; i++) {
			char cha = ch[i];
			if (cha == 'E') {
				e[ind1] = new East(x[i],y[i],i); ind1++;
			} else {
				n[ind2] = new North(x[i],y[i],i); ind2++;
			}
		}
		Arrays.sort(e); Arrays.sort(n);
		boolean[] stop = new boolean[t];
		int[] ans = new int[t];
		for (int i = 0; i < ce; i++) {
			for (int j = 0; j < cn; j++) {
				East ec = e[i];
				North nc = n[j];
				if (stop[n[j].ind] || nc.x < ec.x || ec.y < nc.y) {
					continue;
				}
				if (ec.y - nc.y < nc.x - ec.x) {
					ans[nc.ind] += ans[ec.ind] + 1;
					break;
				}
				else if (nc.x - ec.x < ec.y - nc.y) {
					ans[ec.ind] += ans[nc.ind] + 1;
					stop[nc.ind] = true; 
				}
			}
		}
		for (int i = 0; i < t; i++) {
			System.out.println(ans[i]);
		}
	}
	static class East implements Comparable<East>{
		int x, y;
		int ind;
		East(int x, int y, int ind){
			this.x = x;
			this.y = y;
			this.ind = ind;
		}
		public int compareTo(East e) {
			return this.y - e.y;
		}
	}
	static class North implements Comparable<North>{
		int x, y, ind;
		North(int x, int y, int ind){
			this.x = x;
			this.y = y;
			this.ind = ind;
		}
		public int compareTo(North e) {
			return this.x - e.x;
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
