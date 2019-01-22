package cn.qingyuyu.maliao.logic;

import cn.qingyuyu.maliao.GdxGame;
import cn.qingyuyu.maliao.Util;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;

import java.io.InputStream;
import java.net.Socket;

public class StartScreen implements Screen {
    private Texture bgImg,startImg;
    final GdxGame game;

    OrthographicCamera camera;

    public StartScreen(final GdxGame game) {
        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        bgImg = new Texture("bg2.png");
        startImg = new Texture("startButton.png");
        new Thread(new Runnable() {
            @Override
            public void run() {
                // do something important here, asynchronously to the rendering thread
                try {
                    Socket s=new Socket(Util.serverAddress,Util.serverPort);
                    s.getOutputStream().write("{\"token\":\"c4droiduser\",\"need\":\"set\",\"data\":\"game start\"}\n".getBytes());
                    Thread.sleep(500);
                    InputStream is=s.getInputStream();
                    byte [] b=new byte[is.available()];
                    is.read(b);
                    System.out.print(new String(b));
                    s.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.batch.draw(bgImg,0,0);
        game.batch.draw(startImg,250,200);
        game.font.draw(game.batch, "create by TTHHR! ", 100, 150);
        game.font.draw(game.batch, "2019.1.22!", 100, 100);
        game.batch.end();
        if (Gdx.input.isTouched()) {
            game.setScreen(new GameScreen(game));
            dispose();
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
bgImg.dispose();
startImg.dispose();

    }
}
