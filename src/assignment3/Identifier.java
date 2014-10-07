package assignment3;

public class Identifier implements IdentifierInterface {

	private char[] characterSet;
	private int nextIndex;

	public Identifier(char character) throws APException {
		init(character);
	}

	@Override
	public void init(char character) throws APException {
		characterSet = new char[1];
		if (isAlhpabetic(character)) {
			characterSet[0] = character;
			nextIndex = 1;
		} else {
			throw new APException("The first character should be Alphabetic");
		}
	}

	@Override
	public void addCharacter(char character) throws APException {
		if (isAlpaNumeric(character)) {
			arrayLengthCheck();
			characterSet[nextIndex] = character;
			nextIndex++;
		} else {
			throw new APException("Character '" + character
					+ "' is not Alphanummeric");
		}
	}

	private void arrayLengthCheck() {
		if (nextIndex == characterSet.length) {
			char[] temp = characterSet;
			characterSet = new char[temp.length * 2];
			for (int i = 0; i < temp.length; i++) {
				characterSet[i] = temp[i];
			}
		}
	}

	@Override
	public boolean removeCharacter(int index) {
		if (index > nextIndex - 1) {
			return false;
		}
		for (int i = index; i < nextIndex; i++) {
			characterSet[i] = characterSet[i + 1];
		}
		return true;
	}

	@Override
	public char getCharacter(int index) {
		return characterSet[index];
	}

	@Override
	public int getLenght() {
		return characterSet.length;
	}

	@Override
	public char[] getAllCharacters() {
		return characterSet;
	}

	private boolean isAlpaNumeric(char character) {
		return Character.isDigit(character) || Character.isLetter(character);
	}

	private boolean isAlhpabetic(char character) {
		return Character.isLetter(character);
	}

	public Identifier clone() {

		Identifier clone = null;
		try {
			clone = new Identifier(this.getCharacter(0));
		} catch (APException e) {
		}

		for (int i = 1; i < this.getLenght(); i++) {
			try {
				clone.addCharacter(this.getCharacter(i));
			} catch (APException e) {
			}
		}
		return clone;
	}

	@Override
	public String toString() {
		String s = "";
		for (char c : characterSet) {
			s += c;
		}
		return s;
	}

	@Override
	public int compareTo(Object o) {

		Identifier compare = ((Identifier) o);
		int i = 0;
		while (Math.min(this.nextIndex, compare.nextIndex)-1 > i
				&& (compare.getCharacter(i) == this.getCharacter(i))){
			i++;
		}
		
		return this.getCharacter(i) - compare.getCharacter(i);
	}

	@Override
	public void toLowerCase() {
		for (int i = 0; i < nextIndex; i++) {
			characterSet[i] = Character.toLowerCase(characterSet[i]);
		}
	}

}
