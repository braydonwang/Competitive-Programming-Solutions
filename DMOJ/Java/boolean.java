import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
		String str = sc.nextLine();
		int count = 0;
		int x = 0;
		while (true) {
			if (str.indexOf("not", x) != -1) {
				count++;
				x+= 4;
			}
			else {
				break;
			}
		}
		int index = str.indexOf("True");
		if (index == -1 && count % 2 == 0) {
			System.out.println("False");
		}
		else if (index == -1 && count % 2 == 1) {
			System.out.println("True");
		}
		else if (index != -1 && count % 2 == 0) {
			System.out.println("True");
		}
		else {
			System.out.println("False");
		}
    }
}
