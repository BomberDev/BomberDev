package update;

import java.awt.Rectangle;
import java.lang.reflect.Method;
import java.util.Vector;

import entityConsole.drawable.BombDrawable;

import gameframework.motion.Movable;
import gameframework.motion.blocking.MoveBlocker;
import gameframework.motion.blocking.MoveBlockerRulesApplierDefaultImpl;

public class GameBlockerRule extends MoveBlockerRulesApplierDefaultImpl {
	@Override
	public boolean moveValidationProcessing(Movable movable,
	Vector<MoveBlocker> blockers) {
		for (MoveBlocker moveBlocker : blockers) {
			try {
				moveBlockerRuleApply(movable, moveBlocker);
			} catch (Exception e) {
				//-------------------------------
				//I change their for player will be locked in his bomb :3
				Rectangle  a;
				Rectangle  b;
				a = moveBlocker.getBoundingBox();
				b = movable.getBoundingBox();
				if(a.contains(b.getMaxX(),b.getMaxY())||(a.contains(b.getMinX(),b.getMaxY()))||a.contains(b.getMaxX(),b.getMinY())||a.contains(b.getMinX(),b.getMinY()))
					if(moveBlocker instanceof BombDrawable)	continue;
				//-------------------------------
				return false;
			}
		}
		return true;
	}
	
	private void moveBlockerRuleApply(Movable movable, MoveBlocker blocker)
			throws Exception {
		Method m = null;
		m = (getClass()).getMethod("moveBlockerRule", movable.getClass(),
				blocker.getClass());
		m.invoke(this, movable, blocker);
	}
}
