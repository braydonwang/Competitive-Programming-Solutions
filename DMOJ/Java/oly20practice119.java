import java.util.*;
import java.io.*;
public class P6 {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static PrintWriter ps = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
  static StringTokenizer st;
  static int mod = (int)1e9+7;
  public static void main(String[] args) throws IOException {
	  int t = readInt();
	  for (int a = 0; a < t; a++) {
		  long b = readInt(), c = readInt(), d = readInt(), k = readInt();
		  if (c - b == d - c) {
			  //dif 
			  //a, a + dif, a + dif + dif, a = dif + dif + dif ...
			  //a + (k-1) * dif
			  long dif = c - b;
			  long ans = (b + ((k-1) % mod * dif % mod) % mod) % mod;
			  System.out.println(ans);
		  } else {
			  //ratio = c/b
			  //a, a*ratio, a*ratio*ratio, ...
			  //a*ratio^(k-1)
			  long ratio = c/b;
			  long ans = power(ratio,k-1);
			  ans = (b * ans) % mod;
			  System.out.println(ans);
		  }
	  }
  }
  static long power(long x, long y) {
	long ans = 1, mod = (long) (1e9+7);
	while (y > 0) {
		if (y % 2 != 0) {
			ans = multiply(ans,x,mod);
		}
		x = multiply(x,x,mod);
		y = y/2;
	}
	return ans;
  }
	static long multiply(long a, long b, long k) {
		return ((a % k) * (b % k)) % k;
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

  static class State implements Comparable<State> {
    int x, y, fuel;
    double cost;

    State(int x, int y, int fuel, double cost) {
      this.x = x;
      this.y = y;
      this.fuel = fuel;
      this.cost = cost;
    }

    @Override
    public int compareTo(State o) {
      return (int)(cost - o.cost);
    }
  }
}
