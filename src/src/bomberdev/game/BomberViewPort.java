package src.bomberdev.game;

import java.net.URL;

import gameframework.drawing.GameUniverseViewPortDefaultImpl;

public class BomberViewPort extends GameUniverseViewPortDefaultImpl {

	@Override
	protected URL backgroundImage() {
		return backgroundImage("/Resources/Graphics/background.png");
	}
}
