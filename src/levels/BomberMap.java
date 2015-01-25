package src.bomberdev.model;

import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BomberMap {

	private Tile[][] tiles;

	public BomberMap(String fName, int rows, int columns) {
		String filename = "target/classes/Resources/Maps/" + fName;
		this.tiles = new Tile[rows][columns];
		int[][] tiles = getTilesArray(filename, rows, columns);

		for (int j = 0; j < rows; j++) {
			for (int i = 0; i < columns; i++) {
				if (tiles[j][i] == 0) {
					this.tiles[j][i] = new BackgroundTile(new Point(i, j));
				} else if (tiles[j][i] == 1) {
					this.tiles[j][i] = new SolidBlock(new Point(i, j));
				} else if (tiles[j][i] == 2) {
					this.tiles[j][i] = new ExplodableBlock(new Point(i, j));
				} else {
					throw new RuntimeException(
							"Bricks must be represented by 0 for a DestrutibleBrick or 1 for a SolidBrick");
				}
			}
		}
	}

	public static int[][] getTilesArray(String fileName, int rows, int columns) {
		int[][] tiles = new int[rows][columns];
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
						tiles[i][j] = lineReader.nextInt();
					}
					lineReader.close();
				}
			}
			fileReader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tiles;
	}

	public Tile getTileAt(int i, int j) {
		return this.tiles[i][j];
	}

	public int getNbRows() {
		return this.tiles.length;
	}

	public int getNbColumns() {
		return this.tiles[1].length;
	}
}