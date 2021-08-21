import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		String str1 = sc.next();
		String operand = sc.next();
		String str2 = sc.next();
		if (operand.equals("*")) {
			str2 = str2.replaceAll("1", "");
			System.out.println(str1 + str2);
		}
		else {
			if (str1.equals("1") && str2.equals("1")) {
				System.out.println(2);
				return;
			}
			if (str1.length() > str2.length()) {
				for (int i = 0; i < str1.length(); i++) {
					if (str1.length() - i == str2.length()) {
						System.out.print(str2);
						break;
					}
					else {
						System.out.print(str1.charAt(i));
					}
				}
			}
			else if (str2.length() > str1.length()){
				for (int i = 0; i < str2.length(); i++) {
					if (str2.length() - i == str1.length()) {
						System.out.print(str1);
						break;
					}
					else {
						System.out.print(str2.charAt(i));
					}
				}
			}
			else {
				str1 = str1.replaceAll("1","2");
				System.out.println(str1);
			}
		}
    }
}
