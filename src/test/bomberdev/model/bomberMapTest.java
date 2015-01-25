package test.bomberdev.model;

import static org.junit.Assert.assertEquals;

import java.awt.Point;

import org.junit.Test;

import src.bomberdev.model.BomberMap;
import src.bomberdev.model.ExplodableBlock;
import src.bomberdev.model.SolidBlock;
import src.bomberdev.model.Tile;

public class bomberMapTest {

	@Test
	public void test() {
		BomberMap map = new BomberMap("testMap.txt", 6, 6);
		SolidBlock solid = new SolidBlock(new Point(0, 0));
		ExplodableBlock dest = new ExplodableBlock(new Point(1,1));
		Tile tile1 = map.getTileAt(0,0);
		Tile tile2 = map.getTileAt(1,1);
		assertEquals(solid, tile1);
		assertEquals(dest, tile2);
	}

}
