import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		List<Character> ans = new ArrayList();
		char letter = 'z';
		Pair[] array = new Pair[n];
		int[] pos = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = new Pair(next(),0);
		}
		Arrays.sort(array);
		while (letter >= 'a') {
			boolean good = true;
			for (int i = 0; i < n; i++) {
				boolean ok = false;
				for (int j = array[i].ind; j < array[i].str.length(); j++) {
					if (array[i].str.charAt(j) == letter) {
						pos[i] = j+1;
						ok = true;
						break;
					} 
				}
				if (!ok) {
					good = false;
					break;
				}
			}
			if (good) {
				ans.add(letter);
				for (int i = 0; i < n; i++) {
					array[i].ind = pos[i];
				}
			} else {
				letter--;
			}
		}
		if (ans.isEmpty()){
		    System.out.println(-1);
		} else {
		    for (char x: ans){
		        System.out.print(x);
		    }
		    System.out.println();
		}
	}
	static class Pair implements Comparable<Pair>{
		String str;
		int ind;
		Pair(String str, int ind){
			this.str = str;
			this.ind = ind;
		}
		public int compareTo(Pair p) {
			return this.str.compareTo(p.str);
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
