import java.util.*;
import java.io.*;
public class Template {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
        String s = "";
        String ans = "";
        for (int k = 0; k < N; k++) {
            s += sc.next();
        }
        while (!s.equals("")) {
            if (check (s) == 0) {
                ans += s.charAt(0);
                s = s.substring(1);
            }
            else {
                ans += s.charAt(s.length()-1);
                s = s.substring(0,s.length()-1);
            }
        }
        System.out.println(ans);
	}
	static int check(String s) {
        if (s.length() == 1 && s.length() == 2) {
            return 0;
        }
        else if (s.charAt(0) < s.charAt(s.length()-1)) {
            return 0;
        }
        else if (s.charAt(s.length()-1) < s.charAt(0)){
            return 1;
        }
        else {
            if (s.length() > 2){
               return check(s.substring(1,s.length()-1)); 
            } else {
                return 0;
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
	static char readCharacter () throws IOException {
		return next().charAt(0);
	}
	static String readLine () throws IOException {
		return br.readLine().trim();
	}
}
