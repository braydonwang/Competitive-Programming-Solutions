import java.io.*;
import java.util.*;
public class CCC2{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[]args) throws IOException{
    	int n = readInt(), l = readInt();
    	ArrayList<String> list = new ArrayList<String>();
    	for (int i = 0; i < n; i++) {
    		int x = readInt();
    		if (list.size() == 0) {
    			for (int j = 0; j < x; j++) {
        			String str = next();
        			list.add(str);
        		}
    		} else {
    			int size = list.size();
    			for (int j = 0; j < x; j++) {
        			String str = next();
        			for (int k = 0; k < size; k++) {
        				if (list.get(k).length() < l) {
        					list.add(list.get(k) + str);
        				}
        			}
        		}
    		}
    	}
    	Collections.sort(list);
    	for (String s: list) {
    		System.out.println(s);
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
