package assignment3;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

	void run() {
		Scanner in = new Scanner(System.in);
		in.useDelimiter(Pattern.compile("[^a-zA-Z0-9]+"));
		while (in.hasNext()) {
			String s = in.next();
			if(Character.isLetter(s.charAt(0))){
				System.out.println("Identifier: " + s);
			}else{
				System.out.println("non-Identifier: " + s);
			}
		}
		in.close();
	}

	public static void main(String[] args) {
		new Main().run();
	}

}
