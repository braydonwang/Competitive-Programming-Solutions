import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int x = readInt(), b = 0; List<Integer> ans = new ArrayList();
		for(b=2; b <= Math.sqrt(x); b++) {
			if(check(x, b)) ans.add(b);
		}
		while((long)(b*b + b) >= x) b--;
		for( ; b>=1; b--) {
			if ( x % b == 0 ) ans.add(x/b - 1);
		}
		Collections.sort(ans);
		for(int y: ans) System.out.println(y);
	}
	static boolean check(int x, int b) {
		List<Integer> a = new ArrayList();
		List<Integer> c = new ArrayList();
		while(x >= b) {
			a.add(x % b);  c.add(0,x%b); x/=b;
		}
		a.add(x); c.add(0,x);
		if (a.equals(c)){
		    return true;
		}
		return false;
	}
	static String next() throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}

	static long readLong() throws IOException {
		return Long.parseLong(next());
	}

	static int readInt() throws IOException {
		return Integer.parseInt(next());
	}

	static double readDouble() throws IOException {
		return Double.parseDouble(next());
	}

	static char readCharacter() throws IOException {
		return next().charAt(0);
	}

	static String readLine() throws IOException {
		return br.readLine().trim();
	}
}
