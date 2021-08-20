import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
	    Stack<Double> s = new Stack<Double>();
		String str = sc.nextLine();
		String[] a = str.split(" ");
		for (int i = 0; i < a.length; i++) {
			if (a[i].equals("+")) {
				double x = s.pop();
				double y = s.pop();
				double temp = x + y;
				s.push(temp);
			}
			else if (a[i].equals("-")) {
				double x = s.pop();
				double y = s.pop();
				double temp = y - x;
				s.push(temp);
			}
			else if (a[i].equals("*")) {
				double x = s.pop();
				double y = s.pop();
				double temp = x*y;
				s.push(temp);
			}
			else if (a[i].equals("/")) {
				double x = s.pop();
				double y = s.pop();
				double temp = y/x;
				s.push(temp);
			}
			else if (a[i].equals("%")) {
				double x = s.pop();
				double y = s.pop();
				double temp = y%x;
				s.push(temp);
			}
			else if (a[i].equals("^")) {
				double x = s.pop();
				double y = s.pop();
				double temp = Math.pow(y, x);
				s.push(temp);
			}
			else {
				s.push(Double.parseDouble(a[i]));
			}
		}
		System.out.println(Math.round(s.peek()*10)/10.0);
    }
}
