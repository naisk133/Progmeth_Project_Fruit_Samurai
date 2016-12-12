package gui;

import javafx.animation.PauseTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import main.Main;

public class StartScreen extends GridPane {
	private Button startButton, collectionButton, exitButton;
	private StackPane startPane, collectionPane, exitPane, titlePane;
	private Label titleLabel;

	public StartScreen() {

		setAlignment(Pos.CENTER);

		String image = ClassLoader.getSystemResource("image/menu.jpg").toString();
		this.setStyle("-fx-background-image: url('" + image + "'); " + "-fx-background-position: center center;"
				+ "-fx-background-repeat: stretch; -fx-background-size:" + ScreenProperties.screenWidth + " "
				+ ScreenProperties.screenHeight + "; -fx-background-radius: 0");

		titleLabel = new Label("Fruit Samurai");
		startButton = new Button("Start");
		collectionButton = new Button("Collections");
		exitButton = new Button("Exit");

		titleLabel.setStyle("-fx-font-size: 50px; -fx-font-family:\"Arial Black\"; -fx-text-fill: black;"
				+ "-fx-text-alignment:center; -fx-padding: 20; " + "-fx-background-color: white;"
				+ "-fx-border-color: black; -fx-border-width: 5;");

		startButton.setStyle("-fx-background-color:darkorange; -fx-background-radius: 0,0,0,0; "
				+ "-fx-padding: 5 30 5 30; -fx-background-size:50;" + "-fx-text-fill: black; -fx-font-size: 40px;"
				+ "-fx-font-weight: bold; -fx-font-family: \"Arial\"; "
				+ "-fx-border-color: black; -fx-border-width: 5;");

		collectionButton.setStyle("-fx-background-color:dodgerblue; -fx-background-radius: 0,0,0,0; "
				+ "-fx-padding: 5 30 5 30; -fx-background-size:50;" + "-fx-text-fill: black; -fx-font-size: 40px;"
				+ "-fx-font-weight: bold; -fx-font-family: \"Arial\"; "
				+ "-fx-border-color: black; -fx-border-width: 5;");

		exitButton.setStyle("-fx-background-color:orchid; -fx-background-radius: 0,0,0,0; "
				+ "-fx-padding: 5 30 5 30; -fx-background-size:50;" + "-fx-text-fill: black; -fx-font-size: 40px;"
				+ "-fx-font-weight: bold; -fx-font-family: \"Arial\"; "
				+ "-fx-border-color: black; -fx-border-width: 5;");

		titlePane = new StackPane(titleLabel);
		startPane = new StackPane(startButton);
		collectionPane = new StackPane(collectionButton);
		exitPane = new StackPane(exitButton);

		GridPane.setVgrow(titlePane, Priority.ALWAYS);
		GridPane.setVgrow(startPane, Priority.ALWAYS);
		GridPane.setVgrow(collectionPane, Priority.ALWAYS);
		GridPane.setVgrow(exitPane, Priority.ALWAYS);

		add(titlePane, 0, 0);
		add(startPane, 0, 1);
		add(collectionPane, 0, 2);
		add(exitPane, 0, 3);

		addListener();
	}

