package logic.entity;

import java.util.Random;

import Utility.DrawingUtility;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import model.Entity;

public class HalfFruit extends Entity {
	private int index;
	private int side;

	public HalfFruit(double x, double y, double speedX, double speedY, double rotation, int index, int side) {
		super(x, y, speedX, speedY);
		Random random = new Random();
		super.rotation = rotation;
		this.side = side;
		this.index = index;
	}

	@Override
	public int getZ() {
		return z;
	}

	@Override
	public boolean isDestroyed() {
		return isDestroyed;
	}

	@Override
	public void draw(GraphicsContext gc) {
		Image image = DrawingUtility.cut_fruit[index * 2 + side];

		DrawingUtility.drawRotatedImage(gc, image, rotation, x, y);
		gc.fillRect(x + image.getWidth() / 2, y + image.getHeight() / 2, 5, 5);
	}

}