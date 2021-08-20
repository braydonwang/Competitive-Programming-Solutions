import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		String[] array = new String[52];
		ArrayList<String> list = new ArrayList<String>();
		list.add("ace");
		list.add("jack");
		list.add("queen");
		list.add("king");
		for (int i = 0; i < 52; i++) {
			array[i] = next();
		}
		int totala = 0, totalb = 0;
		for (int i = 0; i < 52; i+=2) {
			String a = array[i]; String b = array[i+1];
			if (a.equals("ace")) {
				if (i < 48) {
					if (!list.contains(array[i+1]) && !list.contains(array[i+2]) && !list.contains(array[i+3]) && !list.contains(array[i+4])){
						totala += 4;
						System.out.println("Player A scores 4 point(s).");
					}
				}
			}
			else if (a.equals("king")) {
				if (i < 49) {
					if (!list.contains(array[i+1]) && !list.contains(array[i+2]) && !list.contains(array[i+3])){
						totala += 3;
						System.out.println("Player A scores 3 point(s).");
					}
				}
			}
			else if (a.equals("queen")) {
				if (i < 50) {
					if (!list.contains(array[i+1]) && !list.contains(array[i+2])){
						totala += 2;
						System.out.println("Player A scores 2 point(s).");
					}
				}
			}
			else if (a.equals("jack")) {
				if (i < 51) {
					if (!list.contains(array[i+1])){
						totala += 1;
						System.out.println("Player A scores 1 point(s).");
					}
				}
			}
			if (b.equals("ace")) {
				if (i < 48) {
					if (!list.contains(array[i+2]) && !list.contains(array[i+3]) && !list.contains(array[i+4]) && !list.contains(array[i+5])){
						totalb += 4;
						System.out.println("Player B scores 4 point(s).");
					}
				}
			}
			else if (b.equals("king")) {
				if (i < 49) {
					if (!list.contains(array[i+2]) && !list.contains(array[i+3]) && !list.contains(array[i+4])){
						totalb += 3;
						System.out.println("Player B scores 3 point(s).");
					}
				}
			}
			else if (b.equals("queen")) {
				if (i < 50) {
					if (!list.contains(array[i+2]) && !list.contains(array[i+3])){
						totalb += 2;
						System.out.println("Player B scores 2 point(s).");
					}
				}
			}
			else if (b.equals("jack")) {
				if (i < 51) {
					if (!list.contains(array[i+2])){
						totalb += 1;
						System.out.println("Player B scores 1 point(s).");
					}
				}
			}
		}
		System.out.println("Player A: " + totala + " point(s).");
		System.out.println("Player B: " + totalb + " point(s).");
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