	public void addListener() {
<<<<<<< HEAD
		titlePane.setOnMouseEntered(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				int colorA = (int) (Math.random() * 255);
				int colorB = (int) (Math.random() * 255);
				int colorC = (int) (Math.random() * 255);
				String color = colorA + ", " + colorB + ", " + colorC;
				titleLabel.setStyle("-fx-font-size: 50px; -fx-font-family:\"Arial Black\"; -fx-text-fill: black;"
						+ "-fx-text-alignment:center; -fx-padding: 20; " + "-fx-background-color: rgb(" + color + ");"
						+ "-fx-border-color: black; -fx-border-width: 5;");
			}
		});

		titlePane.setOnMouseExited(new EventHandler<Event>() {
=======
		
		titleLabel.setOnMousePressed(new EventHandler<Event>() {
>>>>>>> 445f32ffc1d6bfc97db4473bc972c6f8158159e4

			@Override
			public void handle(Event event) {
				int colorA = (int) (Math.random() * 255);
				int colorB = (int) (Math.random() * 255);
				int colorC = (int) (Math.random() * 255);
				String color = colorA + ", " + colorB + ", " + colorC;
				titleLabel.setStyle("-fx-font-size: 50px; -fx-font-family:\"Arial Black\"; -fx-text-fill: black;"
						+ "-fx-text-alignment:center; -fx-padding: 20; " + "-fx-background-color: rgb(" + color + ");"
						+ "-fx-border-color: black; -fx-border-width: 5;");
			}
		});

		startButton.setOnMouseEntered(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				startButton.setStyle("-fx-background-color:orange; -fx-background-radius: 0,0,0,0; "
						+ "-fx-padding: 5 30 5 30; -fx-background-size:50;"
						+ "-fx-text-fill: black; -fx-font-size: 40px;"
						+ "-fx-font-weight: bold; -fx-font-family: \"Arial\"; "
						+ "-fx-border-color: black; -fx-border-width: 5;");
			}
		});

		startButton.setOnMouseExited(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				startButton.setStyle("-fx-background-color:darkorange; -fx-background-radius: 0,0,0,0; "
						+ "-fx-padding: 5 30 5 30; -fx-background-size:50;"
						+ "-fx-text-fill: black; -fx-font-size: 40px;"
						+ "-fx-font-weight: bold; -fx-font-family: \"Arial\"; "
						+ "-fx-border-color: black; -fx-border-width: 5;");
			}
		});

		startButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				screenTransitionOut();
				PauseTransition pause = new PauseTransition(Duration.millis(700));
				pause.setOnFinished(event -> {
					Main.instance.changeToGameScreen();
				});
				pause.play();

			}

		});

		collectionButton.setOnMouseEntered(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				collectionButton.setStyle("-fx-background-color:deepskyblue; -fx-background-radius: 0,0,0,0; "
						+ "-fx-padding: 5 30 5 30; -fx-background-size:50;"
						+ "-fx-text-fill: black; -fx-font-size: 40px;"
						+ "-fx-font-weight: bold; -fx-font-family: \"Arial\"; "
						+ "-fx-border-color: black; -fx-border-width: 5;");
			}
		});

		collectionButton.setOnMouseExited(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				collectionButton.setStyle("-fx-background-color:dodgerblue; -fx-background-radius: 0,0,0,0; "
						+ "-fx-padding: 5 30 5 30; -fx-background-size:50;"
						+ "-fx-text-fill: black; -fx-font-size: 40px;"
						+ "-fx-font-weight: bold; -fx-font-family: \"Arial\"; "
						+ "-fx-border-color: black; -fx-border-width: 5;");
			}
		});

		collectionButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				screenTransitionOut();
				PauseTransition pause = new PauseTransition(Duration.millis(700));
				pause.setOnFinished(event -> {
					Main.instance.getCollectionScreen().screenTransitionIn();
					Main.instance.changeToCollectionScreen();
				});
				pause.play();

			}

		});

		exitButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Main.instance.closeScreen();
			}

		});

		exitButton.setOnMouseEntered(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				exitButton.setStyle("-fx-background-color:violet; -fx-background-radius: 0,0,0,0; "
						+ "-fx-padding: 5 30 5 30; -fx-background-size:50;"
						+ "-fx-text-fill: black; -fx-font-size: 40px;"
						+ "-fx-font-weight: bold; -fx-font-family: \"Arial\"; "
						+ "-fx-border-color: black; -fx-border-width: 5;");
			}
		});

		exitButton.setOnMouseExited(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				exitButton.setStyle("-fx-background-color:orchid; -fx-background-radius: 0,0,0,0; "
						+ "-fx-padding: 5 30 5 30; -fx-background-size:50;"
						+ "-fx-text-fill: black; -fx-font-size: 40px;"
						+ "-fx-font-weight: bold; -fx-font-family: \"Arial\"; "
						+ "-fx-border-color: black; -fx-border-width: 5;");
			}
		});

	}

	public void screenTransitionOut() {
		TranslateTransition titleTrans = new TranslateTransition(Duration.millis(700), titlePane);
		titleTrans.setByX(-ScreenProperties.screenWidth);
		TranslateTransition startTrans = new TranslateTransition(Duration.millis(700), startPane);
		startTrans.setByX(-ScreenProperties.screenWidth);
		TranslateTransition collctionTrans = new TranslateTransition(Duration.millis(700), collectionPane);
		collctionTrans.setByX(-ScreenProperties.screenWidth);
		TranslateTransition exitTrans = new TranslateTransition(Duration.millis(700), exitPane);
		exitTrans.setByX(-ScreenProperties.screenWidth);
		titleTrans.play();
		startTrans.play();
		collctionTrans.play();
		exitTrans.play();
	}

	public void screenTransitionIn() {
		TranslateTransition titleTrans = new TranslateTransition(Duration.millis(700), titlePane);
		titleTrans.setByX(ScreenProperties.screenWidth);
		TranslateTransition startTrans = new TranslateTransition(Duration.millis(700), startPane);
		startTrans.setByX(ScreenProperties.screenWidth);
		TranslateTransition collctionTrans = new TranslateTransition(Duration.millis(700), collectionPane);
		collctionTrans.setByX(ScreenProperties.screenWidth);
		TranslateTransition exitTrans = new TranslateTransition(Duration.millis(700), exitPane);
		exitTrans.setByX(ScreenProperties.screenWidth);
		titleTrans.play();
		startTrans.play();
		collctionTrans.play();
		exitTrans.play();
	}
}
