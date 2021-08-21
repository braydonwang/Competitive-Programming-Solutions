import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int max = 101;
	public static void main(String[] args) throws IOException {
		PriorityQueue<Pair>[] q = new PriorityQueue[max];
		int n = readInt(), s = readInt();
		boolean[][] cur = new boolean[n+1][max];
		int[] d = new int[n+1];
		for (int i = 1; i <= n; i++) {
			d[i] = readInt();
		}
		for (int i = 0; i < max; i++) {
			q[i] = new PriorityQueue();
		}
		for (int i = 0; i < s; i++) {
			int si = readInt(), ai = readInt();
			q[ai].add(new Pair(si,d[si]));
			cur[si][ai] = true;
		}
		int Q = readInt();
		for (int i = 0; i < Q; i++) {
			char ch = readCharacter();
			if (ch == 'A') {
				int x = readInt(), k = readInt();
				q[k].add(new Pair(x,d[x]));
				cur[x][k] = true;
			} else if (ch == 'S') {
				int x = readInt(), k = readInt();
				cur[x][k] = false;
			} else if (ch == 'E') {
				int x = readInt(), k = readInt();
				d[x] = k;
				Arrays.fill(cur[x], false);
			} else {
				int k = readInt();
				Pair temp = q[k].peek();
				//System.out.println(temp.id);
				while (!q[k].isEmpty() && d[temp.id] != temp.dis) {
					q[k].poll();
					q[k].add(new Pair(temp.id,d[temp.id]));
					temp = q[k].peek();
				}
				temp = q[k].peek();
				//System.out.println(cur[temp.id][k]);
				while (!q[k].isEmpty() && !cur[temp.id][k]) {
					//System.out.println("HI");
					q[k].poll();
					temp = q[k].peek();
				}
				if (q[k].isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(q[k].peek().id);
				}
			}
		}
	}
	static class Pair implements Comparable<Pair>{
		int id, dis;
		Pair(int id, int dis){
			this.id = id;
			this.dis = dis;
		}
		public int compareTo(Pair p) {
			if (this.dis == p.dis) {
				return this.id - p.id;
			}
			return this.dis - p.dis;
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
