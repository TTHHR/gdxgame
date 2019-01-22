package cn.qingyuyu.maliao.logic;

import cn.qingyuyu.maliao.GdxGame;
import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.Screen;

import com.badlogic.gdx.graphics.GL20;

import com.badlogic.gdx.graphics.Texture;

public class GameScreen implements Screen {
    final GdxGame game;

    Texture bgImage;
    Texture coinImage;

    public GameScreen(final GdxGame game) {
        this.game = game;

        // load the images for the droplet and the bucket, 64x64 pixels each
        bgImage = new Texture(Gdx.files.internal("bg.jpg"));
        coinImage = new Texture(Gdx.files.internal("coin.png"));


    }


    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(1, 1, 1f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();
        game.batch.draw(bgImage,0,0);
        game.batch.draw(coinImage,0,0);
        game.batch.end();

    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void show() {

    }

    @Override
    public void hide() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {

    }

}