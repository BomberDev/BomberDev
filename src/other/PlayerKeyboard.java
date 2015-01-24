package other;

import java.awt.Point;
import java.awt.event.KeyEvent;

import player.PlayerModel;

import gameframework.game.GameEntity;
import gameframework.motion.MoveStrategyKeyboard;

public class PlayerKeyboard extends MoveStrategyKeyboard {
	
	GameEntity entity;

	
	public PlayerKeyboard() {
	}
	
	public PlayerKeyboard(GameEntity entity) {
		this.entity = entity;
	}

	public void setEntity(GameEntity entity){
		this.entity=entity;
	}
	
	public GameEntity getEntity(){
		return this.entity;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		if(entity==null||!(entity instanceof PlayerModel))return;
		if (e.getKeyChar() == 'x')
			((PlayerModel) entity).action(1);
		else if (e.getKeyChar() == 'c')
			((PlayerModel) entity).action(2);
	}
	
    @Override
    public void keyReleased(KeyEvent e) {
    	switch (e.getKeyCode()) {
		case KeyEvent.VK_RIGHT:
		case KeyEvent.VK_LEFT:
			if(this.speedVector.getDirection().x==0)break;
			this.speedVector.setDirection(new Point(0,0));
			break;
		case KeyEvent.VK_UP:
		case KeyEvent.VK_DOWN:
			if(this.speedVector.getDirection().y==0)break;
			this.speedVector.setDirection(new Point(0,0));
			break;
		}
    	
    }
    
    
}
