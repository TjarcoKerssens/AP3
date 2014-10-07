package assignment3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
	private boolean descending, lowercase;

	boolean isIdentifier(Scanner in) {
		return in.hasNext(Pattern.compile("[a-zA-Z].*"));
	}

	void run(String[] args) {
		if (args.length == 0) {
			System.err.println("ussage: Main [options] filename <filename>");
		} else {
			readInput(args);
		}
	}

	void readInput(String[] args) {
		try {
			args = parseOptions(args);
			Scanner[] files = openFiles(args);
			for (Scanner in : files) {
				parseText(in);
			}
		} catch (APException e) {
			System.err.println(e.getMessage());
		} catch (IndexOutOfBoundsException ie) {
			System.err.println("ussage: Main [options] filename <filename>");
		}
	}

	String[] parseOptions(String[] args) throws APException {
		while (args[0].startsWith("-")) {
			if (args[0].equals("-i")) {
				lowercase = true;
			} else if (args[0].equals("-d")) {
				descending = true;
			} else {
				throw new APException("Illegal argument given: " + args[0]);
			}
			args = Arrays.copyOfRange(args, 1, args.length);
		}
		return args;
	}

	Scanner[] openFiles(String[] files) throws APException {
		Scanner[] fileScanners = new Scanner[files.length];
		for (int i = 0; i < fileScanners.length; i++) {
			File f = new File(files[i]);
			try {
				fileScanners[i] = new Scanner(f);
			} catch (FileNotFoundException e) {
				throw new APException("The file: " + files[i]
						+ " does not exist");
			}
		}

		return fileScanners;
	}

	void parseText(Scanner in) {
		in.useDelimiter(Pattern.compile("[^a-zA-Z0-9]+"));
		while (in.hasNext()) {
			if (isIdentifier(in)) {
				System.out.println(in.next());
			} else {
				in.next(); //ignore the non-identifier
			}
		}
	}
	
	void printOutput(){
		//print the tree
	}

	public static void main(String[] args) {		
		new Main().run(args);
	}

}
