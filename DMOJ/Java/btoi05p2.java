import java.io.*;
import java.util.*;
public class CCC2{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[]args) throws IOException{
    	int n = readInt(), m = readInt();
    	int og = m;
    	StringBuilder str = new StringBuilder();
    	while (str.length() < n){
    	    str.append(next());
    	}
    	int count = 0;
    	for (int i = 0; i < n; i++) {
    		if (str.charAt(i) == '(') {
    			count++;
    		} else if (str.charAt(i) == ')') {
    			count--;
    			if (count < 0) {
    				System.out.println(0);
    				return;
    			}
    		} else {
    			if (count <= 0) {
    				System.out.println(0);
    				return;
    			} else {
    				if (m != 1) {
    					count--;
    					m--;
    				}
    			}
    		}
    	}
    	if (count <= 0) {
    		System.out.println(0);
    	} else {
    		System.out.println(1);
    		for (int i = 0; i < og-1; i++) {
    			System.out.println(1);
    		}
    		System.out.println(count);
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
