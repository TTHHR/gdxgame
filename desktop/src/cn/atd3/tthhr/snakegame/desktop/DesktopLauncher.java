package cn.atd3.tthhr.snakegame.desktop;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import cn.atd3.tthhr.snakegame.MyGdxGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width=800;
		config.height=480;
		config.title="贪食蛇";
		config.addIcon("pic/icon.png",Files.FileType.Internal);
		new LwjglApplication(new MyGdxGame(), config);
	}
}
