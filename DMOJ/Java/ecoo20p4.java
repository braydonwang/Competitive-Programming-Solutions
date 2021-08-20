import java.util.*;
import java.io.*;
public class Template {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int mod = (int) 1e9 + 7;
	public static void main(String[] args) throws IOException {
		int t = readInt();
		for (int a = 0; a < t; a++) {
			int n = readInt();
			Map<String,Pair> func = new HashMap<String,Pair>();
			Stack<String> st = new Stack();
			func.put("main",new Pair(1,0));
			st.push("main");
			for (int i = 0; i < n; i++) {
				String s = next();
				if (s.equals("END")) {
					st.pop();
				} else if (s.equals("FUN")){
					String name = next();
					func.put(name, new Pair(1,0));
					st.push(name);
				} else if (s.equals("CALL")) {
					String name = next();
					Pair t1 = func.get(name);
					Pair t2 = func.get(st.peek());
					func.put(st.peek(),new Pair((t1.m * t2.m) % mod,((t1.m * t2.b) % mod + t1.b) % mod));
				} else if (s.equals("ADD")) {
					int x = readInt();
					Pair t1 = func.get(st.peek());
					func.put(st.peek(),new Pair(t1.m,(t1.b + x)%mod));
				} else if (s.equals("SUB")) {
					int x = readInt();
					Pair t1 = func.get(st.peek());
					func.put(st.peek(),new Pair(t1.m,(t1.b - x + mod)%mod));
				} else if (s.equals("MULT")) {
					int x = readInt();
					Pair t1 = func.get(st.peek());
					func.put(st.peek(),new Pair(t1.m*x % mod,t1.b * x %mod));
				}
			}
			System.out.println(func.get("main").b);
		}
	}
	static class Pair{
		long m,b;
		Pair(long m, long b){
			this.m = m;
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
