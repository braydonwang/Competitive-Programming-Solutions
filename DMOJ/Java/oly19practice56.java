import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int m = sc.nextInt(), n = sc.nextInt(), u = sc.nextInt(), f = sc.nextInt(), d = sc.nextInt();
		char[] array = new char[n];
		String str = sc.next();
		for (int i = 0; i < n; i++) {
			array[i] = str.charAt(i);
		}
		int forward = 0;
		int backward = 0;
		int count = 0;
		while (forward + backward < m) {
			if (array[count] == 'u') {
				forward += u;
				backward += d;
			} else if (array[count] == 'f') {
				forward += f;
				backward += f;
			} else {
				forward += d;
				backward += u;
			}
			count++;
		}
		System.out.println(count-1);
    }
}
