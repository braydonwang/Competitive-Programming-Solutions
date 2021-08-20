import java.util.*;
import java.io.*;
public class Template {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int t = readInt();
		for (int a = 0; a < t; a++) {
			int n = readInt();
			ArrayList<String> list = new ArrayList<String>();
			ArrayList<Temp> temp = new ArrayList<Temp>();
			for (int i = 0; i < n; i++) {
				int m = readInt();
				for (int j = 0; j < m; j++) {
					String s = next();
					int p = readInt(), q = readInt();
					if (!list.contains(s)) {
						list.add(s);
					}
					temp.add(new Temp(s,p,q));
				}
			}
			ArrayList<Store> adj[] = new ArrayList[list.size()+1];
			for (int i = 0; i <= list.size(); i++) {
				adj[i] = new ArrayList();
			}
			for (int i = 0; i < temp.size(); i++) {
				adj[list.indexOf(temp.get(i).s)].add(new Store(temp.get(i).p,temp.get(i).q));
			}
			for (int i = 0; i <= list.size(); i++) {
				Collections.sort(adj[i]);
			}
			int k = readInt();
			int total = 0;
			for (int i = 0; i < k; i++) {
				String s = next();
				int amount = readInt();
				for (Store st: adj[list.indexOf(s)]) {
					if (st.q < amount) {
						amount -= st.q;
						total += st.p * st.q;
					} else {
						total += st.p * amount;
						break;
					}
				}
			}
			System.out.println(total);
		}
	}
	static class Store implements Comparable<Store>{
		int p, q;
		Store(int p , int q){
			this.p = p;
			this.q = q;
		}
		public int compareTo(Store x) {
			return this.p - x.p;
		}
	}
	static class Temp{
		String s;
		int p, q;
		Temp(String s, int p, int q){
			this.s = s;
			this.p = p;
			this.q = q;
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
