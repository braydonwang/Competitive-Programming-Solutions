import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
		int n = sc.nextInt();
		String str = Integer.toString(n);
		String[] a = str.split("");
		while (true) {
			n++;
			String x = Integer.toString(n);
			String[] c = x.split("");
			Arrays.sort(c); Arrays.sort(a);
			if (Arrays.equals(c, a)) {
				System.out.println(x);
				break;
			}
			else if (x.length() > str.length()) {
				System.out.println(0);
				break;
			}
		}
    }
}
