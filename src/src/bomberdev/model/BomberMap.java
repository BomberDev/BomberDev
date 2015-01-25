package src.bomberdev.model;

import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BomberMap {

	private Block[][] bricks;

	public BomberMap(String fName, int rows, int columns) {
		String filename = "target/classes/Resources/Maps/" + fName;
		this.bricks = new Block[rows][columns];
		int[][] bricks = getBricksArray(filename, rows, columns);

		for (int j = 0; j < rows; j++) {
			for (int i = 0; i < columns; i++) {
				if (bricks[j][i] == 0) {
					this.bricks[j][i] = new BackgroundBlock(new Point(i, j));
				} else if (bricks[j][i] == 1) {
					this.bricks[j][i] = new SolidBlock(new Point(i, j));
				} else if (bricks[j][i] == 2) {
					this.bricks[j][i] = new ExplodableBlock(new Point(i, j));
				} else {
					throw new RuntimeException(
							"Bricks must be represented by 2 for a DestrutibleBrick or 1 for a SolidBrick");
				}
			}
		}
	}

	public static int[][] getBricksArray(String fileName, int rows, int columns) {
		int[][] bricks = new int[rows][columns];
		Scanner fileReader;
		String line;
		try {
			fileReader = new Scanner(new File(fileName));
			while (fileReader.hasNext()) {
				for (int i = 0; i < rows; i++) {
					line = fileReader.nextLine();
					Scanner lineReader = new Scanner(line);
					for (int j = 0; j < columns; j++) {
						bricks[i][j] = lineReader.nextInt();
					}
					lineReader.close();
				}
			}
			fileReader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bricks;
	}

	public Block getBrickAt(int i, int j) {
		return this.bricks[i][j];
	}

	public int getNbRows() {
		return this.bricks.length;
	}

	public int getNbColumns() {
		return this.bricks[1].length;
	}
}