package test.bomberdev.model;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

import src.bomberdev.model.BomberMap;
import src.bomberdev.model.Brick;
import src.bomberdev.model.DestructibleBrick;
import src.bomberdev.model.SolidBrick;

public class bomberMapTest {

	@Test
	public void test() {
		BomberMap map = new BomberMap("testMap.txt", 6, 6);
		SolidBrick solid = new SolidBrick(new Point(0, 0));
		DestructibleBrick dest = new DestructibleBrick(new Point(1,1));
		Brick brick1 = map.getBrickAt(0,0);
		Brick brick2 = map.getBrickAt(1,1);
		assertEquals(solid, brick1);
		assertEquals(dest, brick2);
	}

}
