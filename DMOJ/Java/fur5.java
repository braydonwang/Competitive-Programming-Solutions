import java.io.*;
import java.util.*;
public class CCC2{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[]args) throws IOException{
    	int n = readInt();
    	solve(n,"A","B","C");
    }
    static void solve(int n, String og, String temp, String dest) {
    	if (n == 0) {
    		return;
    	}
    	solve(n-1,og,dest,temp);
    	System.out.println(og + dest);
    	solve(n-1,temp,og,dest);
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
    static String readLine () throws IOException {
  	  return br.readLine().trim();
    } 
}
