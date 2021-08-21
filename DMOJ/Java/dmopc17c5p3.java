import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static boolean isPrime(long n) {
		if (n <= 1) {  
			return false;  
		 }  
		 for (int i = 2; i <= Math.sqrt(n); i++) {  
			 if (n % i == 0) {  
				 return false;  
			 }  
		 }  
		 return true;  
	}
	public static void main(String[] args) throws IOException {
		int n = readInt();
		long[] array = new long[n];
		for (int i = 0; i < n; i++) {
			array[i] = readLong();
		}
		long a = array[0];
		long b = array[1];
		for (int i = 2; i < n; i++) {
			long rem = 0;
			while (a != 0 && b != 0) {
				if (a > b) {
					rem = a % b;
				}
				else {
					rem = b % a;
				}
				a = Math.min(a, b);
				b = rem;
			}
			a = Math.max(a, b);
			b = array[i];
		}
		int prime = 0;
		for (int i = 2; i <= Math.sqrt(a); i++){
		    while (a % i == 0){
		        a = a/i;
		        prime = i;
		    }
		}
		if (a != 1){
		    System.out.println(a);
		}
		else if (prime != 0){
		    System.out.println(prime);
		}
		else{
		    System.out.println("DNE");
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
