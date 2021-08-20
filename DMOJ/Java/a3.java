import java.io.*;
import java.util.*;
public class CCC2{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[]args) throws IOException{
    	int n = readInt();
    	for (int i = 0; i < n; i++) {
    		int x = readInt();
    		int cnt = 192;
    		while (true) {
    			if (cnt > x) {
    				System.out.println(cnt);
    				break;
    			}
    			cnt += 250;
    		}
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
    static String readLine () throws IOException {
  	  return br.readLine().trim();
    } 
}
