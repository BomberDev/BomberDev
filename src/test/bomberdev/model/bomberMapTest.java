package test.bomberdev.model;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

import src.bomberdev.model.BomberMap;
import src.bomberdev.model.Block;
import src.bomberdev.model.ExplodableBlock;
import src.bomberdev.model.SolidBlock;

public class bomberMapTest {

	@Test
	public void test() {
		BomberMap map = new BomberMap("testMap.txt", 6, 6);
		SolidBlock solid = new SolidBlock(new Point(0, 0));
		ExplodableBlock dest = new ExplodableBlock(new Point(1,1));
		Block brick1 = map.getBrickAt(0,0);
		Block brick2 = map.getBrickAt(1,1);
		assertEquals(solid, brick1);
		assertEquals(dest, brick2);
	}

}
