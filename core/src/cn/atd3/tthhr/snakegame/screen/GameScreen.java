package cn.atd3.tthhr.snakegame.screen;

import cn.atd3.tthhr.snakegame.MyGdxGame;
import cn.atd3.tthhr.snakegame.actor.FPSActor;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.StretchViewport;

public class GameScreen implements Screen {
    MyGdxGame game;
    int leave;
    Stage stage;
    Image bgImg;
    FPSActor fps;
    int gameRunning=1;//游戏运行的标志
    public GameScreen(MyGdxGame game,int leave)
    {
        this.game=game;
        this.leave=leave;//关卡

    }

    @Override
    public void show() {
        stage=new Stage(new StretchViewport(game.width,game.height));//新建一个舞台
        switch (leave)
        {
            case 1:bgImg=new Image(new TextureRegionDrawable(new Texture("pic/grass.jpg")));//生成image对像，这样可以添加到舞台上

                break;
            case 2:bgImg=new Image(new TextureRegionDrawable(new Texture("pic/stone.jpg")));//生成image对像，这样可以添加到舞台上

                break;
           default:bgImg=new Image(new TextureRegionDrawable(new Texture("pic/grass.jpg")));//生成image对像，这样可以添加到舞台上
        }

        bgImg.setPosition(0,0);
        stage.addActor(bgImg);//先添加背景

         fps=new FPSActor();//自定义演员，显示FPS
        fps.setPosition(10,game.height-10);
        stage.addActor(fps);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor( 1, 1, 1, 1 );
        Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT );
if(gameRunning==1) {
    stage.act();
    stage.draw();
}
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {
        gameRunning=2;
    }

    @Override
    public void resume() {
        gameRunning=1;
    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        fps.dispose();
        stage.dispose();
    }
}
