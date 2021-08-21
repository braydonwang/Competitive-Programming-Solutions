import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
		int n = sc.nextInt(); int m = sc.nextInt();
		int[] array = new int[m];
		String[] s = new String[m];
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt(); array[i] = sc.nextInt();
			sc.nextLine();
			s[i] = sc.nextLine();
		}
		int x = sc.nextInt();
		for (int i = 0; i < m; i++) {
			if (array[i] == x) {
				System.out.println(s[i]);
			}
		}
    }
}
