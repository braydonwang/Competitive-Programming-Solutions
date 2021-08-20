import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int t = readInt();
		for (int z = 0; z < t; z++) {
			int n = readInt(), a = readInt(), b = readInt(); 
			int[] p = new int[a];
			for (int i = 0; i < a; i++) {
				p[i] = readInt();
			}
			Arrays.sort(p);
			PriorityQueue<Pair> q = new PriorityQueue();
			if (p[0] > 1){
			    q.add(new Pair(p[0] - 1,"end"));
			} 
			if (p[a-1] < n){
			    q.add(new Pair(n-p[a-1],"end"));
			}
			for (int i = 1; i < a; i++) {
				int num = p[i]-p[i-1]-1;
				if (num <= 0) {
					continue;
				}
				if (num % 2 == 0) {
					q.add(new Pair(num/2,"even"));
				} else {
					q.add(new Pair((num+1)/2,"odd"));
				}
			}
			int ans = 0;
			while (!q.isEmpty() && b > 0) {
				Pair cur = q.poll();
				if (cur.x < 0){
				    break;
				}
				ans += cur.x;
				if (cur.str.equals("odd")) {
					q.add(new Pair(cur.x-2,"odd2"));
				} else if (cur.str.equals("even")) {
					q.add(new Pair(cur.x,"even2"));
				} else if (cur.str.equals("odd2")) {
					q.add(new Pair(1,"odd3"));
				}
				b--;
			}
			System.out.println(ans);
		}
    }
	static class Pair implements Comparable<Pair>{
		int x; String str;
		Pair(int x, String str){
			this.x = x;
			this.str = str;
		}
		public int compareTo(Pair p) {
			return p.x - this.x;
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
