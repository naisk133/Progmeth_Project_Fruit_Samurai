package model;

import Utility.DrawingUtility;
import javafx.scene.canvas.GraphicsContext;

public class MenuButton implements IRenderable {
	private int buttonSize = 50;
	public static final MenuButton instance = new MenuButton();


	@Override
	public int getZ() {
		return Integer.MAX_VALUE;
	}

	@Override
	public boolean isDestroyed() {
		return false;
	}

	@Override
	public void draw(GraphicsContext gc) {
		DrawingUtility.drawMenuButton(gc, PlayerStatus.instance.isPause(), 10, 10, buttonSize);
	}

}
