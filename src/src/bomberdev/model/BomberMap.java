package src.bomberdev.model;

import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BomberMap {

	private Brick[][] bricks;

	public BomberMap(String fName, int rows, int columns) {
		String filename = "Resources/Maps/" + fName;
		this.bricks = new Brick[rows][columns];
		int[][] bricks = getBricksArray(filename, rows, columns);

		for (int j = 0; j < rows; j++) {
			for (int i = 0; i < columns; i++) {
				if (bricks[j][i] == 0) {
					
				} else if (bricks[j][i] == 1) {
					this.bricks[j][i] = new SolidBrick(new Point(i, j));
				} else if (bricks[j][i] == 2) {
					this.bricks[j][i] = new DestructibleBrick(new Point(i, j));
				} else {
					throw new RuntimeException(
							"Bricks must be represented by 0 for a DestrutibleBrick or 1 for a SolidBrick");
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
					line.split(" ");
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

	public Brick getBrickAt(int i, int j) {
		return this.bricks[i][j];
	}
	
	public int getNbRows() {
		return this.bricks.length;
	}
	
	public int getNbColumns() {
		return this.bricks[1].length;
	}
}