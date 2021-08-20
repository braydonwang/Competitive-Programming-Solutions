import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
		int[] num = new int[10];
		for (int i = 0; i < 10; i++) {
			Set<String> set = new HashSet<String>();
			int n = sc.nextInt();
			sc.nextLine();
			for (int j = 0; j < n; j++) {
				String str = sc.nextLine();
				str = str.toLowerCase();
				String[] c = str.split("@");
				c[0] = c[0].replaceAll("\\.", "");
				int plus = c[0].indexOf("+");
				if (plus != -1) {
					c[0] = c[0].substring(0,plus);
				}
				str = c[0] + "@" + c[1];
				set.add(str);
			}
			num[i] = set.size();
		}
		for (int c = 0; c < 10; c++) {
			System.out.println(num[c]);
		}
    }
}
