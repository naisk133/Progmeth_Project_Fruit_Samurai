package thread;

import graphic.PlayerStatus;
import javafx.application.Platform;
import logic.entity.ItemStatus;
import logic.highscore.HighScoreUtility;
import main.Main;

public class GameThread extends Thread {
	public GameThread() {
		super(() -> {
			while (true) {
				if (PlayerStatus.instance.isGameOver()) {
					Platform.runLater(() -> {
						HighScoreUtility.recordHighScore(PlayerStatus.instance.getScore());
					});
					PlayerStatus.instance.setGameOver(false);
					ItemStatus.instance.resetAllCounter();
					return;
				}
				try {
					if (!PlayerStatus.instance.isPause()) {
						Main.instance.getGameLogic().updateLogic();
						ItemStatus.instance.update();
					}
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
					return;
				}
			}
		});
	}
}