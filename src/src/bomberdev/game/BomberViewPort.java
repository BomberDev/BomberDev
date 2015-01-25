package src.bomberdev.game;

import gameframework.drawing.GameUniverseViewPortDefaultImpl;

import java.net.URL;

public class BomberViewPort extends GameUniverseViewPortDefaultImpl {

	@Override
	protected URL backgroundImage() {
		return backgroundImage("/Resources/Graphics/background.png");
	}
}
