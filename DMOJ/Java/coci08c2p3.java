import java.io.*;
import java.util.*;
public class CCC2{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[]args) throws IOException{
    	int n = readInt();
    	ArrayList<Integer> sour = new ArrayList<Integer>();
    	ArrayList<Integer> bitter = new ArrayList<Integer>();
    	for (int i = 0; i < n; i++) {
    		int a = readInt(), b = readInt();
    		int size = sour.size();
    		if (size == 0) {
    			sour.add(a); bitter.add(b);
    		}
    		for (int j = 0; j < size; j++) {
    			sour.add(sour.get(j) * a);
    			bitter.add(bitter.get(j) + b);
    		}
    		sour.add(a); bitter.add(b);
    	}
    	int min = Integer.MAX_VALUE;
    	for (int i = 0; i < sour.size(); i++) {
    		min = Math.min(min, Math.abs(sour.get(i) - bitter.get(i)));
    	}
    	System.out.println(min);
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
