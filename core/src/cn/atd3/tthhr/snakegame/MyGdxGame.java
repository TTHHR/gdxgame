package cn.atd3.tthhr.snakegame;


import cn.atd3.tthhr.snakegame.screen.StartScreen;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;




public class MyGdxGame extends Game {
	public int width,height;

	@Override
	public void create () {
		Gdx.app.setLogLevel(Application.LOG_DEBUG);
		width=Gdx.graphics.getWidth();
		height=Gdx.graphics.getHeight();
		setScreen(new StartScreen(this));
	}

	@Override
	public void dispose () {
	}

	@Override
	public void resize(int width, int height) {
		this.width=width;
		this.height=height;
	}
}
