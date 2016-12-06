package model;

import Utility.DrawingUtility;
import javafx.scene.canvas.GraphicsContext;

public class MenuButton extends Entity implements IRenderable {
	private int buttonSize = 50;

	public MenuButton(double x, double y) {
		super(x, y, 0, 0);
	}

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
		DrawingUtility.drawMenuButton(gc, PlayerStatus.instance.isPause(), x, y, buttonSize);
	}

}