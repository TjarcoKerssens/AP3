package assignment3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
	private boolean descending, lowercase;
	private BinaryTree<Identifier> tree;

	public Main() {
		tree = new BinaryTree<Identifier>();
	}

	boolean isIdentifier(Scanner in) {
		return in.hasNext(Pattern.compile("[a-zA-Z].*"));
	}

	void run(String[] args) {
		if (args.length == 0) {
			System.out.println("ussage: Main [options] filename <filename>");
		} else {
			readInput(args);
			printOutput();
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
			System.out.println(e.getMessage());
		} catch (IndexOutOfBoundsException ie) {
			System.out.println("ussage: Main [options] filename <filename>");
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

	void parseText(Scanner in) throws APException {
		in.useDelimiter(Pattern.compile("[^a-zA-Z0-9]+"));
		while (in.hasNext()) {
			if (isIdentifier(in)) {
				insertIdentifier(in);
			} else {
				in.next(); // ignore the non-identifier
			}
		}
	}

	private void insertIdentifier(Scanner in) throws APException {
		String id = in.next();
		Identifier identifier = new Identifier(id.charAt(0));
		for (int i = 1; i < id.length(); i++) {
			identifier.addCharacter(id.charAt(i));
		}
		if (lowercase) {
			identifier.toLowerCase();
		}

		if (tree.contains(identifier)) {
			tree.remove(identifier);
		} else {
			tree.insert(identifier);
		}
	}

	void printOutput() {
		Iterator<Identifier> i;
		if (descending) {
			i = tree.descendingIterator();
		} else {
			i = tree.ascendingIterator();
		}
		while (i.hasNext()) {
			System.out.print(i.next() + " ");
		}
	}

	public static void main(String[] args) {
		new Main().run(args);
	}

}
