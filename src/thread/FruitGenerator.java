/*
 * Author: 	Wattanai Thangsrirojkul		5831062121 Section 33
 * 			Sivakorn Chanpitayanukulkij 5830535521 Section 33
 */
package thread;

import java.util.Random;

import graphic.PlayerStatus;
import gui.ScreenProperties;
import logic.entity.Fruit;
import logic.entity.SuperFruit;
import main.Main;

public class FruitGenerator extends Generator {

	public FruitGenerator(long generateInterval) {
		super(generateInterval);
	}

	@Override
	public Runnable initRunnable() {
		return () -> {
			while (true) {
				try {
					Thread.sleep(generateInterval);
					if (!PlayerStatus.instance.isPause()) {
						Random random = new Random();
						int x = random.nextInt((int) ScreenProperties.screenWidth);
						int y = (int) ScreenProperties.screenHeight;
						int speedX = (100 + random.nextInt(200)) * (x > ScreenProperties.screenWidth / 2 ? -1 : 1);
						int speedY = 700 + random.nextInt(200);
						Main.instance.getGameLogic().addEntity(random.nextInt(5) != 0 ? new Fruit(x, y, speedX, speedY)
								: new SuperFruit(x, y, speedX, speedY));
					}
				} catch (InterruptedException e) {
					return;
				}
			}
		};
	}

}
