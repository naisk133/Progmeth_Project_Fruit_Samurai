package gui;

import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import logic.Trail;
import Utility.InputUtility;
import graphic.Background;
import graphic.MenuButton;
import graphic.PlayerStatus;
import graphic.RenderableHolder;
import model.IRenderable;

public class GameScreen extends GridPane {

	private double screen_width, screen_height;
	private Canvas canvas;
	private GraphicsContext gc;

	public GameScreen() {

		screen_width = ConfigurableSettings.screenWidth;
		screen_height = ConfigurableSettings.screenHeight;
		canvas = new Canvas(screen_width, screen_height);
		gc = canvas.getGraphicsContext2D();
		this.getChildren().add(canvas);

		RenderableHolder.instance.addEntity(Background.instance);
		RenderableHolder.instance.addEntity(PlayerStatus.instance);
		RenderableHolder.instance.addEntity(MenuButton.instance);
		RenderableHolder.instance.addEntity(Trail.instance);

		addListener();
		
	}


	public void paintComponents() {
		synchronized (RenderableHolder.instance.getEntities()) {
			for (IRenderable entity : RenderableHolder.instance.getEntities()) {
				if (!entity.isDestroyed()) {
					entity.draw(gc);
				}
			}
		}
	}

	private void addListener() {

		canvas.setOnMouseReleased(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				System.out.println("MouseReleased : " + event.getButton().toString());
				if (event.getButton() == MouseButton.PRIMARY) {
					InputUtility.setMouseLeftDown(false);
					Trail.instance.clearTrail();
				}
			}
		});
		canvas.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				System.out.println("MousePressed : " + event.getButton().toString());
				if (event.getButton() == MouseButton.PRIMARY) {
					InputUtility.setMouseLeftDown(true);
					InputUtility.setMouseLeftLastDown(true);
					logic.Trail.instance.addTrail((int) event.getX(), (int) event.getY());
				}

			}
		});

		canvas.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				InputUtility.setMouseOnScreen(false);
			}
		});

		canvas.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				InputUtility.setMouseOnScreen(true);
			}
		});

		canvas.setOnMouseMoved(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
					InputUtility.setMouseX((int) event.getX());
					InputUtility.setMouseY((int) event.getY());
			}
		});

		canvas.setOnMouseDragged(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
					InputUtility.setMouseX((int) event.getX());
					InputUtility.setMouseY((int) event.getY());
			}
		});

	}
}
