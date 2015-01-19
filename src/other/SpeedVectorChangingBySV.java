package other;

import gameframework.motion.SpeedVector;

import java.awt.Point;

public class SpeedVectorChangingBySV extends SpeedVectorAutoChanging {
	SpeedVector mk;

	public SpeedVectorChangingBySV(SpeedVector ch, int SpeedLimit) {
		super(SpeedLimit);
		this.mk = ch;
	}

	@Override
	protected Point getGVector() {
		Point res = new Point(mk.getDirection().x * mk.getSpeed(),
				mk.getDirection().y * mk.getSpeed());
		mk.setDirection(new Point(0, 0));
		return res;
	}

}
