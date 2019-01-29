package cn.atd3.tthhr.snakegame.screen;

import cn.atd3.tthhr.snakegame.MyGdxGame;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.StretchViewport;

public class StartScreen implements Screen {
    MyGdxGame game;
    Stage stage;
    Image bgImg;
    ImageButton startButton;
    boolean gameStart=false;//游戏开始的标志
    public StartScreen(MyGdxGame game)
    {
        this.game=game;
    }


    @Override
    public void show() {
        stage=new Stage(new StretchViewport(game.width,game.height));//新建一个舞台

        bgImg=new Image(new TextureRegionDrawable(new Texture("pic/bg.png")));//生成image对像，这样可以添加到舞台上
        bgImg.setPosition(0,0);
        stage.addActor(bgImg);//先添加背景

        //设置按钮样式
        ImageButton.ImageButtonStyle ibs=new ImageButton.ImageButtonStyle();
        ibs.imageUp=new TextureRegionDrawable(new Texture("pic/startButtonUp.png"));
        ibs.imageDown=new TextureRegionDrawable(new Texture("pic/startButtonDown.png"));

        startButton=new ImageButton(ibs);//根据样式生成Button
        startButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                gameStart = true;
                super.clicked(event, x, y);
            }
        });
        startButton.setPosition((game.width-startButton.getWidth())/2,(game.height-startButton.getHeight())/2);
        stage.addActor(startButton);//添加按钮到舞台

        Gdx.input.setInputProcessor(stage);

    }

    @Override
    public void render(float delta) {
    Gdx.gl.glClearColor( 1, 1, 1, 1 );
    Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT );

    stage.act();
    stage.draw();
    if(gameStart) {
        game.setScreen(new GameScreen(game, 1));

        this.dispose();
    }
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width,height);
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
    stage.dispose();
    }
}
