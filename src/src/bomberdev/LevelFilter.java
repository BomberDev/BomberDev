package src.bomberdev;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.util.Scanner;

public class LevelFilter implements FilenameFilter {

	protected static final String PACKAGE_NAME = "target/classes/Resources/Maps/";

	@Override
	public boolean accept(File directory, String name) {

		if (name.endsWith(".txt")) {
			return reallyAccept(PACKAGE_NAME + name);
		} else
			return false;
	}

	private boolean reallyAccept(String name) {
		try {
			int nbRows = 0;
			String line;
			Scanner fileReader = new Scanner(new File(name));
			while (fileReader.hasNext()) {
				nbRows++;
				line = fileReader.nextLine();
				String[] numbers = line.split(" ");

				if (numbers.length != 17) {
					fileReader.close();
					return false;
				}
				try {
					for (int j = 0; j < 17; j++) {
						if (Integer.parseInt(numbers[j]) != 0
								&& Integer.parseInt(numbers[j]) != 1
								&& Integer.parseInt(numbers[j]) != 2) {
							fileReader.close();
							return false;
						}
					}
				} catch (NumberFormatException e) {
					fileReader.close();
					return false;
				}
			}
			if (nbRows != 9) {
				fileReader.close();
				return false;
			}

			fileReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return true;
	}
}
