import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static ArrayList<String> list;
	public static void main(String[] args) throws IOException {
		for (int a = 0; a < 5; a++) {
			list = new ArrayList();
			String str = next();
			int n = str.length(); 
	        permute(str, 0, n-1);
	        Collections.sort(list);
	        for (String s: list) {
	        	System.out.println(s);
	        }
		}
	}
		
	public static void permute(String str, int l, int r) { 
	    if (l == r) 
		        list.add(str);
		    else {	            
		    	for (int i = l; i <= r; i++) { 
		            str = swap(str,l,i); 
		            permute(str, l+1, r); 
		            str = swap(str,l,i); 
		        } 
	        } 
		} 
		public static String swap(String a, int i, int j) { 
		    char temp; 
		    char[] charArray = a.toCharArray(); 
		    temp = charArray[i] ; 
	        charArray[i] = charArray[j]; 
		    charArray[j] = temp; 
	        return String.valueOf(charArray);  
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
