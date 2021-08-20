import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
		int n = sc.nextInt(); int m = sc.nextInt(); int count = 0;
		for (int i = n; i <= m; i++) {
			boolean rotate = false;;
			String str = Integer.toString(i);
			for (int j = 0; j < str.length(); j++) {
				char ch = str.charAt(j); char c = str.charAt(str.length()-j-1);
				if (ch == '1' || ch == '0' || ch == '8') {
					if (ch == c) {
						rotate = true;
					}
					else {
						rotate = false;
						break;
					}
				}
				else {
					if (ch == '6' && c == '9' || ch == '9' && c == '6') {
						rotate = true;
					}
					else {
						rotate = false;
						break;
					}
				}
			}
			if (rotate) {
				count++;
			}
		}
		System.out.println(count);
    }
}
