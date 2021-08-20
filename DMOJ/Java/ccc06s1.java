import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner (System.in);
		String a = sc.next();
		String b = sc.next();
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			String str = sc.next();
			boolean done = true;
			for (int j = 0; j < str.length(); j++) {
				if ((a.charAt(j*2) == a.charAt(j*2+1) && Character.isUpperCase(a.charAt(j*2))) || (b.charAt(j*2) == b.charAt(j*2+1) && Character.isUpperCase(b.charAt(j*2)))){
					if (Character.isLowerCase(str.charAt(j))) {
						done = false;
						break;
					}
				}
				else if ((a.charAt(j*2) == a.charAt(j*2+1) && Character.isLowerCase(a.charAt(j*2))) && (b.charAt(j*2) == b.charAt(j*2+1) && Character.isLowerCase(b.charAt(j*2)))) {
					if (Character.isUpperCase(str.charAt(j))) {
						done = false;
						break;
					}
				}
			}
			if (done) {
				System.out.println("Possible baby.");
			}
			else {
				System.out.println("Not their baby!");
			}
		}
    }
}
